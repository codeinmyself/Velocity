DROP TABLE IF EXISTS `142450_goods`;
CREATE TABLE `142450_goods` (
  `id` bigint(20) NOT NULL,
  `name` varchar(40) NOT NULL,
  `serial_code` varchar(40) NOT NULL,
  `weight` double NOT NULL,
  `stock_count` int(11) NOT NULL,
  `pre_sale_number` int(11) NOT NULL,
  `store_id` varchar(100) NOT NULL,
  `mid_user_price` double NOT NULL,
  `market_price` double NOT NULL,
  `real_price` double NOT NULL,
  `redeem_point` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `brand_id` int(11) NOT NULL,
  `Stand_id` int(11) NOT NULL,
  `add_time` varchar(40) NOT NULL,
  `last_modified_time` varchar(40) NOT NULL,
  `description` varchar(100) NOT NULL,
  `image_path` varchar(40) NOT NULL,
  `is_dividable` tinyint(1) NOT NULL,
  `default_express` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `142450_order_goods`;
CREATE TABLE `142450_order_goods` (
  `id` bigint(20) NOT NULL,
  `order_id` bigint(20) NOT NULL,
  `goods_id` bigint(20) NOT NULL,
  `goods_name` varchar(40) NOT NULL,
  `goods_number` int(11) NOT NULL,
  `goods_price` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `142450_users`;
CREATE TABLE `142450_users` (
  `user_id` bigint(20) NOT NULL,
  `user_name` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `mobile_phone` varchar(11) NOT NULL,
  `imagepath` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `142450_order_info`;
CREATE TABLE `142450_order_info` (
  `order_id` bigint(20) NOT NULL,
  `order_sn` varchar(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `order_status` int(11) NOT NULL,
  `consignee` varchar(20) NOT NULL,
  `address` varchar(100) NOT NULL,
  `Zipcode` varchar(10) DEFAULT NULL,
  `telephone` varchar(11) NOT NULL,
  `email` varchar(40) DEFAULT NULL,
  `goods_price` double NOT NULL,
  `order_price` double NOT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `total_weight` double NOT NULL,
  `signature_characters` varchar(40) DEFAULT NULL,
  `add_time` int(11) NOT NULL,
  `pay_time` int(11) DEFAULT NULL,
  `make_time` int(11) DEFAULT NULL,
  `shipped_time` int(11) DEFAULT NULL,
  `receive_time` int(11) DEFAULT NULL,
  `cancel_timwe` int(11) DEFAULT NULL,
  `expressCode` varchar(25) DEFAULT NULL,
  `isUrgency` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


