BEGIN;
DROP SCHEMA IF EXISTS "productConsumerSchema" CASCADE;
CREATE SCHEMA IF NOT EXISTS "productConsumerSchema";
SET SEARCH_PATH = "productConsumerSchema";
DROP TABLE IF EXISTS "consumers-products";
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS consumers;
CREATE TABLE IF NOT EXISTS products( id BIGSERIAL PRIMARY KEY, name VARCHAR(45) NOT NULL, price INT NOT NULL);
INSERT INTO products (name, price) VALUES ('Молоко', 14), ('Кефир', 21), ('Сметана', 32), ('Сыр', 64), ('Творог', 29);
CREATE TABLE IF NOT EXISTS consumers(id BIGSERIAL PRIMARY KEY, name VARCHAR(45) NOT NULL);
INSERT INTO consumers (name) VALUES ('Сергей'), ('Иван'), ('Андрей'), ('Петр'), ('Семён');
CREATE TABLE IF NOT EXISTS "consumers-products" (consumer_id INT NOT NULL, product_id INT NOT NULL,
    FOREIGN KEY (consumer_id) REFERENCES consumers(id), FOREIGN KEY (product_id) REFERENCES products(id));
INSERT INTO "consumers-products" VALUES (1,1), (1,2), (2,3), (3,5), (2,4);
COMMIT;