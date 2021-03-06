-- MySQL Script generated by MySQL Workbench
-- Tue Mar 30 14:37:07 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
SET GLOBAL time_zone = '+3:00';
-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8mb4 ;
SHOW WARNINGS;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`airplane`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`airplane`;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `mydb`.`airplane` (
    `id` VARCHAR(45) NOT NULL,
    `year_` INT NULL,
    `model` VARCHAR(45) NULL,
    `brand` VARCHAR(45) NULL,
    `type_` TINYINT NOT NULL,
    `cant_max` INT NOT NULL,
    PRIMARY KEY (`id`)
)  ENGINE=INNODB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mydb`.`rute`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`rute` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `mydb`.`rute` (
    `id` VARCHAR(45) NOT NULL,
    `origin` VARCHAR(45) NOT NULL,
    `destination` VARCHAR(45) NOT NULL,
    `duration` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
)  ENGINE=INNODB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mydb`.`schedule_`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`schedule_` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `mydb`.`schedule_` (
    `id` VARCHAR(45) NOT NULL,
    `date_` DATETIME NOT NULL,
    PRIMARY KEY (`id`)
)  ENGINE=INNODB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mydb`.`user_`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`user_` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `mydb`.`user_` (
    `user_name` VARCHAR(45) NOT NULL,
    `password_` VARCHAR(45) NOT NULL,
    `rol` TINYINT NOT NULL,
    PRIMARY KEY (`user_name`)
)  ENGINE=INNODB;

-- -----------------------------------------------------
-- Table `mydb`.`flight`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`flight` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `mydb`.`flight` (
  `id` VARCHAR(45) NOT NULL,
  `rute_id` VARCHAR(45) NOT NULL,
  `airplane_id` VARCHAR(45) NOT NULL,
  `schedule_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_flight_rute1_idx` (`rute_id` ASC) VISIBLE,
  INDEX `fk_flight_airplane1_idx` (`airplane_id` ASC) VISIBLE,
  INDEX `fk_flight_schedule_1_idx` (`schedule_id` ASC) VISIBLE,
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
  CONSTRAINT `fk_flight_schedule_1`
    FOREIGN KEY (`schedule_id`)
    REFERENCES `mydb`.`schedule_` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mydb`.`ticket`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`ticket` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `mydb`.`ticket` (
  `id` VARCHAR(45) NOT NULL,
  `flight_id` VARCHAR(45) NOT NULL,
  `price` INT NOT NULL,
  `seat` INT NOT NULL,
  `discount` INT NOT NULL,
  INDEX `fk_ticket_flight1_idx` (`flight_id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_ticket_flight1`
    FOREIGN KEY (`flight_id`)
    REFERENCES `mydb`.`flight` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mydb`.`passenger`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`passenger` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `mydb`.`passenger` (
  `user_user_name` VARCHAR(45) NOT NULL,
  `name_` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `bob` DATETIME NULL,
  `address` VARCHAR(45) NULL,
  `work_phone` INT NULL,
  `cell_phone` INT NULL,
  `ticket_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_user_name`),
  INDEX `fk_passenger_user__idx` (`user_user_name` ASC) VISIBLE,
  INDEX `fk_passenger_ticket1_idx` (`ticket_id` ASC) VISIBLE,
  CONSTRAINT `fk_passenger_user_`
    FOREIGN KEY (`user_user_name`)
    REFERENCES `mydb`.`user_` (`user_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_passenger_ticket1`
    FOREIGN KEY (`ticket_id`)
    REFERENCES `mydb`.`ticket` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;


ALTER TABLE `mydb`.`passenger` 
DROP FOREIGN KEY `fk_passenger_ticket1`;
ALTER TABLE `mydb`.`passenger` 
DROP COLUMN `ticket_id`,
DROP INDEX `fk_passenger_ticket1_idx` ;
;

ALTER TABLE `mydb`.`ticket` 
ADD COLUMN `passenger_user` VARCHAR(45) NOT NULL AFTER `seat`,
ADD INDEX `passenger_user_idx` (`passenger_user` ASC) VISIBLE;
;
ALTER TABLE `mydb`.`ticket` 
ADD CONSTRAINT `passenger_user`
  FOREIGN KEY (`passenger_user`)
  REFERENCES `mydb`.`passenger` (`user_user_name`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

-- -----------------------------------------------------
-- TODOS LOS PROCEDIMIENTOS DE INSERTAR
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Procedure PRC_INSERT_AIRPLANE (CORRECTO)
-- Se inserta el airplane
-- -----------------------------------------------------
USE `mydb`;
DROP procedure IF EXISTS `mydb`.`PRC_INSERT_AIRPLANE`;
DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_INSERT_AIRPLANE`(id VARCHAR(45),year_ INT,
model varchar(45), brand varchar(45),type_ TINYINT, cant_max INT)
BEGIN

insert into airplane values(id,year_,model,brand,type_,cant_max);
END$$
DELIMITER ;
-- -----------------------------------------------------
-- Procedure PRC_INSERT_RUTE (CORRECTO)
-- Se inserta el rute
-- -----------------------------------------------------
USE `mydb`;
DROP procedure IF EXISTS `mydb`.`PRC_INSERT_RUTE`;
DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_INSERT_RUTE`(id VARCHAR(45),origin varchar(45),
destination varchar(45), duration varchar(45))
BEGIN

insert into rute values(id,origin,destination,duration);
END$$
DELIMITER ;

-- -----------------------------------------------------
-- Procedure PRC_INSERT_SCHEDULE(CORRECTO)
-- Se inserta el schedule
-- -----------------------------------------------------
USE `mydb`;
DROP procedure IF EXISTS `mydb`.`PRC_INSERT_SCHEDULE`;
DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_INSERT_SCHEDULE`(id VARCHAR(45), date_ DATETIME)
BEGIN

insert into schedule_ values(id, date_);
END$$
DELIMITER;

-- -----------------------------------------------------
-- Procedure PRC_INSERT_USER(CORRECTO)
-- Se inserta el user
-- -----------------------------------------------------
USE `mydb`;
DROP procedure IF EXISTS `mydb`.`PRC_INSERT_USER`;
DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_INSERT_USER`(user_name VARCHAR(45),password_ VARCHAR(45),
rol TINYINT)
BEGIN

insert into user_ values(user_name,password_,rol);
END$$
DELIMITER ;

-- -----------------------------------------------------
-- Procedure PRC_INSERT_FLIGHT(CORRECTO)
-- Se inserta el flight
-- -----------------------------------------------------

USE `mydb`;
DROP procedure IF EXISTS `mydb`.`PRC_INSERT_FLIGHT`;

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_INSERT_FLIGHT`(id VARCHAR(45),rute_id VARCHAR(45),
airplane_id VARCHAR(45), schedule_id VARCHAR(45))

BEGIN
insert into flight(id,rute_id,airplane_id,schedule_id) values (id,(select rute.id from rute where rute.id = rute_id),(select airplane.id from airplane where airplane.id = airplane_id),(select schedule_.id from schedule_ where schedule_.id = schedule_id));

END$$
DELIMITER ;

-- -----------------------------------------------------
-- Procedure PRC_INSERT_TICKET(CORRECTO)
-- Se inserta el ticket
-- -----------------------------------------------------

USE `mydb`;
DROP procedure IF EXISTS `mydb`.`PRC_INSERT_TICKET`;

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_INSERT_TICKET`(id VARCHAR(45),flight_id VARCHAR(45),
price INT, seat INT, passenger_user VARCHAR(45), discount INT)

BEGIN
insert into ticket(id,flight_id,price,seat, passenger_user, discount) values (id, (select flight.id from flight where flight.id = flight_id), price, seat, (select passenger.user_user_name from passenger where passenger.user_user_name = passenger_user), discount);

END$$
DELIMITER ;

-- -----------------------------------------------------
-- Procedure PRC_INSERT_PASSENGER(CORRECTO)
-- Se inserta el ticket
-- -----------------------------------------------------

USE `mydb`;
DROP procedure IF EXISTS `mydb`.`PRC_INSERT_PASSENGER`;

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_INSERT_PASSENGER`(user_user_name VARCHAR(45),name_ VARCHAR(50),
lastname VARCHAR(45), email VARCHAR(45),bob DATETIME,address VARCHAR(45),work_phone int,cell_phone int)

BEGIN
insert into passenger(user_user_name,name_,lastname,email,bob,address,work_phone,cell_phone) values ((select user_.user_name from user_ where user_.user_name = user_user_name),name_,lastname,email,bob,address,work_phone,cell_phone);

END$$
DELIMITER ;

-- -----------------------------------------------------
-- TODOS LOS PROCEDIMIENTOS DE LISTAR
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Procedure PRC_LIST_AIRPLANES
-- En este caso, lista de todos los airplanes
-- -----------------------------------------------------

USE `mydb`;
DROP procedure IF EXISTS `mydb`.`PRC_LIST_AIRPLANES`;

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_LIST_AIRPLANES`()
BEGIN
SELECT * FROM mydb.airplane;
END$$
DELIMITER ;
-- -----------------------------------------------------
-- Procedure PRC_LIST_RUTE
-- En este caso, lista de todas las rutes
-- -----------------------------------------------------

USE `mydb`;
DROP procedure IF EXISTS `mydb`.`PRC_LIST_RUTE`;

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_LIST_RUTE`()
BEGIN
SELECT * FROM mydb.rute;
END$$
DELIMITER ;

-- -----------------------------------------------------
-- Procedure PRC_LIST_SCHEDULE
-- En este caso, lista de todas los schedules
-- -----------------------------------------------------

USE `mydb`;
DROP procedure IF EXISTS `mydb`.`PRC_LIST_SCHEDULE`;

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_LIST_SCHEDULE`()
BEGIN
SELECT * FROM mydb.schedule_;
END$$
DELIMITER ;

-- -----------------------------------------------------
-- Procedure PRC_LIST_USER
-- En este caso, lista de todos los users
-- -----------------------------------------------------

USE `mydb`;
DROP procedure IF EXISTS `mydb`.`PRC_LIST_USER`;

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_LIST_USER`()
BEGIN
SELECT * FROM mydb.user_;
END$$
DELIMITER ;

-- -----------------------------------------------------
-- Procedure PRC_LIST_FLIGHT
-- En este caso, lista de todas los flights
-- -----------------------------------------------------

USE `mydb`;
DROP procedure IF EXISTS `mydb`.`PRC_LIST_FLIGHT`;

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_LIST_FLIGHT`()
BEGIN
SELECT * FROM mydb.flight;
END$$
DELIMITER ;

-- -----------------------------------------------------
-- Procedure PRC_LIST_TICKET
-- En este caso, lista de todas los tickets
-- -----------------------------------------------------

USE `mydb`;
DROP procedure IF EXISTS `mydb`.`PRC_LIST_TICKET`;

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_LIST_TICKET`()
BEGIN
SELECT * FROM mydb.ticket;
END$$
DELIMITER ;

-- -----------------------------------------------------
-- Procedure PRC_LIST_PASSENGER
-- En este caso, lista de todas los passenger
-- -----------------------------------------------------

USE `mydb`;
DROP procedure IF EXISTS `mydb`.`PRC_LIST_PASSENGER`;

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_LIST_PASSENGER`()
BEGIN
SELECT * FROM mydb.passenger;
END$$
DELIMITER ;
-- -----------------------------------------------------
-- TODOS LOS PROCEDIMIENTOS DE BUSCAR
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Procedure PRC_SEARCH_AIRPLANE
-- Busca el airplane por medio del ID
-- -----------------------------------------------------

USE `mydb`;
DROP procedure IF EXISTS `mydb`.`PRC_SEARCH_AIRPLANE`;

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_SEARCH_AIRPLANE`(P_AIRPLANE_ID VARCHAR(45))
BEGIN
select * from mydb.airplane where id = P_AIRPLANE_ID;
END$$
DELIMITER ;

-- -----------------------------------------------------
-- Procedure PRC_SEARCH_RUTE
-- Busca la rute por medio del ID
-- -----------------------------------------------------
USE `mydb`;
DROP procedure IF EXISTS `mydb`.`PRC_SEARCH_RUTE`;

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_SEARCH_RUTE`(P_RUTE_ID VARCHAR(45))
BEGIN
select * from mydb.rute where id = P_RUTE_ID;
END$$
DELIMITER ;

-- -----------------------------------------------------
-- Procedure PRC_SEARCH_SCHEDULE
-- Busca el schedule por medio del ID
-- -----------------------------------------------------
USE `mydb`;
DROP procedure IF EXISTS `mydb`.`PRC_SEARCH_SCHEDULE`;

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_SEARCH_SCHEDULE`(P_SCHEDULE_ID VARCHAR(45))
BEGIN
select * from mydb.schedule_ where id = P_SCHEDULE_ID;
END$$
DELIMITER ;

-- -----------------------------------------------------
-- Procedure PRC_SEARCH_USER
-- Busca el user por medio del user_name
-- -----------------------------------------------------
USE `mydb`;
DROP procedure IF EXISTS `mydb`.`PRC_SEARCH_USER`;

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_SEARCH_USER`(P_USER_NAME VARCHAR(45))
BEGIN
select * from mydb.user_ where user_name = P_USER_NAME;
END$$
DELIMITER ;

-- -----------------------------------------------------
-- Procedure PRC_SEARCH_FLIGHT
-- Busca el user por medio del id
-- -----------------------------------------------------
USE `mydb`;
DROP procedure IF EXISTS `mydb`.`PRC_SEARCH_FLIGHT`;

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_SEARCH_FLIGHT`(P_ID VARCHAR(45))
BEGIN
select * from mydb.flight where id = P_ID;
END$$
DELIMITER ;

-- -----------------------------------------------------
-- Procedure PRC_SEARCH_TICKET
-- Busca el user por medio del id
-- -----------------------------------------------------
USE `mydb`;
DROP procedure IF EXISTS `mydb`.`PRC_SEARCH_TICKET`;

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_SEARCH_TICKET`(P_ID VARCHAR(45))
BEGIN
select * from mydb.ticket where id = P_ID;
END$$
DELIMITER ;

-- -----------------------------------------------------
-- Procedure PRC_SEARCH_PASSENGER
-- Busca el user por medio del id
-- -----------------------------------------------------
USE `mydb`;
DROP procedure IF EXISTS `mydb`.`PRC_SEARCH_PASSENGER`;

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_SEARCH_PASSENGER`(P_USER_NAME VARCHAR(45))
BEGIN
select * from mydb.passenger where user_user_name = P_USER_NAME;
END$$
DELIMITER ;
-- -----------------------------------------------------
-- TODOS LOS PROCEDIMIENTOS DE BORRAR
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Procedure PRC_DELETE_AIRPLANE
-- En este caso, elimina el airplane
-- -----------------------------------------------------

USE `mydb`;
DROP procedure IF EXISTS `mydb`.`PRC_DELETE_AIRPLANE`;
DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_DELETE_AIRPLANE`(in P_AIRPLANE_ID VARCHAR(45))
BEGIN
DELETE FROM airplane
WHERE id =P_AIRPLANE_ID;
END$$
DELIMITER ;

-- -----------------------------------------------------
-- Procedure PRC_DELETE_RUTE
-- En este caso, elimina la rute
-- -----------------------------------------------------

USE `mydb`;
DROP procedure IF EXISTS `mydb`.`PRC_DELETE_RUTE`;
DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_DELETE_RUTE`(in P_RUTE_ID VARCHAR(45))
BEGIN
DELETE FROM rute
WHERE id =P_RUTE_ID;
END$$
DELIMITER ;

-- -----------------------------------------------------
-- Procedure PRC_DELETE_SCHEDULE
-- En este caso, elimina el schedule
-- -----------------------------------------------------

USE `mydb`;
DROP procedure IF EXISTS `mydb`.`PRC_DELETE_SCHEDULE`;
DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_DELETE_SCHEDULE`(in P_SCHEDULE_ID VARCHAR(45))
BEGIN
DELETE FROM schedule_
WHERE id =P_SCHEDULE_ID;
END$$
DELIMITER ;

-- -----------------------------------------------------
-- Procedure PRC_DELETE_USER
-- En este caso, elimina el user
-- -----------------------------------------------------

USE `mydb`;
DROP procedure IF EXISTS `mydb`.`PRC_DELETE_USER`;
DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_DELETE_USER`(in P_USER_NAME VARCHAR(45))
BEGIN
DELETE FROM user_
WHERE user_name =P_USER_NAME;
END$$
DELIMITER ;

-- -----------------------------------------------------
-- Procedure PRC_DELETE_FLIGHT
-- En este caso, elimina el flight
-- -----------------------------------------------------

USE `mydb`;
DROP procedure IF EXISTS `mydb`.`PRC_DELETE_FLIGHT`;
DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_DELETE_FLIGHT`(in P_ID VARCHAR(45))
BEGIN
DELETE FROM flight
WHERE id =P_ID;
END$$
DELIMITER ;

-- -----------------------------------------------------
-- Procedure PRC_DELETE_TICKET
-- En este caso, elimina el flight
-- -----------------------------------------------------

USE `mydb`;
DROP procedure IF EXISTS `mydb`.`PRC_DELETE_TICKET`;
DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_DELETE_TICKET`(in P_ID VARCHAR(45))
BEGIN
DELETE FROM ticket
WHERE id =P_ID;
END$$
DELIMITER ;

-- -----------------------------------------------------
-- Procedure PRC_DELETE_PASSENGER
-- En este caso, elimina el passenger
-- -----------------------------------------------------

USE `mydb`;
DROP procedure IF EXISTS `mydb`.`PRC_DELETE_PASSENGER`;
DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_DELETE_PASSENGER`(in P_USER_NAME VARCHAR(45))
BEGIN
DELETE FROM passenger
WHERE user_user_name =P_USER_NAME;
END$$
DELIMITER ;
-- -----------------------------------------------------
-- TODOS LOS PROCEDIMIENTOS DE ACTUALIZAR
-- -----------------------------------------------------

-- -----------------------------------------------------
-- procedure PRC_UPDATE_user_
-- Actualiza el airplane, excepto el id
-- -----------------------------------------------------

USE `mydb`;
DROP procedure IF EXISTS `mydb`.`PRC_UPDATE_AIRPLANE`;

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_UPDATE_AIRPLANE`( 
IN P_AIRPLANE_ID VARCHAR(45),
IN P_AIRPLANE_YEAR INT,
IN P_AIRPLANE_MODEL varchar(100),
IN P_AIRPLANE_BRAND varchar(100),
IN P_AIRPLANE_TYPE INT,
IN P_AIRPLANE_CANT_MAX INT
)

BEGIN
UPDATE airplane
SET
year_ = P_AIRPLANE_YEAR,
model = P_AIRPLANE_MODEL,
brand = P_AIRPLANE_BRAND,
type_ = P_AIRPLANE_TYPE,
cant_max = P_AIRPLANE_CANT_MAX
WHERE id = P_AIRPLANE_ID;
END$$
DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_UPDATE_RUTE
-- Actualiza la rute, excepto el id
-- -----------------------------------------------------

USE `mydb`;
DROP procedure IF EXISTS `mydb`.`PRC_UPDATE_RUTE`;

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_UPDATE_RUTE`( 
IN P_RUTE_ID VARCHAR(45),
IN P_RUTE_ORIGIN varchar(100),
IN P_RUTE_DESTINATION varchar(100),
IN P_RUTE_DURATION varchar(100)
)
BEGIN
UPDATE rute
SET
origin = P_RUTE_ORIGIN,
destination = P_RUTE_DESTINATION,
duration = P_RUTE_DURATION
WHERE id = P_RUTE_ID;
END$$
DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_UPDATE_SCHEDULE
-- Actualiza la rute, excepto el id
-- -----------------------------------------------------

USE `mydb`;
DROP procedure IF EXISTS `mydb`.`PRC_UPDATE_SCHEDULE`;

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_UPDATE_SCHEDULE`( 
IN P_SCHEDULE_ID VARCHAR(45),
IN P_SCHEDULE_DATE DATETIME
)

BEGIN
UPDATE schedule_
SET
date_ = P_SCHEDULE_DATE
WHERE id = P_SCHEDULE_ID;
END$$
DELIMITER ;


-- -----------------------------------------------------
-- procedure PRC_UPDATE_USER
-- Actualiza la user, excepto el user_name
-- -----------------------------------------------------

USE `mydb`;
DROP procedure IF EXISTS `mydb`.`PRC_UPDATE_USER`;

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_UPDATE_USER`( 
IN P_USER_NAME VARCHAR(45),
IN P_USER_PASSWORD VARCHAR(45),
IN P_USER_ROL int
)
BEGIN
UPDATE user_
SET
password_ = P_USER_PASSWORD,
rol = P_USER_ROL
WHERE user_name = P_USER_NAME;
END$$
DELIMITER ;


-- -----------------------------------------------------
-- procedure PRC_UPDATE_FLIGHT
-- Actualiza el flight, excepto el id
-- -----------------------------------------------------

USE `mydb`;
DROP procedure IF EXISTS `mydb`.`PRC_UPDATE_FLIGHT`;

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_UPDATE_FLIGHT`( 
IN P_FLIGHT_ID VARCHAR(45),
IN P_FLIGHT_RUTE VARCHAR(45),
IN P_FLIGHT_AIRPLANE VARCHAR(45),
IN P_FLIGHT_SCHEDULE VARCHAR(45)
)

BEGIN
UPDATE flight
SET
rute_id = P_FLIGHT_RUTE,
airplane_id = P_FLIGHT_AIRPLANE,
schedule_id = P_FLIGHT_SCHEDULE
WHERE id = P_FLIGHT_ID;
END$$
DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_UPDATE_TICKET
-- Actualiza el ticket, excepto el id
-- -----------------------------------------------------

USE `mydb`;
DROP procedure IF EXISTS `mydb`.`PRC_UPDATE_TICKET`;

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_UPDATE_TICKET`( 
IN P_TICKET_ID VARCHAR(45),
IN P_TICKET_FLIGHT VARCHAR(45),
IN P_TICKET_PRICE int,
IN P_TICKET_SEAT int,
IN P_TICKET_passenger VARCHAR(45),
in P_TICKET_DISCOUNT int
)

BEGIN
UPDATE ticket
SET
flight_id = P_TICKET_FLIGHT,
price = P_TICKET_PRICE,
seat = P_TICKET_SEAT,
passenger_user = P_TICKET_passenger,
discount = P_TICKET_DISCOUNT
WHERE id = P_TICKET_ID;
END$$
DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_UPDATE_PASSENGER
-- Actualiza el passenger, excepto el user_user_name
-- -----------------------------------------------------

USE `mydb`;
DROP procedure IF EXISTS `mydb`.`PRC_UPDATE_PASSENGER`;

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_UPDATE_PASSENGER`( 
IN P_PASSENGER_USER_NAME VARCHAR(45),
IN P_PASSENGER_NAME VARCHAR(45),
IN P_PASSENGER_LASTNAME VARCHAR(45),
IN P_PASSENGER_EMAIL VARCHAR(45),
IN P_PASSENGER_BOB DATETIME,
IN P_PASSENGER_ADDRESS VARCHAR(45),
IN P_PASSENGER_WORK_PHONE INT,
IN P_PASSENGER_CELL_PHONE INT
)

BEGIN
UPDATE passenger
SET
name_ = P_PASSENGER_NAME,
lastname = P_PASSENGER_LASTNAME,
email = P_PASSENGER_EMAIL,
bob = P_PASSENGER_BOB,
address = P_PASSENGER_ADDRESS,
work_phone = P_PASSENGER_WORK_PHONE,
cell_phone = P_PASSENGER_CELL_PHONE
WHERE user_user_name = P_PASSENGER_USER_NAME;
END$$
DELIMITER ;
-- -----------------------------------------------------
-- PRUEBAS DE LOS PROCEDIMIENTOS
-- TODOS FUNCIONAN CORRECTAMENTE
-- -----------------------------------------------------

call PRC_INSERT_AIRPLANE('5094A',2020,'Iberia','Airbus A330',01,150);
call PRC_INSERT_AIRPLANE('6589B',2019,'Iberia','Airbus B440',02,140);
call PRC_LIST_AIRPLANES();
call PRC_SEARCH_AIRPLANE('6589B');
call PRC_UPDATE_AIRPLANE('5094A',2020,'Iberia','Airbus A330',01,160);

call PRC_INSERT_RUTE('5296','Estados Unidos','Mexico','120');
call PRC_INSERT_RUTE('7854','Costa Rica','Panama','300');
call PRC_LIST_RUTE();
call PRC_SEARCH_RUTE('5296');
call PRC_UPDATE_RUTE('5296','Estados Unidos','Mexico','200');

call PRC_INSERT_SCHEDULE('01','1996-12-27');
call PRC_INSERT_SCHEDULE('02','1996-12-27');
call PRC_LIST_SCHEDULE();
call PRC_SEARCH_SCHEDULE('01');
call PRC_UPDATE_SCHEDULE('02','1995-12-27');

call PRC_INSERT_USER('kev_qc','2095',1);
call PRC_INSERT_USER('mari_vm','2548',0);
call PRC_LIST_USER();

call PRC_INSERT_FLIGHT('5789','5296','5094A','01');
call PRC_INSERT_FLIGHT('7845','7854','6589B','02');
call PRC_LIST_FLIGHT();
call PRC_SEARCH_FLIGHT('5789');
call PRC_UPDATE_FLIGHT('5789','5296','5094A','02');

call PRC_INSERT_PASSENGER('kev_qc','Kevin','Quesada','kevin.q.c20@hotmail.com','1995-06-20','Heredia',22604859,84258285);
call PRC_INSERT_PASSENGER('mari_vm','Mariana','Valverde','mari@hotmail.com','1994-08-05','Heredia',22604859,84258285);
call PRC_LIST_PASSENGER();

SELECT SUM(v.price) AS Total,
MONTHNAME(s.date_) AS Mes
FROM ticket v, schedule_ s, flight f
WHERE v.flight_id = f.id AND f.schedule_id = s.id
GROUP BY Mes;

SELECT SUM(v.price) AS Total,
YEAR(s.date_) AS Year
FROM ticket v, schedule_ s, flight f
WHERE v.flight_id = f.id AND f.schedule_id = s.id AND YEAR(s.date_) = 'parametro'
GROUP BY Year;

SELECT passenger_user
FROM ticket v, airplane s, flight f
WHERE v.flight_id = 'parametro' AND s.id = f.airplane_id AND f.id = v.flight_id;

SELECT r.id, count(t.id) AS Total
FROM ticket t, flight f, rute r
WHERE t.flight_id = f.id and f.rute_id = r.id
GROUP BY r.id
ORDER BY Total DESC
LIMIT 5;
