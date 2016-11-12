-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema yakukawsay
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema yakukawsay
-- -----------------------------------------------------
--CREATE SCHEMA IF NOT EXISTS `yakukawsay` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
--USE `yakukawsay` ;

-- -----------------------------------------------------
-- Table `yakukawsay`.`type_indicator`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `yakukawsay`.`type_indicator` (`id` INT NOT NULL AUTO_INCREMENT, `type` VARCHAR(45) NOT NULL, PRIMARY KEY (`id`))ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yakukawsay`.`Device`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `yakukawsay`.`Device` ( `id` INT NOT NULL AUTO_INCREMENT, `model` VARCHAR(45) NOT NULL, `date` DATE NOT NULL, `latitude` VARCHAR(45) NOT NULL, `longitude` VARCHAR(45) NOT NULL, `type_indicator_id` INT NOT NULL, PRIMARY KEY (`id`, `type_indicator_id`), INDEX `fk_Device_type_indicator_idx` (`type_indicator_id` ASC), CONSTRAINT `fk_Device_type_indicator` FOREIGN KEY (`type_indicator_id`) REFERENCES `yakukawsay`.`type_indicator` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION)ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yakukawsay`.`data`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `yakukawsay`.`data` ( `id` INT NOT NULL AUTO_INCREMENT, `date` VARCHAR(45) NULL, `value` DECIMAL(10,0) NOT NULL, `Device_id` INT NOT NULL, `Device_type_indicator_id` INT NOT NULL, PRIMARY KEY (`id`, `Device_id`, `Device_type_indicator_id`), INDEX `fk_data_Device1_idx` (`Device_id` ASC, `Device_type_indicator_id` ASC), CONSTRAINT `fk_data_Device1` FOREIGN KEY (`Device_id` , `Device_type_indicator_id`) REFERENCES `yakukawsay`.`Device` (`id` , `type_indicator_id`) ON DELETE NO ACTION ON UPDATE NO ACTION)ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;