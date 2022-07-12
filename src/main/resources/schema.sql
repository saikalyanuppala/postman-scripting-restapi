create table book(
id varchar(50) primary key,
name varchar(50) not null,
isbn varchar(50) not null,
rack varchar(50) not null,
author varchar(50) not null
);

create table person(
id int primary key auto_increment,
fullName varchar(50) not null,
age int not null
);