DROP DATABASE IF EXISTS `user_database`;
CREATE DATABASE `user_database`;
USE `user_database`;
SET SQL_SAFE_UPDATES = 0;
CREATE TABLE `user` (
  id int NOT NULL,
  username varchar(250) NOT NULL,
  password varchar(250),
  PRIMARY KEY (id, username)
);
 
 INSERT INTO `user` VALUES (1,'tomcat','123456');
 INSERT INTO `user` VALUES (2,'merry','789101');
