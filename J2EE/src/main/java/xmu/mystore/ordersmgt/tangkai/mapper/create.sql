/*
Navicat MySQL Data Transfer

Source Server         : j2ee
Source Server Version : 50552
Source Host           : 120.77.173.98:3306
Source Database       : j2ee

Target Server Type    : MYSQL
Target Server Version : 50552
File Encoding         : 65001

Date: 2017-06-01 22:37:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for 142489_order_goods
-- ----------------------------
DROP TABLE IF EXISTS `142489_order_goods`;
CREATE TABLE `142489_order_goods` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`order_id`  bigint(20) NOT NULL ,
`goods_id`  bigint(20) NOT NULL ,
`goods_name`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`goods_number`  int(11) NOT NULL ,
`goods_price`  double NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=10

;

-- ----------------------------
-- Table structure for 142489_order_info
-- ----------------------------
DROP TABLE IF EXISTS `142489_order_info`;
CREATE TABLE `142489_order_info` (
`order_id`  bigint(20) NOT NULL ,
`order_sn`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`user_id`  bigint(20) NULL DEFAULT NULL ,
`order_status`  int(11) NOT NULL ,
`consignee`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`address`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`Zipcode`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`telephone`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' ,
`email`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`goods_price`  double NOT NULL ,
`order_price`  double NOT NULL ,
`remark`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`total_weight`  double NOT NULL ,
`signature_characters`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`add_time`  int(11) NOT NULL ,
`pay_time`  int(11) NULL DEFAULT NULL ,
`make_time`  int(11) NULL DEFAULT NULL ,
`shipped_time`  int(11) NULL DEFAULT NULL ,
`receive_time`  int(11) NULL DEFAULT NULL ,
`cancel_timwe`  int(11) NULL DEFAULT NULL ,
`expressCode`  varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`isUrgency`  varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`order_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for 142489_users
-- ----------------------------
DROP TABLE IF EXISTS `142489_users`;
CREATE TABLE `142489_users` (
`user_id`  bigint(20) NOT NULL ,
`user_name`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`password`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`mobile_phone`  varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Auto increment value for 142489_order_goods
-- ----------------------------
ALTER TABLE `142489_order_goods` AUTO_INCREMENT=10;
