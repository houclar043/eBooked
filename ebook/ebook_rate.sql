-- MySQL dump 10.13  Distrib 8.0.20, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: ebook
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `rate`
--

DROP TABLE IF EXISTS `rate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rate` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `rate` float DEFAULT NULL,
  `book_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT '0' COMMENT '0: available\n1: deleted',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=301 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rate`
--

LOCK TABLES `rate` WRITE;
/*!40000 ALTER TABLE `rate` DISABLE KEYS */;
INSERT INTO `rate` VALUES (1,4,302,205,'2022-05-25 11:16:49','2022-10-13 15:50:37',0),(2,3,325,170,'2022-09-25 11:12:24','2022-10-13 15:50:37',0),(3,3,439,152,'2022-08-22 07:03:17','2022-10-13 15:50:37',0),(4,4,237,163,'2021-10-10 07:40:05','2022-10-13 15:50:37',0),(5,2,426,186,'2022-03-29 03:00:46','2022-10-13 15:50:37',0),(6,4,310,160,'2022-07-01 18:54:32','2022-10-13 15:50:37',0),(7,3,346,178,'2022-02-18 20:26:58','2022-10-13 15:50:37',0),(8,1,382,191,'2022-10-02 03:15:31','2022-10-13 15:50:37',0),(9,3,259,191,'2022-09-17 23:02:07','2022-10-13 15:50:37',0),(10,3,321,180,'2022-03-19 04:28:50','2022-10-13 15:50:37',0),(11,2,357,174,'2021-11-25 18:55:47','2022-10-13 15:50:37',0),(12,4,295,146,'2021-11-06 08:30:45','2022-10-13 15:50:37',0),(13,1,377,176,'2021-10-15 14:09:06','2022-10-13 15:50:37',0),(14,4,256,125,'2022-06-01 13:18:38','2022-10-13 15:50:37',0),(15,5,252,167,'2022-02-19 00:31:22','2022-10-13 15:50:37',0),(16,1,246,196,'2022-07-28 06:08:28','2022-10-13 15:50:37',0),(17,2,311,159,'2021-11-15 00:41:04','2022-10-13 15:50:37',0),(18,2,249,127,'2022-08-31 17:25:08','2022-10-13 15:50:37',0),(19,1,307,168,'2022-04-06 04:23:28','2022-10-13 15:50:37',0),(20,1,234,171,'2022-02-19 03:00:14','2022-10-13 15:50:37',0),(21,5,334,155,'2022-02-03 13:52:30','2022-10-13 15:50:37',0),(22,5,346,108,'2022-01-11 19:22:52','2022-10-13 15:50:37',0),(23,1,388,134,'2022-08-29 01:26:49','2022-10-13 15:50:37',0),(24,5,311,196,'2021-10-20 22:11:10','2022-10-13 15:50:37',0),(25,1,328,183,'2021-12-08 06:40:30','2022-10-13 15:50:37',0),(26,2,410,179,'2022-02-09 17:18:59','2022-10-13 15:50:37',0),(27,2,383,201,'2022-05-11 13:03:17','2022-10-13 15:50:37',0),(28,3,292,185,'2021-10-17 17:30:53','2022-10-13 15:50:37',0),(29,2,435,116,'2022-09-13 23:56:08','2022-10-13 15:50:37',0),(30,3,244,206,'2022-04-08 05:20:53','2022-10-13 15:50:37',0),(31,4,354,188,'2022-04-28 08:11:34','2022-10-13 15:50:37',0),(32,1,307,199,'2022-06-28 01:11:00','2022-10-13 15:50:37',0),(33,1,357,195,'2022-05-08 05:37:01','2022-10-13 15:50:37',0),(34,5,432,176,'2022-02-12 06:13:24','2022-10-13 15:50:37',0),(35,3,273,153,'2021-10-06 10:46:08','2022-10-13 15:50:37',0),(36,3,276,142,'2022-05-13 23:17:50','2022-10-13 15:50:37',0),(37,2,377,142,'2022-05-11 07:59:30','2022-10-13 15:50:37',0),(38,3,306,194,'2022-02-26 22:49:28','2022-10-13 15:50:37',0),(39,3,258,202,'2022-05-13 10:50:20','2022-10-13 15:50:37',0),(40,1,336,189,'2022-02-06 19:35:00','2022-10-13 15:50:37',0),(41,2,369,142,'2022-02-17 10:56:27','2022-10-13 15:50:37',0),(42,4,421,147,'2022-03-09 09:00:20','2022-10-13 15:50:37',0),(43,1,397,173,'2022-02-10 09:20:46','2022-10-13 15:50:37',0),(44,2,297,157,'2022-07-20 21:54:07','2022-10-13 15:50:37',0),(45,5,412,189,'2022-09-19 03:41:59','2022-10-13 15:50:37',0),(46,5,398,152,'2022-05-14 00:11:54','2022-10-13 15:50:37',0),(47,3,242,167,'2022-01-28 08:18:32','2022-10-13 15:50:37',0),(48,4,278,184,'2022-02-23 02:52:15','2022-10-13 15:50:37',0),(49,3,401,168,'2022-07-11 04:26:12','2022-10-13 15:50:37',0),(50,5,330,142,'2022-09-03 20:56:57','2022-10-13 15:50:37',0),(51,2,393,141,'2022-08-03 23:43:37','2022-10-13 15:50:37',0),(52,3,311,201,'2021-12-09 02:33:49','2022-10-13 15:50:37',0),(53,4,414,186,'2022-06-27 05:19:20','2022-10-13 15:50:37',0),(54,4,336,150,'2021-12-11 05:25:14','2022-10-13 15:50:37',0),(55,2,239,169,'2022-09-17 08:55:46','2022-10-13 15:50:37',0),(56,4,245,118,'2022-05-11 07:42:50','2022-10-13 15:50:37',0),(57,4,311,204,'2022-03-22 14:50:28','2022-10-13 15:50:37',0),(58,5,318,144,'2022-09-12 10:32:48','2022-10-13 15:50:37',0),(59,5,325,131,'2022-05-05 16:22:09','2022-10-13 15:50:37',0),(60,2,279,158,'2022-08-09 22:05:58','2022-10-13 15:50:37',0),(61,4,331,188,'2021-12-14 01:58:32','2022-10-13 15:50:37',0),(62,2,366,134,'2022-01-30 05:28:23','2022-10-13 15:50:37',0),(63,4,391,184,'2022-05-21 03:15:14','2022-10-13 15:50:37',0),(64,2,427,149,'2022-07-21 18:16:01','2022-10-13 15:50:37',0),(65,3,278,137,'2021-11-01 14:47:23','2022-10-13 15:50:37',0),(66,2,298,129,'2021-10-10 19:02:46','2022-10-13 15:50:37',0),(67,4,329,125,'2022-07-11 11:06:00','2022-10-13 15:50:37',0),(68,3,400,115,'2022-10-06 02:27:18','2022-10-13 15:50:37',0),(69,3,289,196,'2022-01-29 14:44:07','2022-10-13 15:50:37',0),(70,4,266,114,'2022-03-20 02:55:33','2022-10-13 15:50:37',0),(71,2,334,127,'2022-04-10 13:07:24','2022-10-13 15:50:37',0),(72,4,350,196,'2022-05-13 06:20:34','2022-10-13 15:50:37',0),(73,4,421,167,'2022-09-15 00:54:08','2022-10-13 15:50:37',0),(74,2,306,171,'2022-04-15 15:23:02','2022-10-13 15:50:37',0),(75,2,324,126,'2022-02-10 19:35:25','2022-10-13 15:50:37',0),(76,1,395,112,'2021-12-18 07:41:15','2022-10-13 15:50:37',0),(77,5,261,154,'2022-02-26 15:27:33','2022-10-13 15:50:37',0),(78,2,423,129,'2022-01-30 02:26:03','2022-10-13 15:50:37',0),(79,3,295,152,'2022-09-27 12:11:42','2022-10-13 15:50:37',0),(80,4,239,152,'2022-03-29 01:53:51','2022-10-13 15:50:37',0),(81,2,418,193,'2022-08-03 16:42:31','2022-10-13 15:50:37',0),(82,3,271,205,'2022-09-04 18:51:10','2022-10-13 15:50:37',0),(83,5,281,176,'2022-10-11 02:34:44','2022-10-13 15:50:37',0),(84,5,344,173,'2022-04-20 06:50:53','2022-10-13 15:50:37',0),(85,2,381,175,'2021-12-22 03:06:10','2022-10-13 15:50:37',0),(86,4,273,205,'2021-10-19 23:38:42','2022-10-13 15:50:37',0),(87,1,234,135,'2022-08-23 17:35:36','2022-10-13 15:50:37',0),(88,2,250,183,'2022-02-10 02:07:04','2022-10-13 15:50:37',0),(89,1,304,203,'2022-01-07 10:04:44','2022-10-13 15:50:37',0),(90,2,341,190,'2022-06-15 18:14:33','2022-10-13 15:50:37',0),(91,5,414,151,'2021-10-15 16:48:51','2022-10-13 15:50:37',0),(92,4,323,130,'2022-04-30 02:42:39','2022-10-13 15:50:37',0),(93,3,392,184,'2022-09-03 18:46:19','2022-10-13 15:50:37',0),(94,1,352,191,'2022-01-01 22:11:49','2022-10-13 15:50:37',0),(95,2,349,164,'2022-06-19 14:07:46','2022-10-13 15:50:37',0),(96,3,367,159,'2022-08-07 23:50:01','2022-10-13 15:50:37',0),(97,3,343,203,'2022-07-29 01:17:42','2022-10-13 15:50:37',0),(98,3,273,158,'2022-02-09 16:24:49','2022-10-13 15:50:37',0),(99,5,429,145,'2022-01-28 03:01:25','2022-10-13 15:50:37',0),(100,1,236,125,'2022-02-11 04:28:22','2022-10-13 15:50:37',0),(101,2,265,192,'2021-12-03 13:22:46','2022-10-13 15:51:32',0),(102,2,304,158,'2022-03-29 11:02:22','2022-10-13 15:51:32',0),(103,1,268,117,'2022-01-09 06:14:13','2022-10-13 15:51:32',0),(104,1,352,111,'2021-10-04 01:28:13','2022-10-13 15:51:32',0),(105,3,404,125,'2022-03-21 20:38:18','2022-10-13 15:51:32',0),(106,5,314,175,'2021-11-28 02:51:08','2022-10-13 15:51:32',0),(107,2,408,166,'2022-09-05 23:30:35','2022-10-13 15:51:32',0),(108,1,283,160,'2021-10-29 23:48:01','2022-10-13 15:51:32',0),(109,4,365,124,'2021-11-03 21:37:35','2022-10-13 15:51:32',0),(110,3,427,175,'2022-02-10 15:17:17','2022-10-13 15:51:32',0),(111,4,281,179,'2021-12-03 03:54:38','2022-10-13 15:51:32',0),(112,4,423,187,'2022-09-11 19:01:08','2022-10-13 15:51:32',0),(113,4,301,147,'2022-02-13 19:34:16','2022-10-13 15:51:32',0),(114,2,265,202,'2022-01-03 14:58:04','2022-10-13 15:51:32',0),(115,3,429,207,'2021-11-07 17:31:31','2022-10-13 15:51:32',0),(116,2,237,190,'2021-11-05 23:59:46','2022-10-13 15:51:32',0),(117,2,372,111,'2022-07-08 10:15:05','2022-10-13 15:51:32',0),(118,1,271,164,'2022-03-27 19:41:30','2022-10-13 15:51:32',0),(119,5,320,111,'2022-09-15 12:11:03','2022-10-13 15:51:32',0),(120,2,262,166,'2022-03-30 07:25:12','2022-10-13 15:51:32',0),(121,5,233,176,'2022-02-06 19:51:20','2022-10-13 15:51:32',0),(122,2,277,195,'2021-11-27 23:10:17','2022-10-13 15:51:32',0),(123,2,341,168,'2021-11-23 16:01:18','2022-10-13 15:51:32',0),(124,2,426,197,'2021-12-15 13:10:30','2022-10-13 15:51:32',0),(125,5,392,157,'2021-12-09 08:32:52','2022-10-13 15:51:32',0),(126,5,253,200,'2022-08-04 18:13:05','2022-10-13 15:51:32',0),(127,5,260,169,'2022-06-09 12:38:51','2022-10-13 15:51:32',0),(128,3,304,203,'2022-09-18 13:21:10','2022-10-13 15:51:32',0),(129,1,339,134,'2022-07-11 11:19:32','2022-10-13 15:51:32',0),(130,3,420,199,'2021-12-05 14:21:01','2022-10-13 15:51:32',0),(131,2,360,140,'2022-08-28 07:37:27','2022-10-13 15:51:32',0),(132,3,335,156,'2022-09-28 05:22:59','2022-10-13 15:51:32',0),(133,1,404,197,'2022-03-03 20:23:09','2022-10-13 15:51:32',0),(134,3,269,195,'2022-02-25 19:06:43','2022-10-13 15:51:32',0),(135,1,245,127,'2022-02-20 13:21:17','2022-10-13 15:51:32',0),(136,4,365,191,'2022-08-04 08:18:07','2022-10-13 15:51:32',0),(137,3,248,170,'2022-08-16 07:29:00','2022-10-13 15:51:32',0),(138,3,299,159,'2022-04-24 03:20:47','2022-10-13 15:51:32',0),(139,3,323,187,'2022-04-22 02:45:19','2022-10-13 15:51:32',0),(140,4,363,157,'2021-11-11 18:46:25','2022-10-13 15:51:32',0),(141,4,398,128,'2022-07-21 00:16:25','2022-10-13 15:51:32',0),(142,4,401,198,'2022-05-25 09:22:21','2022-10-13 15:51:32',0),(143,2,233,143,'2021-12-28 23:27:00','2022-10-13 15:51:32',0),(144,4,263,135,'2021-11-18 04:09:06','2022-10-13 15:51:32',0),(145,4,357,163,'2021-10-02 22:32:13','2022-10-13 15:51:32',0),(146,4,281,166,'2022-09-14 17:36:48','2022-10-13 15:51:32',0),(147,3,247,158,'2022-06-28 12:18:44','2022-10-13 15:51:32',0),(148,3,232,182,'2022-04-04 19:28:52','2022-10-13 15:51:32',0),(149,2,421,204,'2021-12-11 23:59:42','2022-10-13 15:51:32',0),(150,5,383,145,'2021-10-12 06:40:14','2022-10-13 15:51:32',0),(151,1,436,124,'2022-01-27 01:11:36','2022-10-13 15:51:33',0),(152,5,379,190,'2022-05-19 16:27:24','2022-10-13 15:51:33',0),(153,4,338,189,'2022-03-15 19:29:18','2022-10-13 15:51:33',0),(154,3,328,110,'2022-02-28 08:08:14','2022-10-13 15:51:33',0),(155,2,273,128,'2021-11-30 23:19:49','2022-10-13 15:51:33',0),(156,4,435,147,'2022-04-25 21:40:10','2022-10-13 15:51:33',0),(157,1,397,191,'2022-06-13 11:38:24','2022-10-13 15:51:33',0),(158,4,410,180,'2022-01-01 11:49:31','2022-10-13 15:51:33',0),(159,1,326,166,'2022-08-30 09:11:41','2022-10-13 15:51:33',0),(160,3,311,131,'2022-07-05 22:54:57','2022-10-13 15:51:33',0),(161,1,360,207,'2021-12-17 05:36:01','2022-10-13 15:51:33',0),(162,4,234,154,'2022-08-02 08:24:41','2022-10-13 15:51:33',0),(163,3,270,116,'2022-07-12 11:37:07','2022-10-13 15:51:33',0),(164,3,268,195,'2022-02-03 17:24:27','2022-10-13 15:51:33',0),(165,4,420,194,'2022-01-02 19:28:32','2022-10-13 15:51:33',0),(166,4,275,160,'2022-09-20 07:15:24','2022-10-13 15:51:33',0),(167,5,392,182,'2022-03-29 14:41:13','2022-10-13 15:51:33',0),(168,2,281,142,'2022-08-24 18:06:47','2022-10-13 15:51:33',0),(169,1,417,156,'2022-04-06 23:37:49','2022-10-13 15:51:33',0),(170,5,255,176,'2021-11-03 09:12:57','2022-10-13 15:51:33',0),(171,1,291,143,'2022-07-26 08:53:53','2022-10-13 15:51:33',0),(172,5,296,160,'2022-01-01 21:40:47','2022-10-13 15:51:33',0),(173,3,331,192,'2021-11-27 00:35:34','2022-10-13 15:51:33',0),(174,1,325,171,'2022-07-26 22:33:37','2022-10-13 15:51:33',0),(175,2,306,125,'2022-02-09 12:01:41','2022-10-13 15:51:33',0),(176,5,322,182,'2021-12-12 08:09:20','2022-10-13 15:51:33',0),(177,2,399,154,'2021-10-02 18:01:37','2022-10-13 15:51:33',0),(178,5,261,149,'2022-08-20 02:07:52','2022-10-13 15:51:33',0),(179,2,406,154,'2022-08-14 13:31:48','2022-10-13 15:51:33',0),(180,2,400,160,'2022-03-08 10:08:31','2022-10-13 15:51:33',0),(181,3,337,162,'2021-11-03 23:04:22','2022-10-13 15:51:33',0),(182,1,332,127,'2021-10-12 21:33:23','2022-10-13 15:51:33',0),(183,4,382,160,'2021-12-07 05:50:17','2022-10-13 15:51:33',0),(184,2,274,152,'2022-07-01 19:26:52','2022-10-13 15:51:33',0),(185,1,359,123,'2022-08-05 04:57:09','2022-10-13 15:51:33',0),(186,4,354,114,'2022-06-29 15:39:20','2022-10-13 15:51:33',0),(187,3,257,139,'2021-10-01 19:41:00','2022-10-13 15:51:33',0),(188,2,431,139,'2022-01-05 13:33:39','2022-10-13 15:51:33',0),(189,5,279,127,'2022-09-18 21:13:57','2022-10-13 15:51:33',0),(190,3,418,112,'2022-01-02 04:10:42','2022-10-13 15:51:33',0),(191,5,313,147,'2022-09-07 17:15:27','2022-10-13 15:51:33',0),(192,1,238,164,'2022-08-10 00:23:51','2022-10-13 15:51:33',0),(193,1,424,178,'2022-04-23 21:59:49','2022-10-13 15:51:33',0),(194,1,357,132,'2022-02-11 05:21:06','2022-10-13 15:51:33',0),(195,3,263,123,'2021-12-14 05:11:19','2022-10-13 15:51:33',0),(196,5,335,144,'2021-11-25 16:28:13','2022-10-13 15:51:33',0),(197,3,244,136,'2022-03-04 11:02:38','2022-10-13 15:51:33',0),(198,3,257,177,'2022-08-28 09:47:42','2022-10-13 15:51:33',0),(199,2,304,140,'2021-12-22 23:19:47','2022-10-13 15:51:33',0),(200,1,264,196,'2022-10-05 03:28:37','2022-10-13 15:51:33',0),(201,5,322,168,'2021-11-06 14:30:41','2022-10-13 15:53:40',0),(202,3,390,109,'2021-10-05 16:57:13','2022-10-13 15:53:40',0),(203,4,267,119,'2022-05-15 07:03:24','2022-10-13 15:53:40',0),(204,1,417,177,'2022-02-13 07:58:48','2022-10-13 15:53:40',0),(205,2,371,182,'2022-03-09 10:06:23','2022-10-13 15:53:40',0),(206,3,387,158,'2022-05-28 00:02:05','2022-10-13 15:53:40',0),(207,5,288,127,'2022-05-11 04:07:03','2022-10-13 15:53:40',0),(208,3,409,176,'2022-03-17 17:31:48','2022-10-13 15:53:40',0),(209,4,348,168,'2022-01-05 15:16:08','2022-10-13 15:53:40',0),(210,3,300,132,'2022-06-08 13:39:47','2022-10-13 15:53:40',0),(211,3,264,160,'2021-12-09 12:16:26','2022-10-13 15:53:40',0),(212,4,437,112,'2021-10-14 20:15:03','2022-10-13 15:53:40',0),(213,5,369,163,'2021-11-10 21:22:54','2022-10-13 15:53:40',0),(214,1,373,181,'2022-09-19 22:14:52','2022-10-13 15:53:40',0),(215,4,431,182,'2022-06-13 21:41:21','2022-10-13 15:53:40',0),(216,1,346,172,'2022-01-12 15:42:57','2022-10-13 15:53:40',0),(217,5,413,147,'2022-04-28 04:17:11','2022-10-13 15:53:40',0),(218,1,310,117,'2022-01-30 13:28:28','2022-10-13 15:53:40',0),(219,2,333,173,'2022-02-01 12:58:29','2022-10-13 15:53:40',0),(220,4,238,178,'2021-12-12 22:12:39','2022-10-13 15:53:40',0),(221,5,413,126,'2022-09-03 14:25:30','2022-10-13 15:53:40',0),(222,1,379,201,'2022-02-27 20:56:17','2022-10-13 15:53:40',0),(223,2,403,120,'2022-07-31 12:21:32','2022-10-13 15:53:40',0),(224,1,263,116,'2022-01-24 06:52:08','2022-10-13 15:53:40',0),(225,2,367,116,'2022-03-20 17:29:32','2022-10-13 15:53:40',0),(226,5,300,178,'2022-06-14 10:55:55','2022-10-13 15:53:40',0),(227,1,393,167,'2022-10-01 23:00:09','2022-10-13 15:53:40',0),(228,3,282,128,'2022-05-20 22:02:30','2022-10-13 15:53:40',0),(229,5,402,191,'2022-04-02 14:53:27','2022-10-13 15:53:40',0),(230,3,276,150,'2021-11-25 03:16:52','2022-10-13 15:53:40',0),(231,1,333,127,'2022-02-24 10:14:00','2022-10-13 15:53:40',0),(232,1,415,113,'2022-01-17 05:47:54','2022-10-13 15:53:40',0),(233,1,270,186,'2022-01-28 19:23:10','2022-10-13 15:53:40',0),(234,5,434,151,'2022-07-26 11:48:21','2022-10-13 15:53:40',0),(235,1,293,108,'2022-08-01 00:22:31','2022-10-13 15:53:40',0),(236,5,428,166,'2021-12-07 07:41:53','2022-10-13 15:53:40',0),(237,4,428,163,'2022-03-18 14:22:34','2022-10-13 15:53:40',0),(238,5,255,161,'2021-11-21 14:46:54','2022-10-13 15:53:40',0),(239,5,296,174,'2021-10-16 19:42:34','2022-10-13 15:53:40',0),(240,3,330,156,'2022-06-08 00:54:26','2022-10-13 15:53:40',0),(241,5,315,195,'2022-04-08 01:27:53','2022-10-13 15:53:40',0),(242,1,417,200,'2022-07-28 04:57:24','2022-10-13 15:53:40',0),(243,4,328,115,'2022-04-10 03:48:37','2022-10-13 15:53:40',0),(244,4,418,114,'2021-11-08 20:05:24','2022-10-13 15:53:40',0),(245,1,265,136,'2022-09-03 03:41:44','2022-10-13 15:53:40',0),(246,4,331,204,'2022-05-13 15:07:53','2022-10-13 15:53:40',0),(247,1,307,207,'2022-03-01 22:40:40','2022-10-13 15:53:40',0),(248,3,392,168,'2021-11-06 11:35:10','2022-10-13 15:53:40',0),(249,5,330,110,'2022-03-14 22:37:45','2022-10-13 15:53:40',0),(250,2,231,150,'2021-12-10 08:09:15','2022-10-13 15:53:40',0),(251,1,250,158,'2022-02-24 07:14:42','2022-10-13 15:53:40',0),(252,5,285,128,'2022-10-03 20:30:51','2022-10-13 15:53:40',0),(253,1,263,163,'2021-12-30 14:39:04','2022-10-13 15:53:40',0),(254,1,383,111,'2021-10-20 16:09:00','2022-10-13 15:53:40',0),(255,2,332,199,'2022-07-16 01:30:11','2022-10-13 15:53:40',0),(256,5,350,202,'2022-04-02 21:42:48','2022-10-13 15:53:40',0),(257,2,305,160,'2022-04-12 00:11:50','2022-10-13 15:53:40',0),(258,4,294,150,'2021-10-30 04:26:09','2022-10-13 15:53:40',0),(259,3,415,156,'2021-12-31 03:56:34','2022-10-13 15:53:40',0),(260,4,438,172,'2022-03-20 18:17:19','2022-10-13 15:53:40',0),(261,2,378,173,'2022-09-18 15:07:38','2022-10-13 15:53:40',0),(262,4,373,144,'2022-05-15 04:20:17','2022-10-13 15:53:40',0),(263,2,431,167,'2022-02-12 06:32:15','2022-10-13 15:53:40',0),(264,1,353,122,'2022-02-28 04:07:56','2022-10-13 15:53:40',0),(265,4,260,159,'2022-05-28 20:34:23','2022-10-13 15:53:40',0),(266,4,343,179,'2022-04-23 04:12:37','2022-10-13 15:53:40',0),(267,5,273,163,'2021-11-07 20:24:58','2022-10-13 15:53:40',0),(268,5,325,125,'2022-08-10 00:25:33','2022-10-13 15:53:40',0),(269,3,357,190,'2021-10-22 15:53:25','2022-10-13 15:53:40',0),(270,5,341,132,'2021-10-18 20:13:26','2022-10-13 15:53:40',0),(271,1,258,152,'2022-05-21 01:04:33','2022-10-13 15:53:40',0),(272,2,289,199,'2022-02-12 19:42:03','2022-10-13 15:53:40',0),(273,3,302,117,'2021-10-16 00:44:21','2022-10-13 15:53:40',0),(274,1,421,146,'2022-03-02 03:11:23','2022-10-13 15:53:40',0),(275,2,263,174,'2021-11-13 11:32:44','2022-10-13 15:53:40',0),(276,1,430,190,'2022-01-05 10:33:11','2022-10-13 15:53:40',0),(277,4,256,136,'2022-10-07 06:16:58','2022-10-13 15:53:40',0),(278,5,401,125,'2021-11-07 00:08:45','2022-10-13 15:53:40',0),(279,4,252,128,'2022-02-26 05:36:13','2022-10-13 15:53:40',0),(280,3,421,158,'2022-07-07 02:10:59','2022-10-13 15:53:40',0),(281,2,382,184,'2021-12-22 10:34:27','2022-10-13 15:53:40',0),(282,1,428,112,'2022-02-08 21:52:04','2022-10-13 15:53:40',0),(283,1,347,193,'2022-05-29 10:03:50','2022-10-13 15:53:40',0),(284,3,384,121,'2022-08-30 04:26:53','2022-10-13 15:53:40',0),(285,2,437,134,'2022-05-06 08:43:05','2022-10-13 15:53:40',0),(286,1,399,183,'2022-09-13 09:38:08','2022-10-13 15:53:40',0),(287,1,425,174,'2022-06-01 10:34:52','2022-10-13 15:53:40',0),(288,4,386,136,'2022-08-26 09:48:57','2022-10-13 15:53:40',0),(289,2,332,193,'2022-09-11 08:48:14','2022-10-13 15:53:40',0),(290,5,291,171,'2022-10-01 00:33:48','2022-10-13 15:53:40',0),(291,5,285,131,'2022-04-05 16:53:38','2022-10-13 15:53:40',0),(292,5,305,137,'2022-03-29 04:09:57','2022-10-13 15:53:40',0),(293,5,404,139,'2022-01-27 09:35:09','2022-10-13 15:53:40',0),(294,1,338,134,'2021-12-18 12:45:39','2022-10-13 15:53:40',0),(295,5,366,130,'2022-04-04 19:51:59','2022-10-13 15:53:40',0),(296,3,433,179,'2022-03-27 11:29:52','2022-10-13 15:53:40',0),(297,2,241,184,'2022-03-09 13:21:55','2022-10-13 15:53:40',0),(298,2,394,178,'2022-04-26 02:10:16','2022-10-13 15:53:40',0),(299,4,321,153,'2022-02-01 22:33:58','2022-10-13 15:53:40',0),(300,1,357,159,'2022-01-29 12:04:43','2022-10-13 15:53:40',0);
/*!40000 ALTER TABLE `rate` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-21 13:17:21