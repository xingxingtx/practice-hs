drop table if exists sys_user;

/*==============================================================*/
/* Table: home_user                                             */
/*==============================================================*/
create table sys_user
(
    id                   bigint(20) not null auto_increment comment '用户ID',
    user_name            varchar(30) not null comment '用户名',
    login_name           varchar(30) not null comment '登录名',
    user_type            varchar(2) default '00' comment '用户类型（00系统用户）',
    phone_number         varchar(11) default '' comment '手机号码',
    sex                  char(1) default '0' comment '用户性别（0男 1女 2未知）',
    password             varchar(100) default '' comment '密码',
    status               char(1) default '0' comment '帐号状态（0正常 1停用）',
    address              varchar(100) not null comment '用户地址',
    create_by            varchar(64) default '' comment '创建者',
    create_time          datetime comment '创建时间',
    update_by            varchar(64) default '' comment '更新者',
    update_time          datetime comment '更新时间',
    remark               varchar(500) default NULL comment '备注',
    primary key (id)
) engine=innodb auto_increment=100 comment = '用户信息表';