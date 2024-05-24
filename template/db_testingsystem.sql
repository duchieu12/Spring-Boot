-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: db_testingsystem
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `department_id` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `department_code` varchar(50) DEFAULT NULL,
  `total_member` tinyint unsigned DEFAULT NULL,
  `department_name` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `status` enum('OPEN','REVIEW','APPROVED','REJECTED') DEFAULT NULL,
  PRIMARY KEY (`department_id`),
  UNIQUE KEY `department_code` (`department_code`),
  UNIQUE KEY `department_name` (`department_name`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'O-1',1,'Marketing','2024-05-19 11:48:20','OPEN'),(2,'REV-1',2,'Sale','2024-05-19 11:48:20','REVIEW'),(3,'A-1',3,'Bảo vệ','2024-05-19 11:48:20','APPROVED'),(4,'REJ-1',4,'Nhân sự','2024-05-19 11:48:20','REJECTED'),(5,'O-2',5,'Kỹ thuật','2024-05-19 11:48:20','OPEN'),(6,'REV-2',6,'Tài chính','2024-05-19 11:48:20','REVIEW'),(7,'A-2',7,'Phó giám đốc','2024-05-19 11:48:20','APPROVED'),(8,'REJ-2',8,'Giám đốc','2024-05-19 11:48:20','REJECTED'),(9,'O-3',9,'Thư kí','2024-05-19 11:48:20','OPEN'),(10,'REV-3',10,'Bán hàng','2024-05-19 11:48:20','REVIEW'),(20,NULL,0,'Duy','2024-05-21 11:39:55','OPEN'),(22,NULL,0,'Duy1','2024-05-21 11:44:30','OPEN');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-21 11:48:39
