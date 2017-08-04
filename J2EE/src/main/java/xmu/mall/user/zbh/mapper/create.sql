SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `142537_user`
-- ----------------------------
DROP TABLE IF EXISTS `142537_user`;
CREATE TABLE `142537_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `reg_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `address` varchar(50) NOT NULL,
  `openid` varchar(50) NOT NULL,
  `real_name` varchar(50) NOT NULL,
  `mobile_phone` varchar(50) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `142537_goods`
-- ----------------------------
DROP TABLE IF EXISTS `142537_goods`;
CREATE TABLE `142537_goods` (
  `id` bigint(20) NOT NULL COMMENT '商品id',
  `name` varchar(50) NOT NULL COMMENT '商品名',
  `serial_code` varchar(50) NOT NULL COMMENT '商品编码',
  `weight` double NOT NULL COMMENT '商品重量',
  `stock_count` int(11) NOT NULL COMMENT '商品库存',
  `pre_sale_number` int(11) NOT NULL COMMENT '预售数量',
  `store_id` varchar(50) NOT NULL COMMENT '商店id',
  `mid_user_price` double NOT NULL COMMENT '中介价格',
  `market_price` double NOT NULL COMMENT '市场价格',
  `real_price` double NOT NULL COMMENT '真实价格',
  `redeem_point` int(11) NOT NULL COMMENT '商品积分',
  `category_id` int(11) NOT NULL COMMENT '品类id',
  `brand_id` int(11) NOT NULL COMMENT '品牌id',
  `Stand_id` int(11) NOT NULL COMMENT '上下架id',
  `add_time` varchar(50) NOT NULL COMMENT '增加商品时间',
  `last_modified_time` varchar(50) NOT NULL COMMENT '最后修改商品信息时间',
  `description` varchar(50) NOT NULL COMMENT '商品描述',
  `image_path` varchar(50) NOT NULL COMMENT '商品图片',
  `is_dividable` bit(1) NOT NULL COMMENT '是否允许分单 1是 0否',
  `default_express` varchar(50) NOT NULL COMMENT '默认快递',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `142537_order_goods`
-- ----------------------------
DROP TABLE IF EXISTS `142537_order_goods`;
CREATE TABLE `142537_order_goods` (
  `id` bigint(20) NOT NULL COMMENT '主码',
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单ID',
  `goods_id` bigint(20) DEFAULT NULL COMMENT '商品ID',
  `goods_name` varchar(50) DEFAULT NULL COMMENT '商品名称',
  `goods_number` int(11) DEFAULT NULL COMMENT '商品数量',
  `goods_price` double DEFAULT NULL COMMENT '商品单价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `142537_order_info`
-- ----------------------------
DROP TABLE IF EXISTS `142537_order_info`;
CREATE TABLE `142537_order_info` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `order_sn` varchar(50) NOT NULL COMMENT '订单编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `order_status` int(11) NOT NULL COMMENT '订单状态（0：未付款；1：已付款；2：定制中；3：已发货；4：已收货；5：取消）',
  `consignee` varchar(50) NOT NULL COMMENT '收货人',
  `address` varchar(50) NOT NULL COMMENT '地址',
  `zipcode` varchar(50) NOT NULL COMMENT '邮编',
  `telephone` varchar(50) NOT NULL COMMENT '电话',
  `email` varchar(50) NOT NULL COMMENT '邮箱',
  `goods_price` double NOT NULL COMMENT '商品总价',
  `order_price` double NOT NULL COMMENT '订单总价',
  `remark` varchar(50) CHARACTER SET utf8mb4 NOT NULL COMMENT '备注',
  `total_weight` double NOT NULL COMMENT '订单总重',
  `signature_characters` varchar(50) NOT NULL COMMENT '签名编码',
  `add_time` int(11) NOT NULL COMMENT '下单时间（用int类型来保存时间戳）',
  `pay_time` int(11) DEFAULT NULL COMMENT '支付时间',
  `make_time` int(11) DEFAULT NULL COMMENT '状态变为定制中的时间',
  `shipped_time` int(11) DEFAULT NULL COMMENT '状态变为已发货的时间',
  `receive_time` int(11) DEFAULT NULL COMMENT '状态变为已收货的时间',
  `cancel_time` int(11) DEFAULT NULL COMMENT '状态变为已取消的时间',
  `expressCode` varchar(50) DEFAULT NULL COMMENT '快递单号',
  `isUrgency` varchar(50) NOT NULL COMMENT '是否加急  （可以用Y/N来表示）',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;


SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `142537_users`
-- ----------------------------
DROP TABLE IF EXISTS `142537_users`;
CREATE TABLE `142537_users` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `user_name` varchar(50) NOT NULL COMMENT '用户姓名',
  `password` varchar(50) NOT NULL COMMENT '用户密码（进行加密，用rsa加密，注意保留公钥和私钥',
  `mobile_phone` varchar(50) NOT NULL COMMENT '用户联系方式',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `142537_userlogin`
-- ----------------------------
DROP TABLE IF EXISTS `142537_userlogin`;
CREATE TABLE `142537_userlogin` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(100) DEFAULT NULL,
  `nickname` varchar(50) DEFAULT NULL,
  `mobile_phone` varchar(30) DEFAULT NULL,
  `imagepath` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
