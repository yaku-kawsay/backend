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


-- -----------------------------------------------------
-- Table `yakukawsay`.`metric`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `yakukawsay`.`metric` ( `id` INT NOT NULL AUTO_INCREMENT, `indicator` VARCHAR(45) NOT NULL, `data` DECIMAL(10,0) NOT NULL, `date` DATE NOT NULL, `unity` VARCHAR(45) NOT NULL, `metric` VARCHAR(45) NOT NULL, `Device_id` INT NOT NULL, `Device_type_indicator_id` INT NOT NULL, PRIMARY KEY (`id`, `Device_id`, `Device_type_indicator_id`), INDEX `fk_metrica_Device1_idx` (`Device_id` ASC, `Device_type_indicator_id` ASC), CONSTRAINT `fk_metrica_Device1` FOREIGN KEY (`Device_id` , `Device_type_indicator_id`) REFERENCES `yakukawsay`.`Device` (`id` , `type_indicator_id`) ON DELETE NO ACTION ON UPDATE NO ACTION) ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`period`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `yakukawsay`.`period` ( `id` INT NOT NULL, `filter_time` VARCHAR(45) NOT NULL, PRIMARY KEY (`id`)) ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`general_report`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `yakukawsay`.`general_report` ( `id` INT NOT NULL, `indicator` VARCHAR(45) NOT NULL, `data` DECIMAL(10,0) NOT NULL, `date` DATE NOT NULL, `period_id` INT NOT NULL, PRIMARY KEY (`id`, `period_id`), INDEX `fk_general_report_period1_idx` (`period_id` ASC), CONSTRAINT `fk_general_report_period1` FOREIGN KEY (`period_id`) REFERENCES `yakukawsay`.`period` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION) ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`report`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `yakukawsay`.`report` ( `id` INT NOT NULL, `date` DATE NOT NULL, `indicator` VARCHAR(45) NOT NULL, `data` DECIMAL(10,0) NULL, `general_report_id` INT NOT NULL, PRIMARY KEY (`id`, `general_report_id`), INDEX `fk_report_general_report1_idx` (`general_report_id` ASC), CONSTRAINT `fk_report_general_report1` FOREIGN KEY (`general_report_id`) REFERENCES `yakukawsay`.`general_report` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION) ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`report_has_metrica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `yakukawsay`.`report_has_metrica` ( `report_id` INT NOT NULL, `metrica_id` INT NOT NULL, `metrica_Device_id` INT NOT NULL, `metrica_Device_type_indicator_id` INT NOT NULL, PRIMARY KEY (`report_id`, `metrica_id`, `metrica_Device_id`, `metrica_Device_type_indicator_id`), INDEX `fk_report_has_metrica_metrica1_idx` (`metrica_id` ASC, `metrica_Device_id` ASC, `metrica_Device_type_indicator_id` ASC), INDEX `fk_report_has_metrica_report1_idx` (`report_id` ASC), CONSTRAINT `fk_report_has_metrica_report1` FOREIGN KEY (`report_id`) REFERENCES `yakukawsay`.`report` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION, CONSTRAINT `fk_report_has_metrica_metrica1` FOREIGN KEY (`metrica_id` , `metrica_Device_id` , `metrica_Device_type_indicator_id`) REFERENCES `yakukawsay`.`metric` (`id` , `Device_id` , `Device_type_indicator_id`) ON DELETE NO ACTION ON UPDATE NO ACTION) ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;