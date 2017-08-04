/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50635
Source Host           : localhost:3306
Source Database       : spring

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-06-01 21:52:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Records of 142402_goods
-- ----------------------------
BEGIN;
INSERT INTO `142402_goods` VALUES ('1', '鼠标', '000001', '0.12', '100', '98', '海韵二601', '98', '100', '95', '90', '1', '1', '1', '2017-5-8 12:00:20', '2017-5-10 12:00:20', '这是一个无线鼠标', 'G:图片/亚索.jpg', '1', '圆通快递'), ('2', '键盘', '000002', '0.25', '200', '150', '海韵二601', '198', '210', '190', '150', '2', '1', '2', '2017-5-8 12:20:20', '2017-5-10 12:30:20', '这是一个无线键盘', 'G:图片/亚索.jpg', '1', '申通快递');
COMMIT;

-- ----------------------------
-- Records of 142402_order_goods
-- ----------------------------
BEGIN;
INSERT INTO `142402_order_goods` VALUES ('1', '1', '1', '鼠标', '2', '100'), ('2', '8', '2', '键盘', '3', '210'), ('3', '2', '1', '键盘', '1', '210');
COMMIT;

-- ----------------------------
-- Records of 142402_order_info
-- ----------------------------
BEGIN;
INSERT INTO `142402_order_info` VALUES ('1', '2017123', '2202402', '3', '张三ss', '厦大aaaa', '361005', '18906036111', 'zhang@qq.com', '100', '200', '大法师的', '2.2', '23231013', '1494764911', '1494765857', '1494765957', '1494765957', '1494765857', null, '', 'Y'), ('2', '2017469', '2202402', '0', '微黄', '福州', '361205', '18234452984', 'lkj@gmail.com', '20', '210', '恩', '18', '23231013', '1494764911', '1494765857', '1494765957', '1494765957', '1494765857', null, '123456789123456', 'N'), ('3', '2017233', '2202434', '3', '王五', '北大', '361005', '18234452984', 'lkj@gmail.com', '20', '0', '哈哈', '18', '23231013', '1494764911', '1494765857', '1494765957', '1494765957', '1494765857', null, '8787', 'N'), ('4', '2017650', '2202434', '0', '名言', '厦门', '361005', '18234452984', 'ming@qq.com', '20', '0', '啦啦啦', '18', '23231013', '1494764911', '1494765857', '1494765957', '1494765957', '1494765857', null, '123456789123456', 'N'), ('5', '2017908', '2202490', '0', '李四', '浙大', '361003', '18136631323', 'klasd@qq.com', '20', '0', '备注1', '18', '23231013', '1494764911', '1494765347', '1494765957', '1494765957', '1494765857', null, '12345', 'Y'), ('7', '2017527', '2202418', '0', '俊轩', '广州', '361000', '18060345760', 'czz@sina.com', '20', '0', '阿拉加', '18', '23231013', '1494764911', '1494765857', '1494765957', '1494765957', '1494765857', null, '123456789123456', 'N'), ('8', '2017846', '2202411', '2', '赵钱', '清华', '361005', '18222451234', 'laaaa@gmail.com', '20', '630', '呵呵', '18', '23231013', '1494764911', '1494765857', '1494765957', '1494765957', '1494765857', null, '123456789123456', 'N');
COMMIT;

-- ----------------------------
-- Records of 142402_users
-- ----------------------------
BEGIN;
INSERT INTO `142402_users` VALUES ('2202402', '订单用户一', '111', '110'), ('2202411', '订单用户四', '2323', '232'), ('2202418', '订单用户五', '89', '499'), ('2202434', '订单用户二', '123', '120'), ('2202490', '订单用户三', '23', '232');
COMMIT;
