-- 财务系统 资金账号表
drop table if exists account;
create table account(
  id int unsigned auto_increment,
  user_id int unsigned,
  type tinyint,
  balance int,
  blocked_balances int,
  password varchar(64),
  salt varchar(8),
  PRIMARY KEY (id)
);
