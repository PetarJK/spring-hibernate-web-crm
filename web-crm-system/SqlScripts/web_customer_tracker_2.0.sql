-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema web_customer_tracker
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema web_customer_tracker
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `web_customer_tracker` DEFAULT CHARACTER SET latin1 ;
-- -----------------------------------------------------
-- Schema web_customer_tracker
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema web_customer_tracker
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `web_customer_tracker` DEFAULT CHARACTER SET latin1 ;
-- -----------------------------------------------------
-- Schema hb_student_tracker
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema hb-05-many-to-many
-- -----------------------------------------------------
USE `web_customer_tracker` ;

-- -----------------------------------------------------
-- Table `web_customer_tracker`.`sales_representative`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `web_customer_tracker`.`sales_representative` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL DEFAULT NULL,
  `last_name` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `web_customer_tracker`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `web_customer_tracker`.`customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL DEFAULT NULL,
  `last_name` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 15
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `web_customer_tracker`.`customer_sales_representative`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `web_customer_tracker`.`customer_sales_representative` (
  `customer_id` INT NOT NULL,
  `sales_representative_id` INT NOT NULL,
  PRIMARY KEY (`customer_id`, `sales_representative_id`),
  INDEX `fk_customer_sales_representative_sales_representative1_idx` (`sales_representative_id` ASC) VISIBLE,
  CONSTRAINT `fk_customer_sales_representative_customer`
    FOREIGN KEY (`customer_id`)
    REFERENCES `web_customer_tracker`.`customer` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_customer_sales_representative_sales_representative1`
    FOREIGN KEY (`sales_representative_id`)
    REFERENCES `web_customer_tracker`.`sales_representative` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;

USE `web_customer_tracker` ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
