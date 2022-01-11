create database student_management;
use student_management;

create table student_management.class(
id int primary key,
`name` varchar(20)
);

select * from class;

create table student_management.teacher(
id int primary key,
`name` varchar(20),
age int,
country varchar(50)
);

select * from teacher;