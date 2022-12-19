/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 *
 * @author matia
 */

@EnableWebMvc
@EnableWebSecurity
@Configuration
public class WebSecurityConfig implements WebMvcConfigurer{

        
	@Autowired
	private UserDetailsService myUserDetailsService;
	
        @Autowired
	private JwtRequestFilter jwtRequestFilter;
        
        @Override
        public void addCorsMappings(CorsRegistry registry){
            registry.addMapping("/**")
                    .allowedMethods("*")
                    //.allowedOrigins("http://localhost:4200")
                    .allowedHeaders("*");
                    //.allowCredentials(false)
                    //.maxAge(-1);
        }
        
        @Bean
	public PasswordEncoder passwordEncoder() {
            //BCrypt para encriptar las passwords antes de comparar con BD.
            return new BCryptPasswordEncoder();
	}
        
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
        
        @Bean
        public AuthenticationManager authManager(HttpSecurity http) throws Exception {
            AuthenticationManagerBuilder authenticationManagerBuilder = 
                http.getSharedObject(AuthenticationManagerBuilder.class);
            
            authenticationManagerBuilder.userDetailsService(myUserDetailsService);
            return authenticationManagerBuilder.build();
        }
        
        
        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http.csrf().disable();

            return http.build();
        }

}
