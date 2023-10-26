CREATE DATABASE IF NOT EXISTS `test_movie_night_planner`; #This is a test database
USE `test_movie_night_planner`;

DROP TABLE IF EXISTS `providers`;
DROP TABLE IF EXISTS `watchlist`;

CREATE TABLE `providers` (
  `id` int(11) NOT NULL,
  `technical_name` varchar(100),
  `icon_url` varchar(200),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `watchlist` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `title_id` int NOT NULL,
  `user_id` bigint NOT NULL,
  `media_type` enum('FILM','TV_SHOW') NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKden7i83qo2swnr5br4wgc5r7j` (`user_id`),
  CONSTRAINT `FKden7i83qo2swnr5br4wgc5r7j` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;