

## 翻旧账 app 表设计


## 1 用户信息表 user_info
CREATE TABLE IF Not exists `user`  (
  `id` bigint(30) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户 id',
  `name` varchar(20) DEFAULT null unique COMMENT '用户名',
  `mobile` varchar(20) NOT NULL DEFAULT '' COMMENT '手机',
  `email` varchar(50) NOT NULL DEFAULT '' COMMENT '邮箱',
  `nick_name` varchar(20) NOT NULL DEFAULT '' COMMENT '昵称',
  `avatar` varchar(100) NOT NULL DEFAULT '' COMMENT '头像 uri',
  `gender` tinyint(3) unsigned NOT NULL DEFAULT '3' COMMENT '性别，1 为男性，2 为女性, 3 保密',
  `pairing_id` bigint(30) unsigned NOT NULL  COMMENT '配对id, 0标识未找到另一半',
  `prov_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '省份 id',
  `city_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '城市 id',
  `area_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '地区 id',
  `address` varchar(255) NOT NULL DEFAULT '' COMMENT '地址',
  `idc_no` varchar(20) NOT NULL DEFAULT '' COMMENT '身份证号码',
  `idc_pic1` varchar(255) NOT NULL DEFAULT '' COMMENT '身份证照片1',
  `idc_pic2` varchar(255) NOT NULL DEFAULT '' COMMENT '身份证照片2',
  `state` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0 正常, 1 违规封禁',
  `del` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '删除标识 0 删除 1 正常',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `IDX_MOBILE` (`mobile`),
  KEY `IDX_EMAIL` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='用户信息表';


## 2 用户security 表 user_security

CREATE TABLE IF Not exists `user_security` (
  `id` bigint(30) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(30) unsigned NOT NULL COMMENT '用户 id',
  `salt` varchar(40) NOT NULL COMMENT '盐',
  `password` varchar(40) NOT NULL COMMENT '密码',
  `security question1` varchar(255) NOT NULL default "" COMMENT '密保问题1',
  `security_answer1` varchar(255) NOT NULL default "" COMMENT '密保问题1答案',
  `security question2` varchar(255) NOT NULL default "" COMMENT '密保问题2',
  `security_answer2` varchar(255) NOT NULL default "" COMMENT '密保问题2答案',
  `del` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '删除标识 0 删除 1 正常',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `IDX_SECURITY` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='用户账户表';

## 第三方登录信息表

create table IF Not exists `third_auth` (
  `id` bigint(30) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(30) unsigned NOT NULL COMMENT '用户 id, 0 代表未绑定主体账号',
  `genre` tinyint(3) unsiged not null comment '授权类型, 1 微信, 2 qq, 3 微博',
  `open_id` bigint(100) unsiged not null comment 'openid',
  `del` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '删除标识 0 删除 1 正常',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `IDX_THIRD` (`user_id`, `open_id`) USING BTREE
)ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='第三方登录信息表';

## 3 旧账表  old_grudge
create table IF not exists `old_grudge` (
  `id` bigint(30) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(50) NOT NULL default "" COMMENT '标题',
  `state` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0 未翻篇, 1 已翻篇',
  `del` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '删除标识 0 删除 1 正常',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='旧账表';

## 4 旧账详情表 grude_detail
create table IF not exists `grude_detail` (
  `id` bigint(30) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `grudge_id` bigint(30) unsigned NOT NULL COMMENT '旧账id',
  `content` text NOT NULL default "" COMMENT '内容',
  `mood` varchar(255) NOT NULL default "" COMMENT '性情',
  `expectation` varchar(255) NOT NULL default "" COMMENT '期望',
  `del` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '删除标识 0 删除 1 正常',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',

)ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='旧账详情表';

## 配对表 pairing
create table IF not exists `pairing` (
  `id` bigint(30) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL default "" COMMENT '组合名称',
  `user_id1` bigint(30) unsigned NOT NULL COMMENT '用户 id1,',
  `user_id2` bigint(30) unsigned NOT NULL COMMENT '用户 id2,',
  `crisis_time` int(10) unsigned NOT NULL default 0 COMMENT '共患难关次数',
  `label` varchar (50) unsigned NOT NULL default "" COMMENT '标签',
  `signature` varchar (255) unsigned NOT NULL default "" COMMENT '签名',
  `del` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '删除标识 0 删除 1 正常',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',

)ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='配对表';
