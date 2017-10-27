-- 用户基础信息表
drop table if exists user;
create table user(
  id int unsigned auto_increment,
  name varchar(32) NOT NULL UNIQUE ,
  password varchar(64) not null,
  salt varchar(8) not null,
  nickname varchar(32),
  sex tinyint DEFAULT '1',
  age tinyint,
  mobile varchar(12),
  mobile_status tinyint,
  email varchar(48),
  email_status tinyint,
  usertype int,
  createat datetime,
  superior int,
  PRIMARY KEY (id)
);


-- 用户信息表
drop table if exists user_info;
create table user_info(
  id int unsigned auto_increment,
  user_id int unsigned,
  realname varchar(32),
  birth date,
  idno varchar(32),
  occupation varchar(32),
  school varchar(64),
  company varchar(64),
  hometown varchar(64),
  country varchar(32),
  province varchar(32),
  city varchar(32),
  district varchar(32),
  address varchar(64),
  lastlogin_time datetime,
  lastlogin_ip varchar(15),
  PRIMARY key (id)
);

-- 用户类型表
drop table if exists user_type;
create table user_type(
  id int unsigned auto_increment,
  name varchar(32),
  PRIMARY KEY (id)
);


-- 登录日志表
drop table if exists user_login_log;
create table user_login_log(
  id int unsigned auto_increment,
  user_id int unsigned,
  login_time datetime,
  login_ip varchar(15),
  login_device varchar(32),
  primary key (id)
);


-- 创建收货地址表
drop table if exists address;
create table address(
  id int unsigned auto_increment,
  user_id int unsigned,
  province varchar(32),
  city varchar(32),
  district varchar(32),
  address varchar(64),
  status tinyint,
  isdefault tinyint,
  PRIMARY KEY (id)
);