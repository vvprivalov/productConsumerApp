BEGIN;
USE `product-consumer-scheme`;
DROP TABLE IF EXISTS products;
CREATE TABLE IF NOT EXISTS products( id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(45) NOT NULL, price INT NOT NULL);
INSERT INTO `products` (name, price) VALUES ('Молоко', 14), ('Кефир', 21), ('Сметана', 32), ('Сыр', 64), ('Творог', 29);
DROP TABLE IF EXISTS consumers;
CREATE TABLE IF NOT EXISTS consumers(id INT AUTO_INCREMENT PRIMARY KEY , name VARCHAR(45));

COMMIT;