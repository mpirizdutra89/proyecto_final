
-- -----------------------------------------------------
-- Table `gimnacio`.`socios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gimnacio`.`socios` ;

CREATE  TABLE IF NOT EXISTS `gimnacio`.`socios` (
  `idSocio` INT NOT NULL AUTO_INCREMENT ,
  `dni` VARCHAR(12) NOT NULL ,
  `nombre` VARCHAR(45) NOT NULL ,
  `apellido` VARCHAR(45) NOT NULL ,
  `edad` INT NOT NULL ,
  `correo` VARCHAR(100) NULL ,
  `telefono` VARCHAR(20) NOT NULL ,
  PRIMARY KEY (`idSocio`) ,
  UNIQUE INDEX `dni_UNIQUE` (`dni` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gimnacio`.`membresia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gimnacio`.`membresias` ;

CREATE  TABLE IF NOT EXISTS `gimnacio`.`membresias` (
  `idMembresia` INT NOT NULL AUTO_INCREMENT ,
  `idSocio` INT NOT NULL ,
  `tipo` VARCHAR(45) NULL COMMENT ' Tipo de membresía (mensual, anual, etc.).\nVamos usar enum dedsde la bd' ,
  `fecha_inicio` DATE NULL ,
  `fecha_fin` DATE NULL ,
  PRIMARY KEY (`idMembresia`) ,
  INDEX `fk_membresias_socios1_idx` (`idSocio` ASC) ,
  CONSTRAINT `fk_membresias_socios1`
    FOREIGN KEY (`idSocio` )
    REFERENCES `gimnacio`.`socios` (`idSocio` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gimnacio`.`entrenadores`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gimnacio`.`entrenadores` ;

CREATE  TABLE IF NOT EXISTS `gimnacio`.`entrenadores` (
  `idEntrenador` INT NOT NULL AUTO_INCREMENT ,
  `dni` VARCHAR(12) NOT NULL ,
  `nombre` VARCHAR(45) NOT NULL ,
  `apellido` VARCHAR(45) NOT NULL ,
  `especialidad` VARCHAR(60) NOT NULL ,
  `disponibilidad` VARCHAR(80) NOT NULL COMMENT 'El horiario del profesor' ,
  PRIMARY KEY (`idEntrenador`) ,
  UNIQUE INDEX `dni_UNIQUE` (`dni` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gimnacio`.`clases`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gimnacio`.`clases` ;

CREATE  TABLE IF NOT EXISTS `gimnacio`.`clases` (
  `idclase` INT NOT NULL AUTO_INCREMENT ,
  `idEntrenador` INT NOT NULL ,
  `nombre` VARCHAR(45) NULL ,
  `horario` TIME NOT NULL ,
  `capacidad` INT NOT NULL ,
  PRIMARY KEY (`idclase`) ,
  INDEX `fk_clases_entrenadores1_idx` (`idEntrenador` ASC) ,
  CONSTRAINT `fk_clases_entrenadores1`
    FOREIGN KEY (`idEntrenador` )
    REFERENCES `gimnacio`.`entrenadores` (`idEntrenador` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gimnacio`.`inscribirseClase`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gimnacio`.`inscribirseClases` ;

CREATE  TABLE IF NOT EXISTS `gimnacio`.`inscribirseClases` (
  `idInscripcionClase` INT NOT NULL AUTO_INCREMENT ,
  `idSocio` INT NOT NULL ,
  `idclase` INT NOT NULL ,
  `fecha` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP() ,
  INDEX `fk_inscribirseClase_socios1_idx` (`idSocio` ASC) ,
  INDEX `fk_inscribirseClase_clases1_idx` (`idclase` ASC) ,
  PRIMARY KEY (`idInscripcionClase`) ,
  CONSTRAINT `fk_inscribirseClase_socios1`
    FOREIGN KEY (`idSocio` )
    REFERENCES `gimnacio`.`socios` (`idSocio` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_inscribirseClase_clases1`
    FOREIGN KEY (`idclase` )
    REFERENCES `gimnacio`.`clases` (`idclase` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

