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
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id` varchar(255) NOT NULL,
  `pid` varchar(100) DEFAULT NULL,
  `book_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  `reply_to_id` bigint DEFAULT NULL,
  `nickname` varchar(45) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `content` text,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES ('1e56665b83180e56715edfc523e24958','e647063325600a33f5205ee92244fb4b',230,6,7,'yuhan',NULL,'hi','2022-11-18 23:14:22'),('91d935d1972a83e53d324d30b0aa310a','dc4209ba939d2c443b502cd1e7c75e1e',230,7,108,'cliffe','https://csc207-ebook-storage.s3.ca-central-1.amazonaws.com/default.png','hello','2022-10-23 23:21:07'),('cde7a43a1f707527647b386d4e9cb225','f782e5db0924f6e946731b79794fed83',230,7,108,'cliffe','https://csc207-ebook-storage.s3.ca-central-1.amazonaws.com/default.png','hi from cliffe','2022-10-23 23:34:38'),('dc4209ba939d2c443b502cd1e7c75e1e','-1',230,108,0,'Katrinka Sivier','https://csc207-ebook-storage.s3.ca-central-1.amazonaws.com/default.png','hi','2022-10-23 23:05:10'),('e647063325600a33f5205ee92244fb4b','f834890db129069b59ccb1eaef7aa836',230,7,108,'cliffe','https://csc207-ebook-storage.s3.ca-central-1.amazonaws.com/default.png','hiiiiii','2022-10-23 23:21:32'),('f782e5db0924f6e946731b79794fed83','-1',230,108,0,'Katrinka Sivier','https://csc207-ebook-storage.s3.ca-central-1.amazonaws.com/default.png','hi','2022-10-23 23:05:09'),('f834890db129069b59ccb1eaef7aa836','-1',230,108,0,'Katrinka Sivier','https://csc207-ebook-storage.s3.ca-central-1.amazonaws.com/default.png','hello','2022-10-23 23:05:24');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-21 13:17:20
