-- MySQL dump 10.13  Distrib 5.5.29, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: personalBlog
-- ------------------------------------------------------
-- Server version	5.5.29-0ubuntu0.12.04.2

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
-- Current Database: `personalBlog`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `personalBlog` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `personalBlog`;

--
-- Table structure for table `Activation`
--

DROP TABLE IF EXISTS `Activation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Activation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_added` datetime NOT NULL,
  `date_modyfication` datetime DEFAULT NULL,
  `activationLink` varchar(255) DEFAULT NULL,
  `captcha` varchar(255) DEFAULT NULL,
  `confirmPassword` varchar(255) DEFAULT NULL,
  `emailLogin` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `PrivacyPolicy` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Activation`
--

LOCK TABLES `Activation` WRITE;
/*!40000 ALTER TABLE `Activation` DISABLE KEYS */;
/*!40000 ALTER TABLE `Activation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Blog`
--

DROP TABLE IF EXISTS `Blog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Blog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `DATE_ADDED` datetime NOT NULL,
  `DATE_MODYFICATION` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `owner_id` bigint(20) DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1FA3C280285FFB` (`owner_id`),
  KEY `FK1FA3C2BF2E27B0` (`category_id`),
  CONSTRAINT `FK1FA3C280285FFB` FOREIGN KEY (`owner_id`) REFERENCES `User` (`id`),
  CONSTRAINT `FK1FA3C2BF2E27B0` FOREIGN KEY (`category_id`) REFERENCES `Category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Blog`
--

LOCK TABLES `Blog` WRITE;
/*!40000 ALTER TABLE `Blog` DISABLE KEYS */;
/*!40000 ALTER TABLE `Blog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `BlogEntry`
--

DROP TABLE IF EXISTS `BlogEntry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `BlogEntry` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `DATE_ADDED` datetime NOT NULL,
  `DATE_MODYFICATION` datetime DEFAULT NULL,
  `allowComment` tinyint(1) NOT NULL,
  `author` varchar(255) NOT NULL,
  `content` varchar(255) NOT NULL,
  `entryState` varchar(255) DEFAULT NULL,
  `publishDate` datetime DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `blog_id` bigint(20) DEFAULT NULL,
  `comment_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKB03A7DD041B5170C` (`blog_id`),
  KEY `FKB03A7DD0F4B8C1D1` (`comment_id`),
  CONSTRAINT `FKB03A7DD041B5170C` FOREIGN KEY (`blog_id`) REFERENCES `Blog` (`id`),
  CONSTRAINT `FKB03A7DD0F4B8C1D1` FOREIGN KEY (`comment_id`) REFERENCES `Comment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BlogEntry`
--

LOCK TABLES `BlogEntry` WRITE;
/*!40000 ALTER TABLE `BlogEntry` DISABLE KEYS */;
/*!40000 ALTER TABLE `BlogEntry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Car`
--

DROP TABLE IF EXISTS `Car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Car` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_added` datetime NOT NULL,
  `date_modyfication` datetime DEFAULT NULL,
  `age` int(11) NOT NULL,
  `make` varchar(255) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK107B471686EF2` (`person_id`),
  CONSTRAINT `FK107B471686EF2` FOREIGN KEY (`person_id`) REFERENCES `Person` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=156 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Car`
--

LOCK TABLES `Car` WRITE;
/*!40000 ALTER TABLE `Car` DISABLE KEYS */;
INSERT INTO `Car` VALUES (71,'2013-04-14 13:46:57',NULL,17,'polonez',67),(72,'2013-04-14 13:46:57',NULL,12,'fiat',67),(73,'2013-04-14 13:46:57',NULL,5,'suzuki',67),(74,'2013-04-14 13:46:57',NULL,1,'ferrari',68),(75,'2013-04-14 13:46:57',NULL,2,'porche',68),(76,'2013-04-14 13:46:57',NULL,17,'polonez1',67),(77,'2013-04-14 13:46:57',NULL,12,'fiat1',67),(78,'2013-04-14 13:46:57',NULL,5,'suzuki1',67),(79,'2013-04-14 13:46:57',NULL,1,'ferrari1',67),(80,'2013-04-14 13:46:57',NULL,2,'porche1',67),(81,'2013-04-14 13:46:57',NULL,17,'polonez2',67),(82,'2013-04-14 13:46:57',NULL,12,'fiat2',67),(83,'2013-04-14 13:46:57',NULL,5,'suzuki2',67),(84,'2013-04-14 13:46:57',NULL,1,'ferrari2',67),(85,'2013-04-14 13:46:57',NULL,2,'porche2',67),(86,'2013-04-14 13:46:57',NULL,17,'polonez3',67),(87,'2013-04-14 13:46:57',NULL,12,'fiat3',67),(88,'2013-04-14 13:46:57',NULL,5,'suzuki3',67),(89,'2013-04-14 13:46:57',NULL,1,'ferrari3',67),(90,'2013-04-14 13:46:57',NULL,2,'porche3',67),(91,'2013-04-14 13:46:57',NULL,17,'polonez4',67),(92,'2013-04-14 13:46:57',NULL,12,'fiat4',67),(93,'2013-04-14 13:46:57',NULL,5,'suzuki4',67),(94,'2013-04-14 13:46:57',NULL,1,'ferrari4',67),(95,'2013-04-14 13:46:57',NULL,2,'porche4',67),(96,'2013-04-14 13:46:57',NULL,17,'polonez5',67),(97,'2013-04-14 13:46:57',NULL,12,'fiat5',67),(98,'2013-04-14 13:46:57',NULL,5,'suzuki5',67),(99,'2013-04-14 13:46:57',NULL,1,'ferrari5',67),(100,'2013-04-14 13:46:57',NULL,2,'porche5',67);
/*!40000 ALTER TABLE `Car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Category`
--

DROP TABLE IF EXISTS `Category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_added` datetime NOT NULL,
  `date_modyfication` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `PARENT_CATEGORY_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6DD211E317BDF9B` (`PARENT_CATEGORY_ID`),
  CONSTRAINT `FK6DD211E317BDF9B` FOREIGN KEY (`PARENT_CATEGORY_ID`) REFERENCES `Category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Category`
--

LOCK TABLES `Category` WRITE;
/*!40000 ALTER TABLE `Category` DISABLE KEYS */;
/*!40000 ALTER TABLE `Category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Comment`
--

DROP TABLE IF EXISTS `Comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `DATE_ADDED` datetime NOT NULL,
  `DATE_MODYFICATION` datetime DEFAULT NULL,
  `content` varchar(2000) NOT NULL,
  `title` varchar(255) NOT NULL,
  `userName` varchar(20) NOT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9BDE863FEB31F3FA` (`userId`),
  KEY `FK9BDE863F3A877FA6` (`parent_id`),
  CONSTRAINT `FK9BDE863F3A877FA6` FOREIGN KEY (`parent_id`) REFERENCES `Comment` (`id`),
  CONSTRAINT `FK9BDE863FEB31F3FA` FOREIGN KEY (`userId`) REFERENCES `User` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Comment`
--

LOCK TABLES `Comment` WRITE;
/*!40000 ALTER TABLE `Comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `Comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PageContent`
--

DROP TABLE IF EXISTS `PageContent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PageContent` (
  `ID` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PageContent`
--

LOCK TABLES `PageContent` WRITE;
/*!40000 ALTER TABLE `PageContent` DISABLE KEYS */;
/*!40000 ALTER TABLE `PageContent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Person`
--

DROP TABLE IF EXISTS `Person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_added` datetime NOT NULL,
  `date_modyfication` datetime DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Person`
--

LOCK TABLES `Person` WRITE;
/*!40000 ALTER TABLE `Person` DISABLE KEYS */;
INSERT INTO `Person` VALUES (67,'2013-04-14 13:46:57',NULL,'warszawa','slawek'),(68,'2013-04-14 13:46:57',NULL,'gdansk','pawel');
/*!40000 ALTER TABLE `Person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Ranking`
--

DROP TABLE IF EXISTS `Ranking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Ranking` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `DATE_ADDED` datetime NOT NULL,
  `DATE_MODYFICATION` datetime DEFAULT NULL,
  `clazzName` varchar(255) DEFAULT NULL,
  `objectId` varchar(255) DEFAULT NULL,
  `point` int(11) NOT NULL,
  `summaryResult` float NOT NULL,
  `userName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Ranking`
--

LOCK TABLES `Ranking` WRITE;
/*!40000 ALTER TABLE `Ranking` DISABLE KEYS */;
/*!40000 ALTER TABLE `Ranking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tag`
--

DROP TABLE IF EXISTS `Tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `DATE_ADDED` datetime NOT NULL,
  `DATE_MODYFICATION` datetime DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `entryId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1477A40FE49AB` (`entryId`),
  CONSTRAINT `FK1477A40FE49AB` FOREIGN KEY (`entryId`) REFERENCES `BlogEntry` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tag`
--

LOCK TABLES `Tag` WRITE;
/*!40000 ALTER TABLE `Tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `Tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER_ROLE`
--

DROP TABLE IF EXISTS `USER_ROLE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER_ROLE` (
  `userId` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleId` bigint(20) NOT NULL,
  KEY `FKBC16F46A9E67F47B` (`roleId`),
  KEY `FKBC16F46AEB31F3FA` (`userId`),
  CONSTRAINT `FKBC16F46A9E67F47B` FOREIGN KEY (`roleId`) REFERENCES `UserRole` (`id`),
  CONSTRAINT `FKBC16F46AEB31F3FA` FOREIGN KEY (`userId`) REFERENCES `User` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER_ROLE`
--

LOCK TABLES `USER_ROLE` WRITE;
/*!40000 ALTER TABLE `USER_ROLE` DISABLE KEYS */;
/*!40000 ALTER TABLE `USER_ROLE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `UnExpectedException`
--

DROP TABLE IF EXISTS `UnExpectedException`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `UnExpectedException` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_added` datetime NOT NULL,
  `date_modyfication` datetime DEFAULT NULL,
  `DESCRIPTION` longtext,
  `EXCEPTION` longtext NOT NULL,
  `MESSAGE` longtext,
  `ARGUMENTS` varchar(256) DEFAULT NULL,
  `ERROR_NUMBER` varchar(128) NOT NULL,
  `FORM_OR_MODULE_NAME` varchar(128) NOT NULL,
  `FUNCTION_NAME` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UnExpectedException`
--

LOCK TABLES `UnExpectedException` WRITE;
/*!40000 ALTER TABLE `UnExpectedException` DISABLE KEYS */;
/*!40000 ALTER TABLE `UnExpectedException` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `DATE_ADDED` datetime NOT NULL,
  `DATE_MODYFICATION` datetime DEFAULT NULL,
  `active` tinyint(1) NOT NULL,
  `USER_COUNRTY` varchar(50) NOT NULL,
  `homeNumber` varchar(255) DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `USER_STREET` varchar(50) DEFAULT NULL,
  `USER_STREET_NUMBER` varchar(255) NOT NULL,
  `USER_TOWN` varchar(50) NOT NULL,
  `zipcode` varchar(6) NOT NULL,
  `birthDate` datetime NOT NULL,
  `email` varchar(50) NOT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `ip` varchar(20) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phoneNumber` varchar(11) NOT NULL,
  `photo` longblob,
  `sex` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `UserRole`
--

DROP TABLE IF EXISTS `UserRole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `UserRole` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `DATE_ADDED` datetime NOT NULL,
  `DATE_MODYFICATION` datetime DEFAULT NULL,
  `role` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UserRole`
--

LOCK TABLES `UserRole` WRITE;
/*!40000 ALTER TABLE `UserRole` DISABLE KEYS */;
/*!40000 ALTER TABLE `UserRole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequences`
--

DROP TABLE IF EXISTS `hibernate_sequences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequences` (
  `sequence_name` varchar(255) DEFAULT NULL,
  `sequence_next_hi_value` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequences`
--

LOCK TABLES `hibernate_sequences` WRITE;
/*!40000 ALTER TABLE `hibernate_sequences` DISABLE KEYS */;
/*!40000 ALTER TABLE `hibernate_sequences` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-04-14 14:58:07
