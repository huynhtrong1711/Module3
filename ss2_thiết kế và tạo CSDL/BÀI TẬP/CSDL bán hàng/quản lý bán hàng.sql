CREATE DATABASE quan_ly_ban_hang;
USE quan_ly_ban_hang;

CREATE TABLE customer(
customer_id INT PRIMARY KEY AUTO_INCREMENT,
customer_name VARCHAR(50),
customer_age INT
);

CREATE TABLE `order`(
order_id INT PRIMARY KEY AUTO_INCREMENT,
order_date DATETIME,
order_tatal_price INT,
customer_id INT,
FOREIGN KEY(customer_id) REFERENCES customer(customer_id)
);

CREATE TABLE product(
product_id INT PRIMARY KEY AUTO_INCREMENT,
product_name VARCHAR(70),
product_price INT
);

CREATE TABLE order_detail(
order_qty VARCHAR(30),
order_id INT,
product_id INT,
PRIMARY KEY(order_id,product_id),
FOREIGN KEY(order_id) REFERENCES `order`(order_id),
FOREIGN KEY(product_id) REFERENCES product(product_id)
);