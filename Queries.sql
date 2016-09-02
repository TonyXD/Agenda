CREATE SCHEMA `agenda` ;

CREATE TABLE `agenda`.`personas` (
  `idPersona` INT NOT NULL,
  `Nombre` VARCHAR(45) NULL,
  `Telefono` VARCHAR(45) NULL,
  `Direccion` VARCHAR(45) NULL,
  `NroCalle` INT NULL,
  `NroPiso` INT NULL,
  `NroDpto` VARCHAR(45) NULL,
  `DirEmail` VARCHAR(45) NULL,
  `FechaCumpleaños` DATE NULL,
  PRIMARY KEY (`idpersona`));


CREATE TABLE `agenda`.`localidad` (
  `idLocalidad` INT NOT NULL AUTO_INCREMENT,
  `Descripcion` VARCHAR(45) NOT NULL,
  `CodigoPostal` INT,
  PRIMARY KEY (`idLocalidad`));

  CREATE TABLE `agenda`.`contacto` (
  `idContacto` INT NOT NULL AUTO_INCREMENT,
  `Descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`idContacto`));

  
  ALTER TABLE `agenda`.`personas` 
ADD COLUMN `IdLocalidad` INT NULL AFTER `FechaCumpleaños`,
ADD COLUMN `IdContacto` INT NULL AFTER `IdLocalidad`,
ADD INDEX `IdLocalidad_idx` (`IdLocalidad` ASC),
ADD INDEX `IdContacto_idx` (`IdContacto` ASC);
ALTER TABLE `agenda`.`personas` 
ADD CONSTRAINT `IdLocalidad`
  FOREIGN KEY (`IdLocalidad`)
  REFERENCES `agenda`.`localidad` (`idLocalidad`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `IdContacto`
  FOREIGN KEY (`IdContacto`)
  REFERENCES `agenda`.`contacto` (`idContacto`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;