-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 31-05-2024 a las 01:07:49
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gimnasio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clases`
--

CREATE TABLE `clases` (
  `idClases` int(11) NOT NULL,
  `idEntrenadores` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `horario` time NOT NULL,
  `capacidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrenadores`
--

CREATE TABLE `entrenadores` (
  `idEntrenadores` int(11) NOT NULL,
  `dni` varchar(12) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `especialidad` varchar(60) NOT NULL,
  `disponibilidad` varchar(80) NOT NULL COMMENT 'El horiario del profesor'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscribirseclase`
--

CREATE TABLE `inscribirseclase` (
  `clases_idclases` int(11) NOT NULL,
  `socios_idSocio` int(11) NOT NULL,
  `fecha` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `membresias`
--

CREATE TABLE `membresias` (
  `idMembresias` int(11) NOT NULL,
  `idSocio` int(11) NOT NULL,
  `tipo` varchar(45) DEFAULT NULL COMMENT ' Tipo de membresía (mensual, anual, etc.).\nVamos usar enum dedsde la bd',
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `socios`
--

CREATE TABLE `socios` (
  `idSocio` int(11) NOT NULL,
  `dni` varchar(12) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `edad` int(11) NOT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `telefono` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clases`
--
ALTER TABLE `clases`
  ADD PRIMARY KEY (`idClases`),
  ADD KEY `fk_clases_entrenadores1_idx` (`idEntrenadores`);

--
-- Indices de la tabla `entrenadores`
--
ALTER TABLE `entrenadores`
  ADD PRIMARY KEY (`idEntrenadores`),
  ADD UNIQUE KEY `dni_UNIQUE` (`dni`);

--
-- Indices de la tabla `inscribirseclase`
--
ALTER TABLE `inscribirseclase`
  ADD PRIMARY KEY (`clases_idclases`,`socios_idSocio`),
  ADD KEY `fk_clases_has_socios_socios1_idx` (`socios_idSocio`),
  ADD KEY `fk_clases_has_socios_clases1_idx` (`clases_idclases`);

--
-- Indices de la tabla `membresias`
--
ALTER TABLE `membresias`
  ADD PRIMARY KEY (`idMembresias`),
  ADD KEY `fk_membresias_socios1_idx` (`idSocio`);

--
-- Indices de la tabla `socios`
--
ALTER TABLE `socios`
  ADD PRIMARY KEY (`idSocio`),
  ADD UNIQUE KEY `dni_UNIQUE` (`dni`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clases`
--
ALTER TABLE `clases`
  MODIFY `idClases` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `entrenadores`
--
ALTER TABLE `entrenadores`
  MODIFY `idEntrenadores` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `membresias`
--
ALTER TABLE `membresias`
  MODIFY `idMembresias` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `socios`
--
ALTER TABLE `socios`
  MODIFY `idSocio` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `clases`
--
ALTER TABLE `clases`
  ADD CONSTRAINT `fk_clases_entrenadores1` FOREIGN KEY (`idEntrenadores`) REFERENCES `entrenadores` (`idEntrenadores`);

--
-- Filtros para la tabla `inscribirseclase`
--
ALTER TABLE `inscribirseclase`
  ADD CONSTRAINT `fk_clases_has_socios_clases1` FOREIGN KEY (`clases_idclases`) REFERENCES `clases` (`idclases`),
  ADD CONSTRAINT `fk_clases_has_socios_socios1` FOREIGN KEY (`socios_idSocio`) REFERENCES `socios` (`idSocio`);

--
-- Filtros para la tabla `membresias`
--
ALTER TABLE `membresias`
  ADD CONSTRAINT `fk_membresias_socios1` FOREIGN KEY (`idSocio`) REFERENCES `socios` (`idSocio`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
