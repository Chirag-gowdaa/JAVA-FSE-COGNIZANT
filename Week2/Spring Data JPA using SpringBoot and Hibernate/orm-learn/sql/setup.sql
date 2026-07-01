-- Run in MySQL Workbench or mysql client

create schema if not exists ormlearn;
use ormlearn;

-- Column names match the Country entity (@Column name="code" and name="name")
create table if not exists country (
    code varchar(2) primary key,
    name varchar(50)
);

insert into country values ('IN', 'India');
insert into country values ('US', 'United States of America');
