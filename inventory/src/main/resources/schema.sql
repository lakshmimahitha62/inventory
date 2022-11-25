
CREATE TABLE `inventory` (
  `id` int NOT NULL AUTO_INCREMENT,
  `reset_qty` bigint NOT NULL,
  `available_quantity` bigint NOT NULL,
  `location_number` int NOT NULL,
  `material_id` varchar(255) DEFAULT NULL,
  `order_quantity` bigint NOT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

CREATE TABLE `login` (
  `user_id` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ;


CREATE TABLE `orders` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `local_date` date DEFAULT NULL,
  `local_time` time DEFAULT NULL,
  `location_number` bigint DEFAULT NULL,
  `material_number` int DEFAULT NULL,
  `order_quantity` bigint DEFAULT NULL,
  `order_status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ;

CREATE TABLE `rest_inventor` (
  `location_number` int NOT NULL AUTO_INCREMENT,
  `reset_qty` bigint NOT NULL,
  `material_id` varchar(255) DEFAULT NULL,
  `reset_date` date DEFAULT NULL,
  PRIMARY KEY (`location_number`)
);

CREATE TABLE `users` (
  `user_id` varchar(255) NOT NULL,
  `dob` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ;


