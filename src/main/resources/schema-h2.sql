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
 NAME VARCHAR2(50) not null,
 INTEREST_RATE NUMBER(10) null,
 PRIMARY KEY(ID)
);

create table CUSTOMER_PRODUCT
(
    CUSTOMER_ID NUMBER(10) not null,
    PRODUCT_ID NUMBER(10) not null,
    AMOUNT NUMBER(10) null,
    PRIMARY KEY (CUSTOMER_ID, PRODUCT_ID)
);