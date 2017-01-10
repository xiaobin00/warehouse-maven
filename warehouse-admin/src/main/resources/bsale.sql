/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50628
Source Host           : localhost:3306
Source Database       : bsale

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2016-10-12 21:53:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_access`
-- ----------------------------

CREATE TABLE `procedure_plan_info` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`user_id`  int(11) NULL ,
`company_id`  int(11) NULL ,
`procedure_id`  int(11) NULL ,
`name`  varchar(50) NULL ,
`count`  int(11) NULL ,
`percentage`  int(11) NULL ,
`status`  int(11) NULL ,
`start_time`  timestamp NULL ON UPDATE CURRENT_TIMESTAMP ,
`end_time`  timestamp NULL ON UPDATE CURRENT_TIMESTAMP ,
`actual_time`  timestamp NULL ON UPDATE CURRENT_TIMESTAMP ,
`create_time`  timestamp NULL ON UPDATE CURRENT_TIMESTAMP ,
PRIMARY KEY (`id`)
)
;
CREATE TABLE `procedure_goods_record_info` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`plan_id`  int(11) NULL ,
`goods_id`  int(11) NULL ,
`user_id`  int(11) NULL ,
`name`  varchar(50) NULL ,
`count`  int(11) NULL ,
`create_time`  timestamp NULL ON UPDATE CURRENT_TIMESTAMP ,
`status`  int(11) NULL ,
`update_time`  timestamp NULL ON UPDATE CURRENT_TIMESTAMP ,
PRIMARY KEY (`id`)
)
;
CREATE TABLE `plan_schedule_info` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`plan_id`  int(11) NULL ,
`p_department_id`  int(11) NULL ,
`user_id`  int(11) NULL ,
`count`  int(11) NULL ,
`percentage`  int(11) NULL ,
`status`  int(11) NULL ,
`update_time`  timestamp NULL ON UPDATE CURRENT_TIMESTAMP ,
`create_time`  timestamp NULL ON UPDATE CURRENT_TIMESTAMP ,
PRIMARY KEY (`id`)
)
;
CREATE TABLE `notice_info` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`user_id`  int(11) NULL ,
`content`  varchar(250) NULL ,
`type`  int(11) NULL ,
`status`  int(11) NULL ,
`create_time`  timestamp NULL ON UPDATE CURRENT_TIMESTAMP ,
PRIMARY KEY (`id`)
)
;








DROP TABLE IF EXISTS `t_access`;

CREATE TABLE `base_goods_info` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`name`  varchar(11) NULL ,
`company_id`  int(11) NULL ,
`status`  int(11) NOT NULL DEFAULT 0 ,
`create_time`  timestamp NULL ON UPDATE CURRENT_TIMESTAMP ,
PRIMARY KEY (`id`)
)
;
CREATE TABLE `goods_record_info` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`company_id`  int(11) NULL ,
`name`  varchar(50) NULL ,
`count`  int(11) NULL ,
`price`  int(11) NULL ,
`specifications`  varchar(50) NULL ,
`type`  int(11) NULL ,
`status`  int(11) NULL ,
`tatol_price`  int(11) NULL ,
`describe`  varchar(255) NULL ,
`create_time`  timestamp NULL ON UPDATE CURRENT_TIMESTAMP ,
`parent_id`  int(11) NULL
PRIMARY KEY (`id`)
)
;




CREATE TABLE `t_access` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `url` varchar(100) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `icon` varchar(20) DEFAULT NULL,
  `pid` smallint(6) DEFAULT NULL,
  `seq` tinyint(4) NOT NULL DEFAULT '0',
  `state` tinyint(4) NOT NULL DEFAULT '0',
  `accesstype` tinyint(4) NOT NULL DEFAULT '0',
  `createdatetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9039 DEFAULT CHARSET=utf8 COMMENT='资源';

-- ----------------------------
-- Records of t_access
-- ----------------------------
INSERT INTO `t_access` VALUES ('10', '基本资料', '', '基本资料', 'icon_folder', null, '1', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('101', '机构档案', '/branch/manager', '机构档案', 'icon_folder', '10', '1', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1011', '机构列表', '/branch/treeGrid', '机构列表', 'icon_folder', '101', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1012', '添加', '/branch/add', '机构添加', 'icon_folder', '101', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1013', '编辑', '/branch/edit', '机构编辑', 'icon_folder', '101', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1014', '删除', '/branch/delete', '机构删除', 'icon_folder', '101', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1015', '查看', '/branch/view', '机构查看', 'icon_folder', '101', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('102', '店组档案', '/branchclass/manager', '店组档案', 'icon_folder', '10', '4', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1021', '店组列表', '/branchclass/dataGrid', '店组列表', 'icon_folder', '102', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1022', '添加', '/branchclass/add', '添加', 'icon_folder', '102', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1023', '编辑', '/branchclass/edit', '编辑', 'icon_folder', '102', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1024', '删除', '/branchclass/delete', '删除', 'icon_folder', '102', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('103', '商品分类', '/itemclass/manager', '商品分类', 'icon_folder', '10', '4', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1031', '分类列表', '/itemclass/dataGrid', '分类列表', 'icon_folder', '103', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1032', '添加', '/itemclass/add', '添加', 'icon_folder', '103', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1033', '编辑', '/itemclass/edit', '编辑', 'icon_folder', '103', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1034', '删除', '/itemclass/delete', '删除', 'icon_folder', '103', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('104', '商品档案', '/item/manager', '商品档案', 'icon_folder', '10', '4', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1041', '商品列表', '/item/dataGrid', '商品列表', 'icon_folder', '104', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1042', '添加', '/item/add', '添加', 'icon_folder', '104', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1043', '编辑', '/item/edit', '编辑', 'icon_folder', '104', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1044', '删除', '/item/delete', '删除', 'icon_folder', '104', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('105', '货商分类', '/supclass/manager', '货商分类', 'icon_folder', '10', '4', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1051', '分类列表', '/supclass/dataGrid', '分类列表', 'icon_folder', '105', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1052', '添加', '/supclass/add', '添加', 'icon_folder', '105', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1053', '编辑', '/supclass/edit', '编辑', 'icon_folder', '105', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1054', '删除', '/supclass/delete', '删除', 'icon_folder', '105', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('106', '货商档案', '/supinfo/manager', '货商档案', 'icon_folder', '10', '4', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1061', '货商列表', '/supinfo/dataGrid', '货商列表', 'icon_folder', '106', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1062', '添加', '/supinfo/add', '添加', 'icon_folder', '106', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1063', '编辑', '/supinfo/edit', '编辑', 'icon_folder', '106', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1064', '删除', '/supinfo/delete', '删除', 'icon_folder', '106', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('107', '客户分类', '/cusclass/manager', '客户分类', 'icon_folder', '10', '4', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1071', '分类列表', '/cusclass/dataGrid', '分类列表', 'icon_folder', '107', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1072', '添加', '/cusclass/add', '添加', 'icon_folder', '107', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1073', '编辑', '/cusclass/edit', '编辑', 'icon_folder', '107', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1074', '删除', '/cusclass/delete', '删除', 'icon_folder', '107', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('108', '客户档案', '/cusinfo/manager', '客户档案', 'icon_folder', '10', '8', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1081', '客户列表', '/cusinfo/dataGrid', '客户列表', 'icon_folder', '108', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1082', '添加', '/cusinfo/add', '添加', 'icon_folder', '108', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1083', '编辑', '/cusinfo/edit', '编辑', 'icon_folder', '108', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1084', '删除', '/cusinfo/delete', '删除', 'icon_folder', '108', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('109', '商品属性', '/itemproperty/manager', '商品属性', 'icon_folder', '10', '4', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1091', '属性列表', '/itemproperty/dataGrid', '属性列表', 'icon_folder', '109', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1092', '添加', '/itemproperty/add', '添加', 'icon_folder', '109', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1093', '编辑', '/itemproperty/edit', '编辑', 'icon_folder', '109', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1094', '删除', '/itemproperty/delete', '删除', 'icon_folder', '109', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('110', '商品品牌', '/itembrand/manager', '商品品牌', 'icon_folder', '10', '4', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1101', '品牌列表', '/itembrand/dataGrid', '品牌列表', 'icon_folder', '110', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1102', '添加', '/itembrand/add', '添加', 'icon_folder', '110', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1103', '编辑', '/itembrand/edit', '编辑', 'icon_folder', '110', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1104', '删除', '/itembrand/delete', '删除', 'icon_folder', '110', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('111', '员工档案', '/employee/manager', '员工档案', 'icon_folder', '10', '4', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1111', '员工列表', '/employee/dataGrid', '员工列表', 'icon_folder', '110', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1112', '添加', '/employee/add', '添加', 'icon_folder', '110', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1113', '编辑', '/employee/edit', '编辑', 'icon_folder', '110', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1114', '删除', '/employee/delete', '删除', 'icon_folder', '110', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('112', '支付方式', '/payment/manager', '支付方式', 'icon_folder', '10', '4', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1121', '支付方式列表', '/payment/dataGrid', '支付方式列表', 'icon_folder', '110', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1122', '添加', '/payment/add', '添加', 'icon_folder', '110', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1123', '编辑', '/payment/edit', '编辑', 'icon_folder', '110', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('1124', '删除', '/payment/delete', '删除', 'icon_folder', '110', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('20', '采购中心', '', '采购中心', 'icon_folder', null, '2', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('201', '采购入库', '/access/manager', '采购入库', 'icon_folder', '20', '1', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('202', '采购退货', '/access/manager', '采购退货', 'icon_folder', '20', '2', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('30', '零售管理', '', '零售管理', 'icon_folder', null, '3', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('301', '促销管理', '/access/manager', '促销管理', 'icon_folder', '30', '1', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('302', '前台收银', '/access/manager', '前台收银', 'icon_folder', '30', '2', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('40', '批发销售', '', '批发销售', 'icon_folder', null, '4', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('401', '批发销售', '/access/manager', '批发销售', 'icon_folder', '40', '1', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('402', '批发退货', '/access/manager', '批发退货', 'icon_folder', '40', '2', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('50', '库存管理', '', '库存管理', 'icon_folder', null, '5', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('501', '库存查询', '/access/manager', '库存查询', 'icon_folder', '50', '1', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('502', '其他出入', '/access/manager', '其他出入', 'icon_folder', '50', '2', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('60', '会员管理', '', '会员管理', 'icon_folder', null, '6', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('601', '会员分类', '/access/manager', '会员分类', 'icon_folder', '60', '1', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('602', '会员档案', '/access/manager', '会员档案', 'icon_folder', '60', '2', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('70', '连锁配送', '', '连锁配送', 'icon_folder', null, '7', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('701', '直接配送', '/access/manager', '直接配送', 'icon_folder', '70', '1', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('702', '机构调拨', '/access/manager', '机构调拨', 'icon_folder', '70', '2', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('80', '报表分析', '', '报表分析', 'icon_folder', null, '8', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('801', '零售查询', '/access/manager', '销售查询', 'icon_folder', '80', '1', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('802', '批发销售', '/access/manager', '批发销售', 'icon_folder', '80', '2', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('90', '系统设置', '', '系统设置', 'icon_folder', null, '9', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('901', '资源管理', '/access/manager', '资源管理', 'icon_folder', '90', '1', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('9011', '资源列表', '/access/treeGrid', '资源列表', 'icon_folder', '901', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('9012', '添加', '/access/add', '资源添加', 'icon_folder', '901', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('9013', '编辑', '/access/edit', '资源编辑', 'icon_folder', '901', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('9014', '删除', '/access/delete', '资源删除', 'icon_folder', '901', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('902', '角色管理', '/role/manager', '角色管理', 'icon_folder', '90', '2', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('9021', '角色列表', '/role/dataGrid', '角色列表', 'icon_folder', '902', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('9022', '添加', '/role/add', '角色添加', 'icon_folder', '902', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('9023', '编辑', '/role/edit', '角色编辑', 'icon_folder', '902', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('9024', '删除', '/role/delete', '角色删除', 'icon_folder', '902', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('9025', '授权', '/role/grant', '角色授权', 'icon_folder', '902', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('903', '用户管理', '/user/manager', '用户管理', 'icon_folder', '90', '3', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('9031', '用户列表', '/user/dataGrid', '用户列表', 'icon_folder', '903', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('9032', '添加', '/user/add', '用户添加', 'icon_folder', '903', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('9033', '编辑', '/user/edit', '用户编辑', 'icon_folder', '903', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('9034', '删除', '/user/delete', '用户删除', 'icon_folder', '903', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('9035', '查看', '/user/view', '用户查看', 'icon_folder', '903', '0', '0', '1', '2014-02-19 01:00:00');
INSERT INTO `t_access` VALUES ('9036', '测试', 'a/a/a', '', '', '50', '2', '0', '1', '2016-07-24 15:44:10');
INSERT INTO `t_access` VALUES ('100', '生产流程', '/production/manager', '生产流程', 'icon_folder', null, '10', '0', '0', '2016-10-07 19:20:23');
INSERT INTO `t_access` VALUES ('1001', '流程添加', '/production/add', '流程添加', 'icon_folder', '100', '0', '0', '0', '2016-10-07 19:23:45');

-- ----------------------------
-- Table structure for `t_branch`
-- ----------------------------
DROP TABLE IF EXISTS `t_branch`;
CREATE TABLE `t_branch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(4) NOT NULL,
  `name` varchar(64) NOT NULL,
  `icon` varchar(20) DEFAULT NULL,
  `seq` tinyint(4) NOT NULL DEFAULT '0',
  `pid` int(11) DEFAULT NULL,
  `manager` varchar(32) DEFAULT NULL,
  `tel` varchar(32) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `createdatetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `branchtype` tinyint(4) NOT NULL DEFAULT '0',
  `branchclass_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='机构档案';

-- ----------------------------
-- Records of t_branch
-- ----------------------------
INSERT INTO `t_branch` VALUES ('1', '01', '舒心雅琪制衣有限公司', 'icon_company', '1', null, '李泽龙', '88015535', '亚泰鼎盛国际1924', '2014-02-19 01:00:00', '0', '1');

-- ----------------------------
-- Table structure for `t_branch_class`
-- ----------------------------
DROP TABLE IF EXISTS `t_branch_class`;
CREATE TABLE `t_branch_class` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `code` varchar(32) DEFAULT NULL,
  `isdefault` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='机构分组';

-- ----------------------------
-- Records of t_branch_class
-- ----------------------------
INSERT INTO `t_branch_class` VALUES ('1', '1', '1', '1');

-- ----------------------------
-- Table structure for `t_cus_class`
-- ----------------------------
DROP TABLE IF EXISTS `t_cus_class`;
CREATE TABLE `t_cus_class` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `code` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='客户分类';

-- ----------------------------
-- Records of t_cus_class
-- ----------------------------

-- ----------------------------
-- Table structure for `t_cus_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_cus_info`;
CREATE TABLE `t_cus_info` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `code` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `cusclass_id` smallint(6) NOT NULL DEFAULT '0',
  `linkman` varchar(32) DEFAULT NULL,
  `tel` varchar(32) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(32) DEFAULT NULL,
  `bank` varchar(32) DEFAULT NULL,
  `account` varchar(32) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  `createdatetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `state` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='客户档案';

-- ----------------------------
-- Records of t_cus_info
-- ----------------------------

-- ----------------------------
-- Table structure for `t_employee`
-- ----------------------------
DROP TABLE IF EXISTS `t_employee`;
CREATE TABLE `t_employee` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `code` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `sex` tinyint(4) NOT NULL DEFAULT '0',
  `age` tinyint(4) NOT NULL DEFAULT '0',
  `race` varchar(16) DEFAULT NULL,
  `hiredate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `tel` varchar(32) DEFAULT NULL,
  `cardid` varchar(32) DEFAULT NULL,
  `basesalary` smallint(6) DEFAULT NULL,
  `branch_id` int(11) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  `duty` varchar(32) DEFAULT NULL,
  `rate` smallint(6) DEFAULT NULL,
  `createdatetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='员工档案';

-- ----------------------------
-- Records of t_employee
-- ----------------------------

-- ----------------------------
-- Table structure for `t_item`
-- ----------------------------
DROP TABLE IF EXISTS `t_item`;
CREATE TABLE `t_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `itemno` varchar(32) NOT NULL,
  `barcode` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `itemclass_id` smallint(6) NOT NULL DEFAULT '0',
  `unit` varchar(10) DEFAULT NULL,
  `brand_id` int(11) NOT NULL DEFAULT '0',
  `property_id` int(11) NOT NULL DEFAULT '0',
  `sup_id` int(11) NOT NULL DEFAULT '0',
  `purchaseprice` double NOT NULL DEFAULT '0',
  `retailprice` double NOT NULL DEFAULT '0',
  `wholesaleprice` double NOT NULL DEFAULT '0',
  `isbranch` tinyint(4) NOT NULL DEFAULT '0',
  `state` tinyint(4) NOT NULL DEFAULT '0',
  `createdatetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='商品档案';

-- ----------------------------
-- Records of t_item
-- ----------------------------

-- ----------------------------
-- Table structure for `t_item_brand`
-- ----------------------------
DROP TABLE IF EXISTS `t_item_brand`;
CREATE TABLE `t_item_brand` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `code` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='商品品牌';

-- ----------------------------
-- Records of t_item_brand
-- ----------------------------

-- ----------------------------
-- Table structure for `t_item_class`
-- ----------------------------
DROP TABLE IF EXISTS `t_item_class`;
CREATE TABLE `t_item_class` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `code` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `pid` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='商品分类';

-- ----------------------------
-- Records of t_item_class
-- ----------------------------

-- ----------------------------
-- Table structure for `t_item_property`
-- ----------------------------
DROP TABLE IF EXISTS `t_item_property`;
CREATE TABLE `t_item_property` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `code` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='商品属性';

-- ----------------------------
-- Records of t_item_property
-- ----------------------------
INSERT INTO `t_item_property` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for `t_payment`
-- ----------------------------
DROP TABLE IF EXISTS `t_payment`;
CREATE TABLE `t_payment` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `code` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `paytype` tinyint(4) NOT NULL DEFAULT '0',
  `isvalid` tinyint(4) NOT NULL DEFAULT '0',
  `isdefault` tinyint(4) NOT NULL DEFAULT '0',
  `account` tinyint(4) NOT NULL DEFAULT '0',
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='员工档案';

-- ----------------------------
-- Records of t_payment
-- ----------------------------

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `seq` tinyint(4) NOT NULL DEFAULT '0',
  `description` varchar(255) DEFAULT NULL,
  `isdefault` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '超级管理员', '0', '超级管理员，拥有全部权限', '0');
INSERT INTO `t_role` VALUES ('2', '管理员', '1', '123', '1');

-- ----------------------------
-- Table structure for `t_role_access`
-- ----------------------------
DROP TABLE IF EXISTS `t_role_access`;
CREATE TABLE `t_role_access` (
  `role_id` smallint(6) NOT NULL,
  `access_id` smallint(6) NOT NULL,
  PRIMARY KEY (`role_id`,`access_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='角色资源';

-- ----------------------------
-- Records of t_role_access
-- ----------------------------
INSERT INTO `t_role_access` VALUES ('1', '10');
INSERT INTO `t_role_access` VALUES ('1', '20');
INSERT INTO `t_role_access` VALUES ('1', '30');
INSERT INTO `t_role_access` VALUES ('1', '40');
INSERT INTO `t_role_access` VALUES ('1', '50');
INSERT INTO `t_role_access` VALUES ('1', '60');
INSERT INTO `t_role_access` VALUES ('1', '70');
INSERT INTO `t_role_access` VALUES ('1', '80');
INSERT INTO `t_role_access` VALUES ('1', '90');
INSERT INTO `t_role_access` VALUES ('1', '100');
INSERT INTO `t_role_access` VALUES ('1', '101');
INSERT INTO `t_role_access` VALUES ('1', '102');
INSERT INTO `t_role_access` VALUES ('1', '103');
INSERT INTO `t_role_access` VALUES ('1', '104');
INSERT INTO `t_role_access` VALUES ('1', '105');
INSERT INTO `t_role_access` VALUES ('1', '106');
INSERT INTO `t_role_access` VALUES ('1', '107');
INSERT INTO `t_role_access` VALUES ('1', '108');
INSERT INTO `t_role_access` VALUES ('1', '109');
INSERT INTO `t_role_access` VALUES ('1', '110');
INSERT INTO `t_role_access` VALUES ('1', '111');
INSERT INTO `t_role_access` VALUES ('1', '112');
INSERT INTO `t_role_access` VALUES ('1', '201');
INSERT INTO `t_role_access` VALUES ('1', '202');
INSERT INTO `t_role_access` VALUES ('1', '301');
INSERT INTO `t_role_access` VALUES ('1', '302');
INSERT INTO `t_role_access` VALUES ('1', '401');
INSERT INTO `t_role_access` VALUES ('1', '402');
INSERT INTO `t_role_access` VALUES ('1', '501');
INSERT INTO `t_role_access` VALUES ('1', '502');
INSERT INTO `t_role_access` VALUES ('1', '601');
INSERT INTO `t_role_access` VALUES ('1', '602');
INSERT INTO `t_role_access` VALUES ('1', '701');
INSERT INTO `t_role_access` VALUES ('1', '702');
INSERT INTO `t_role_access` VALUES ('1', '801');
INSERT INTO `t_role_access` VALUES ('1', '802');
INSERT INTO `t_role_access` VALUES ('1', '901');
INSERT INTO `t_role_access` VALUES ('1', '902');
INSERT INTO `t_role_access` VALUES ('1', '903');
INSERT INTO `t_role_access` VALUES ('1', '1001');
INSERT INTO `t_role_access` VALUES ('1', '1011');
INSERT INTO `t_role_access` VALUES ('1', '1012');
INSERT INTO `t_role_access` VALUES ('1', '1013');
INSERT INTO `t_role_access` VALUES ('1', '1014');
INSERT INTO `t_role_access` VALUES ('1', '1015');
INSERT INTO `t_role_access` VALUES ('1', '1021');
INSERT INTO `t_role_access` VALUES ('1', '1022');
INSERT INTO `t_role_access` VALUES ('1', '1023');
INSERT INTO `t_role_access` VALUES ('1', '1024');
INSERT INTO `t_role_access` VALUES ('1', '1031');
INSERT INTO `t_role_access` VALUES ('1', '1032');
INSERT INTO `t_role_access` VALUES ('1', '1033');
INSERT INTO `t_role_access` VALUES ('1', '1034');
INSERT INTO `t_role_access` VALUES ('1', '1041');
INSERT INTO `t_role_access` VALUES ('1', '1042');
INSERT INTO `t_role_access` VALUES ('1', '1043');
INSERT INTO `t_role_access` VALUES ('1', '1044');
INSERT INTO `t_role_access` VALUES ('1', '1051');
INSERT INTO `t_role_access` VALUES ('1', '1052');
INSERT INTO `t_role_access` VALUES ('1', '1053');
INSERT INTO `t_role_access` VALUES ('1', '1054');
INSERT INTO `t_role_access` VALUES ('1', '1061');
INSERT INTO `t_role_access` VALUES ('1', '1062');
INSERT INTO `t_role_access` VALUES ('1', '1063');
INSERT INTO `t_role_access` VALUES ('1', '1064');
INSERT INTO `t_role_access` VALUES ('1', '1071');
INSERT INTO `t_role_access` VALUES ('1', '1072');
INSERT INTO `t_role_access` VALUES ('1', '1073');
INSERT INTO `t_role_access` VALUES ('1', '1074');
INSERT INTO `t_role_access` VALUES ('1', '1081');
INSERT INTO `t_role_access` VALUES ('1', '1082');
INSERT INTO `t_role_access` VALUES ('1', '1083');
INSERT INTO `t_role_access` VALUES ('1', '1084');
INSERT INTO `t_role_access` VALUES ('1', '1091');
INSERT INTO `t_role_access` VALUES ('1', '1092');
INSERT INTO `t_role_access` VALUES ('1', '1093');
INSERT INTO `t_role_access` VALUES ('1', '1094');
INSERT INTO `t_role_access` VALUES ('1', '1101');
INSERT INTO `t_role_access` VALUES ('1', '1102');
INSERT INTO `t_role_access` VALUES ('1', '1103');
INSERT INTO `t_role_access` VALUES ('1', '1104');
INSERT INTO `t_role_access` VALUES ('1', '1111');
INSERT INTO `t_role_access` VALUES ('1', '1112');
INSERT INTO `t_role_access` VALUES ('1', '1113');
INSERT INTO `t_role_access` VALUES ('1', '1114');
INSERT INTO `t_role_access` VALUES ('1', '1121');
INSERT INTO `t_role_access` VALUES ('1', '1122');
INSERT INTO `t_role_access` VALUES ('1', '1123');
INSERT INTO `t_role_access` VALUES ('1', '1124');
INSERT INTO `t_role_access` VALUES ('1', '9011');
INSERT INTO `t_role_access` VALUES ('1', '9012');
INSERT INTO `t_role_access` VALUES ('1', '9013');
INSERT INTO `t_role_access` VALUES ('1', '9014');
INSERT INTO `t_role_access` VALUES ('1', '9021');
INSERT INTO `t_role_access` VALUES ('1', '9022');
INSERT INTO `t_role_access` VALUES ('1', '9023');
INSERT INTO `t_role_access` VALUES ('1', '9024');
INSERT INTO `t_role_access` VALUES ('1', '9025');
INSERT INTO `t_role_access` VALUES ('1', '9031');
INSERT INTO `t_role_access` VALUES ('1', '9032');
INSERT INTO `t_role_access` VALUES ('1', '9033');
INSERT INTO `t_role_access` VALUES ('1', '9034');
INSERT INTO `t_role_access` VALUES ('1', '9035');

-- ----------------------------
-- Table structure for `t_sup_class`
-- ----------------------------
DROP TABLE IF EXISTS `t_sup_class`;
CREATE TABLE `t_sup_class` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `code` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='货商分类';

-- ----------------------------
-- Records of t_sup_class
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sup_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_sup_info`;
CREATE TABLE `t_sup_info` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `code` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `supclass_id` smallint(6) NOT NULL DEFAULT '0',
  `linkman` varchar(32) DEFAULT NULL,
  `tel` varchar(32) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(32) DEFAULT NULL,
  `bank` varchar(32) DEFAULT NULL,
  `account` varchar(32) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  `createdatetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `state` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='货商档案';

-- ----------------------------
-- Records of t_sup_info
-- ----------------------------
INSERT INTO `t_sup_info` VALUES ('1', '1', '1', '0', null, null, null, null, null, null, null, '0000-00-00 00:00:00', '0');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `sex` tinyint(4) NOT NULL DEFAULT '0',
  `age` tinyint(4) NOT NULL DEFAULT '0',
  `usertype` tinyint(4) NOT NULL DEFAULT '0',
  `isdefault` tinyint(4) NOT NULL DEFAULT '0',
  `state` tinyint(4) NOT NULL DEFAULT '0',
  `createdatetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `branch_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `loginname` (`loginname`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', '超级管理员', '21232f297a57a5a743894a0e4a801fc3', '0', '18', '1', '0', '0', '2012-06-04 01:00:00', '1');

-- ----------------------------
-- Table structure for `t_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `user_id` smallint(6) NOT NULL,
  `role_id` smallint(6) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='用户角色';

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '1');

CREATE TABLE `procedure` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`name`  varchar(50) NULL ,
`company_id`  int(11) NULL ,
`status`  int(11) NOT NULL DEFAULT 0 ,
`create_time`  timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP ,
PRIMARY KEY (`id`)
)
;


CREATE TABLE `procedure_by_department` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`procedure_id`  int(11) NULL ,
`p_department_id`  int(11) NULL ,
`sort`  int(11) NULL ,
`status`  int(11) NOT NULL DEFAULT 0 ,
`create_time`  timestamp NULL ON UPDATE CURRENT_TIMESTAMP ,
PRIMARY KEY (`id`)
)
;



