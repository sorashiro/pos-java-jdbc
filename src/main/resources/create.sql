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
CREATE TABLE promotion_item (
  promotion_id INT,
  item_id INT ,
  discount INT
);

## 插入初始数据
INSERT INTO item (id,barcode,name,unit,price)
    VALUES(000001,'ITEM000001','雪碧','瓶',3.5),
      (000002,'ITEM000002','苹果','斤',10.00),
      (000003,'ITEM000003','香蕉','斤',5.00),
      (000004,'ITEM000004','方便面','包',1.50),
      (000005,'ITEM000005','电池','个',5.00),
      (000006,'ITEM000006','荔枝','斤',10.00),
      (000007,'ITEM000007','羽毛球拍','副',100.00),
      (000002,'ITEM000008','袜子','双',5.00),
      (000003,'ITEM000009','牙刷','个',5.00);

INSERT INTO promotion (id, type, level)
    VALUES (0001, 'buy_two_get_one_free',1),
      (0002, 'second_half_price_promotion',2),
      (0003, 'discount',3);

INSERT INTO promotion_item (promotion_id, item_id)
    VALUES (0001,000001),
      (0001,000004),
      (0001,000009),
      (0002,000005),
      (0002,000007),
      (0002,000008);

INSERT INTO promotion_item (promotion_id, item_id,discount)
    VALUES (0001,000001,50),
      (0003,000002,50),
      (0003,000003,50),
      (0003,000004,50),
      (0003,000005,50),
      (0003,000006,50),
      (0003,000007,50),
      (0004,000008,50);
COMMIT;