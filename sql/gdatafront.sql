/*
Navicat MySQL Data Transfer

Source Server         : hacker
Source Server Version : 50162
Source Host           : localhost:3306
Source Database       : gdatafront

Target Server Type    : MYSQL
Target Server Version : 50162
File Encoding         : 65001

Date: 2019-04-13 23:37:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cache_component_config
-- ----------------------------
DROP TABLE IF EXISTS `cache_component_config`;
CREATE TABLE `cache_component_config` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `component_code` varchar(64) NOT NULL COMMENT '组件编码',
  `rowkey_rule` varchar(2000) NOT NULL COMMENT '缓存key生产规则,逗号分割列名',
  `access_column` varchar(2000) NOT NULL COMMENT '处理的缓存列,逗号分割列名',
  `cache_time` int(11) DEFAULT '30' COMMENT '缓存时效,默认值30s,如果同时存在调用传参和配置值,优先使用传参',
  `data_template_id` varchar(64) NOT NULL COMMENT '数据模板id,缓存的数据结构信息,元数据关联使用,关联到元数据管理表',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_component_code` (`component_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='缓存组件配置表';

-- ----------------------------
-- Records of cache_component_config
-- ----------------------------
INSERT INTO `cache_component_config` VALUES ('1', '2019-04-13 23:25:47', '2019-04-13 23:25:51', 'JXL_BEESCORE_CACHE_READ', 'id_card,phone,name,type', 'code,code_description,data,spend_time', '30', 'JXL_BEESCORE_TABLE_ID');
INSERT INTO `cache_component_config` VALUES ('2', '2019-04-13 23:27:04', '2019-04-13 23:27:08', 'JXL_BEESCORE_CACHE_WRITE', 'id_card,phone,name,type', 'id_card,phone,name,type,code,code_description,data,spend_time', '30', 'JXL_BEESCORE_TABLE_ID');

-- ----------------------------
-- Table structure for channel
-- ----------------------------
DROP TABLE IF EXISTS `channel`;
CREATE TABLE `channel` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `channel_code` varchar(64) NOT NULL COMMENT '渠道编码',
  `channel_name` varchar(256) NOT NULL COMMENT '渠道名称',
  `channel_desc` varchar(512) NOT NULL COMMENT '渠道描述',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_channel_code` (`channel_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='渠道表';

-- ----------------------------
-- Records of channel
-- ----------------------------
INSERT INTO `channel` VALUES ('1', '2019-04-13 16:37:22', '2019-04-13 16:37:26', 'CHANNEL_JXL_BEETOKEAN', '聚信立小蜜分token渠道', '聚信立小蜜分token渠道');
INSERT INTO `channel` VALUES ('2', '2019-04-13 16:38:26', '2019-04-13 16:38:30', 'CHANNEL_JXL_BEESCORE', '聚信立小蜜分查询渠道', '聚信立小蜜分查询渠道');

-- ----------------------------
-- Table structure for channel_orchestration
-- ----------------------------
DROP TABLE IF EXISTS `channel_orchestration`;
CREATE TABLE `channel_orchestration` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `channel_code` varchar(64) NOT NULL COMMENT '渠道编码',
  `channel_order` int(11) NOT NULL COMMENT '渠道顺序',
  `dataview_code` varchar(64) NOT NULL COMMENT '所属试图编码',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_dataview_code_channel_code` (`dataview_code`,`channel_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='渠道编排表,用来建立和试图的关系的';

-- ----------------------------
-- Records of channel_orchestration
-- ----------------------------
INSERT INTO `channel_orchestration` VALUES ('1', '2019-04-13 16:39:41', '2019-04-13 16:39:46', 'CHANNEL_JXL_BEETOKEN', '1', 'JXL_BEESCORE');
INSERT INTO `channel_orchestration` VALUES ('2', '2019-04-13 16:40:15', '2019-04-13 16:40:18', 'CHANNEL_JXL_BEESCORE', '2', 'JXL_BEESCORE');

-- ----------------------------
-- Table structure for component_meta
-- ----------------------------
DROP TABLE IF EXISTS `component_meta`;
CREATE TABLE `component_meta` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `component_code` varchar(64) NOT NULL COMMENT '组件编码',
  `component_type` varchar(64) NOT NULL COMMENT '组件类型,dynamic,telcom',
  `config_param` varchar(1024) DEFAULT NULL COMMENT '组件配置',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_component_code` (`component_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='组件元数据表';

-- ----------------------------
-- Records of component_meta
-- ----------------------------
INSERT INTO `component_meta` VALUES ('1', '2019-04-13 16:42:04', '2019-04-13 16:42:09', 'JXL_BEETOKEN_REQ', 'dynamic', null);
INSERT INTO `component_meta` VALUES ('2', '2019-04-13 16:42:58', '2019-04-13 16:42:55', 'JXL_BEETOKEN_RESP', 'dynamic', null);
INSERT INTO `component_meta` VALUES ('3', '2019-04-13 16:43:32', '2019-04-13 16:43:36', 'JXL_BEETOKEN_TELCOM', 'net_telcom', null);
INSERT INTO `component_meta` VALUES ('4', '2019-04-13 16:44:20', '2019-04-13 16:44:24', 'JXL_BEESCORE_DISPATCH', 'dispatch', null);
INSERT INTO `component_meta` VALUES ('5', '2019-04-13 16:44:47', '2019-04-13 16:44:50', 'JXL_BEESCORE_CACHE_READ', 'cache_read', null);
INSERT INTO `component_meta` VALUES ('6', '2019-04-13 16:45:13', '2019-04-13 16:45:17', 'JXL_BEESCORE_CACHE_WRITE', 'cache_write', null);
INSERT INTO `component_meta` VALUES ('7', '2019-04-13 16:45:35', '2019-04-13 16:45:39', 'JXL_BEESCORE_REQ', 'dynamic', null);
INSERT INTO `component_meta` VALUES ('8', '2019-04-13 16:45:57', '2019-04-13 16:46:04', 'JXL_BEESCORE_RESP', 'dynamic', null);
INSERT INTO `component_meta` VALUES ('9', '2019-04-13 16:46:31', '2019-04-13 16:46:37', 'JXL_BEESCORE_TELCOM', 'net_telcom', null);
INSERT INTO `component_meta` VALUES ('10', '2019-04-13 16:47:22', '2019-04-13 16:47:26', 'JXL_BEETOKEN_CACHE_READ', 'ots_read', null);
INSERT INTO `component_meta` VALUES ('11', '2019-04-13 16:47:45', '2019-04-13 16:47:48', 'JXL_BEETOKEN_CACHE_WRITE', 'ots_write', null);

-- ----------------------------
-- Table structure for component_orchestration
-- ----------------------------
DROP TABLE IF EXISTS `component_orchestration`;
CREATE TABLE `component_orchestration` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `component_code` varchar(64) NOT NULL COMMENT '组件编码',
  `rel_code` varchar(64) NOT NULL COMMENT '关联主体编码',
  `rel_type` varchar(64) NOT NULL COMMENT '关联主体类型,渠道-channel; 视图-dataview',
  `run_direction` varchar(16) NOT NULL COMMENT '运行方向,request or response or dispatch',
  `run_order` int(8) NOT NULL COMMENT '运行顺序, request or response:1-x; dispatch:0',
  `context` varchar(64) DEFAULT NULL COMMENT '编排上下文信息 拓展用',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_rel_code_component_code` (`rel_code`,`rel_type`,`component_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='组件元数据表';

-- ----------------------------
-- Records of component_orchestration
-- ----------------------------
INSERT INTO `component_orchestration` VALUES ('1', '2019-04-13 16:56:45', '2019-04-13 16:56:50', 'JXL_BEESCORE_DISPATCH', 'JXL_BEESCORE', 'dataview', 'dispatch', '1', null);
INSERT INTO `component_orchestration` VALUES ('2', '2019-04-13 16:57:58', '2019-04-13 16:58:01', 'JXL_BEETOKEN_REQ', 'CHANNEL_JXL_BEETOKEN', 'channel', 'request', '2', null);
INSERT INTO `component_orchestration` VALUES ('3', '2019-04-13 16:58:36', '2019-04-13 16:58:40', 'JXL_BEETOKEN_RESP', 'CHANNEL_JXL_BEETOKEN', 'channel', 'response', '1', null);
INSERT INTO `component_orchestration` VALUES ('4', '2019-04-13 21:50:57', '2019-04-13 21:52:17', 'JXL_BEETOKEN_TELECOM', 'CHANNEL_JXL_BEETOKEN', 'channel', 'telcom', '1', null);
INSERT INTO `component_orchestration` VALUES ('5', '2019-04-13 23:07:26', '2019-04-13 23:07:30', 'JXL_BEESCORE_CACHE_READ', 'JXL_BEESCORE', 'dataview', 'request', '1', null);
INSERT INTO `component_orchestration` VALUES ('6', '2019-04-13 23:08:22', '2019-04-13 23:08:25', 'JXL_BEESCORE_REQ', 'CHANNEL_JXL_BEESCORE', 'channel', 'request', '2', null);
INSERT INTO `component_orchestration` VALUES ('7', '2019-04-13 23:10:15', '2019-04-13 23:10:18', 'JXL_BEESCORE_RESP', 'CHANNEL_JXL_BEESCORE', 'channel', 'response', '1', null);
INSERT INTO `component_orchestration` VALUES ('8', '2019-04-13 23:11:10', '2019-04-13 23:11:14', 'JXL_BEESCORE_TELCOM', 'CHANNEL_JXL_BEESCORE', 'channel', 'telcom', '1', null);
INSERT INTO `component_orchestration` VALUES ('9', '2019-04-13 23:12:20', '2019-04-13 23:12:24', 'JXL_BEETOKEN_CACHE_READ', 'CHANNEL_JXL_BEETOKEN', 'channel', 'request', '1', null);
INSERT INTO `component_orchestration` VALUES ('10', '2019-04-13 23:13:39', '2019-04-13 23:13:43', 'JXL_BEETOKEN_CACHE_WRITE', 'CHANNEL_JXL_BEETOKEN', 'channel', 'response', '2', null);
INSERT INTO `component_orchestration` VALUES ('11', '2019-04-13 23:17:46', '2019-04-13 23:17:51', 'JXL_BEESCORE_CACHE_WRITE', 'CHANNEL_JXL_BEESCORE', 'dataview', 'response', '1', null);

-- ----------------------------
-- Table structure for dataview
-- ----------------------------
DROP TABLE IF EXISTS `dataview`;
CREATE TABLE `dataview` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `dataview_code` varchar(64) NOT NULL COMMENT '试图编码',
  `dataview_name` varchar(64) NOT NULL COMMENT '视图名',
  `dataview_desc` varchar(2000) NOT NULL COMMENT '视图描述',
  `business_onwner` varchar(128) NOT NULL COMMENT '业务owner',
  `tech_owner` varchar(128) NOT NULL COMMENT '技术owner',
  `reliable_level` varchar(16) NOT NULL COMMENT '可用性等级',
  `avaiable` char(1) NOT NULL COMMENT '是否可用 0-不可用,1-可用',
  `creator` varchar(64) NOT NULL COMMENT '创建人',
  `modifier` varchar(64) NOT NULL COMMENT '修改人',
  `ext_info` varchar(1024) DEFAULT NULL COMMENT '拓展信息',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_dataview_code` (`dataview_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='视图表';

-- ----------------------------
-- Records of dataview
-- ----------------------------
INSERT INTO `dataview` VALUES ('1', '2019-04-13 16:34:31', '2019-04-13 16:34:39', 'JXL_BEESCORE', '聚信立小蜜分', '聚信立小蜜分', 'hacker', 'hacker', 'A', '1', 'hacker', 'hacker', null);

-- ----------------------------
-- Table structure for data_meta_config
-- ----------------------------
DROP TABLE IF EXISTS `data_meta_config`;
CREATE TABLE `data_meta_config` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `data_template_id` varchar(64) NOT NULL COMMENT '缓存数据模板标识',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `field_name` varchar(50) DEFAULT NULL,
  `field_type` varchar(16) NOT NULL COMMENT '缓存key生成规则, 逗号分割列名',
  `memo` varchar(255) DEFAULT NULL COMMENT '备注字段',
  `extra_info` varchar(255) DEFAULT NULL COMMENT '拓展预留字段',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_data_template_id` (`data_template_id`,`field_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='数据模板列配置表';

-- ----------------------------
-- Records of data_meta_config
-- ----------------------------
INSERT INTO `data_meta_config` VALUES ('1', 'JXL_BEESCORE_TABLE_ID', '2019-04-13 23:32:30', '2019-04-13 23:32:36', 'id_card', 'string', null, null);
INSERT INTO `data_meta_config` VALUES ('2', 'JXL_BEESCORE_TABLE_ID', '2019-04-13 23:33:41', '2019-04-13 23:33:47', 'phone', 'string', null, null);
INSERT INTO `data_meta_config` VALUES ('3', 'JXL_BEESCORE_TABLE_ID', '2019-04-13 23:32:30', '2019-04-13 23:32:36', 'name', 'string', '', '');
INSERT INTO `data_meta_config` VALUES ('4', 'JXL_BEESCORE_TABLE_ID', '2019-04-13 23:32:30', '2019-04-13 23:32:36', 'type', 'string', '', '');
INSERT INTO `data_meta_config` VALUES ('5', 'JXL_BEESCORE_TABLE_ID', '2019-04-13 23:32:30', '2019-04-13 23:32:36', 'code', 'string', '', '');
INSERT INTO `data_meta_config` VALUES ('6', 'JXL_BEESCORE_TABLE_ID', '2019-04-13 23:32:30', '2019-04-13 23:32:36', 'code_description', 'string', '', '');
INSERT INTO `data_meta_config` VALUES ('7', 'JXL_BEESCORE_TABLE_ID', '2019-04-13 23:32:30', '2019-04-13 23:32:36', 'data', 'string', '', '');
INSERT INTO `data_meta_config` VALUES ('8', 'JXL_BEESCORE_TABLE_ID', '2019-04-13 23:32:30', '2019-04-13 23:32:36', 'spend_time', 'string', '', '');

-- ----------------------------
-- Table structure for data_template
-- ----------------------------
DROP TABLE IF EXISTS `data_template`;
CREATE TABLE `data_template` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `data_template_id` varchar(64) NOT NULL COMMENT '数据模板id, 缓存的数据结构信息,元数据关联作用,关联到元数据管理表',
  `template_type` char(1) NOT NULL COMMENT '模板存储类型,0-ots,1-待定',
  `table_name` varchar(125) NOT NULL COMMENT '模板表名字',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_data_template_id` (`data_template_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='数据模板表';

-- ----------------------------
-- Records of data_template
-- ----------------------------
INSERT INTO `data_template` VALUES ('1', '2019-04-13 23:31:05', '2019-04-13 23:31:10', 'JXL_BEETOKEN_TABLE_ID', '0', 'token_cache');
INSERT INTO `data_template` VALUES ('2', '2019-04-13 23:31:41', '2019-04-13 23:31:47', 'JXL_BEESCORE_TABLE_ID', '0', 'JXL_BEESCORE');

-- ----------------------------
-- Table structure for dynamic_component
-- ----------------------------
DROP TABLE IF EXISTS `dynamic_component`;
CREATE TABLE `dynamic_component` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `component_code` varchar(64) NOT NULL COMMENT '组件编码',
  `dynamic_component_type` varchar(64) NOT NULL COMMENT '动态组件类型：route,run',
  `component_desc` varchar(2000) NOT NULL COMMENT '组件描述',
  `prod` int(11) NOT NULL COMMENT '脚本生产版本号',
  `pre_test` int(11) NOT NULL COMMENT '脚本预发测试版本号',
  `pre_percent` int(11) DEFAULT NULL COMMENT '预发测试比例',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_component_code` (`component_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='动态组件配置表';

-- ----------------------------
-- Records of dynamic_component
-- ----------------------------
INSERT INTO `dynamic_component` VALUES ('1', '2019-04-13 23:20:09', '2019-04-13 23:20:13', 'JXL_BEETOKEN_REQ', 'run', 'run', '1', '1', '0');
INSERT INTO `dynamic_component` VALUES ('2', '2019-04-13 23:20:46', '2019-04-13 23:20:50', 'JXL_BEETOKEN_RESP', 'run', 'run', '1', '1', '0');
INSERT INTO `dynamic_component` VALUES ('3', '2019-04-13 23:21:10', '2019-04-13 23:21:15', 'JXL_BEESCORE_REQ', 'run', 'run', '1', '1', '0');
INSERT INTO `dynamic_component` VALUES ('4', '2019-04-13 23:22:15', '2019-04-13 23:22:08', 'JXL_BEESCORE_RESP', 'run', 'run', '1', '1', '0');

-- ----------------------------
-- Table structure for dynamic_component_script
-- ----------------------------
DROP TABLE IF EXISTS `dynamic_component_script`;
CREATE TABLE `dynamic_component_script` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `component_code` varchar(64) NOT NULL COMMENT '组件编码',
  `groovy_script` text NOT NULL COMMENT '脚本',
  `version` int(11) NOT NULL COMMENT '版本号',
  `desc` varchar(4000) NOT NULL COMMENT '版本描述',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_component_code_version` (`component_code`,`version`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='动态组件脚本表';

-- ----------------------------
-- Records of dynamic_component_script
-- ----------------------------
INSERT INTO `dynamic_component_script` VALUES ('1', '2019-04-13 23:22:32', '2019-04-13 23:22:36', 'JXL_BEETOKEN_REQ', 'xxx', '1', '聚信立token请求脚本');
INSERT INTO `dynamic_component_script` VALUES ('2', '2019-04-13 23:23:09', '2019-04-13 23:23:14', 'JXL_BEETOKEN_RESP', 'xxx', '1', '聚信立token响应脚本');
INSERT INTO `dynamic_component_script` VALUES ('3', '2019-04-13 23:23:47', '2019-04-13 23:23:52', 'JXL_BEESCORE_REQ', 'xxx', '1', '聚信立小蜜分请求脚本');
INSERT INTO `dynamic_component_script` VALUES ('4', '2019-04-13 23:24:20', '2019-04-13 23:24:25', 'JXL_BEESCORE_RESP', 'xxx', '1', '聚信立小蜜分响应脚本');

-- ----------------------------
-- Table structure for ots_component_config
-- ----------------------------
DROP TABLE IF EXISTS `ots_component_config`;
CREATE TABLE `ots_component_config` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `component_code` varchar(64) NOT NULL COMMENT '组件编码',
  `rowkey_rule` varchar(2000) DEFAULT NULL COMMENT '缓存key生产规则,逗号分割列名',
  `fixed_rowkey_value` varchar(255) NOT NULL COMMENT '固定rowkey',
  `data_template_id` varchar(64) NOT NULL COMMENT '数据模板id,缓存的数据结构信息,元数据关联使用,关联到元数据管理表',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_component_code` (`component_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='ots组件配置表';

-- ----------------------------
-- Records of ots_component_config
-- ----------------------------
INSERT INTO `ots_component_config` VALUES ('1', '2019-04-13 23:28:56', '2019-04-13 23:29:02', 'JXL_BEETOKEN_CACHE_READ', '', 'jxl_beetoken_cache_read', 'JXL_BEETOKEN_TABLE_ID');
INSERT INTO `ots_component_config` VALUES ('2', '2019-04-13 23:30:24', '2019-04-13 23:30:27', 'JXL_BEETOKEN_CACHE_WRITE', null, 'jxl_beetoken_cache_write', 'JXL_BEETOKEN_TABLE_ID');

-- ----------------------------
-- Table structure for t_user_info
-- ----------------------------
DROP TABLE IF EXISTS `t_user_info`;
CREATE TABLE `t_user_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `user_name` varchar(32) NOT NULL,
  `class_no` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_unique_user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_info
-- ----------------------------
INSERT INTO `t_user_info` VALUES ('1', '1001', 'zhangsan', '2012001');
