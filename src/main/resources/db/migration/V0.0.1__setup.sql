--create database LEMANS;
--
-- use LEMANS
-- go

CREATE SCHEMA DIGITAL
GO


CREATE TABLE DIGITAL.PRODUCT
(
    product_id   INT NOT NULL
        PRIMARY KEY,
    product_name VARCHAR(200) not null,
    category_name varchar (200) not null,
    creation_time_stamp   DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
)
GO

CREATE TABLE DIGITAL.PARTS
(
    id        BIGINT       NOT NULL identity (1,1)
        PRIMARY KEY,
    punctuated_part_number varchar(200) NULL,
    part_description  varchar(200) NOT NULL,
    product_id int not NULL,
    original_retail_price   DECIMAL(9, 2)  NOT NULL,
    brand_name varchar(100) NOT NULL,
    image_source varchar(max) NOT NULL,
    creation_time_stamp   DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT FK_PRODUCT_PRODUCT_ID
        FOREIGN KEY (product_id)
            REFERENCES DIGITAL.PRODUCT (product_id) ON DELETE NO ACTION ON UPDATE NO ACTION,
)
GO
