INSERT INTO `142450_goods` VALUES ('1', '《软件体系结构》', '000001', '0.12', '120', '98', '书店', '60', '78', '78', '78', '1', '1', '1', '2017-5-11 12:00:20', '2017-5-14 12:00:20', '防潮', 'C:/picture/001.jpg', '1', 'XX快递');
INSERT INTO `142450_goods` VALUES ('2', '书包', '000002', '0.25', '200', '120', '日用品店', '38', '45', '48', '48', '2', '2', '2', '2017-5-8 12:20:20', '2017-5-10 12:30:20', '无', 'C:/picture/002.jpg', '1', 'XX快递');
INSERT INTO `142450_goods` VALUES ('3', '零食', '000003', '0.4', '120', '150', '食品店', '48', '50', '55', '55', '3', '3', '3', '2017-4-8 11:20:20', '2017-4-10 10:30:20', '防潮', 'C:/picture/003.jpg', '1', 'XX快递');
INSERT INTO `142450_goods` VALUES ('4', '牛肉干', '000004', '0.5', '160', '100', '食品店', '68', '75', '78', '78', '3', '3', '4', '2017-3-1 10:20:20', '2017-3-4 10:30:20', '防潮', 'C:/picture/004.jpg', '0', 'XX快递');
INSERT INTO `142450_goods` VALUES ('5', '服装', '000005', '0.25', '100', '100', '日用品店', '168', '208', '200', '200', '2', '2', '5', '2017-5-7 17:20:20', '2017-5-9 11:30:20', '型号：中等', 'C:/picture/005.jpg', '0', 'XX快递');
INSERT INTO `142450_goods` VALUES ('6', '耳机', '000006', '0.125', '130', '100', '电子产品店', '138', '180', '178', '178', '4', '4', '6', '2017-5-6 17:20:20', '2017-5-8 11:30:20', '易碎', 'C:/picture/006.jpg', '0', 'XX快递');

INSERT INTO `142450_order_goods` VALUES ('1', '1', '1', '《软件体系结构》', '2', '78');
INSERT INTO `142450_order_goods` VALUES ('2', '2', '6', '耳机', '1', '138');
INSERT INTO `142450_order_goods` VALUES ('3', '3', '3', '零食', '1', '55');
INSERT INTO `142450_order_goods` VALUES ('4', '4', '3', '零食', '2', '55');
INSERT INTO `142450_order_goods` VALUES ('5', '5', '3', '零食', '3', '55');
INSERT INTO `142450_order_goods` VALUES ('6', '6', '3', '零食', '4', '55');
INSERT INTO `142450_order_goods` VALUES ('7', '7', '3', '零食', '5', '55');


INSERT INTO `142450_users` VALUES ('24320142202123', '张三', '123', '12345678901', null);
INSERT INTO `142450_users` VALUES ('24320142202124', '李四', '123', '12345678902', null);
INSERT INTO `142450_users` VALUES ('24320142202125', '王五', '123', '12345678903', null);
INSERT INTO `142450_users` VALUES ('24320142202126', '马六', '123', '12345678904', null);


INSERT INTO `142450_order_info` VALUES ('202401141231', '07051401', '24320142201234', '0', '李四', '厦大学生公寓', '361000', '12345678902', 'lisi@qq.com', '156', '156', '无', '0.24', null, '1705240934', '1705240940', null, null, null, null, '', 'N');
INSERT INTO `142450_order_info` VALUES ('202401151232', '07051501', '24320142201233', '2', '张三', '厦大学生公寓', '361000', '12345678901', 'sanzhang@126.com', '138', '138', '颜色：白色', '0.125', null, '1705252334', null, null, null, null, null, '98344444', 'Y');
INSERT INTO `142450_order_info` VALUES ('202401151234', '07051502', '24320142201233', '1', '张三', '厦大学生公寓', '361000', '12345678901', 'sanzhang@126.com', '55', '55', '型号：中等', '0.4', null, '1705271234', '1705271235', '1705271301', null, null, null, '9787121136609', 'Y');


