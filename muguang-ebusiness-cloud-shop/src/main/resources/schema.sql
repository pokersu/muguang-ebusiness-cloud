-- 创建门店表
drop table if exists shop;
create table shop(
  id int unsigned auto_increment,
  name varchar(32),
  dealer_id int unsigned,
  address_id int unsigned,
  PRIMARY KEY (id)
);

-- 创建门店库存表
drop table if exists inventory;
create table inventory(
  id int unsigned auto_increment,
  shop_commodity_id int unsigned,
  goods_id int unsigned,
  price int,
  weight int,
  amount int,
  status int,
  PRIMARY KEY (id)
);

-- 创建门店商品表
drop table if exists shop_commodity;
create table shop_commodity(
  id int unsigned auto_increment,
  name varchar(32),
  shop_id int unsigned,
  commodity_id int unsigned,
  status tinyint,
  PRIMARY KEY (id)
);