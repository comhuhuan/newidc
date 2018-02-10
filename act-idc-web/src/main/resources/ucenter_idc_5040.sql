SET NAMES UTF8;
-- 操作日志中增加参数的记录，目的是为了保证后面定位操作记录时，更有依据
ALTER TABLE `tab_sys_operate_log` ADD COLUMN `op_params`  varchar(512) NOT NULL;
