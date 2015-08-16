/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50533
Source Host           : localhost:3306
Source Database       : smart

Target Server Type    : MYSQL
Target Server Version : 50533
File Encoding         : 65001

Date: 2015-08-16 17:02:40
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ts_permission
-- ----------------------------
INSERT INTO `ts_permission` VALUES ('1', '根目录', '/', '0', '2', '初始化用，不能删除', null);
INSERT INTO `ts_permission` VALUES ('2', '系统管理', 'System', '1', '2', '系统管理', '1');
INSERT INTO `ts_permission` VALUES ('3', '系统配置', '/systemConfig/list.do', '5', '2', '系统配置', '2');
INSERT INTO `ts_permission` VALUES ('4', '权限管理', '/permission/list.do', '4', '2', '权限管理', '2');
INSERT INTO `ts_permission` VALUES ('5', '角色管理', '/role/list.do', '3', '2', '角色管理', '2');
INSERT INTO `ts_permission` VALUES ('6', '用户列表', '/user/list.do', '2', '2', '用户列表', '2');
INSERT INTO `ts_permission` VALUES ('10', '字典管理', '/dic/list.do', '6', '2', '字典管理', '2');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ts_role
-- ----------------------------
INSERT INTO `ts_role` VALUES ('1', '系统管理员', '系统管理员', 'ROLE_ADMIN');

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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ts_role_permission
-- ----------------------------
INSERT INTO `ts_role_permission` VALUES ('1', '7', '2');
INSERT INTO `ts_role_permission` VALUES ('2', '8', '2');
INSERT INTO `ts_role_permission` VALUES ('3', '9', '2');
INSERT INTO `ts_role_permission` VALUES ('4', '11', '2');
INSERT INTO `ts_role_permission` VALUES ('5', '12', '2');
INSERT INTO `ts_role_permission` VALUES ('6', '13', '2');
INSERT INTO `ts_role_permission` VALUES ('7', '14', '2');
INSERT INTO `ts_role_permission` VALUES ('8', '15', '2');
INSERT INTO `ts_role_permission` VALUES ('9', '16', '2');
INSERT INTO `ts_role_permission` VALUES ('10', '17', '2');
INSERT INTO `ts_role_permission` VALUES ('11', '2', '1');
INSERT INTO `ts_role_permission` VALUES ('12', '10', '1');
INSERT INTO `ts_role_permission` VALUES ('13', '3', '1');
INSERT INTO `ts_role_permission` VALUES ('14', '4', '1');
INSERT INTO `ts_role_permission` VALUES ('15', '5', '1');
INSERT INTO `ts_role_permission` VALUES ('16', '6', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ts_user
-- ----------------------------
INSERT INTO `ts_user` VALUES ('8', '2014-08-16 12:26:55', 'gaowenming', '8f5ceacb1b3fb4d8cf6167ce23d47e84', 'gaowenming', 'gaowm0207@163.com', '', '1');
INSERT INTO `ts_user` VALUES ('9', '2014-11-30 14:05:41', '管理员', '32057b94d50d40cac3bb0177b5923c50', 'admin', 'gaowm@163.com', '', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ts_user_role
-- ----------------------------
INSERT INTO `ts_user_role` VALUES ('4', '1', '8');
INSERT INTO `ts_user_role` VALUES ('5', '2', '8');
INSERT INTO `ts_user_role` VALUES ('7', '1', '9');
INSERT INTO `ts_user_role` VALUES ('8', '2', '9');
