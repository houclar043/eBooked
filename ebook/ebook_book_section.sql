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
-- Table structure for table `book_section`
--

DROP TABLE IF EXISTS `book_section`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_section` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `book_id` bigint DEFAULT NULL,
  `section_id` bigint DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT '0' COMMENT '0: normal\n1: deleted',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=916 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_section`
--

LOCK TABLES `book_section` WRITE;
/*!40000 ALTER TABLE `book_section` DISABLE KEYS */;
INSERT INTO `book_section` VALUES (458,230,44,0),(459,230,43,0),(460,231,45,0),(461,231,43,0),(462,232,46,0),(463,232,43,0),(464,233,48,0),(465,233,47,0),(466,234,50,0),(467,234,49,0),(468,235,45,0),(469,235,43,0),(470,236,50,0),(471,236,49,0),(472,237,46,0),(473,237,47,0),(474,238,44,0),(475,238,43,0),(476,239,51,0),(477,239,49,0),(478,240,45,0),(479,240,43,0),(480,241,53,0),(481,241,52,0),(482,242,46,0),(483,242,47,0),(484,243,54,0),(485,243,43,0),(486,244,50,0),(487,244,49,0),(488,245,53,0),(489,245,52,0),(490,246,45,0),(491,246,43,0),(492,247,45,0),(493,247,43,0),(494,248,55,0),(495,248,52,0),(496,249,47,0),(497,249,56,0),(498,250,54,0),(499,250,43,0),(500,251,46,0),(501,251,43,0),(502,252,45,0),(503,252,43,0),(504,253,45,0),(505,253,43,0),(506,254,45,0),(507,254,43,0),(508,255,54,0),(509,255,43,0),(510,256,50,0),(511,256,49,0),(512,257,53,0),(513,257,52,0),(514,258,53,0),(515,258,52,0),(516,259,53,0),(517,259,52,0),(518,260,48,0),(519,260,47,0),(520,261,55,0),(521,261,52,0),(522,262,57,0),(523,262,49,0),(524,263,58,0),(525,263,47,0),(526,264,58,0),(527,264,47,0),(528,265,53,0),(529,265,52,0),(530,266,55,0),(531,266,52,0),(532,267,55,0),(533,267,52,0),(534,268,57,0),(535,268,49,0),(536,269,59,0),(537,269,56,0),(538,270,55,0),(539,270,52,0),(540,271,50,0),(541,271,49,0),(542,272,53,0),(543,272,52,0),(544,273,48,0),(545,273,47,0),(546,274,58,0),(547,274,47,0),(548,275,50,0),(549,275,56,0),(550,276,55,0),(551,276,52,0),(552,277,53,0),(553,277,52,0),(554,278,50,0),(555,278,49,0),(556,279,53,0),(557,279,52,0),(558,280,55,0),(559,280,52,0),(560,281,55,0),(561,281,52,0),(562,282,53,0),(563,282,52,0),(564,283,60,0),(565,283,49,0),(566,284,57,0),(567,284,49,0),(568,285,45,0),(569,285,43,0),(570,286,48,0),(571,286,43,0),(572,287,48,0),(573,287,43,0),(574,288,44,0),(575,288,43,0),(576,289,54,0),(577,289,43,0),(578,290,44,0),(579,290,43,0),(580,291,44,0),(581,291,43,0),(582,292,54,0),(583,292,43,0),(584,293,55,0),(585,293,52,0),(586,294,53,0),(587,294,52,0),(588,295,55,0),(589,295,52,0),(590,296,50,0),(591,296,49,0),(592,297,55,0),(593,297,52,0),(594,298,48,0),(595,298,56,0),(596,299,55,0),(597,299,52,0),(598,300,50,0),(599,300,49,0),(600,301,55,0),(601,301,52,0),(602,302,50,0),(603,302,49,0),(604,303,57,0),(605,303,49,0),(606,304,50,0),(607,304,49,0),(608,305,48,0),(609,305,43,0),(610,306,61,0),(611,306,49,0),(612,307,61,0),(613,307,49,0),(614,308,61,0),(615,308,49,0),(616,309,62,0),(617,309,49,0),(618,310,63,0),(619,310,56,0),(620,311,61,0),(621,311,49,0),(622,312,50,0),(623,312,49,0),(624,313,50,0),(625,313,49,0),(626,314,55,0),(627,314,52,0),(628,315,50,0),(629,315,49,0),(630,316,55,0),(631,316,52,0),(632,317,50,0),(633,317,49,0),(634,318,53,0),(635,318,52,0),(636,319,63,0),(637,319,56,0),(638,320,51,0),(639,320,49,0),(640,321,50,0),(641,321,49,0),(642,322,55,0),(643,322,52,0),(644,323,58,0),(645,323,47,0),(646,324,48,0),(647,324,47,0),(648,325,58,0),(649,325,47,0),(650,326,53,0),(651,326,52,0),(652,327,53,0),(653,327,52,0),(654,328,48,0),(655,328,49,0),(656,329,55,0),(657,329,52,0),(658,330,57,0),(659,330,49,0),(660,331,56,0),(661,331,56,0),(662,332,50,0),(663,332,49,0),(664,333,53,0),(665,333,52,0),(666,334,57,0),(667,334,49,0),(668,335,53,0),(669,335,52,0),(670,336,53,0),(671,336,52,0),(672,337,53,0),(673,337,52,0),(674,338,57,0),(675,338,56,0),(676,339,50,0),(677,339,49,0),(678,340,55,0),(679,340,52,0),(680,341,46,0),(681,341,47,0),(682,342,56,0),(683,342,56,0),(684,343,53,0),(685,343,52,0),(686,344,48,0),(687,344,47,0),(688,345,50,0),(689,345,49,0),(690,346,64,0),(691,346,49,0),(692,347,57,0),(693,347,49,0),(694,348,57,0),(695,348,49,0),(696,349,53,0),(697,349,52,0),(698,350,55,0),(699,350,52,0),(700,351,50,0),(701,351,49,0),(702,352,61,0),(703,352,49,0),(704,353,56,0),(705,353,56,0),(706,354,55,0),(707,354,52,0),(708,355,50,0),(709,355,49,0),(710,356,61,0),(711,356,49,0),(712,357,55,0),(713,357,52,0),(714,358,53,0),(715,358,52,0),(716,359,65,0),(717,359,56,0),(718,360,50,0),(719,360,49,0),(720,361,55,0),(721,361,52,0),(722,362,55,0),(723,362,52,0),(724,363,46,0),(725,363,47,0),(726,364,45,0),(727,364,43,0),(728,365,50,0),(729,365,49,0),(730,366,46,0),(731,366,47,0),(732,367,50,0),(733,367,49,0),(734,368,66,0),(735,368,52,0),(736,369,66,0),(737,369,52,0),(738,370,66,0),(739,370,52,0),(740,371,66,0),(741,371,52,0),(742,372,66,0),(743,372,52,0),(744,373,46,0),(745,373,47,0),(746,374,66,0),(747,374,52,0),(748,375,66,0),(749,375,52,0),(750,376,66,0),(751,376,52,0),(752,377,66,0),(753,377,52,0),(754,378,66,0),(755,378,52,0),(756,379,66,0),(757,379,52,0),(758,380,66,0),(759,380,52,0),(760,381,57,0),(761,381,49,0),(762,382,46,0),(763,382,47,0),(764,383,48,0),(765,383,47,0),(766,384,44,0),(767,384,43,0),(768,385,54,0),(769,385,43,0),(770,386,54,0),(771,386,43,0),(772,387,45,0),(773,387,43,0),(774,388,53,0),(775,388,52,0),(776,389,61,0),(777,389,49,0),(778,390,45,0),(779,390,43,0),(780,391,50,0),(781,391,49,0),(782,392,50,0),(783,392,49,0),(784,393,50,0),(785,393,49,0),(786,394,50,0),(787,394,49,0),(788,395,50,0),(789,395,49,0),(790,396,50,0),(791,396,49,0),(792,397,50,0),(793,397,49,0),(794,398,55,0),(795,398,52,0),(796,399,55,0),(797,399,52,0),(798,400,55,0),(799,400,52,0),(800,401,55,0),(801,401,52,0),(802,402,54,0),(803,402,43,0),(804,403,54,0),(805,403,43,0),(806,404,54,0),(807,404,43,0),(808,405,45,0),(809,405,43,0),(810,406,55,0),(811,406,52,0),(812,407,59,0),(813,407,56,0),(814,408,59,0),(815,408,56,0),(816,409,58,0),(817,409,47,0),(818,410,45,0),(819,410,43,0),(820,411,58,0),(821,411,47,0),(822,412,46,0),(823,412,47,0),(824,413,47,0),(825,413,47,0),(826,414,67,0),(827,414,49,0),(828,415,56,0),(829,415,56,0),(830,416,56,0),(831,416,56,0),(832,417,56,0),(833,417,56,0),(834,418,57,0),(835,418,49,0),(836,419,50,0),(837,419,49,0),(838,420,50,0),(839,420,49,0),(840,421,50,0),(841,421,49,0),(842,422,67,0),(843,422,49,0),(844,423,55,0),(845,423,52,0),(846,424,55,0),(847,424,52,0),(848,425,55,0),(849,425,52,0),(850,426,55,0),(851,426,52,0),(852,427,55,0),(853,427,52,0),(854,428,53,0),(855,428,52,0),(856,429,55,0),(857,429,52,0),(858,430,55,0),(859,430,52,0),(860,431,55,0),(861,431,52,0),(862,432,55,0),(863,432,52,0),(864,433,55,0),(865,433,52,0),(866,434,66,0),(867,434,52,0),(868,435,51,0),(869,435,56,0),(870,436,46,0),(871,436,47,0),(872,437,44,0),(873,437,43,0),(874,438,53,0),(875,438,52,0),(876,439,53,0),(877,439,52,0),(878,440,53,0),(879,440,52,0),(890,469,43,0),(891,469,44,0),(892,470,43,0),(893,470,44,0),(894,471,43,0),(895,471,44,0),(896,472,43,0),(897,472,44,0),(898,473,43,0),(899,473,44,0),(900,474,43,0),(901,474,44,0),(902,475,43,0),(903,475,44,0),(904,476,43,0),(905,476,44,0),(906,477,43,0),(907,477,44,0),(908,477,45,0),(909,477,46,0),(910,478,43,0),(911,478,44,0),(912,479,43,0),(913,479,44,0),(914,480,43,0),(915,480,44,0);
/*!40000 ALTER TABLE `book_section` ENABLE KEYS */;
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