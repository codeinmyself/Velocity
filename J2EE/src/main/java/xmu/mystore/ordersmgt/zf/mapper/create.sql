/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : javaee_order

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-06-03 16:35:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for 142560_goods
-- ----------------------------
DROP TABLE IF EXISTS `142560_goods`;
CREATE TABLE `142560_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 NOT NULL,
  `serial_code` varchar(25) NOT NULL,
  `weight` double NOT NULL,
  `stock_count` int(11) NOT NULL,
  `pre_sale_number` int(11) DEFAULT NULL COMMENT '预售数量',
  `store_id` varchar(25) DEFAULT NULL,
  `mid_user_price` double DEFAULT NULL COMMENT '中介价格',
  `market_price` double DEFAULT NULL COMMENT '市场价格',
  `real_price` double DEFAULT NULL COMMENT '真实价格',
  `redeem_point` int(11) DEFAULT NULL COMMENT '商品积分',
  `category_id` int(11) DEFAULT NULL COMMENT '品类ID',
  `brand_id` int(11) DEFAULT NULL COMMENT '品牌ID',
  `stand_id` int(11) DEFAULT NULL COMMENT '上下架ID',
  `add_time` varchar(20) DEFAULT NULL COMMENT '增加商品时间',
  `last_modified_time` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `decription` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `image_path` varchar(128) DEFAULT NULL COMMENT '商品图片',
  `is_dividable` tinyint(2) DEFAULT '0' COMMENT '是否允许分单',
  `default_express` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '默认快递',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for 142560_order_goods
-- ----------------------------
DROP TABLE IF EXISTS `142560_order_goods`;
CREATE TABLE `142560_order_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) NOT NULL,
  `goods_id` bigint(20) NOT NULL,
  `goods_name` varchar(50) CHARACTER SET utf8 NOT NULL,
  `goods_number` int(11) NOT NULL DEFAULT '1',
  `goods_price` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `orderid` (`order_id`),
  KEY `goodsid` (`goods_id`),
  CONSTRAINT `goodsid` FOREIGN KEY (`goods_id`) REFERENCES `142560_goods` (`id`),
  CONSTRAINT `orderid` FOREIGN KEY (`order_id`) REFERENCES `142560_order_info` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for 142560_order_info
-- ----------------------------
DROP TABLE IF EXISTS `142560_order_info`;
CREATE TABLE `142560_order_info` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_sn` varchar(25) DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) DEFAULT NULL,
  `order_status` int(4) DEFAULT '0' COMMENT '0-未付款  1-已付款  2-定制中  3-已发货  4-已收货   5-取消',
  `consignee` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `zipcode` varchar(10) DEFAULT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  `goods_price` double DEFAULT NULL COMMENT '商品总价',
  `order_price` double DEFAULT NULL COMMENT '订单总价',
  `remark` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `total_weight` double DEFAULT NULL,
  `signature_characters` varchar(25) CHARACTER SET utf8 DEFAULT NULL,
  `add_time` int(11) DEFAULT NULL COMMENT '下单时间',
  `pay_time` int(11) DEFAULT NULL COMMENT '支付时间',
  `make_time` int(11) DEFAULT NULL COMMENT '状态变为定制中的时间',
  `shipped_time` int(11) DEFAULT NULL COMMENT '状态变为已发货的时间',
  `recieve_time` int(11) DEFAULT NULL COMMENT '状态变为已收货的时间',
  `cancel_time` int(11) DEFAULT NULL COMMENT '状态变为已取消的时间',
  `expressCode` varchar(25) DEFAULT NULL COMMENT '快递单号',
  `isUrgency` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for 142560_users
-- ----------------------------
DROP TABLE IF EXISTS `142560_users`;
CREATE TABLE `142560_users` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(25) NOT NULL,
  `password` varchar(50) NOT NULL,
  `mobile_phone` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
