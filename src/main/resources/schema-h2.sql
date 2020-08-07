create table CUSTOMER
(
 ID NUMBER(20) not null,
 FIRST_NAME VARCHAR2(50) not null,
 LAST_NAME VARCHAR2(50) not null,
 PRIMARY KEY(ID)
);

create table PRODUCT
(
 ID NUMBER(10) not null,
 TYPE VARCHAR2(30) not null,
 NAME VARCHAR2(50) not null
);