-- 创建commodity 表
drop table if exists commodity;
create table commodity(
  id int unsigned auto_increment,
  barcode varchar(64),
  out_code varchar(64),
  category_id int unsigned,
  name varchar(64),
  pic varchar(256),
  base_price int,
  base_weight int,
  type tinyint,
  PRIMARY KEY (id)
);

-- 创建货品表
drop table if exists goods;
create table goods(
  id int unsigned auto_increment,
  code varchar(32),
  commodity_id int unsigned,
  specifications varchar(45),
  price int,
  weight int,
  PRIMARY KEY (id)
);

-- 创建商品分类表
drop table if exists category;
create table category(
  id int unsigned auto_increment,
  name varchar(32),
  logo varchar(256),
  hot tinyint,
  recommend int,
  PRIMARY KEY (id)
);