create database Test;
create table members (
index_id INT NOT NULL AUTO_INCREMENT,
id varchar(20),
pwd varchar(20),
email varchar(20),
phone varchar(20),
regdate DATETIME,
PRIMARY KEY(index_id)
);

drop table members;
create table members (
id varchar(20),
pwd varchar(20),
email varchar(20),
phone varchar(20),
regdate DATETIME,
PRIMARY KEY(id)
);

insert into members values ('hi', '12', '@', '010', now());
select * from members;

select * from members;

select pwd from members where id = 'd';
