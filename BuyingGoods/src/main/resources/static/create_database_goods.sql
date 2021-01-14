create database Goods;
use Goods;
#产品表
create table t_product(
id  int(12) auto_increment primary key comment '编号 主键',
prodect_name varchar(60) comment '产品名称',
stock int(10) not null comment '库存',
price decimal(16,2) not null comment '单价',
version int(10) not null default 0 comment '版本号',
note varchar(256) comment '备注'
);
#购买信息表
create table t_purchase_record(
id int(12) auto_increment primary key comment '编号',
user_id int(12) not null comment '用户ID',
product_id int(12) not null comment '产品ID',
price decimal(16,2) not null comment '订单总价',
quantity int(12) not null comment '数量',
sum decimal(16,2) not null comment '总价',
purchase_date timestamp not null default now() comment '购买日期',
note varchar(512) comment '备注'
);



