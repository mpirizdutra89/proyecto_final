-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 31-05-2024 a las 19:58:03
-- Versión del servidor: 8.3.0
-- Versión de PHP: 8.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gimnacio`
--
CREATE DATABASE IF NOT EXISTS `gimnacio` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `gimnacio`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asistencias`
--

DROP TABLE IF EXISTS `asistencias`;
CREATE TABLE IF NOT EXISTS `asistencias` (
  `idAsistencia` int NOT NULL AUTO_INCREMENT,
  `idSocio` int NOT NULL,
  `idClase` int NOT NULL,
  `fecha_asistencia` date DEFAULT NULL COMMENT 'fecha actual',
  PRIMARY KEY (`idAsistencia`),
  KEY `fk_asistenciaClase_socios1_idx` (`idSocio`),
  KEY `fk_asistenciaClase_clases1_idx` (`idClase`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clases`
--

DROP TABLE IF EXISTS `clases`;
CREATE TABLE IF NOT EXISTS `clases` (
  `idClase` int NOT NULL AUTO_INCREMENT,
  `idEntrenador` int NOT NULL,
  `nombre` varchar(45) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `horario` time NOT NULL COMMENT '14:00\ndura una hora\n',
  `capacidad` int NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idClase`),
  KEY `fk_clases_entrenadores1_idx` (`idEntrenador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrenadores`
--

DROP TABLE IF EXISTS `entrenadores`;
CREATE TABLE IF NOT EXISTS `entrenadores` (
  `idEntrenador` int NOT NULL AUTO_INCREMENT,
  `dni` varchar(12) COLLATE utf8mb4_general_ci NOT NULL,
  `nombre` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `apellido` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `especialidad` varchar(60) COLLATE utf8mb4_general_ci NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idEntrenador`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `membresias`
--

DROP TABLE IF EXISTS `membresias`;
CREATE TABLE IF NOT EXISTS `membresias` (
  `idMembresia` int NOT NULL AUTO_INCREMENT,
  `idSocio` int NOT NULL,
  `cantidadPases` int NOT NULL DEFAULT '0' COMMENT '(8, 12 o 20, se debe decrementar cada vez que el alumno\nconsume una inscripción a una clase',
  `costo` double NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL COMMENT 'Fecha de fin de la membresía 30 días a partir de la fecha de\nincio.\r',
  `estado` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`idMembresia`),
  KEY `fk_membresias_socios1_idx` (`idSocio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `socios`
--

DROP TABLE IF EXISTS `socios`;
CREATE TABLE IF NOT EXISTS `socios` (
  `idSocio` int NOT NULL AUTO_INCREMENT,
  `dni` varchar(12) COLLATE utf8mb4_general_ci NOT NULL,
  `nombre` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `apellido` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `edad` int NOT NULL,
  `correo` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `telefono` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idSocio`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asistencias`
--
ALTER TABLE `asistencias`
  ADD CONSTRAINT `fk_asistenciaClase_clases1` FOREIGN KEY (`idClase`) REFERENCES `clases` (`idClase`),
  ADD CONSTRAINT `fk_asistenciaClase_socios1` FOREIGN KEY (`idSocio`) REFERENCES `socios` (`idSocio`);

--
-- Filtros para la tabla `clases`
--
ALTER TABLE `clases`
  ADD CONSTRAINT `fk_clases_entrenadores1` FOREIGN KEY (`idEntrenador`) REFERENCES `entrenadores` (`idEntrenador`);

--
-- Filtros para la tabla `membresias`
--
ALTER TABLE `membresias`
  ADD CONSTRAINT `fk_membresias_socios1` FOREIGN KEY (`idSocio`) REFERENCES `socios` (`idSocio`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
