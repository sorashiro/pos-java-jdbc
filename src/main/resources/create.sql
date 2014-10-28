DROP DATABASE IF EXISTS pos_java_jdbc;
CREATE DATABASE pos_java_jdbc DEFAULT CHARACTER SET utf8;
USE pos_java_jdbc;

## 创建商品列表
CREATE TABLE item (
id INT AUTO_INCREMENT PRIMARY KEY ,
barcode VARCHAR(50),
name VARCHAR(50),
unit VARCHAR(50),
price DOUBLE
);

## 创建优惠信息表
CREATE TABLE promotion (
  id INT AUTO_INCREMENT PRIMARY KEY ,
  type VARCHAR(50),
  level INT
);

## 创建商品_优惠连接表
CREATE TABLE item_promotion (
  item_id INT ,
  promotion_id INT,
  discount INT 
);

## 插入初始数据
INSERT INTO item (id,barcode,name,unit,price)
VALUES(000001,'ITEM000001','雪碧','瓶',3.5);

INSERT INTO promotion (id,type,level)
    VALUES (0001, 'buy_two_get_one_free',1);
COMMIT;