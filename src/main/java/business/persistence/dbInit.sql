/*
    You might want to rename the database to your own needs.
    If so, please substitute `startcode` with whatever your project is called.
 */

CREATE DATABASE  IF NOT EXISTS `startcode`;

USE `startcode`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(90) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(20) NOT NULL DEFAULT 'student',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES
(1,'barbie@world.dk','jensen','student'),
(2,'ken@world.com','jensen','student'),
(3,'robin@gotham.com','batman','admin');
UNLOCK TABLES;

