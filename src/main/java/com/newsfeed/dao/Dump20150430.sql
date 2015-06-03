CREATE DATABASE  IF NOT EXISTS `newsdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `newsdb`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: newsdb
-- ------------------------------------------------------
-- Server version	5.6.23-log

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
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `departmentId` int(11) NOT NULL DEFAULT '0',
  `departmentName` varchar(45) NOT NULL DEFAULT 'N/A',
  PRIMARY KEY (`departmentId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (-1,'Default'),(1,'Editorial'),(2,'Weather'),(3,'Classifieds'),(4,'Sports');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feed`
--

DROP TABLE IF EXISTS `feed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feed` (
  `feedId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`feedId`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feed`
--

LOCK TABLES `feed` WRITE;
/*!40000 ALTER TABLE `feed` DISABLE KEYS */;
INSERT INTO `feed` VALUES (1),(2),(3),(4),(6),(7),(8),(10),(11),(13),(14),(15),(16),(17),(18);
/*!40000 ALTER TABLE `feed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `internetfeed`
--

DROP TABLE IF EXISTS `internetfeed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `internetfeed` (
  `feedId` int(11) NOT NULL,
  `headline` varchar(100) NOT NULL,
  `deptId` int(11) NOT NULL,
  PRIMARY KEY (`feedId`),
  KEY `FK_deptKey_idx` (`deptId`),
  CONSTRAINT `FK_deptKey1` FOREIGN KEY (`deptId`) REFERENCES `department` (`departmentId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_fid1` FOREIGN KEY (`feedId`) REFERENCES `feed` (`feedId`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `internetfeed`
--

LOCK TABLES `internetfeed` WRITE;
/*!40000 ALTER TABLE `internetfeed` DISABLE KEYS */;
INSERT INTO `internetfeed` VALUES (1,'India won over Pakistan by 87 runs',4),(2,'Basefall fans disheartened by IU\'s defeat',4),(3,'Saina Nehwal wins Wimbeldon',4),(4,'Rofer Federar undefeated !!',4),(6,'Congress has lost it power',1),(7,'Semester end peaks study tension !!',1),(8,'Greatest American Leaders',1),(10,'Earthquake in Nepal - 5000 homeless',2),(11,'Unexpected cold in Bloomington',2),(13,'Paid survey study at SOIC',3),(14,'Yard sale at Crescent Park',3),(15,'Looking for a Pet Sitter',3),(16,'House available for rent',3),(17,'Storm  conditions around Bloomington',2),(18,'Three cheers for Mary Com !!',4);
/*!40000 ALTER TABLE `internetfeed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `newsfeed`
--

DROP TABLE IF EXISTS `newsfeed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `newsfeed` (
  `feedId` int(11) NOT NULL,
  `headline` varchar(100) NOT NULL,
  `deptId` int(11) NOT NULL,
  PRIMARY KEY (`feedId`),
  KEY `FK_deptKey_idx` (`deptId`),
  CONSTRAINT `FK_deptKey` FOREIGN KEY (`deptId`) REFERENCES `department` (`departmentId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_fid2` FOREIGN KEY (`feedId`) REFERENCES `feed` (`feedId`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `newsfeed`
--

LOCK TABLES `newsfeed` WRITE;
/*!40000 ALTER TABLE `newsfeed` DISABLE KEYS */;
INSERT INTO `newsfeed` VALUES (1,'India won over Pakistan by 87 runs',4),(2,'Basefall fans disheartened by IU\'s defeat',4),(3,'Saina Nehwal wins Wimbeldon',4),(4,'Rofer Federar undefeated !!',4),(6,'Congress has lost it power',1),(7,'Semester end peaks study tension !!',1),(8,'Greatest American Leaders',1),(10,'Earthquake in Nepal - 5000 homeless',2),(11,'Unexpected cold in Bloomington',2),(13,'Paid survey study at SOIC',3),(14,'Yard sale at Crescent Park',3),(15,'Looking for a Pet Sitter',3),(16,'House available for rent',3),(17,'Storm  conditions around Bloomington',2),(18,'Three cheers for Mary Com !!',4);
/*!40000 ALTER TABLE `newsfeed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `twitterfeed`
--

DROP TABLE IF EXISTS `twitterfeed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `twitterfeed` (
  `feedId` int(11) NOT NULL,
  `headline` varchar(100) NOT NULL,
  `deptId` int(11) NOT NULL,
  PRIMARY KEY (`feedId`),
  KEY `FK_deptKey_idx` (`deptId`),
  CONSTRAINT `FK_deptKey2` FOREIGN KEY (`deptId`) REFERENCES `department` (`departmentId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_fid3` FOREIGN KEY (`feedId`) REFERENCES `feed` (`feedId`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `twitterfeed`
--

LOCK TABLES `twitterfeed` WRITE;
/*!40000 ALTER TABLE `twitterfeed` DISABLE KEYS */;
INSERT INTO `twitterfeed` VALUES (1,'India won over Pakistan by 87 runs',4),(2,'Basefall fans disheartened by IU\'s defeat',4),(3,'Saina Nehwal wins Wimbeldon',4),(4,'Rofer Federar undefeated !!',4),(6,'Congress has lost it power',1),(7,'Semester end peaks study tension !!',1),(8,'Greatest American Leaders',1),(10,'Earthquake in Nepal - 5000 homeless',2),(11,'Unexpected cold in Bloomington',2),(13,'Paid survey study at SOIC',3),(14,'Yard sale at Crescent Park',3),(15,'Looking for a Pet Sitter',3),(16,'House available for rent',3),(17,'Storm  conditions around Bloomington',2),(18,'Three cheers for Mary Com !!',4);
/*!40000 ALTER TABLE `twitterfeed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 NOT NULL,
  `role` int(11) NOT NULL DEFAULT '-1',
  `address` varchar(50) DEFAULT NULL,
  `gender` int(11) NOT NULL DEFAULT '-1',
  `dept` int(11) NOT NULL DEFAULT '-1',
  PRIMARY KEY (`user_id`),
  KEY `FK_deptId_idx` (`dept`),
  CONSTRAINT `FK_deptId` FOREIGN KEY (`dept`) REFERENCES `department` (`departmentId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (38,'Admin','admin@admin.com','admin',1,'Bloomington',18,-1),(39,'Renuka Deshmukh','renud1988@gmail.com','123456',3,'Pune',2,-1),(43,'Alia Stevens','alia@gmail.com','alia',3,'Santa Clara',28,-1),(44,'Hal Gregory','hal@gmail.com','halg',3,'Santa Barbara',28,-1),(45,'Hailey Gregory','hailey@gmail.com','hailey',3,'Santa Barbara',28,-1),(50,'Mahesh Tokle','mtokle@gmail.com','tokle',3,'Tavisca Solutions Pvt. Ltd.',1,-1),(51,'Mahesh Tokle','mtokle@gmail.com','tokle',3,'Tavisca Solutions Pvt. Ltd.',1,-1),(53,'Madhav Sarode','madhav@gmail.com','madhav',2,'Cyprus',1,1),(54,'Suman Pandey','suman@yahoo.com','suman',2,'Dubai',2,2),(55,'Renuka Deshmukh','manimau@gmail.com','12345',3,'Bloomington',1,1),(56,'Satwik Narlanka','satwik@gmail.com','satwik',3,'UITS',1,4),(57,'Mira ','Mira@gmail.com','mira',2,'Mumbai',2,3),(58,'Josh Cox','joshcox@gmail.com','josh',2,'Indiana',1,4),(60,'John Doe','john@doe.com','john',2,'Bloomington',1,1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-04-30 22:15:52
