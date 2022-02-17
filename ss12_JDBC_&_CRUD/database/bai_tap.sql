CREATE DATABASE bai_tap_12;
USE bai_tap_12;

CREATE TABLE users (
id_user INT AUTO_INCREMENT PRIMARY KEY,
name_user VARCHAR(120),
email VARCHAR(220),
country VARCHAR(120)
);

insert into users(name_user, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name_user, email, country) values('Kante','kante@che.uk','Kenia');
