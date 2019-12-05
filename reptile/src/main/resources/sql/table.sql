-- 跟着小灰灰学写字()-用户信息表
create table IF Not exists `user` (
  `id` bigint(30) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(30) unsigned NOT NULL COMMENT '用户id',
  `nick_name` tinyint(3) unsiged not null comment '昵称',
  `head_url` bigint(100) unsiged not null comment '头像URL',
  `mobile` bigint(100) unsiged not null comment '手机号',
  `email` bigint(100) unsiged not null comment '邮箱',
  `del` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '删除标识 0 删除 1 正常',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `IDX_THIRD` (`user_id`, `open_id`) USING BTREE
)ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- 平台用户信息表
create table IF Not exists `user` (
  `id` bigint(30) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(30) unsigned NOT NULL COMMENT '用户id',
  `mobile` char(11)  not null default '' comment '手机号',
  `nick_name` varchar(20) not null default '' comment '昵称',
  `head_url` varchar(200)  not null default '' comment '头像URL',
  `gender` tinyint(3) unsigned NOT NULL DEFAULT '3' COMMENT '性别，1 为男性，2 为女性, 3 保密',
  `email` varchar (30)  not null default '' comment '邮箱',
  `password` varchar(20) NOT NULL default '' COMMENT '密码',
  `salt` varchar(40) NOT NULL default '' COMMENT '盐',
  `pid` tinyint(4) unsiged not null comment '应用ID',
  `del` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '删除标识 0 删除 1 正常',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `IDX_USER_MOBILE` (`user_id`, `mobile`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- 微信auth
create table IF Not exists `wx_auth` (
  `id` bigint(30) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(30) unsigned NOT NULL COMMENT '用户id',
  `openid` varchar(50) not null comment 'openid',
  `unid` varchar(50) not null default '' comment 'unid',
  `appid` varchar(50) not null comment '微信应用ID',
  `del` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '删除标识 0 删除 1 正常',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `IDX_THIRD` (`user_id`, `open_id`, `unid`) USING BTREE
)ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='微信oauth信息表';

-- 平台应用信息表
create table IF Not exists `platform_app` (
  `id` bigint(30) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `appid` varchar(50) unsigned NOT NULL COMMENT '应用ID',
  `secret` varchar(50) unsiged not null comment '应用secret',
  `platform` tinyint(3) unsiged not null comment '平台类型 1 微信，2 移动端， 3 pc端',
  `message_authorize` tinyint(1) unsiged not null default '1' comment '是否可以进行短信验证登录注册',
  `password_authorize` tinyint(1) unsiged not null default '1' comment '是否可以进行密码登录注册',
  `must_bind_mobile` tinyint(1) unsiged not null default '0' comment'是否必须绑定手机',
  `del` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '删除标识 0 删除 1 正常',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `IDX_THIRD` (`user_id`, `open_id`) USING BTREE
)ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='用户表';
