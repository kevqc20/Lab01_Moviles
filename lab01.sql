-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user` (
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `rol` TINYINT NOT NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`passenger`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`passenger` (
  `user_username` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `dob` DATETIME NULL,
  `address` VARCHAR(45) NULL,
  `work_phone` INT NULL,
  `cell_phone` INT NULL,
  PRIMARY KEY (`user_username`),
  INDEX `fk_passenger_user_idx` (`user_username` ASC) ,
  CONSTRAINT `fk_passenger_user`
    FOREIGN KEY (`user_username`)
    REFERENCES `mydb`.`user` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`rute`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`rute` (
  `id` VARCHAR(45) NOT NULL,
  `origin` VARCHAR(45) NOT NULL,
  `destination` VARCHAR(45) NOT NULL,
  `duration` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`schedule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`schedule` (
  `id` VARCHAR(45) NOT NULL,
  `day` INT NOT NULL,
  `hour` INT NOT NULL,
  `minute` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`airplane`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`airplane` (
  `id` VARCHAR(45) NOT NULL,
  `year` INT NULL,
  `model` VARCHAR(45) NULL,
  `brand` VARCHAR(45) NULL,
  `type` TINYINT NOT NULL,
  `cant_max` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`flight`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`flight` (
  `id` VARCHAR(45) NOT NULL,
  `rute_id` VARCHAR(45) NOT NULL,
  `airplane_id` VARCHAR(45) NOT NULL,
  `schedule_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_flight_rute1_idx` (`rute_id` ASC) ,
  INDEX `fk_flight_airplane1_idx` (`airplane_id` ASC) ,
  INDEX `fk_flight_schedule1_idx` (`schedule_id` ASC) ,
  CONSTRAINT `fk_flight_rute1`
    FOREIGN KEY (`rute_id`)
    REFERENCES `mydb`.`rute` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_flight_airplane1`
    FOREIGN KEY (`airplane_id`)
    REFERENCES `mydb`.`airplane` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_flight_schedule1`
    FOREIGN KEY (`schedule_id`)
    REFERENCES `mydb`.`schedule` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ticket` (
  `id` VARCHAR(45) NOT NULL,
  `flight_id` VARCHAR(45) NOT NULL,
  `price` INT NOT NULL,
  `seat` INT NOT NULL,
  `id_user` VARCHAR(45) NOT NULL,
  `user_username` VARCHAR(45) NOT NULL,
  INDEX `fk_ticket_flight1_idx` (`flight_id` ASC) ,
  PRIMARY KEY (`id`),
  INDEX `fk_ticket_user1_idx` (`user_username` ASC) ,
  CONSTRAINT `fk_ticket_flight1`
    FOREIGN KEY (`flight_id`)
    REFERENCES `mydb`.`flight` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_user1`
    FOREIGN KEY (`user_username`)
    REFERENCES `mydb`.`user` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
