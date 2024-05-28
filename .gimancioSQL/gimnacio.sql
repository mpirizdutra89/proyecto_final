-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 28-05-2024 a las 21:19:26
-- Versión del servidor: 8.2.0
-- Versión de PHP: 8.2.13

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
-- Estructura de tabla para la tabla `clases`
--

DROP TABLE IF EXISTS `clases`;
CREATE TABLE IF NOT EXISTS `clases` (
  `idclases` int NOT NULL AUTO_INCREMENT,
  `idEntrenadore` int NOT NULL,
  `nombre` varchar(45) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `horario` time NOT NULL,
  `capacidad` int NOT NULL,
  PRIMARY KEY (`idclases`),
  KEY `fk_clases_entrenadores1_idx` (`idEntrenadore`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrenadores`
--

DROP TABLE IF EXISTS `entrenadores`;
CREATE TABLE IF NOT EXISTS `entrenadores` (
  `idEntrenadore` int NOT NULL AUTO_INCREMENT,
  `dni` varchar(12) COLLATE utf8mb4_general_ci NOT NULL,
  `nombre` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `apellido` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `especialidad` varchar(60) COLLATE utf8mb4_general_ci NOT NULL,
  `disponibilidad` varchar(80) COLLATE utf8mb4_general_ci NOT NULL COMMENT 'El horiario del profesor',
  PRIMARY KEY (`idEntrenadore`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscribirseclase`
--

DROP TABLE IF EXISTS `inscribirseclase`;
CREATE TABLE IF NOT EXISTS `inscribirseclase` (
  `clases_idclases` int NOT NULL,
  `socios_idSocio` int NOT NULL,
  `fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`clases_idclases`,`socios_idSocio`),
  KEY `fk_clases_has_socios_socios1_idx` (`socios_idSocio`),
  KEY `fk_clases_has_socios_clases1_idx` (`clases_idclases`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `membresias`
--

DROP TABLE IF EXISTS `membresias`;
CREATE TABLE IF NOT EXISTS `membresias` (
  `idMembresias` int NOT NULL AUTO_INCREMENT,
  `idSocio` int NOT NULL,
  `tipo` varchar(45) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT ' Tipo de membresía (mensual, anual, etc.).\nVamos usar enum dedsde la bd',
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  PRIMARY KEY (`idMembresias`),
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
  PRIMARY KEY (`idSocio`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `clases`
--
ALTER TABLE `clases`
  ADD CONSTRAINT `fk_clases_entrenadores1` FOREIGN KEY (`idEntrenadore`) REFERENCES `entrenadores` (`idEntrenadore`);

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
