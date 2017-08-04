﻿-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: cmy
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `142407_goods`
--

LOCK TABLES `142407_goods` WRITE;
/*!40000 ALTER TABLE `142407_goods` DISABLE KEYS */;
INSERT INTO `142407_goods` VALUES (1,'鼠标','000001',0.12,100,98,'海韵二601',98,100,95,90,1,1,1,'2017-5-8 12:00:20','2017-5-10 12:00:20','这是一个无线鼠标','C:/picture/001.jpg',1,'圆通快递'),(2,'键盘','000002',0.25,200,150,'海韵二601',198,210,190,150,2,1,2,'2017-5-8 12:20:20','2017-5-10 12:30:20','这是一个无线键盘','C:/picture/002.jpg',1,'申通快递'),(3,'巧克力','000003',0.125,1200,1050,'海韵二610',48,50,450,50,3,2,3,'2017-3-8 11:20:20','2017-4-10 10:30:20','这是一个巧克力','C:/picture/003.jpg',1,'EMS'),(4,'鱿鱼丝','000004',0.5,1000,560,'海韵二610',68,75,66,60,4,2,4,'2017-4-18 10:20:20','2017-4-20 10:30:20','这是一个鱿鱼丝','C:/picture/004.jpg',0,'天天快递'),(5,'固态硬盘','000005',0.25,1000,560,'海韵二609',568,575,500,480,5,3,5,'2017-5-1 17:20:20','2017-5-12 11:30:20','这是一个固态硬盘','C:/picture/005.jpg',0,'天天快递'),(6,'8G内存条','000006',0.125,1000,560,'海韵二609',368,380,350,300,6,3,6,'2017-5-1 17:20:20','2017-5-12 11:30:20','这是一个固态硬盘','C:/picture/006.jpg',0,'天天快递');
/*!40000 ALTER TABLE `142407_goods` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-01 22:38:14


-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: cmy
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `142407_order_goods`
--

LOCK TABLES `142407_order_goods` WRITE;
/*!40000 ALTER TABLE `142407_order_goods` DISABLE KEYS */;
INSERT INTO `142407_order_goods` VALUES (1,3,2,'键盘',2,380),(2,17,4,'鱿鱼丝',4,250);
/*!40000 ALTER TABLE `142407_order_goods` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-01 22:38:14


-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: cmy
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `142407_order_info`
--

LOCK TABLES `142407_order_info` WRITE;
/*!40000 ALTER TABLE `142407_order_info` DISABLE KEYS */;
INSERT INTO `142407_order_info` VALUES (3,'2017052200003',17,3,'王崇菲123','海韵二','361000','18060938760','chongfei@gmail.com',20,26,'我是王崇菲',18,'23231013',1494764911,0,0,0,1494765857,NULL,'','Y'),(17,'2017052200004',27,3,'梁浩然','厦大123','361000','18989765282','haoran@gmail.com',30,38,'我是梁浩然123',18,'24231013',1494764911,0,1495587595,1495587605,1494765857,NULL,'12345678','Y'),(19,'2017052200005',37,3,'伟煌123fc','海韵八337','361000','18989898923','weihuang@gmail.com',25,34,'我是伟煌1hao',18,'25231013',1494764911,0,0,1495807797,1494765857,NULL,'12345','Y'),(20,'2017052200006',27,3,'梁浩然','厦大','361000','18989765282','haoran@gmail.com',30,38,'我是梁浩然',18,'24231013',1494764911,1494765857,1495585373,1495585479,1494765857,NULL,'12345678','N'),(21,'2017052200007',37,3,'伟煌','海韵八','361000','18989898923','weihuang@gmail.com',25,34,'我是伟煌',18,'25231013',1494764911,1494765857,0,1495807831,1494765857,NULL,'23456','N'),(22,'2017052200008',27,2,'梁浩然','厦大','361000','18989765282','haoran@gmail.com',30,38,'我是梁浩然',18,'24231013',1494764911,1494765857,1495807821,0,1494765857,NULL,'123456789654321','N'),(23,'2017052200009',37,0,'伟煌','海韵八','361000','18989898923','weihuang@gmail.com',25,34,'我是伟煌',18,'25231013',1494764911,1494765857,1494765957,1494765957,1494765857,NULL,'dsfsdfa','N'),(24,'2017052200010',27,0,'梁浩然','厦大','361000','18989765282','haoran@gmail.com',30,38,'我是梁浩然',18,'24231013',1494764911,1494765857,1494765957,1494765957,1494765857,NULL,'123456789654321','N'),(25,'2017052200011',37,0,'伟煌','海韵八','361000','18989898923','weihuang@gmail.com',25,34,'我是伟煌',18,'25231013',1494764911,1494765857,1494765957,1494765957,1494765857,NULL,'dsfsdfa','N'),(26,'2017052200012',27,0,'梁浩然','厦大','361000','18989765282','haoran@gmail.com',30,38,'我是梁浩然',18,'24231013',1494764911,1494765857,1494765957,1494765957,1494765857,NULL,'123456789654321','N'),(27,'2017052200013',37,0,'伟煌','海韵八','361000','18989898923','weihuang@gmail.com',25,34,'我是伟煌',18,'25231013',1494764911,1494765857,1494765957,1494765957,1494765857,NULL,'dsfsdfa','N'),(28,'2017052200014',27,0,'梁浩然','厦大','361000','18989765282','haoran@gmail.com',30,38,'我是梁浩然',18,'24231013',1494764911,1494765857,1494765957,1494765957,1494765857,NULL,'123456789654321','N'),(29,'2017052200015',37,0,'伟煌','海韵八','361000','18989898923','weihuang@gmail.com',25,34,'我是伟煌',18,'25231013',1494764911,1494765857,1494765957,1494765957,1494765857,NULL,'dsfsdfa','N'),(30,'2017052200016',27,0,'梁浩然','厦大','361000','18989765282','haoran@gmail.com',30,38,'我是梁浩然',18,'24231013',1494764911,1494765857,1494765957,1494765957,1494765857,NULL,'123456789654321','N'),(31,'2017052200017',37,0,'伟煌','海韵八','361000','18989898923','weihuang@gmail.com',25,34,'我是伟煌',18,'25231013',1494764911,1494765857,1494765957,1494765957,1494765857,NULL,'dsfsdfa','N'),(32,'2017052200018',27,1,'梁浩然','厦大','361000','18989765282','haoran@gmail.com',30,38,'我是梁浩然',18,'24231013',1494764911,1494765857,1494765957,1494765957,1494765857,NULL,'123456789654321','N'),(33,'2017052200019',37,0,'伟煌','海韵八','361000','18989898923','weihuang@gmail.com',25,34,'我是伟煌',18,'25231013',1494764911,1494765857,1494765957,1494765957,1494765857,NULL,'dsfsdfa','N'),(34,'2017052200020',27,0,'梁浩然','厦大','361000','18989765282','haoran@gmail.com',30,38,'我是梁浩然',18,'24231013',1494764911,1494765857,1494765957,1494765957,1494765857,NULL,'123456789654321','Y'),(35,'2017052200021',37,0,'伟煌','海韵八','361000','18989898923','weihuang@gmail.com',25,34,'我是伟煌',18,'25231013',1494764911,1494765857,1494765957,1494765957,1494765857,NULL,'dsfsdfa','N'),(36,'2017052200022',27,0,'梁浩然','厦大','361000','18989765282','haoran@gmail.com',30,38,'我是梁浩然',18,'24231013',1494764911,1494765857,1494765957,1494765957,1494765857,NULL,'123456789654321','N'),(37,'2017052200023',37,0,'伟煌','海韵八','361000','18989898923','weihuang@gmail.com',25,34,'我是伟煌',18,'25231013',1494764911,1494765857,1494765957,1494765957,1494765857,NULL,'dsfsdfa','N');
/*!40000 ALTER TABLE `142407_order_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-01 22:38:14

-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: cmy
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `142407_users`
--

LOCK TABLES `142407_users` WRITE;
/*!40000 ALTER TABLE `142407_users` DISABLE KEYS */;
INSERT INTO `142407_users` VALUES (27,'梁浩然','sfsfs','18989765282'),(17,'王崇菲','congfei','18060938760'),(37,'伟煌','weihuang','18989898982');
/*!40000 ALTER TABLE `142407_users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-01 22:38:14