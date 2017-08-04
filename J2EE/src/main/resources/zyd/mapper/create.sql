SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `142558_goods`;
CREATE TABLE `142558_goods` (
  `id` int(200) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT '',
  `real_price` double(200,2) DEFAULT NULL,
  `serial_code` varchar(20) DEFAULT '',
  `weight` double(20,0) DEFAULT NULL,
  `stock_count` int(20) DEFAULT NULL,
  `pre_sale_number` int(20) DEFAULT NULL,
  `store_id` varchar(20) DEFAULT '',
  `mid_user_price` double(20,0) DEFAULT NULL,
  `market_price` double(20,0) DEFAULT NULL,
  `redeem_point` int(20) DEFAULT NULL,
  `category_id` int(20) DEFAULT NULL,
  `brand_id` int(20) DEFAULT NULL,
  `stand_id` int(20) DEFAULT NULL,
  `add_time` varchar(20) DEFAULT '',
  `last_modified_time` varchar(20) DEFAULT '',
  `description` varchar(20) DEFAULT NULL,
  `image_path` varchar(20) DEFAULT '',
  `is_dividable` bit(1) DEFAULT NULL,
  `default_express` varchar(20) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `142558_order_goods`;
CREATE TABLE `142558_order_goods` (
  `id` int(200) NOT NULL AUTO_INCREMENT,
  `order_id` int(200) DEFAULT NULL,
  `goods_id` int(200) DEFAULT NULL,
  `goods_number` int(20) DEFAULT NULL,
  `goods_name` varchar(200) DEFAULT '',
  `goods_price` double(200,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

DROP TABLE IF EXISTS `142558_order_info`;
CREATE TABLE `142558_order_info` (
  `order_id` int(200) NOT NULL AUTO_INCREMENT,
  `user_id` int(200) DEFAULT NULL,
  `order_status` int(10) DEFAULT NULL,
  `consignee` varchar(200) DEFAULT '',
  `address` varchar(200) DEFAULT '',
  `zipcode` varchar(20) DEFAULT '',
  `telephone` varchar(200) DEFAULT '',
  `email` varchar(200) DEFAULT '',
  `goods_price` double(200,2) DEFAULT NULL,
  `order_price` double(200,2) DEFAULT NULL,
  `remark` varchar(200) DEFAULT '',
  `add_time` int(200) DEFAULT NULL,
  `expressCode` varchar(200) DEFAULT '',
  `signature_characters` varchar(200) DEFAULT '',
  `order_sn` varchar(20) DEFAULT '',
  `total_weight` double(20,0) DEFAULT NULL,
  `pay_time` int(200) DEFAULT NULL,
  `make_time` int(200) DEFAULT NULL,
  `shipped_time` int(200) DEFAULT NULL,
  `receive_time` int(200) DEFAULT NULL,
  `cancel_time` int(200) DEFAULT NULL,
  `isUrgency` varchar(1) DEFAULT '',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

DROP TABLE IF EXISTS `142558_user`;
CREATE TABLE `142558_user` (
  `user_id` int(200) NOT NULL,
  `password` varchar(200) DEFAULT '',	
  `user_name` varchar(200) DEFAULT '',
  `mobile_phone` varchar(200) DEFAULT '',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;