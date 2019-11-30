SET FOREIGN_KEY_CHECKS = 0;
USE `springbootdb`;
DROP TABLE IF EXISTS `category`;
DROP TABLE IF EXISTS `product`;
DROP TABLE IF EXISTS `role`;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `user_role`;
SET foreign_key_checks = 1;
/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE IF NOT EXISTS `springbootdb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `springbootdb`;

CREATE TABLE `category` (
  `category_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `description` MEDIUMTEXT DEFAULT NULL,
  `created_date` TIMESTAMP NOT NULL DEFAULT '1970-01-01 00:00:01' comment 'meta data: record creation timestamp',
  `updated_date` TIMESTAMP NOT NULL DEFAULT '1970-01-01 00:00:01' comment 'meta data: record update timestamp',
  PRIMARY KEY (`category_id`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

CREATE TABLE `product` (
  `product_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `category_id` BIGINT(20) NOT NULL,
  `product_name` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `description`  MEDIUMTEXT DEFAULT NULL,
  `created_date` TIMESTAMP NOT NULL DEFAULT '1970-01-01 00:00:01' comment 'meta data: record creation timestamp',
  `updated_date` TIMESTAMP NOT NULL DEFAULT '1970-01-01 00:00:01' comment 'meta data: record update timestamp',
  PRIMARY KEY (`product_id`),
  KEY `category_id_idx` (`category_id`),
  CONSTRAINT `fk_product_category` FOREIGN KEY (`category_id`) REFERENCES
  `category` (`category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=latin1;

CREATE TABLE `role` (
  `role_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `role_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

CREATE TABLE `user` (
  `user_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `active` TINYINT(1) NOT NULL COMMENT 'active status of the user',
  `email` VARCHAR(100) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

CREATE TABLE `user_role` (
    user_id BIGINT(20) NOT NULL,
    role_id BIGINT(20) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES `user` (user_id) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (role_id) REFERENCES `role` (role_id) ON DELETE RESTRICT ON UPDATE CASCADE,
    PRIMARY KEY (user_id, role_id)
) ENGINE=INNODB DEFAULT CHARSET=latin1;


REPLACE INTO `role` VALUES (1,'ADMIN');
INSERT INTO `user` (`user_id`, `active`, `email`, `first_name`, `last_name`, `password`) VALUES ('1', b'1', 'testone', 'TestUser', 'One', '$2a$10$9XEgY2ZmIn0.EVNGVrRq1uG6f1W3BO05ZikQ6wqXPjG2R91Je8eTC');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('1', '1');