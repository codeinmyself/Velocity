/*
Navicat MySQL Data Transfer

Source Server         : qiuming
Source Server Version : 50552
Source Host           : 120.77.173.98:3306
Source Database       : j2ee

Target Server Type    : MYSQL
Target Server Version : 50552
File Encoding         : 65001

Date: 2017-06-18 07:28:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `142528_organization`
-- ----------------------------
DROP TABLE IF EXISTS `142528_organization`;
CREATE TABLE `142528_organization` (
  `organization_id` bigint(20) NOT NULL DEFAULT '0',
  `organization_name` varchar(50) DEFAULT NULL,
  `organization_address` varchar(50) DEFAULT NULL,
  `organization_description` varchar(50) DEFAULT NULL,
  `enable` varchar(50) NOT NULL,
  PRIMARY KEY (`organization_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 142528_organization
-- ----------------------------
INSERT INTO `142528_organization` VALUES ('1', '厦门大学', '厦门市', '厉害的学校', 'enable');
INSERT INTO `142528_organization` VALUES ('2', '集美大学', '厦门市', '厉害的学校2', 'enable');

-- ----------------------------
-- Table structure for `142528_organization_permission`
-- ----------------------------
DROP TABLE IF EXISTS `142528_organization_permission`;
CREATE TABLE `142528_organization_permission` (
  `op_id` bigint(45) NOT NULL AUTO_INCREMENT,
  `organization_id` bigint(32) NOT NULL,
  `permission_id` bigint(32) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`op_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 142528_organization_permission
-- ----------------------------
INSERT INTO `142528_organization_permission` VALUES ('4', '1', '2', '拥有更新users权限');
INSERT INTO `142528_organization_permission` VALUES ('5', '1', '3', '拥有权限');
INSERT INTO `142528_organization_permission` VALUES ('6', '1', '4', '拥有权限');
INSERT INTO `142528_organization_permission` VALUES ('7', '2', '1', '拥有权限');
INSERT INTO `142528_organization_permission` VALUES ('8', '2', '2', '拥有权限');
INSERT INTO `142528_organization_permission` VALUES ('9', '2', '3', '拥有权限');
INSERT INTO `142528_organization_permission` VALUES ('10', '2', '4', '拥有权限');
INSERT INTO `142528_organization_permission` VALUES ('12', '1', '1', '拥有所有权限');

-- ----------------------------
-- Table structure for `142528_permission`
-- ----------------------------
DROP TABLE IF EXISTS `142528_permission`;
CREATE TABLE `142528_permission` (
  `permission_id` bigint(32) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(32) NOT NULL,
  `permission` varchar(32) NOT NULL,
  `permission_description` varchar(45) NOT NULL,
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 142528_permission
-- ----------------------------
INSERT INTO `142528_permission` VALUES ('1', '查看品牌', 'select_brand', '拥有查看品牌的权限');
INSERT INTO `142528_permission` VALUES ('2', '增加品牌', 'insert_brand', '拥有增加品牌的权限');
INSERT INTO `142528_permission` VALUES ('3', '修改品牌', 'update_brand', '拥有修改品牌的权限');
INSERT INTO `142528_permission` VALUES ('4', '删除品牌', 'delete_brand', '拥有删除品牌的权限');
INSERT INTO `142528_permission` VALUES ('5', '查看品类', 'select_category', '拥有查看品类的权限');
INSERT INTO `142528_permission` VALUES ('6', '增加品类', 'insert_category', '拥有增加品类的权限');
INSERT INTO `142528_permission` VALUES ('7', '修改品类', 'update_category', '拥有修改品类的权限');
INSERT INTO `142528_permission` VALUES ('8', '删除品类', 'delete_category', '拥有删除品类的权限');
INSERT INTO `142528_permission` VALUES ('9', '查看商品', 'select_goods', '拥有查看商品的权限');
INSERT INTO `142528_permission` VALUES ('10', '增加商品', 'insert_goods', '拥有增加商品的权限');
INSERT INTO `142528_permission` VALUES ('11', '修改商品', 'update_goods', '拥有修改商品的权限');
INSERT INTO `142528_permission` VALUES ('12', '删除商品', 'delete_goods', '拥有删除商品的权限');
INSERT INTO `142528_permission` VALUES ('13', '查看日志', 'select_log_info', '拥有查看日志的权限');
INSERT INTO `142528_permission` VALUES ('14', '增加日志', 'insert_log_info', '拥有增加日志的权限');
INSERT INTO `142528_permission` VALUES ('15', '修改日志', 'update_log_info', '拥有修改日志的权限');
INSERT INTO `142528_permission` VALUES ('16', '删除日志', 'delete_log_info', '拥有删除日志的权限');
INSERT INTO `142528_permission` VALUES ('17', '查看上下架', 'select_stand', '拥有查看上下架的权限');
INSERT INTO `142528_permission` VALUES ('18', '增加上下架', 'insert_stand', '拥有增加上下架的权限');
INSERT INTO `142528_permission` VALUES ('19', '修改上下架', 'update_stand', '拥有修改上下架的权限');
INSERT INTO `142528_permission` VALUES ('20', '删除上下架', 'delete_stand', '拥有删除上下架的权限');
INSERT INTO `142528_permission` VALUES ('21', '查看订单', 'select_order', '拥有查看订单的权限');
INSERT INTO `142528_permission` VALUES ('22', '增加订单', 'insert_order', '拥有增加订单的权限');
INSERT INTO `142528_permission` VALUES ('23', '修改订单', 'update_order', '拥有修改订单的权限');
INSERT INTO `142528_permission` VALUES ('24', '删除订单', 'delete_order', '拥有删除订单的权限');
INSERT INTO `142528_permission` VALUES ('25', '查看角色', 'select_role', '拥有查看角色的权限');
INSERT INTO `142528_permission` VALUES ('26', '增加角色', 'insert_role', '拥有增加角色的权限');
INSERT INTO `142528_permission` VALUES ('27', '修改角色', 'update_role', '拥有修改角色的权限');
INSERT INTO `142528_permission` VALUES ('28', '删除角色', 'delete_role', '拥有删除角色的权限');
INSERT INTO `142528_permission` VALUES ('29', '查看用户角色', 'select_user_role', '拥有查看用户角色的权限');
INSERT INTO `142528_permission` VALUES ('30', '增加用户角色', 'insert_user_role', '拥有增加用户角色的权限');
INSERT INTO `142528_permission` VALUES ('31', '修改用户角色', 'update_user_role', '拥有修改用户角色的权限');
INSERT INTO `142528_permission` VALUES ('32', '删除用户角色', 'delete_user_role', '拥有删除用户角色的权限');

-- ----------------------------
-- Table structure for `142528_role`
-- ----------------------------
DROP TABLE IF EXISTS `142528_role`;
CREATE TABLE `142528_role` (
  `role_id` bigint(32) NOT NULL AUTO_INCREMENT,
  `organization_id` bigint(32) NOT NULL,
  `permission_id` bigint(32) NOT NULL,
  PRIMARY KEY (`role_id`,`organization_id`,`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 142528_role
-- ----------------------------
INSERT INTO `142528_role` VALUES ('1', '1', '7');
INSERT INTO `142528_role` VALUES ('1', '1', '10');
INSERT INTO `142528_role` VALUES ('1', '1', '12');
INSERT INTO `142528_role` VALUES ('1', '1', '13');
INSERT INTO `142528_role` VALUES ('2', '1', '1');
INSERT INTO `142528_role` VALUES ('2', '1', '2');
INSERT INTO `142528_role` VALUES ('2', '1', '3');
INSERT INTO `142528_role` VALUES ('6', '2', '1');
INSERT INTO `142528_role` VALUES ('8', '1', '1');
INSERT INTO `142528_role` VALUES ('8', '1', '2');
INSERT INTO `142528_role` VALUES ('8', '1', '3');
INSERT INTO `142528_role` VALUES ('8', '1', '4');
INSERT INTO `142528_role` VALUES ('8', '1', '5');
INSERT INTO `142528_role` VALUES ('8', '1', '6');
INSERT INTO `142528_role` VALUES ('8', '1', '7');
INSERT INTO `142528_role` VALUES ('8', '1', '8');
INSERT INTO `142528_role` VALUES ('8', '1', '9');
INSERT INTO `142528_role` VALUES ('8', '1', '10');
INSERT INTO `142528_role` VALUES ('8', '1', '11');
INSERT INTO `142528_role` VALUES ('8', '1', '12');
INSERT INTO `142528_role` VALUES ('8', '1', '13');
INSERT INTO `142528_role` VALUES ('8', '1', '14');
INSERT INTO `142528_role` VALUES ('8', '1', '15');
INSERT INTO `142528_role` VALUES ('8', '1', '16');
INSERT INTO `142528_role` VALUES ('8', '1', '17');
INSERT INTO `142528_role` VALUES ('8', '1', '18');
INSERT INTO `142528_role` VALUES ('8', '1', '19');
INSERT INTO `142528_role` VALUES ('8', '1', '20');
INSERT INTO `142528_role` VALUES ('8', '1', '21');
INSERT INTO `142528_role` VALUES ('8', '1', '22');
INSERT INTO `142528_role` VALUES ('8', '1', '23');
INSERT INTO `142528_role` VALUES ('8', '1', '24');
INSERT INTO `142528_role` VALUES ('8', '1', '25');
INSERT INTO `142528_role` VALUES ('8', '1', '26');
INSERT INTO `142528_role` VALUES ('8', '1', '27');
INSERT INTO `142528_role` VALUES ('8', '1', '28');
INSERT INTO `142528_role` VALUES ('8', '1', '29');
INSERT INTO `142528_role` VALUES ('8', '1', '30');
INSERT INTO `142528_role` VALUES ('8', '1', '31');
INSERT INTO `142528_role` VALUES ('8', '1', '32');
INSERT INTO `142528_role` VALUES ('9', '1', '1');
INSERT INTO `142528_role` VALUES ('9', '1', '2');
INSERT INTO `142528_role` VALUES ('9', '1', '3');
INSERT INTO `142528_role` VALUES ('9', '1', '4');
INSERT INTO `142528_role` VALUES ('10', '1', '5');
INSERT INTO `142528_role` VALUES ('10', '1', '6');
INSERT INTO `142528_role` VALUES ('10', '1', '7');
INSERT INTO `142528_role` VALUES ('10', '1', '8');
INSERT INTO `142528_role` VALUES ('11', '1', '9');
INSERT INTO `142528_role` VALUES ('11', '1', '10');
INSERT INTO `142528_role` VALUES ('11', '1', '11');
INSERT INTO `142528_role` VALUES ('11', '1', '12');
INSERT INTO `142528_role` VALUES ('12', '1', '17');
INSERT INTO `142528_role` VALUES ('12', '1', '18');
INSERT INTO `142528_role` VALUES ('12', '1', '19');
INSERT INTO `142528_role` VALUES ('12', '1', '20');
INSERT INTO `142528_role` VALUES ('13', '1', '21');
INSERT INTO `142528_role` VALUES ('13', '1', '22');
INSERT INTO `142528_role` VALUES ('13', '1', '23');
INSERT INTO `142528_role` VALUES ('13', '1', '24');
INSERT INTO `142528_role` VALUES ('14', '1', '25');
INSERT INTO `142528_role` VALUES ('14', '1', '26');
INSERT INTO `142528_role` VALUES ('14', '1', '27');
INSERT INTO `142528_role` VALUES ('14', '1', '28');
INSERT INTO `142528_role` VALUES ('15', '1', '29');
INSERT INTO `142528_role` VALUES ('15', '1', '30');
INSERT INTO `142528_role` VALUES ('15', '1', '31');
INSERT INTO `142528_role` VALUES ('15', '1', '32');

-- ----------------------------
-- Table structure for `142528_role_info`
-- ----------------------------
DROP TABLE IF EXISTS `142528_role_info`;
CREATE TABLE `142528_role_info` (
  `role_id` bigint(32) NOT NULL AUTO_INCREMENT,
  `organization_id` bigint(32) NOT NULL,
  `role_name` varchar(32) NOT NULL,
  `description` varchar(45) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 142528_role_info
-- ----------------------------
INSERT INTO `142528_role_info` VALUES ('8', '1', '老板', '老板拥有所有权限');
INSERT INTO `142528_role_info` VALUES ('9', '1', '品牌管理员', '管理品牌');
INSERT INTO `142528_role_info` VALUES ('10', '1', '品类管理员', '管理品类');
INSERT INTO `142528_role_info` VALUES ('11', '1', '商品管理员', '管理商品');
INSERT INTO `142528_role_info` VALUES ('12', '1', '上下架管理员', '管理上下架');
INSERT INTO `142528_role_info` VALUES ('13', '1', '订单管理员', '管理订单');
INSERT INTO `142528_role_info` VALUES ('14', '1', '角色管理员', '管理角色');
INSERT INTO `142528_role_info` VALUES ('15', '1', '用户角色管理员', '管理用户角色');

-- ----------------------------
-- Table structure for `142528_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `142528_user_role`;
CREATE TABLE `142528_user_role` (
  `user_id` bigint(32) NOT NULL,
  `role_id` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 142528_user_role
-- ----------------------------
INSERT INTO `142528_user_role` VALUES ('1', '8');
INSERT INTO `142528_user_role` VALUES ('1', '9');
INSERT INTO `142528_user_role` VALUES ('2588', '14');
INSERT INTO `142528_user_role` VALUES ('2588', '15');
INSERT INTO `142528_user_role` VALUES ('2588', '8');
INSERT INTO `142528_user_role` VALUES ('2588', '9');
INSERT INTO `142528_user_role` VALUES ('2589', '9');

-- ----------------------------
-- Table structure for `142528_users`
-- ----------------------------
DROP TABLE IF EXISTS `142528_users`;
CREATE TABLE `142528_users` (
  `user_id` bigint(32) NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `mobile_phone` varchar(15) NOT NULL,
  `imagepath` varchar(45) DEFAULT NULL,
  `real_name` varchar(45) DEFAULT NULL,
  `openid` bigint(32) DEFAULT NULL,
  `recommend_user_id` bigint(32) DEFAULT NULL,
  `sex` varchar(45) DEFAULT NULL,
  `reg_time` varchar(50) DEFAULT NULL,
  `last_login` varchar(50) DEFAULT NULL,
  `last_ip` varchar(50) DEFAULT NULL,
  `enable` varchar(50) NOT NULL,
  `user_type` varchar(50) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 142528_users
-- ----------------------------
INSERT INTO `142528_users` VALUES ('1', 'admin', '6216f8a75fd5bb3d5f22b6f9958cdede3fc086c2', '13817583728', null, '死神', null, null, '男', null, null, null, 'enable', 'admin');
INSERT INTO `142528_users` VALUES ('2', 'super_admin', '6216f8a75fd5bb3d5f22b6f9958cdede3fc086c2', '15673237555', null, '真名', '1', null, '男', null, null, null, 'enable', 'super_admin');
INSERT INTO `142528_users` VALUES ('3', 'normal_user', '6216f8a75fd5bb3d5f22b6f9958cdede3fc086c2', '18688772345', null, '假名', null, null, '男', null, null, null, 'enable', 'normal_user');
INSERT INTO `142528_users` VALUES ('255', '3', '6216f8a75fd5bb3d5f22b6f9958cdede3fc086c2', '10000000000', null, '黑棋', '1', null, '男', null, null, null, 'enable', 'admin');
INSERT INTO `142528_users` VALUES ('552', 'batsman', '6216f8a75fd5bb3d5f22b6f9958cdede3fc086c2', '17639248575', null, '蝙蝠侠', '1', null, '男', null, null, null, 'enable', 'admin');
INSERT INTO `142528_users` VALUES ('2550', '郑洋', '6216f8a75fd5bb3d5f22b6f9958cdede3fc086c2', '15000588578', null, '郑洋', '1', null, '女', null, null, null, 'enable', 'normal_user');
INSERT INTO `142528_users` VALUES ('2558', '111', '6216f8a75fd5bb3d5f22b6f9958cdede3fc086c2', '18500000022', null, '钢铁侠', '1', null, '男', null, null, null, 'enable', 'super_admin');
INSERT INTO `142528_users` VALUES ('2588', '2', '6216f8a75fd5bb3d5f22b6f9958cdede3fc086c2', '10000000000', null, '老哥', '1', null, '男', null, null, null, 'enable', 'admin');
INSERT INTO `142528_users` VALUES ('2589', '1', '6216f8a75fd5bb3d5f22b6f9958cdede3fc086c2', '10000000000', null, '黑寡妇', '1', null, '女', null, null, null, 'enable', 'normal_user');
