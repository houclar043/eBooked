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
-- Table structure for table `section`
--

DROP TABLE IF EXISTS `section`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `section` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `section_name` varchar(45) DEFAULT NULL,
  `created_by` bigint DEFAULT NULL,
  `updated_by` bigint DEFAULT NULL,
  `is_disabled` tinyint DEFAULT NULL COMMENT '0: normal,\n1: disabled',
  `create_time` varchar(45) DEFAULT NULL,
  `update_time` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `section`
--

LOCK TABLES `section` WRITE;
/*!40000 ALTER TABLE `section` DISABLE KEYS */;
INSERT INTO `section` VALUES (43,'tech',NULL,NULL,0,'2022-10-07 10:06:54.968','2022-10-07 10:06:54.968'),(44,'signal_processing',NULL,NULL,0,'2022-10-07 10:06:54.982','2022-10-07 10:06:54.982'),(45,'data_science',NULL,NULL,0,'2022-10-07 10:06:55.015','2022-10-07 10:06:55.015'),(46,'mathematics',NULL,NULL,0,'2022-10-07 10:06:55.035','2022-10-07 10:06:55.035'),(47,'science',NULL,NULL,0,'2022-10-07 10:06:55.053','2022-10-07 10:06:55.053'),(48,'economics',NULL,NULL,0,'2022-10-07 10:06:55.062','2022-10-07 10:06:55.062'),(49,'nonfiction',NULL,NULL,0,'2022-10-07 10:06:55.079','2022-10-07 10:06:55.079'),(50,'history',NULL,NULL,0,'2022-10-07 10:06:55.085','2022-10-07 10:06:55.085'),(51,'psychology',NULL,NULL,0,'2022-10-07 10:06:55.182','2022-10-07 10:06:55.182'),(52,'fiction',NULL,NULL,0,'2022-10-07 10:06:55.211','2022-10-07 10:06:55.211'),(53,'classic',NULL,NULL,0,'2022-10-07 10:06:55.215','2022-10-07 10:06:55.215'),(54,'computer_science',NULL,NULL,0,'2022-10-07 10:06:55.24','2022-10-07 10:06:55.24'),(55,'novel',NULL,NULL,0,'2022-10-07 10:06:55.303','2022-10-07 10:06:55.303'),(56,'philosophy',NULL,NULL,0,'2022-10-07 10:06:55.316','2022-10-07 10:06:55.316'),(57,'autobiography',NULL,NULL,0,'2022-10-07 10:06:55.478','2022-10-07 10:06:55.478'),(58,'physics',NULL,NULL,0,'2022-10-07 10:06:55.489','2022-10-07 10:06:55.489'),(59,'objectivism',NULL,NULL,0,'2022-10-07 10:06:55.566','2022-10-07 10:06:55.566'),(60,'trivia',NULL,NULL,0,'2022-10-07 10:06:55.719','2022-10-07 10:06:55.719'),(61,'misc',NULL,NULL,0,'2022-10-07 10:06:55.965','2022-10-07 10:06:55.965'),(62,'poetry',NULL,NULL,0,'2022-10-07 10:06:56.004','2022-10-07 10:06:56.004'),(63,'education',NULL,NULL,0,'2022-10-07 10:06:56.015','2022-10-07 10:06:56.015'),(64,'anthology',NULL,NULL,0,'2022-10-07 10:06:56.347','2022-10-07 10:06:56.347'),(65,'politics',NULL,NULL,0,'2022-10-07 10:06:56.465','2022-10-07 10:06:56.465'),(66,'comic',NULL,NULL,0,'2022-10-07 10:06:56.543','2022-10-07 10:06:56.543'),(67,'legal',NULL,NULL,0,'2022-10-07 10:06:56.943','2022-10-07 10:06:56.943');
/*!40000 ALTER TABLE `section` ENABLE KEYS */;
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
