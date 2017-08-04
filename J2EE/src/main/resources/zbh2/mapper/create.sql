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
