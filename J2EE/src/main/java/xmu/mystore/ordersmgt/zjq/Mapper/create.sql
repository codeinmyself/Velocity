/*
Navicat MySQL Data Transfer

Source Server         : mysql6
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mystore

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-06-02 13:00:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for 142539_goods
-- ----------------------------
DROP TABLE IF EXISTS `142539_goods`;
CREATE TABLE `142539_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `serial_code` varchar(40) NOT NULL,
  `weight` double(12,0) unsigned zerofill DEFAULT NULL,
  `stock_count` int(11) unsigned zerofill DEFAULT '00000000000',
  `pre_sale_number` int(11) unsigned zerofill DEFAULT '00000000000',
  `store_id` varchar(40) DEFAULT NULL,
  `mid_user_price` double(12,0) unsigned zerofill DEFAULT '000000000000',
  `market_price` double(12,0) unsigned zerofill DEFAULT '000000000000',
  `real_price` double(12,0) unsigned zerofill DEFAULT '000000000000',
  `redeem_point` int(11) DEFAULT '0',
  `category_id` bigint(11) DEFAULT NULL,
  `brand_id` bigint(11) DEFAULT NULL,
  `stand_id` bigint(11) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `last_modified_time` datetime DEFAULT NULL,
  `description` longtext,
  `image_path` varchar(999) DEFAULT NULL,
  `is_dividable` tinyint(1) DEFAULT '0',
  `default_express` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialCode` (`serial_code`)
) ENGINE=InnoDB AUTO_INCREMENT=164 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for 142539_order_goods
-- ----------------------------
DROP TABLE IF EXISTS `142539_order_goods`;
CREATE TABLE `142539_order_goods` (
  `id` bigint(20) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `goods_id` bigint(20) DEFAULT NULL,
  `goods_name` varchar(55) DEFAULT NULL,
  `goods_number` int(11) DEFAULT NULL,
  `goods_price` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for 142539_order_info
-- ----------------------------
DROP TABLE IF EXISTS `142539_order_info`;
CREATE TABLE `142539_order_info` (
  `order_id` bigint(20) DEFAULT NULL,
  `order_sn` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `order_status` int(11) DEFAULT NULL,
  `consignee` varchar(55) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `zipcode` varchar(55) DEFAULT NULL,
  `telephone` varchar(30) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `goods_price` double DEFAULT NULL,
  `order_price` double DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `total_weight` double DEFAULT NULL,
  `signature_characters` varchar(255) DEFAULT NULL,
  `add_time` int(11) DEFAULT NULL,
  `pay_time` int(11) DEFAULT NULL,
  `make_time` int(11) DEFAULT NULL,
  `shipped_time` int(11) DEFAULT NULL,
  `receive_time` int(11) DEFAULT NULL,
  `cancel_time` int(11) DEFAULT NULL,
  `expressCode` varchar(100) DEFAULT NULL,
  `isUrgency` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for 142539_users
-- ----------------------------
DROP TABLE IF EXISTS `142539_users`;
CREATE TABLE `142539_users` (
  `user_id` bigint(20) DEFAULT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `mobile_phone` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
