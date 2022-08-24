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
  `balance` int DEFAULT '100',
  `balancedouble` double DEFAULT '100',
  `betf` double DEFAULT NULL,
  `betre` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'xcvcxv','sdvs','xcvx','Create an account',12,NULL,NULL,NULL),(2,'dvsd','cdsc','cdscds','cdsc',100,NULL,NULL,NULL),(3,'ede','efef','dede','dede',100,NULL,NULL,NULL),(5,'Yelyzaveta','Korniienkova','1111','lkornejka',100,NULL,NULL,NULL),(7,'Yelyzaveta','Korniienkova','lkornejka','lkornejka',100,NULL,NULL,NULL),(9,'Yelyzaveta','Korniienkova','lkornejkaa','lkornejkaa',100,NULL,NULL,NULL),(11,'Yelyzaveta','Korniienkova','ekornejka','1111',100,NULL,NULL,NULL),(13,'Yelyzaveta','Korniienkova','elkornejka','1111',100,NULL,NULL,NULL),(14,'оля','федько','олялох','№0663869914№',0,119.39999999999992,24.2,10),(15,'d','d','d','d',325,92.4,0,0),(16,'q','q','q','q',100,NULL,NULL,NULL),(18,'w','w','w','w',100,NULL,NULL,NULL),(19,'ww','ww','ww','ww',100,NULL,NULL,NULL),(20,'Наталия','Корниенкова','natali','1111',100,83.3,0,0),(23,'e','e','e','e',100,100,NULL,NULL),(25,'dcd','cdcd','cdcd','dcdcd',100,100,NULL,NULL),(26,'jkbkj','knkn','jbkjb',',nnj',100,100,NULL,NULL),(27,'dckdnc','dcmdkcm','lmcldmcd','cdc',100,100,NULL,NULL),(28,'Радик','Назаров','радик','1111',100,92.4,24.2,10);
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

-- Dump completed on 2022-08-05 21:08:08
