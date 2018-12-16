-- 1. create database
create database my_e_commerce_1;

-- 2. create tables
create table dimUser
(
	name varchar(255) not null,
	password varchar(255) not null
);

create table dimproduct
(
	category varchar(255) not null,
	name varchar(255) not null,
	price int not null,
	unit varchar(255) not null,
	volume int not null,
	description varchar(510) not null
);