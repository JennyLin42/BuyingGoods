use Goods;
alter table t_purchase_record add COLUMN is_delete TINYINT(1) not null default '0' comment '记录是否删除:0 未删除;1 已删除';
