CREATE DATABASE demo;

USE demo;

CREATE TABLE products(
id INT PRIMARY KEY AUTO_INCREMENT,
product_code INT,
product_name VARCHAR(50),
product_price DOUBLE,
product_amount INT,
product_description VARCHAR(60),
product_status VARCHAR(50)
);
ALTER TABLE products MODIFY COLUMN product_price INT;
ALTER TABLE products MODIFY COLUMN product_code VARCHAR(10);

INSERT INTO products(product_code, product_name, product_price, product_amount, product_description, product_status) VALUES
('001', 'điện thoại', 35000000, 10, 'iphone hơi đắt', 'nhưng mà nó sang'),
('002', 'máy tính', 25000000, 11, 'macbook cũng vẫn đắt', 'nhưng mà nó vẫn cứ sang'),
('003', 'ô tô', 100000000, 1, 'vinfast hơi tốt', 'nhưng mà lại không rẻ');

TRUNCATE TABLE products;

-- Tạo index
CREATE UNIQUE INDEX ma_san_pham
on products(product_code);

CREATE INDEX product_name_price 
on products(product_name, product_price);

EXPLAIN SELECT * FROM products WHERE product_code = '003';

EXPLAIN SELECT * FROM products WHERE product_name = 'ô tô' AND product_price = 100000000;

-- Tạo view
CREATE VIEW product_view AS SELECT products.product_code, products.product_name, products.product_price, products.product_status
FROM products;

SELECT * FROM product_view;

ALTER VIEW product_view AS SELECT products.product_code, products.product_name, products.product_price, products.product_description
FROM products;

SELECT * FROM product_view;

DROP VIEW product_view;

-- Tạo store proceduce

DELIMITER //
CREATE PROCEDURE find_all_product()
BEGIN
SELECT * FROM products;
END //
DELIMITER ;
CALL find_all_product();

DELIMITER //
DROP PROCEDURE add_product;
CREATE PROCEDURE add_product(id INT,
product_code VARCHAR(10),
product_name VARCHAR(50),
product_price INT,
product_amount INT,
product_description VARCHAR(60),
product_status VARCHAR(50)) 
BEGIN
INSERT INTO products VALUES
(id, product_code,product_name,product_price,product_amount,product_description,product_status);
END//
DELIMITER ;
CALL add_product(4, '004', 'ti vi', 1500000, 1, 'ti vi đẹp', 'xem phim oke :))')

DELIMITER //
CREATE PROCEDURE edit_product (id_product INT,
product_code VARCHAR(10),
product_name VARCHAR(50),
product_price INT,
product_amount INT,
product_description VARCHAR(60),
product_status VARCHAR(50))
BEGIN
UPDATE products
SET
product_code = product_code,
product_name = product_name,
product_price = product_price,
product_amount = product_amount,
product_description = product_description,
product_status = product_status
WHERE products.id = id_product;
END; //
DELIMITER ;
CALL edit_product(3, '003', "sữa", 40, 6,"sản xuất tại Hà Lan", "nhập khẩu");

DELIMITER //
CREATE PROCEDURE delete_product(IN id INT)
BEGIN
DELETE FROM products WHERE products.id = id;
END//
DELIMITER ;
CALL delete_product(4);


