CREATE DATABASE IF NOT EXISTS `game_store`;

USE `game_store`;

CREATE TABLE IF NOT EXISTS `game_store`.`user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE
);


CREATE TABLE IF NOT EXISTS `game_store`.`shopping_cart` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC) VISIBLE,
  FOREIGN KEY (`user_id`)
  REFERENCES `game_store`.`user` (`id`)
);

 
CREATE TABLE IF NOT EXISTS `game_store`.`product` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `price` DECIMAL NOT NULL,
  `score` SMALLINT NOT NULL,
  `image` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `game_store`.`cart_product` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `shopping_cart_id` BIGINT NOT NULL,
  `product_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`shopping_cart_id`)
  REFERENCES `game_store`.`shopping_cart` (`id`),
  FOREIGN KEY (`product_id`)
  REFERENCES `game_store`.`product` (`id`)
);

INSERT INTO user VALUES(null, "user");
INSERT INTO product VALUES(null, "produto", 1, 1, "img");


