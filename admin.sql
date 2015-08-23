/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50533
Source Host           : localhost:3306
Source Database       : smart

Target Server Type    : MYSQL
Target Server Version : 50533
File Encoding         : 65001

Date: 2015-08-23 16:22:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ts_dic`
-- ----------------------------
DROP TABLE IF EXISTS `ts_dic`;
CREATE TABLE `ts_dic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `dic_value` varchar(2000) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ts_dic
-- ----------------------------
INSERT INTO `ts_dic` VALUES ('4', 'sex', '1=男;2=女', '性别');

-- ----------------------------
-- Table structure for `ts_login_log`
-- ----------------------------
DROP TABLE IF EXISTS `ts_login_log`;
CREATE TABLE `ts_login_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `clientIp` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `loginTime` datetime DEFAULT NULL,
  `logType` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ts_login_log
-- ----------------------------

-- ----------------------------
-- Table structure for `ts_permission`
-- ----------------------------
DROP TABLE IF EXISTS `ts_permission`;
CREATE TABLE `ts_permission` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `perm_name` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `perm_url` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `perm_order` int(5) DEFAULT NULL,
  `perm_type` int(11) DEFAULT NULL,
  `remark` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `p_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_bd33s6hrqe97bujfvy3gej9y4` (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ts_permission
-- ----------------------------
INSERT INTO `ts_permission` VALUES ('1', '根目录', '/', '0', '0', '初始化用，不能删除', null);
INSERT INTO `ts_permission` VALUES ('25', '系统管理', 'system', '1', '2', '系统管理', '1');
INSERT INTO `ts_permission` VALUES ('26', '用户管理', 'user', '2', '2', '用户管理', '25');
INSERT INTO `ts_permission` VALUES ('29', '删除用户', '/user/delete.do', '3', '1', '删除用户', '26');
INSERT INTO `ts_permission` VALUES ('30', '角色管理', 'role', '4', '2', '', '25');
INSERT INTO `ts_permission` VALUES ('33', '删除角色', '/role/delete.do', '5', '1', '', '30');
INSERT INTO `ts_permission` VALUES ('34', '权限管理', 'permission', '6', '2', '', '25');
INSERT INTO `ts_permission` VALUES ('35', '删除权限', '/permission/delete.do', '7', '1', '', '34');
INSERT INTO `ts_permission` VALUES ('36', '系统配置', 'systemConfig', '8', '2', '', '25');
INSERT INTO `ts_permission` VALUES ('37', '删除配置', '/systemConfig/delete.do', '9', '1', '', '36');
INSERT INTO `ts_permission` VALUES ('38', '字典管理', 'dic', '10', '2', '', '25');
INSERT INTO `ts_permission` VALUES ('39', '删除字典', '/dic/delete.do', '11', '1', '', '38');
INSERT INTO `ts_permission` VALUES ('40', '系统监控', 'monitor', '12', '2', '', '1');
INSERT INTO `ts_permission` VALUES ('41', '登录日志', '/loginLog/list.do', '13', '1', '', '40');

-- ----------------------------
-- Table structure for `ts_role`
-- ----------------------------
DROP TABLE IF EXISTS `ts_role`;
CREATE TABLE `ts_role` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `remark` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `role_code` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ts_role
-- ----------------------------
INSERT INTO `ts_role` VALUES ('1', '系统管理员', '系统管理员', 'ROLE_ADMIN');
INSERT INTO `ts_role` VALUES ('6', '监控', '监控', 'ROLE_MONITOR');

-- ----------------------------
-- Table structure for `ts_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `ts_role_permission`;
CREATE TABLE `ts_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_fyfhlipnx6q42j9dqnjtuc7lw` (`permission_id`),
  KEY `FK_p5rhvo2p016exkcbee4rrxq74` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=166 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ts_role_permission
-- ----------------------------
INSERT INTO `ts_role_permission` VALUES ('153', '40', '6');
INSERT INTO `ts_role_permission` VALUES ('154', '41', '6');
INSERT INTO `ts_role_permission` VALUES ('155', '25', '1');
INSERT INTO `ts_role_permission` VALUES ('156', '26', '1');
INSERT INTO `ts_role_permission` VALUES ('157', '29', '1');
INSERT INTO `ts_role_permission` VALUES ('158', '30', '1');
INSERT INTO `ts_role_permission` VALUES ('159', '33', '1');
INSERT INTO `ts_role_permission` VALUES ('160', '34', '1');
INSERT INTO `ts_role_permission` VALUES ('161', '35', '1');
INSERT INTO `ts_role_permission` VALUES ('162', '36', '1');
INSERT INTO `ts_role_permission` VALUES ('163', '37', '1');
INSERT INTO `ts_role_permission` VALUES ('164', '38', '1');
INSERT INTO `ts_role_permission` VALUES ('165', '39', '1');

-- ----------------------------
-- Table structure for `ts_systemconfig`
-- ----------------------------
DROP TABLE IF EXISTS `ts_systemconfig`;
CREATE TABLE `ts_systemconfig` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `config_key` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `config_value` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ts_systemconfig
-- ----------------------------
INSERT INTO `ts_systemconfig` VALUES ('5', 'appid', '0001', '系统appid');

-- ----------------------------
-- Table structure for `ts_user`
-- ----------------------------
DROP TABLE IF EXISTS `ts_user`;
CREATE TABLE `ts_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createTime` datetime DEFAULT NULL,
  `fullname` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `username` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mobile` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ts_user
-- ----------------------------
INSERT INTO `ts_user` VALUES ('8', '2014-08-16 12:26:55', 'gaowenming', '8f5ceacb1b3fb4d8cf6167ce23d47e84', 'gaowenming', 'gaowm0207@163.com', '', '1');
INSERT INTO `ts_user` VALUES ('17', '2015-08-23 15:29:46', 'admin', '32057b94d50d40cac3bb0177b5923c50', 'admin', 'admin@163.com', '', '1');

-- ----------------------------
-- Table structure for `ts_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `ts_user_role`;
CREATE TABLE `ts_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_6b93ununy8i0gbj4k1ndk6i1l` (`role_id`),
  KEY `FK_f3wkkg5x9y1kndy72ksrio7v6` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ts_user_role
-- ----------------------------
INSERT INTO `ts_user_role` VALUES ('12', '1', '8');
INSERT INTO `ts_user_role` VALUES ('26', '6', '17');
INSERT INTO `ts_user_role` VALUES ('27', '1', '17');
