# Trabajo Integrador - Argentina Programa: Portafolio Personal Backend

El Repositorio actual cuenta con mi desarrollo personal del trabajo solicitado para el programa formación ArgentinaPrograma de la 2da Etapa: Yo Programo.

El despliegue del proyecto se realiza en la plataforma **Koyeb**, utilizando conexión con GitHub Workflows la automatización. El Sitio puede ser visitado a través del nombre [portfolio-api-matiasperlo.koyeb.app/](https://portfolio-api-matiasperlo.koyeb.app/)

## Estructura

El proyecto tiene la siguiente estructura bajo la carpeta [src](src/):

```
├───java
│   └───io
│       └───github
│           └───matiasperlo
│               └───portfolio
│                   ├───config
│                   ├───controller
│                   ├───dao
│                   ├───dto
│                   ├───model
│                   └───service
└───resources
    └───static
```

Una explicación de cada paquete:
 - **static** : Contenido estático disponible para los endpoints Web.
 - **config** : Clases para la configuración de la aplicación en aspectos de seguridad.
 - **controller** : Controladores de todos los endpoints de la API, mayormente REST.
 - **dto** : Clases utilizadas para formatear requests y responses en los distintos endpoints.
 - **dao** : Clases especiales para el consumo de Base de Datos de cada objeto persistente.
 - **model** : Clases de persistencia ORM mediante JPA.
 - **service** : Servicios varios para persistencia y seguridad.
 

## Aspectos destacables sobre la implementación

### Manejo de Transacciones, Commits y Rollbacks

Para realizar una correcta secuencia de tareas sobre la base de datos de forma atómica, íntegra y que no comprometa el estado, se implementó transacciones sobre las operaciones específicas que manejan más de una sentencia.

Ejemplo en [ExperienciaService.java](src/main/java/io/github/matiasperlo/portfolio/service/ExperienciaService.java)

```
    @Transactional
    public void registrarExperiencia(Experiencia exp) {
  
        // guardar la empresa primero
        if(exp.getEmpresa().getId() == 0){
            empresaDAO.save(exp.getEmpresa());
        }
        
        // guardar el rol primero
        if(exp.getPuesto().getId() == 0){
            puestoDAO.save(exp.getPuesto());
        }
        
        // guardar la jornada primero
        if(exp.getJornada().getId() == 0){
            jornadaDAO.save(exp.getJornada());
        }
        
        experienciaDAO.save(exp);
    }
```
En este código, podemos ver que la clase **Experiencia** se asocia a otras clases: **Empresa**, **Puesto** y **Jornada**. Si estas no posee un ID numérico que lo identifique dentro de la base de datos, se asume que el mismo todavía no existe y se procede a guardarlo antes de completar la sentencia principal. Para que el comportamiento sea transaccional, debemos decorar el método contenedor con `@Transactional`.
Si todas las tareas son ejecutadas sin problemas, se produce un Commit. Por el otro lado, si alguna de las sentencias ejecutadas falla por algún motivo (error de tipos, atributos nulos, IDs inválidos, etc), la transacción lanzará una excepción que provocará un Rollback que dejará sin efecto a cualquier cambio correctamente realizado.

### Authenticación y Control de Acceso con JWT.

#### Encriptación de Passwords

Para el trabajo de persistencia de datos de los usuarios, los passwords son encriptados para ser almacenados de forma segura. Sobre el framework de Spring Security, se utilizó el hash de `BCryptPasswordEncoder`


Encontramos el siguiente código en la clase `@Configuration` y `@EnabledWebSecurity` de [WebSecurityConfig.java](src/main/java/io/github/matiasperlo/portfolio/config/WebSecurityConfig.java)
```
@Bean
public PasswordEncoder passwordEncoder() {
    //BCrypt para encriptar las passwords antes de comparar con BD.
    return new BCryptPasswordEncoder();
}
```

#### Filtros a peticiones utilizando JWT

La mayoría de los endpoints están dedicados para el uso exclusivo del administrador. Por este motivo el backend implementa ***Control de Acceso Basado en Roles (RBAC)***. Cada Usuario registrado tiene asociado un ROL (por defecto tendrán ROLE_USER) que limita su acceso.
Inicialmente configuramos a todos los endpoints como permitidos:
```
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf().disable();

    return http.build();
}
```

Luego se registra un filtro para los endpoints necesarios:
```
@Bean
public FilterRegistrationBean<JwtRequestFilter> registerPostCommentsRateLimiter(){
    FilterRegistrationBean<JwtRequestFilter> registrationBean  = new FilterRegistrationBean<>();

    registrationBean.setFilter(jwtRequestFilter);
    registrationBean.addUrlPatterns(
            "/api/users/*",
            "/api/educacion/*",
            "/api/empresa/*",
            "/api/experiencias/*",
            "/api/habilidad/*",
            "/api/instituto/*",
            "/api/jornadas/*",
            "/api/perfil",
            "/api/proyecto/*",
            "/api/puestos/*",
            "/api/rol/*");
    registrationBean.setOrder(2);

    return registrationBean;
}
```

Por último, tenemos a [JwtRequestFilter.java](src/main/java/io/github/matiasperlo/portfolio/config/JwtRequestFilter.java) que verifica que el usuario solicitante sea administrador:
```
@Override
protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
        throws ServletException, IOException {

    // es un request de CORS y debemos dejarlo pasar
    if(request.getHeader("Access-Control-Request-Method") != null){
        chain.doFilter(request, response);
        return;
    }

    // control de acceso
    final String authorizationHeader = request.getHeader("Authorization");

    String jwt = null;
    String username = null;

    if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
        jwt = authorizationHeader.substring(7);
        username = jwtUtil.extractUsername(jwt);
    }

    String rolname = null;

    if(username != null){
        List<MyUserDetails.Authority> auths = (List<MyUserDetails.Authority>)
                ((MyUserDetails)userDetailsService.loadUserByUsername(username))
                        .getAuthorities();
        rolname = auths.get(0).getAuthority();
    }

    // no tiene privilegios de administrador
    if(rolname == null || !rolname.equals("ROLE_ADMIN")){
        response.setStatus(403);
        response.getOutputStream().write(("Forbidden \nNo posee permisos suficientes.").getBytes());
        return;
    }

    // todo ok, proceder
    chain.doFilter(request, response);
}
```

### Persistencia de Datos con JPA

La persistencia de los datos se logra utilizando Mapeo Objecto-Relacion (ORM) a través de JPA. Como se trabaja sobre una base de datos con tablas existentes, se brinda al backend la posibilad de realizar únicamente sentencia de Manipulación de Datos (DML en SQL incluye SELECT, UPDATE, DELETE e INSERT)
Las entidades persistentes son creadas declarádolas como `@Entity` y asociándolas a una `@Table`
Ejemplo con la entidad [Instituto.java](src/main/java/io/github/matiasperlo/portfolio/model/Instituto.java)
```
@Entity
@Table(name = "instituciones")
public class Instituto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    
    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;
    
    @Column(name = "logo", nullable = false, length = 50)
    private String logo;  
    
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLogo() {
        return logo;
    }
}
```


