CREATE DATABASE IF NOT EXISTS `test_movie_night_planner`; #This is a test database
USE `test_movie_night_planner`;

DROP TABLE IF EXISTS `providers`;

CREATE TABLE `providers` (
  `id` int(11) NOT NULL,
  `technical_name` varchar(100),
  `icon_url` varchar(200),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;