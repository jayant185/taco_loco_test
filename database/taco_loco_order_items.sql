-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: taco_loco
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `order_items`
--

DROP TABLE IF EXISTS `order_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_items` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_id` int DEFAULT NULL,
  `product_name` varchar(45) DEFAULT NULL,
  `base_price` varchar(45) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_items_orderId_foreign_key_idx` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_items`
--

LOCK TABLES `order_items` WRITE;
/*!40000 ALTER TABLE `order_items` DISABLE KEYS */;
INSERT INTO `order_items` VALUES (1,1,'Veggie Taco','2.5',2),(2,1,'Chicken','3.0',1),(3,2,'Veggie Taco','2.5',2),(4,2,'Chicken','3.0',1),(5,2,'Chorizo Taco','3.5',1),(6,3,'Veggie Taco','2.5',2),(7,3,'Chicken','3.0',1),(8,3,'Chorizo Taco','3.5',1),(9,4,'Veggie Taco','2.5',2),(10,4,'Chicken','3.0',1),(11,4,'Chorizo Taco','3.5',1),(12,5,'Veggie Taco','2.5',2),(13,5,'Chicken','3.0',1),(14,5,'Chorizo Taco','3.5',1),(15,6,'Veggie Taco','2.5',2),(16,6,'Chicken','3.0',1),(17,6,'Chorizo Taco','3.5',1),(18,7,'Veggie Taco','2.5',2),(19,7,'Chicken','3.0',1),(20,7,'Chorizo Taco','3.5',1),(21,8,'Veggie Taco','2.5',2),(22,8,'Chicken','3.0',1),(23,8,'Chorizo Taco','3.5',1),(24,9,'Veggie Taco','2.5',2),(25,9,'Chicken','3.0',1),(26,9,'Chorizo Taco','3.5',1),(27,10,'Veggie Taco','2.5',2),(28,10,'Chicken','3.0',1),(29,10,'Chorizo Taco','3.5',1),(30,10,'Chicken','3.0',3),(31,11,'Veggie Taco','2.5',2),(32,11,'Chicken','3.0',1),(33,11,'Chorizo Taco','3.5',1),(34,11,'Chicken','3.0',3);
/*!40000 ALTER TABLE `order_items` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-25 17:56:50
