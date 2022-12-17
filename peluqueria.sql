-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: peluqueria
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `celular` int DEFAULT NULL,
  `distrito` varchar(22) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Diego','Burneo','diego@gmail.com',987564345,'Chorrillos','AV asteroides'),(5,'Ximena','Cordoba ','ximenita45@gmail.com',990410237,'Ate Vitarte','Los Angeles'),(17,'XIMENA','CORDOBA','ximenita@gmail.com',990410237,'Ate Vitarte','LOS ANGELES'),(21,'MIGUEL ANGEL','MALLQUI','miguelmallqui121@gmail.com',944741052,'Ate Vitarte','AV ASTEROIDES'),(22,'MIGUEL','MALLQUI','miguel12@gmail.com',967456453,'Chorrillos','AV CHORRILLOS');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_reserva_servicio`
--

DROP TABLE IF EXISTS `detalle_reserva_servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_reserva_servicio` (
  `id` int NOT NULL AUTO_INCREMENT,
  `hora_inicio` time NOT NULL,
  `hora_fin` time NOT NULL,
  `mensaje` varchar(45) DEFAULT NULL,
  `duracion` time DEFAULT NULL,
  `subtotal` decimal(10,0) DEFAULT NULL,
  `id_servicio` int DEFAULT NULL,
  `id_empleado` int DEFAULT NULL,
  `id_reserva` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `servicio_idx` (`id_servicio`),
  KEY `empleado_idx` (`id_empleado`),
  KEY `id_reserva` (`id_reserva`),
  CONSTRAINT `detalle_reserva_servicio_ibfk_1` FOREIGN KEY (`id_reserva`) REFERENCES `reserva` (`id_reserva`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `detalle_reserva_servicio_ibfk_2` FOREIGN KEY (`id_servicio`) REFERENCES `servicio` (`id_servicio`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `detalle_reserva_servicio_ibfk_3` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id_empleado`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_reserva_servicio`
--

LOCK TABLES `detalle_reserva_servicio` WRITE;
/*!40000 ALTER TABLE `detalle_reserva_servicio` DISABLE KEYS */;
INSERT INTO `detalle_reserva_servicio` VALUES (63,'08:50:00','09:05:00','','00:15:00',15,2,2,8),(67,'11:00:00','11:15:00','','00:15:00',15,2,1,17),(68,'12:00:00','12:30:00','','00:30:00',22,4,3,17),(70,'12:00:00','12:15:00','','00:15:00',15,2,1,19),(71,'11:00:00','11:15:00','','00:15:00',15,2,1,19),(87,'12:00:00','12:15:00','','00:15:00',20,22,2,13),(91,'11:30:00','11:45:00','','00:15:00',15,2,1,19),(94,'10:00:00','10:15:00','','00:15:00',15,2,1,8);
/*!40000 ALTER TABLE `detalle_reserva_servicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `id_empleado` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `celular` int DEFAULT NULL,
  `distrito` varchar(22) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(256) DEFAULT NULL,
  `cargo` int DEFAULT NULL,
  PRIMARY KEY (`id_empleado`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (1,'CARMEN','SANDOVAL','carmen124@gmail.com',978564378,'Chorrillos','Av Asteroides Chorrillos','carmen1','*Carmen123*',0),(2,'ALEJANDRA','MEJILLA','alejandra12@gmail.com',978564379,'Santiago de Surco','JR. GUARDIA CIVIL SURCO 164','alejandra12','*Sololeveling20*',1),(3,'MARÍA PAULA','CARDENAS','mariapaula@hotmail.com',995828430,'Miraflores','CA. SAN MARTIN 512, MIRAFLORES 15074, CHORRILLOS','Carm','cardenas8d23*12A',0),(11,'ALEXA','MEJILLA','mallquijuan@gmail.com',944741058,'Santiago de Surco','JR. GUARDIA CIVIL SURCO 164','alexa123','*Sololeveling20*',0),(15,'MIGUEL','MALLQUI','mallquijuan@gmail.com',944741058,'Chorrillos','AV ASTEROIDES','miguel','*SoloLeveling20*',1),(16,'MIGUEL','MALLQUI','ma@gmail.com',944741059,'Chorrillos','AV ASTEROIDES','miguel12','*SoloLeveling20*',1);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserva` (
  `id_reserva` int NOT NULL AUTO_INCREMENT,
  `fecha_inicio` date DEFAULT NULL,
  `estado` int DEFAULT NULL,
  `tipo_reserva` varchar(9) NOT NULL,
  `id_cliente` int DEFAULT NULL,
  PRIMARY KEY (`id_reserva`),
  KEY `cliente_idx` (`id_cliente`),
  KEY `id_cliente` (`id_cliente`),
  CONSTRAINT `cliente` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` VALUES (8,'2022-12-05',1,'Domicilio',1),(13,'2022-12-15',0,'Local',5),(14,'2022-12-01',1,'Local',5),(17,'2022-12-15',0,'Local',21),(19,'2022-12-17',0,'Local',17);
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicio`
--

DROP TABLE IF EXISTS `servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicio` (
  `id_servicio` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `duracion` time DEFAULT NULL,
  `costo` decimal(3,0) DEFAULT NULL,
  PRIMARY KEY (`id_servicio`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicio`
--

LOCK TABLES `servicio` WRITE;
/*!40000 ALTER TABLE `servicio` DISABLE KEYS */;
INSERT INTO `servicio` VALUES (2,'CORTE INFANTIL','00:15:00',15),(4,'APLICACIÓN DE TINTE','00:30:00',22),(6,'CEPILLADO Y PLANCHADO LARGO','00:25:00',38),(10,'TRATAMIENTO REDKEN','00:20:00',99),(22,'CORTE DAMA','00:15:00',20),(23,'CEPILLADO Y PLANCHADO CORTO','00:25:00',38),(24,'CEPILLADO Y PLANCHADO MEDIO','00:25:00',38);
/*!40000 ALTER TABLE `servicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'peluqueria'
--
/*!50003 DROP PROCEDURE IF EXISTS `sp_adicionar_cliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_adicionar_cliente`(IN `nom` VARCHAR(45), IN `ape` VARCHAR(45), IN `cor` VARCHAR(45), IN `cel` INT, IN `dis` VARCHAR(22), IN `dir` VARCHAR(100))
BEGIN
DECLARE MSM VARCHAR(45);
DECLARE VALIDAR_CLIENTE INT;
SET VALIDAR_CLIENTE=(SELECT COUNT(*) FROM cliente c WHERE c.correo=cor or c.celular=cel);
IF VALIDAR_CLIENTE=0 THEN 
INSERT INTO cliente(nombre,apellido,correo,celular,distrito,direccion)
VALUES(nom,ape,cor,cel,dis,dir);
SET MSM="AGREGADO";
ELSE 
SET MSM="REPETIDO";
END IF;
SELECT MSM;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_adicionar_empleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_adicionar_empleado`(IN `nom` VARCHAR(45), IN `ape` VARCHAR(45), IN `cor` VARCHAR(45), IN `cel` INT, IN `dis` VARCHAR(22), IN `dir` VARCHAR(100), IN `usern` VARCHAR(45), IN `passw` VARCHAR(256), IN `carg` INT)
BEGIN
DECLARE MSM VARCHAR(8);
DECLARE VALIDAR_EMPLEADO INT;
SET VALIDAR_EMPLEADO=(SELECT COUNT(*) FROM empleado e WHERE e.username=usern or e.correo=cor or e.celular=cel);
IF VALIDAR_EMPLEADO=0 THEN 
INSERT INTO empleado(nombre,apellido,correo,celular,distrito,direccion,username,password,cargo)
VALUES(nom,ape,cor,cel,dis,dir,usern,passw,carg);
SET MSM="AGREGADO";
ELSE 
SET MSM="REPETIDO";
END IF;
SELECT MSM;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_adicionar_reserva` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_adicionar_reserva`(IN `finicio` DATE, IN `estad` INT, IN `tpreserva` VARCHAR(9), IN `idcli` INT)
BEGIN
DECLARE ID INT;
DECLARE VALIDAR_RESERVA INT;
SET VALIDAR_RESERVA=(SELECT COUNT(*) FROM reserva r WHERE r.fecha_inicio=finicio and r.tipo_reserva=tpreserva and r.id_cliente=idcli);
IF VALIDAR_RESERVA=0 THEN 
insert into reserva (fecha_inicio,estado,tipo_reserva,id_cliente) values (finicio,estad,tpreserva,idcli);
SET ID=0;
ELSE 
SET ID=VALIDAR_RESERVA;
END IF;
SELECT ID;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_adicionar_servicio` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_adicionar_servicio`(IN `nombreServ` VARCHAR(45), IN `durc` TIME, IN `cost` DECIMAL(10,0))
BEGIN
DECLARE MSM VARCHAR(8);
DECLARE VALIDAR_SERVICIOS INT;
SET VALIDAR_SERVICIOS=(SELECT COUNT(*) FROM servicio s WHERE s.nombre=nombreServ);
IF VALIDAR_SERVICIOS=0 THEN 
INSERT INTO servicio(nombre,duracion,costo) VALUES(nombreServ,durc,cost);
SET MSM="AGREGADO";
ELSE 
SET MSM="REPETIDO";
END IF;
SELECT MSM;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-08 21:40:56
