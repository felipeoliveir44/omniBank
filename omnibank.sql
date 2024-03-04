-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: omnibank
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `tbcartao`
--

DROP TABLE IF EXISTS `tbcartao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbcartao` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numero` char(16) DEFAULT NULL,
  `validade` varchar(7) DEFAULT NULL,
  `cvv` char(3) DEFAULT NULL,
  `limite` decimal(10,2) DEFAULT NULL,
  `statusCartao` varchar(9) DEFAULT NULL,
  `id_cliente` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `numero` (`numero`),
  KEY `id_cliente` (`id_cliente`),
  CONSTRAINT `tbcartao_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `tbcliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbcartao`
--

LOCK TABLES `tbcartao` WRITE;
/*!40000 ALTER TABLE `tbcartao` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbcartao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbcategoria`
--

DROP TABLE IF EXISTS `tbcategoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbcategoria` (
  `id` int NOT NULL,
  `nome` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbcategoria`
--

LOCK TABLES `tbcategoria` WRITE;
/*!40000 ALTER TABLE `tbcategoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbcategoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbcliente`
--

DROP TABLE IF EXISTS `tbcliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbcliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `cpf` char(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `telefone` char(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cpf` (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbcliente`
--

LOCK TABLES `tbcliente` WRITE;
/*!40000 ALTER TABLE `tbcliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbcliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbcompra`
--

DROP TABLE IF EXISTS `tbcompra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbcompra` (
  `ID` int NOT NULL,
  `valor` decimal(10,2) DEFAULT NULL,
  `dataCompra` datetime DEFAULT NULL,
  `estabelecimento` varchar(100) DEFAULT NULL,
  `categoria` varchar(50) DEFAULT NULL,
  `id_cartao` int DEFAULT NULL,
  `id_categoria` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `id_cartao` (`id_cartao`),
  KEY `id_categoria` (`id_categoria`),
  CONSTRAINT `tbcompra_ibfk_1` FOREIGN KEY (`id_cartao`) REFERENCES `tbcartao` (`id`),
  CONSTRAINT `tbcompra_ibfk_2` FOREIGN KEY (`id_categoria`) REFERENCES `tbcategoria` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbcompra`
--

LOCK TABLES `tbcompra` WRITE;
/*!40000 ALTER TABLE `tbcompra` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbcompra` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-04  0:28:07
