/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50635
Source Host           : localhost:3306
Source Database       : spring

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-06-01 21:51:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `142402_goods`
-- ----------------------------
DROP TABLE IF EXISTS `142402_goods`;
CREATE TABLE `142402_goods` (
`id`  bigint(20) NOT NULL ,
`name`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`serial_code`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`weight`  double NOT NULL ,
`stock_count`  int(11) NOT NULL ,
`pre_sale_number`  int(11) NOT NULL ,
`store_id`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`mid_user_price`  double NOT NULL ,
`market_price`  double NOT NULL ,
`real_price`  double NOT NULL ,
`redeem_point`  int(11) NOT NULL ,
`category_id`  int(11) NOT NULL ,
`brand_id`  int(11) NOT NULL ,
`Stand_id`  int(11) NOT NULL ,
`add_time`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`last_modified_time`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`description`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`image_path`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`is_dividable`  tinyint(1) NOT NULL ,
`default_express`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `142402_order_goods`
-- ----------------------------
DROP TABLE IF EXISTS `142402_order_goods`;
CREATE TABLE `142402_order_goods` (
`id`  bigint(20) NOT NULL ,
`order_id`  bigint(20) NOT NULL ,
`goods_id`  bigint(20) NOT NULL ,
`goods_name`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`goods_number`  int(11) NOT NULL ,
`goods_price`  double NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `142402_order_info`
-- ----------------------------
DROP TABLE IF EXISTS `142402_order_info`;
CREATE TABLE `142402_order_info` (
`order_id`  bigint(20) NOT NULL ,
`order_sn`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`user_id`  bigint(20) NULL DEFAULT NULL ,
`order_status`  int(11) NOT NULL ,
`consignee`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`address`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`Zipcode`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`telephone`  varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
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
-- Table structure for `142402_users`
-- ----------------------------
DROP TABLE IF EXISTS `142402_users`;
CREATE TABLE `142402_users` (
`user_id`  bigint(20) NOT NULL ,
`user_name`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`password`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`mobile_phone`  varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`user_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;
