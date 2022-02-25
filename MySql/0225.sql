create database Test;
create table members (
index int autoincrement,
id varchar(20),
pwd varchar(20),
email varchar(20),
phone varchar(20),
regdate DATETIME
)