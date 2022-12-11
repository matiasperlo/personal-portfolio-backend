-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-12-2022 a las 21:38:40
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ap_portfolio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `educaciones`
--

CREATE TABLE `educaciones` (
  `id` int(3) NOT NULL,
  `titulo` varchar(200) NOT NULL,
  `instituto` int(3) NOT NULL,
  `inicio` date NOT NULL,
  `fin` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `educaciones`
--

INSERT INTO `educaciones` (`id`, `titulo`, `instituto`, `inicio`, `fin`) VALUES
(1, 'Metodologías ágiles para gestión de proyectos', 2, '2022-05-31', '2022-07-21'),
(10, 'Desarrollo de Aplicaciones Moviles: Universidad Complutense de Madrid', 1, '2022-10-31', '2022-11-29'),
(16, 'Ingles Técnico: Desarrollo de Software', 3, '2022-10-30', '2022-11-28');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresas`
--

CREATE TABLE `empresas` (
  `id` int(3) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `logo` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `empresas`
--

INSERT INTO `empresas` (`id`, `nombre`, `logo`) VALUES
(1, 'Bigma Tech', 'https://cryptologos.cc/logos/multi-collateral-dai-dai-logo.png'),
(11, 'Trigma Tech', 'logo1.jpg'),
(12, 'Sigma Tech', 'logo1.jpg'),
(13, 'Sigma Tech', 'logo1.jpg'),
(14, 'Apple', 'https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Apple_logo_black.svg/488px-Apple_logo_black.svg.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `experiencias`
--

CREATE TABLE `experiencias` (
  `id` int(3) NOT NULL,
  `puesto` int(2) NOT NULL,
  `empresa` int(2) NOT NULL,
  `jornada` int(2) NOT NULL,
  `descripcion` varchar(240) DEFAULT NULL,
  `fechainicio` date NOT NULL,
  `fechafin` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `experiencias`
--

INSERT INTO `experiencias` (`id`, `puesto`, `empresa`, `jornada`, `descripcion`, `fechainicio`, `fechafin`) VALUES
(1, 1, 1, 1, NULL, '2020-11-10', '2021-11-23'),
(2, 1, 1, 1, NULL, '2022-11-15', '2022-12-01');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habilidades`
--

CREATE TABLE `habilidades` (
  `id` int(3) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `progreso` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `habilidades`
--

INSERT INTO `habilidades` (`id`, `nombre`, `progreso`) VALUES
(2, 'GitHub', 45),
(4, 'Django', 30),
(5, 'SQL', 70),
(6, 'MySQL', 40),
(7, 'SQL Server', 30),
(8, 'Angular', 20),
(10, 'Java', 35),
(12, 'Python', 50);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `instituciones`
--

CREATE TABLE `instituciones` (
  `id` int(3) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `logo` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `instituciones`
--

INSERT INTO `instituciones` (`id`, `nombre`, `logo`) VALUES
(1, 'Google', 'https://storage.googleapis.com/support-kms-prod/ZAl1gIwyUsvfwxoW9ns47iJFioHXODBbIkrK'),
(2, 'Municipalidad de Cordoba', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSE2e2aatjhNHTAq47LfoN2HlZi10qDr8cvMJQmPLhsMFdJbifmyHBpstW0GwpBMUNC78s&usqp=CAU'),
(3, 'Platzi', 'https://static.platzi.com/media/avatars/platziteam_8cfe6fc7-1246-4c9a-9f5d-d10d467443ee.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jornada`
--

CREATE TABLE `jornada` (
  `id` int(1) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `descripcion` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `jornada`
--

INSERT INTO `jornada` (`id`, `nombre`, `descripcion`) VALUES
(1, 'Jornada Parcial', NULL),
(2, 'Sop Tecnico', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfil`
--

CREATE TABLE `perfil` (
  `id` int(2) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `rol` varchar(100) NOT NULL,
  `foto_perfil` varchar(400) NOT NULL,
  `foto_portada` varchar(400) NOT NULL,
  `desc_sobremi` varchar(420) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `perfil`
--

INSERT INTO `perfil` (`id`, `nombre`, `rol`, `foto_perfil`, `foto_portada`, `desc_sobremi`, `email`) VALUES
(1, 'Matias Perlo', 'Estudiante Ing. Sistemas', 'https://i0.wp.com/imgs.hipertextual.com/wp-content/uploads/2020/01/hipertextual-arte-conceptual-avatar-2-muestra-nuevos-rincones-pandora-2020623395.jpg?fit=2048%2C1295&quality=50&strip=all&ssl=1', 'http://blog.alquilerargentina.com/wp-content/uploads/2022/03/Turismo-de-cercania-c%C3%B3rdoba-san-clemente.jpg', 'Actualmente soy estudiante universitario en la carrera de Ing. de Sistemas en UTN FRC Argentina, en un estado avanzado y con la esperanza de graduarme en los proximos años.  Busco obtener mis primeras experiencias dentro del Área de Desarrollo con el perfil de Programador / Desarrollador, abierto a considerar las oportunidades que se presenten y afrontar nuevos desafios que me permitan crecer.', 'matias.perlo.arg@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `privilegios`
--

CREATE TABLE `privilegios` (
  `id` int(3) NOT NULL,
  `privilegio` varchar(100) NOT NULL,
  `descripcion` varchar(420) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `privilegios`
--

INSERT INTO `privilegios` (`id`, `privilegio`, `descripcion`) VALUES
(1, 'READ_PRIVILEGE', NULL),
(2, 'WRITE_PRIVILEGE', NULL),
(3, 'DELETE_PRIVILEGE', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyectos`
--

CREATE TABLE `proyectos` (
  `id` int(3) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `descripcion` varchar(420) NOT NULL,
  `fecha` date DEFAULT NULL,
  `link` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `proyectos`
--

INSERT INTO `proyectos` (`id`, `nombre`, `descripcion`, `fecha`, `link`) VALUES
(2, 'Argentina Programa Frontend', 'Argentina Programa es un programa de capacitación para jóvenes que buscan adquirir los conocimientos, habilidades y destrezas necesarias para insertarse en el mercado laboral, bajo el perfil de Fullstack Developer.', NULL, 'https://github.com/matiasperlo/personal-portfolio'),
(3, 'Argentina Programa BackEnd', 'Argentina Programa es un programa de capacitación para jóvenes que buscan adquirir los conocimientos, habilidades y destrezas necesarias para insertarse en el mercado laboral, bajo el perfil de Fullstack Developer.', NULL, 'https://github.com/matiasperlo/personal-portfolio-backend');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `puestos`
--

CREATE TABLE `puestos` (
  `id` int(3) NOT NULL,
  `puesto` varchar(100) NOT NULL,
  `descripcion` varchar(420) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `puestos`
--

INSERT INTO `puestos` (`id`, `puesto`, `descripcion`) VALUES
(1, 'Frontend Jr', ''),
(2, 'Android Dev Jr', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `id` int(3) NOT NULL,
  `rol` varchar(100) NOT NULL,
  `descripcion` varchar(420) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`id`, `rol`, `descripcion`) VALUES
(3, 'ROLE_ADMIN', NULL),
(4, 'ROLE_USER', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles_privilegios`
--

CREATE TABLE `roles_privilegios` (
  `id` int(3) NOT NULL,
  `rol_id` int(3) NOT NULL,
  `privilegio_id` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `roles_privilegios`
--

INSERT INTO `roles_privilegios` (`id`, `rol_id`, `privilegio_id`) VALUES
(1, 3, 1),
(3, 4, 1),
(5, 3, 3),
(6, 3, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `id` int(3) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(60) NOT NULL,
  `rol` int(3) NOT NULL DEFAULT 4
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `rol`) VALUES
(1, 'admin', '$2a$12$5gyQtiTs2FSKc7l2L4g8PuTcdRZpgvh23C2on4xwOJlb7BFVU3Fzm', 3),
(11, 'matias', '$2a$10$JWixJ1JGejXWCP9LyArD4uVwlgxn3VRgkAlcirWjQXK4.J/kCskyq', 4),
(28, 'mauricio', '$2a$10$b0QgIUTmpcA6VOdnreAykOSaoFosDaCCSDEYxnBZY7JsySr2QHktG', 4),
(31, 'marcelo', '$2a$10$q0inEs5BJd00CeNPwTMLju1eqhUUTdYCHxPTs49tMWfJ9Etap3onq', 4);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `educaciones`
--
ALTER TABLE `educaciones`
  ADD PRIMARY KEY (`id`),
  ADD KEY `instituto` (`instituto`);

--
-- Indices de la tabla `empresas`
--
ALTER TABLE `empresas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `experiencias`
--
ALTER TABLE `experiencias`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_jornada_jornadasId` (`jornada`),
  ADD KEY `fk_empresa_empresaId` (`empresa`),
  ADD KEY `fk_puesto_puestoid` (`puesto`);

--
-- Indices de la tabla `habilidades`
--
ALTER TABLE `habilidades`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `instituciones`
--
ALTER TABLE `instituciones`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`);

--
-- Indices de la tabla `jornada`
--
ALTER TABLE `jornada`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `perfil`
--
ALTER TABLE `perfil`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `privilegios`
--
ALTER TABLE `privilegios`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `proyectos`
--
ALTER TABLE `proyectos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `puestos`
--
ALTER TABLE `puestos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `roles_privilegios`
--
ALTER TABLE `roles_privilegios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_rol_rolesid` (`rol_id`),
  ADD KEY `fk_privilegio_privilegioid` (`privilegio_id`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD KEY `fk_rol_roles` (`rol`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `educaciones`
--
ALTER TABLE `educaciones`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `empresas`
--
ALTER TABLE `empresas`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `experiencias`
--
ALTER TABLE `experiencias`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `habilidades`
--
ALTER TABLE `habilidades`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `instituciones`
--
ALTER TABLE `instituciones`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `jornada`
--
ALTER TABLE `jornada`
  MODIFY `id` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `perfil`
--
ALTER TABLE `perfil`
  MODIFY `id` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `privilegios`
--
ALTER TABLE `privilegios`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `proyectos`
--
ALTER TABLE `proyectos`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `puestos`
--
ALTER TABLE `puestos`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `roles_privilegios`
--
ALTER TABLE `roles_privilegios`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `educaciones`
--
ALTER TABLE `educaciones`
  ADD CONSTRAINT `fk_instituto` FOREIGN KEY (`instituto`) REFERENCES `instituciones` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `experiencias`
--
ALTER TABLE `experiencias`
  ADD CONSTRAINT `fk_empresa_empresaId` FOREIGN KEY (`empresa`) REFERENCES `empresas` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_jornada_jornadasId` FOREIGN KEY (`jornada`) REFERENCES `jornada` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_puesto_puestoid` FOREIGN KEY (`puesto`) REFERENCES `puestos` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `roles_privilegios`
--
ALTER TABLE `roles_privilegios`
  ADD CONSTRAINT `fk_privilegio_privilegioid` FOREIGN KEY (`privilegio_id`) REFERENCES `privilegios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_rol_rolesid` FOREIGN KEY (`rol_id`) REFERENCES `roles` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `fk_rol_roles` FOREIGN KEY (`rol`) REFERENCES `roles` (`id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
