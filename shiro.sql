/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : shiro-test

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2018-12-15 23:36:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for role_permission2
-- ----------------------------
DROP TABLE IF EXISTS `role_permission2`;
CREATE TABLE `role_permission2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission2
-- ----------------------------
INSERT INTO `role_permission2` VALUES ('1', 'zzh1', '123');
/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : shiro-test

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2018-12-15 23:36:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for roles_permissions
-- ----------------------------
DROP TABLE IF EXISTS `roles_permissions`;
CREATE TABLE `roles_permissions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_name` varchar(50) DEFAULT '' COMMENT '角色名称',
  `permission` varchar(50) DEFAULT '' COMMENT '角色权限',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '编辑时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles_permissions
-- ----------------------------
INSERT INTO `roles_permissions` VALUES ('1', 'admin', 'admin:*', '2018-12-15 19:05:39', '2018-12-15 19:05:39');
INSERT INTO `roles_permissions` VALUES ('2', 'user', 'user:*', '2018-12-15 19:05:39', '2018-12-15 19:05:39');
INSERT INTO `roles_permissions` VALUES ('3', 'test', 'abcd', '2018-12-15 19:37:19', '0000-00-00 00:00:00');
/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : shiro-test

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2018-12-15 23:36:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_roles
-- ----------------------------
DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `role_name` varchar(50) NOT NULL COMMENT '角色名称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '编辑时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_roles
-- ----------------------------
INSERT INTO `user_roles` VALUES ('1', 'zzh1', 'admin', '2018-12-15 19:05:39', '2018-12-15 19:05:39');
INSERT INTO `user_roles` VALUES ('2', 'zzh1', 'user', '2018-12-15 19:05:39', '2018-12-15 19:05:39');
INSERT INTO `user_roles` VALUES ('3', 'zzh1', 'test', '2018-12-15 19:37:11', '0000-00-00 00:00:00');
INSERT INTO `user_roles` VALUES ('4', 'zzh2', 'admin', '2018-12-15 20:33:15', '0000-00-00 00:00:00');
/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : shiro-test

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2018-12-15 23:36:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(50) DEFAULT '' COMMENT '用户名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '编辑时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'zzh1', '111111', '2018-12-15 19:05:38', '2018-12-15 19:05:38');
INSERT INTO `users` VALUES ('2', 'zzh2', '111111', '2018-12-15 20:32:56', '0000-00-00 00:00:00');

