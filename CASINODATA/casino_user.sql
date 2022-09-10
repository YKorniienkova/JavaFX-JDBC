-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: casino
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `balancedouble` double DEFAULT '100',
  `bet` double DEFAULT '0',
  `betres` double DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'xcvcxv','sdvs','xcvx','Create an account',NULL,0,0),(2,'dvsd','cdsc','cdscds','cdsc',NULL,0,0),(3,'ede','efef','dede','dede',NULL,0,0),(5,'Yelyzaveta','Korniienkova','1111','lkornejka',NULL,0,0),(7,'Yelyzaveta','Korniienkova','lkornejka','lkornejka',NULL,0,0),(9,'Yelyzaveta','Korniienkova','lkornejkaa','lkornejkaa',NULL,0,0),(11,'Yelyzaveta','Korniienkova','ekornejka','1111',NULL,0,0),(13,'Yelyzaveta','Korniienkova','elkornejka','1111',NULL,0,0),(14,'оля','федько','олялох','№0663869914№',119.39999999999992,0,0),(15,'d','d','d','d',7341.02,0,0),(16,'q','q','q','q',3,0,0),(18,'w','w','w','w',NULL,0,0),(19,'ww','ww','ww','ww',NULL,0,0),(20,'Наталия','Корниенкова','natali','1111',100,0,0),(23,'e','e','e','e',-20,0,0),(25,'dcd','cdcd','cdcd','dcdcd',-20,0,0),(26,'jkbkj','knkn','jbkjb',',nnj',100,0,0),(27,'dckdnc','dcmdkcm','lmcldmcd','cdc',100,0,0),(28,'Радик','Назаров','радик','1111',92.4,0,0),(29,'людмила','дейкун','людмила','1111',115.62,0,0),(30,'игорь','марченко','игорь','1111',125.80000000000001,0,0),(31,'dvfds','csd','csdc','csd',100,0,0),(32,'Лизочка','Корниенкова','Лизочка','1111',104.2,0,0),(33,'Лиза','Корави','сівс','сівсі',NULL,0,0),(34,'qq','qq','qq','qq',NULL,0,0),(36,'www','www','www','www',104.2,0,0),(37,'r','r','r','r',54.80000000000001,10,10),(38,'t','t','t','t',94.2,0,0),(39,'easywin','easywin','easywin','1111',286.13,0,0),(40,'lizaa','lizaa','lizaa','lizaa',121,62,50);
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

-- Dump completed on 2022-09-02 22:12:39
