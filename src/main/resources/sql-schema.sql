drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items` (
    `item_ID` INT(11) NOT NULL AUTO_INCREMENT,
    `item_name` VARCHAR(40) DEFAULT NULL,
    `item_price` DOUBLE DEFAULT NULL,
    PRIMARY KEY (`item_ID`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
    `order_ID` INT(11) NOT NULL AUTO_INCREMENT,
    `fk_customer_id` INT NOT NULL,
    `order_date` VARCHAR(50) DEFAULT NULL,
    PRIMARY KEY (`order_ID`),
    FOREIGN KEY (`fk_customer_id`) REFERENCES customers(`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`order_items` (
    `orderdetails_id` INT(11) NOT NULL AUTO_INCREMENT,
    `fk_order_id` INT NOT NULL,
    `fk_item_id` INT NOT NULL,
    PRIMARY KEY (`orderdetails_id`),
    FOREIGN KEY (`fk_order_id`) REFERENCES orders(`order_ID`),
	FOREIGN KEY (`fk_item_id`) REFERENCES items(`item_ID`)
);

