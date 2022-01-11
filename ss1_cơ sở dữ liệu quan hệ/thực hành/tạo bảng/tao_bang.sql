create database thc_hanh_1_database;
use thuc_hanh_1_database;

create table thc_hanh_1_database.student(
id int primary key,
`name` varchar(20),
age int,
address varchar(20)
);

select * from student;

insert into student value (1, "trọng", 20, "Quảng Nam")
