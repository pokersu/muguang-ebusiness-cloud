-- 创建订单表
drop table if exists `order`;
create table `order`(
  id int unsigned auto_increment,
  serialno varchar(32),
  user_id int unsigned,
  address_id int unsigned,
  shop_id int unsigned,
  need_inv tinyint,
  inv_id int unsigned,
  price int,    --订单总金额
  amount int,   --实付金额
  discount int, --优惠金额
  postage int,  --邮费
  status tinyint,
  pay_status tinyint,
  create_time datetime,
  pay_time datetime,
  finish_time datetime,
  type int,
  PRIMARY KEY (id)
);

-- 创建订单条目表
drop table if exists order_item;
create table order_item(
  id int unsigned auto_increment,
  order_id int unsigned,
  shop_id int unsigned,
  dealer_id int unsigned,
  commodity_id int unsigned,
  commodity_name varchar(64),
  goods_id int unsigned,
  goods_name varchar(64),
  price int,
  amount int,
  createat datetime,
  PRIMARY KEY (id)
);

-- 创建发票
drop table if exists invoice;
create table invoice(
  id int unsigned auto_increment,
  order_id int unsigned,
  order_serialno varchar(36),
  invoicetype_id int,
  cost int,
  status tinyint,
  print_times datetime,
  PRIMARY KEY (id)
);