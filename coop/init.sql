-- MySQL dump 10.13  Distrib 5.5.28, for Win32 (x86)
--
-- Host: localhost    Database: coop
-- ------------------------------------------------------
-- Server version	5.5.28

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
-- Table structure for table `sequence`
--

DROP TABLE IF EXISTS `sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sequence` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sequence`
--

LOCK TABLES `sequence` WRITE;
/*!40000 ALTER TABLE `sequence` DISABLE KEYS */;
INSERT INTO `sequence` VALUES (4);
/*!40000 ALTER TABLE `sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_acl`
--

DROP TABLE IF EXISTS `t_acl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_acl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `principalType` varchar(255) DEFAULT NULL,
  `principalId` int(11) DEFAULT NULL,
  `moduleId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12483 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_acl`
--

LOCK TABLES `t_acl` WRITE;
/*!40000 ALTER TABLE `t_acl` DISABLE KEYS */;
INSERT INTO `t_acl` VALUES (1265,'Role',733,824),(1266,'Role',733,825),(1267,'Role',733,826),(10414,'Role',1245,824),(10415,'Role',1245,825),(10416,'Role',1245,826),(10417,'Role',1245,1331),(11200,'Role',1246,679),(11201,'Role',1246,677),(11202,'Role',1246,676),(11203,'Role',1246,684),(11204,'Role',1246,689),(11205,'Role',1246,694),(11206,'Role',1246,700),(11207,'Role',1246,705),(11208,'Role',1246,680),(11209,'Role',1246,681),(11210,'Role',1246,682),(11211,'Role',1246,685),(11212,'Role',1246,686),(11213,'Role',1246,687),(11214,'Role',1246,688),(11215,'Role',1246,690),(11216,'Role',1246,691),(11217,'Role',1246,692),(11218,'Role',1246,693),(11219,'Role',1246,695),(11220,'Role',1246,696),(11221,'Role',1246,697),(11222,'Role',1246,698),(11223,'Role',1246,699),(11224,'Role',1246,701),(11225,'Role',1246,702),(12048,'Role',1248,676),(12049,'Role',1248,677),(12050,'Role',1248,729),(12051,'Role',1248,741),(12052,'Role',1248,734),(12053,'Role',1248,732),(12054,'Role',1248,733),(12055,'Role',1248,739),(12056,'Role',1248,740),(12057,'Role',1248,722),(12058,'Role',1248,723),(12059,'Role',1248,724),(12060,'Role',1248,725),(12061,'Role',1248,726),(12062,'Role',1248,727),(12063,'Role',1248,728),(12064,'Role',1248,743),(12065,'Role',1248,744),(12066,'Role',1248,745),(12067,'Role',1248,742),(12068,'Role',1248,730),(12069,'Role',1248,731),(12070,'Role',1248,735),(12071,'Role',1248,736),(12072,'Role',1248,746),(12432,'Role',372,2),(12433,'Role',372,201),(12434,'Role',372,221),(12435,'Role',372,322),(12436,'Role',372,324),(12437,'Role',372,325),(12438,'Role',372,326),(12439,'Role',372,327),(12440,'Role',372,676),(12441,'Role',372,677),(12442,'Role',372,734),(12443,'Role',372,757),(12444,'Role',372,759),(12445,'Role',372,202),(12446,'Role',372,359),(12447,'Role',372,360),(12448,'Role',372,361),(12449,'Role',372,362),(12450,'Role',372,363),(12451,'Role',372,354),(12452,'Role',372,355),(12453,'Role',372,356),(12454,'Role',372,357),(12455,'Role',372,358),(12456,'Role',372,675),(12457,'Role',372,349),(12458,'Role',372,350),(12459,'Role',372,351),(12460,'Role',372,352),(12461,'Role',372,353),(12462,'Role',372,344),(12463,'Role',372,345),(12464,'Role',372,346),(12465,'Role',372,347),(12466,'Role',372,348),(12467,'Role',372,721),(12468,'Role',372,732),(12469,'Role',372,733),(12470,'Role',372,749),(12471,'Role',372,750),(12472,'Role',372,751),(12473,'Role',372,752),(12474,'Role',372,753),(12475,'Role',372,754),(12476,'Role',372,755),(12477,'Role',372,756),(12478,'Role',372,735),(12479,'Role',372,736),(12480,'Role',372,758),(12481,'Role',372,762),(12482,'Role',372,760);
/*!40000 ALTER TABLE `t_acl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_ads`
--

DROP TABLE IF EXISTS `t_ads`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_ads` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `newname` varchar(256) DEFAULT NULL,
  `url` varchar(512) DEFAULT NULL,
  `sequ` int(4) DEFAULT NULL,
  `descri` varchar(512) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `type` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_ads`
--

LOCK TABLES `t_ads` WRITE;
/*!40000 ALTER TABLE `t_ads` DISABLE KEYS */;
INSERT INTO `t_ads` VALUES (1,'有你们的帮助','9e06c648-177a-436e-950c-179a2fa28a52.jpg','#',1,'熬到沙发上都发生地方,按时得发送到发生地发射都发生地方,矮沙发上的发水电费按时得发送到发生地发射都发生地方','2013-04-06',1),(2,'高新区','68a39471-641f-4d67-b3a1-3fb8811632fa.jpg','#',2,'按时得发送到发生地发射都发生地方按时得发送到发生地发射都发生地方按时得发送到发生地发射都发生地方按时得发送到发生地发射都发生地方按时得发送到发生地发射都发生地方','2013-04-06',1),(3,'创新政策','81b63326-d4ff-4e95-b693-6e0410d08e57.jpg','#',3,'按时得发送到发生地发射都发生地方按时得发送到发生地发射都发生地方按时得发送到发生地发射都发生地方','2013-04-06',1),(4,'行业资源','9d7c5443-cc01-4a0c-a2f0-eac6411fcad1.jpg','#',4,'按时得发送到发生地发射都发生地方按时得发送到发生地发射都发生地方按时得发送到发生地发射都发生地方','2013-04-06',1),(11,'创新工场','925e1784-c6f6-4473-a24c-24d378a60228.jpg','http://www.chuangxin.com',1,'asdfasdfasdf','2013-04-06',2),(12,'金钛软件','9b3b5d7d-97bd-45ca-aff0-590ad73f39b9.jpg','http://www.goldnt.com/china/index.aspx',2,'asdfasdf','2013-04-06',2),(13,'外包协会','09b3d568-86f1-4bd3-a8e0-8194dfd70b98.jpg','http://www.int-iom.cn',3,'sssssssssssssssss','2013-04-06',2),(14,'国盾','b4eece54-0c50-4d6a-9db4-1b9900ac05b9.jpg','http://www.jsgds.com',4,'sssssssssssssss','2013-04-06',2),(26,'平台','56e595a6-983f-42c2-8ab2-c5c2c67df4f9.jpg','#',1,'','2013-04-08',3),(27,'外包','7cdc2405-f700-4f19-a1a9-5a82b8df3247.jpg','#',2,'','2013-04-08',3),(28,'创业孵化园','e2bbe72b-5db2-4e1a-ae58-4741d400a591.gif','http://www.can2do.com/platform/usip/',1,'','2013-04-08',4),(29,'工程实践中心','721c8a1b-afc8-417e-8eb3-6c7145269c3a.gif','http://www.can2do.com/platform/epec',2,'','2013-04-08',4),(32,'DOCrystal','b3a31302-c704-48fc-92ae-3f09df6d6757.jpg','http://www.can2do.com/platform/docrystal',1,'','2013-04-08',5),(33,'MMPro','2f08f633-97d1-492d-a5f6-59884f30f452.gif','http://www.can2do.com/platform/mmpro',2,'','2013-04-08',5),(35,'asdfasdf','c2626abf-49ba-434b-b320-a010dfb2b6df.jpg','222',22,'asdfasdfasf','2013-07-17',22),(36,'按时得发卅多发生地方','5a0ea515-aa98-43b1-81ed-4d3cd3a8b042.jpg','#',2,'asdfasdfasdfsadf','2013-07-17',22),(37,'asdfasdfasdf','22db4b1a-854d-4034-be54-93fb112e31e5.jpg','#',222,'asdf哀伤地发射多发送方按时得发卅多发生地方哀伤地发射多发送方哀伤地发射多发送方哀伤地发射多发送方哀伤地发射多发送方','2013-07-17',22),(38,'阿荣旗温柔','c27fe17f-1bfb-4147-8622-24bb65194548.jpg','#',222,'二百二十二万二千三百二十三','2013-07-17',22),(39,'asdf','7216ae19-1baa-47e8-8e8f-fff9f4416160.jpg','#',222,'ss','2013-07-20',65),(40,'按时得发','9502f1ff-60a0-40c6-b56e-41223e4749f1.jpg','#',2,'','2013-08-06',75),(41,'222','455b4506-32e3-474d-95fb-5a5c7cddff1d.jpg','#',222,'asdf','2013-08-06',75);
/*!40000 ALTER TABLE `t_ads` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_agreement`
--

DROP TABLE IF EXISTS `t_agreement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_agreement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `no` varchar(32) NOT NULL,
  `title` varchar(256) NOT NULL,
  `createDate` date DEFAULT NULL,
  `type` int(2) DEFAULT NULL,
  `state` int(2) DEFAULT NULL COMMENT '���״̬',
  `coopid` int(11) DEFAULT NULL COMMENT '乙方',
  `jiafang` int(11) DEFAULT NULL COMMENT '甲方',
  `sxsj` date DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_agreement`
--

LOCK TABLES `t_agreement` WRITE;
/*!40000 ALTER TABLE `t_agreement` DISABLE KEYS */;
INSERT INTO `t_agreement` VALUES (23,'33333333333','9999999','2013-07-30',1,1,68,0,'2013-07-31','a9683d7f-fed6-41b4-b16d-475983dbab57'),(24,'233333','22222222','2013-07-31',1,1,68,0,'2013-07-31','22f9acca-2637-44f8-8140-e93f19090854'),(25,'232323','2wswdfr','2013-07-31',1,1,68,0,'2013-07-31','21cb071e-4019-4d9f-a3f9-8d2e73121c84'),(26,'sss','sss','2013-07-31',1,1,68,0,NULL,'efc8eef3-501e-4271-83ae-07b870f5d2cf');
/*!40000 ALTER TABLE `t_agreement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_agreement_ext`
--

DROP TABLE IF EXISTS `t_agreement_ext`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_agreement_ext` (
  `code` varchar(50) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `value` varchar(4096) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_agreement_ext`
--

LOCK TABLES `t_agreement_ext` WRITE;
/*!40000 ALTER TABLE `t_agreement_ext` DISABLE KEYS */;
INSERT INTO `t_agreement_ext` VALUES ('ccb2a572-21b7-47c6-a0a3-409db4730df8','bfb1','3'),('ccb2a572-21b7-47c6-a0a3-409db4730df8','zh','3'),('ccb2a572-21b7-47c6-a0a3-409db4730df8','yfksj','2013-07-11'),('ccb2a572-21b7-47c6-a0a3-409db4730df8','jiadianhua','3'),('ccb2a572-21b7-47c6-a0a3-409db4730df8','bfb5','3'),('ccb2a572-21b7-47c6-a0a3-409db4730df8','bfb4','3'),('ccb2a572-21b7-47c6-a0a3-409db4730df8','bfb3','3'),('ccb2a572-21b7-47c6-a0a3-409db4730df8','yikaifuhang','3'),('ccb2a572-21b7-47c6-a0a3-409db4730df8','bfb2','3'),('ccb2a572-21b7-47c6-a0a3-409db4730df8','kfhmc','3'),('ccb2a572-21b7-47c6-a0a3-409db4730df8','yfkze','3'),('ccb2a572-21b7-47c6-a0a3-409db4730df8','wcksj','2013-07-25'),('ccb2a572-21b7-47c6-a0a3-409db4730df8','yiwtdlr','3'),('ccb2a572-21b7-47c6-a0a3-409db4730df8','jiazhanghao','3'),('ccb2a572-21b7-47c6-a0a3-409db4730df8','yizhanghong','3'),('ccb2a572-21b7-47c6-a0a3-409db4730df8','jineheji','3'),('ccb2a572-21b7-47c6-a0a3-409db4730df8','wckkze','3'),('ccb2a572-21b7-47c6-a0a3-409db4730df8','yifrdb','3'),('ccb2a572-21b7-47c6-a0a3-409db4730df8','jiayoubian','3'),('ccb2a572-21b7-47c6-a0a3-409db4730df8','jiawtdlr','3'),('ccb2a572-21b7-47c6-a0a3-409db4730df8','yesj','2013-07-24'),('ccb2a572-21b7-47c6-a0a3-409db4730df8','yeze','3'),('ccb2a572-21b7-47c6-a0a3-409db4730df8','shuliangheji','3'),('ccb2a572-21b7-47c6-a0a3-409db4730df8','zhmc','3'),('ccb2a572-21b7-47c6-a0a3-409db4730df8','yidizhi',''),('ccb2a572-21b7-47c6-a0a3-409db4730df8','djze','3'),('ccb2a572-21b7-47c6-a0a3-409db4730df8','jiafrdb','3'),('ccb2a572-21b7-47c6-a0a3-409db4730df8','djsj','2013-07-09'),('ccb2a572-21b7-47c6-a0a3-409db4730df8','wckje','3'),('ccb2a572-21b7-47c6-a0a3-409db4730df8','yeje','3'),('ccb2a572-21b7-47c6-a0a3-409db4730df8','yidianhua','33'),('ccb2a572-21b7-47c6-a0a3-409db4730df8','jiadizhi',''),('ccb2a572-21b7-47c6-a0a3-409db4730df8','yiachuanzhen','3'),('ccb2a572-21b7-47c6-a0a3-409db4730df8','jiakaifuhang','3'),('ccb2a572-21b7-47c6-a0a3-409db4730df8','yfkje','3'),('ccb2a572-21b7-47c6-a0a3-409db4730df8','yiyoubian','3'),('ccb2a572-21b7-47c6-a0a3-409db4730df8','jiachuanzhen','3'),('ccb2a572-21b7-47c6-a0a3-409db4730df8','djje','3'),('92364ffa-9e4b-45a2-aeb4-64fa43da714a','bfb1','3'),('92364ffa-9e4b-45a2-aeb4-64fa43da714a','zh','3'),('92364ffa-9e4b-45a2-aeb4-64fa43da714a','yfksj','2013-07-31'),('92364ffa-9e4b-45a2-aeb4-64fa43da714a','jiadianhua','3'),('92364ffa-9e4b-45a2-aeb4-64fa43da714a','bfb5','3'),('92364ffa-9e4b-45a2-aeb4-64fa43da714a','bfb4','3'),('92364ffa-9e4b-45a2-aeb4-64fa43da714a','bfb3','3'),('92364ffa-9e4b-45a2-aeb4-64fa43da714a','yikaifuhang','3'),('92364ffa-9e4b-45a2-aeb4-64fa43da714a','bfb2','3'),('92364ffa-9e4b-45a2-aeb4-64fa43da714a','kfhmc','3'),('92364ffa-9e4b-45a2-aeb4-64fa43da714a','yfkze','3'),('92364ffa-9e4b-45a2-aeb4-64fa43da714a','wcksj','2013-07-31'),('92364ffa-9e4b-45a2-aeb4-64fa43da714a','yiwtdlr','3'),('92364ffa-9e4b-45a2-aeb4-64fa43da714a','jiazhanghao','3'),('92364ffa-9e4b-45a2-aeb4-64fa43da714a','yizhanghong','33'),('92364ffa-9e4b-45a2-aeb4-64fa43da714a','jineheji','3'),('92364ffa-9e4b-45a2-aeb4-64fa43da714a','wckkze','3'),('92364ffa-9e4b-45a2-aeb4-64fa43da714a','yifrdb','3'),('92364ffa-9e4b-45a2-aeb4-64fa43da714a','jiayoubian','3'),('92364ffa-9e4b-45a2-aeb4-64fa43da714a','jiawtdlr','3'),('92364ffa-9e4b-45a2-aeb4-64fa43da714a','yesj','2013-07-24'),('92364ffa-9e4b-45a2-aeb4-64fa43da714a','yeze','3'),('92364ffa-9e4b-45a2-aeb4-64fa43da714a','shuliangheji','3'),('92364ffa-9e4b-45a2-aeb4-64fa43da714a','zhmc','3'),('92364ffa-9e4b-45a2-aeb4-64fa43da714a','yidizhi',''),('92364ffa-9e4b-45a2-aeb4-64fa43da714a','djze','3'),('92364ffa-9e4b-45a2-aeb4-64fa43da714a','jiafrdb','3'),('92364ffa-9e4b-45a2-aeb4-64fa43da714a','djsj','2013-07-30'),('92364ffa-9e4b-45a2-aeb4-64fa43da714a','wckje','3'),('92364ffa-9e4b-45a2-aeb4-64fa43da714a','yeje','3'),('92364ffa-9e4b-45a2-aeb4-64fa43da714a','yidianhua','3'),('92364ffa-9e4b-45a2-aeb4-64fa43da714a','jiadizhi',''),('92364ffa-9e4b-45a2-aeb4-64fa43da714a','yiachuanzhen','3'),('92364ffa-9e4b-45a2-aeb4-64fa43da714a','jiakaifuhang','3'),('92364ffa-9e4b-45a2-aeb4-64fa43da714a','yfkje','3'),('92364ffa-9e4b-45a2-aeb4-64fa43da714a','yiyoubian','3'),('92364ffa-9e4b-45a2-aeb4-64fa43da714a','jiachuanzhen','3'),('92364ffa-9e4b-45a2-aeb4-64fa43da714a','djje','3'),('a9683d7f-fed6-41b4-b16d-475983dbab57','bfb1','12'),('a9683d7f-fed6-41b4-b16d-475983dbab57','zh','12121212'),('a9683d7f-fed6-41b4-b16d-475983dbab57','yfksj','2013-07-29'),('a9683d7f-fed6-41b4-b16d-475983dbab57','jiadianhua','333333333'),('a9683d7f-fed6-41b4-b16d-475983dbab57','bfb5','33'),('a9683d7f-fed6-41b4-b16d-475983dbab57','bfb4','33'),('a9683d7f-fed6-41b4-b16d-475983dbab57','bfb3','23'),('a9683d7f-fed6-41b4-b16d-475983dbab57','yikaifuhang','33333333333'),('a9683d7f-fed6-41b4-b16d-475983dbab57','bfb2','13'),('a9683d7f-fed6-41b4-b16d-475983dbab57','kfhmc','12121212'),('a9683d7f-fed6-41b4-b16d-475983dbab57','yfkze','123'),('a9683d7f-fed6-41b4-b16d-475983dbab57','wcksj','2013-07-30'),('a9683d7f-fed6-41b4-b16d-475983dbab57','yiwtdlr','33333333333'),('a9683d7f-fed6-41b4-b16d-475983dbab57','jiazhanghao','33333333333'),('a9683d7f-fed6-41b4-b16d-475983dbab57','yizhanghong','1212'),('a9683d7f-fed6-41b4-b16d-475983dbab57','jineheji','403596.00'),('a9683d7f-fed6-41b4-b16d-475983dbab57','wckkze','23'),('a9683d7f-fed6-41b4-b16d-475983dbab57','yifrdb','333333333'),('a9683d7f-fed6-41b4-b16d-475983dbab57','jiayoubian','33333333'),('a9683d7f-fed6-41b4-b16d-475983dbab57','jiawtdlr','333333333'),('a9683d7f-fed6-41b4-b16d-475983dbab57','yesj','2013-08-06'),('a9683d7f-fed6-41b4-b16d-475983dbab57','yeze','23'),('a9683d7f-fed6-41b4-b16d-475983dbab57','shuliangheji','333.0'),('a9683d7f-fed6-41b4-b16d-475983dbab57','zhmc','121212'),('a9683d7f-fed6-41b4-b16d-475983dbab57','yidizhi','12vvvv'),('a9683d7f-fed6-41b4-b16d-475983dbab57','djze','123'),('a9683d7f-fed6-41b4-b16d-475983dbab57','jiafrdb','33333333333'),('a9683d7f-fed6-41b4-b16d-475983dbab57','djsj','2013-07-30'),('a9683d7f-fed6-41b4-b16d-475983dbab57','wckje','23'),('a9683d7f-fed6-41b4-b16d-475983dbab57','yeje','23'),('a9683d7f-fed6-41b4-b16d-475983dbab57','yidianhua','3333312333'),('a9683d7f-fed6-41b4-b16d-475983dbab57','jiadizhi','1212'),('a9683d7f-fed6-41b4-b16d-475983dbab57','yiachuanzhen','3333333333'),('a9683d7f-fed6-41b4-b16d-475983dbab57','jiakaifuhang','3333333333333333'),('a9683d7f-fed6-41b4-b16d-475983dbab57','yfkje','13'),('a9683d7f-fed6-41b4-b16d-475983dbab57','yiyoubian','3333333333'),('a9683d7f-fed6-41b4-b16d-475983dbab57','jiachuanzhen','333333333'),('a9683d7f-fed6-41b4-b16d-475983dbab57','djje','1113'),('22f9acca-2637-44f8-8140-e93f19090854','bfb1','12'),('22f9acca-2637-44f8-8140-e93f19090854','zh','3'),('22f9acca-2637-44f8-8140-e93f19090854','yfksj','2013-07-31'),('22f9acca-2637-44f8-8140-e93f19090854','jiadianhua',''),('22f9acca-2637-44f8-8140-e93f19090854','bfb5','3'),('22f9acca-2637-44f8-8140-e93f19090854','bfb4','12'),('22f9acca-2637-44f8-8140-e93f19090854','bfb3','12'),('22f9acca-2637-44f8-8140-e93f19090854','yikaifuhang',''),('22f9acca-2637-44f8-8140-e93f19090854','bfb2','13'),('22f9acca-2637-44f8-8140-e93f19090854','kfhmc','33'),('22f9acca-2637-44f8-8140-e93f19090854','yfkze','223'),('22f9acca-2637-44f8-8140-e93f19090854','wcksj','2013-07-31'),('22f9acca-2637-44f8-8140-e93f19090854','yiwtdlr',''),('22f9acca-2637-44f8-8140-e93f19090854','jiazhanghao',''),('22f9acca-2637-44f8-8140-e93f19090854','yizhanghong',''),('22f9acca-2637-44f8-8140-e93f19090854','jineheji','759.00'),('22f9acca-2637-44f8-8140-e93f19090854','wckkze','3'),('22f9acca-2637-44f8-8140-e93f19090854','yifrdb',''),('22f9acca-2637-44f8-8140-e93f19090854','jiayoubian',''),('22f9acca-2637-44f8-8140-e93f19090854','jiawtdlr',''),('22f9acca-2637-44f8-8140-e93f19090854','yesj','2013-07-18'),('22f9acca-2637-44f8-8140-e93f19090854','yeze','1'),('22f9acca-2637-44f8-8140-e93f19090854','shuliangheji','23.0'),('22f9acca-2637-44f8-8140-e93f19090854','zhmc','3'),('22f9acca-2637-44f8-8140-e93f19090854','yidizhi',''),('22f9acca-2637-44f8-8140-e93f19090854','djze','23'),('22f9acca-2637-44f8-8140-e93f19090854','jiafrdb',''),('22f9acca-2637-44f8-8140-e93f19090854','djsj','2013-07-31'),('22f9acca-2637-44f8-8140-e93f19090854','wckje','33'),('22f9acca-2637-44f8-8140-e93f19090854','yeje','2'),('22f9acca-2637-44f8-8140-e93f19090854','yidianhua',''),('22f9acca-2637-44f8-8140-e93f19090854','jiadizhi','33'),('22f9acca-2637-44f8-8140-e93f19090854','yiachuanzhen',''),('22f9acca-2637-44f8-8140-e93f19090854','jiakaifuhang',''),('22f9acca-2637-44f8-8140-e93f19090854','yfkje','332'),('22f9acca-2637-44f8-8140-e93f19090854','yiyoubian',''),('22f9acca-2637-44f8-8140-e93f19090854','jiachuanzhen',''),('22f9acca-2637-44f8-8140-e93f19090854','djje','3'),('21cb071e-4019-4d9f-a3f9-8d2e73121c84','bfb1','3'),('21cb071e-4019-4d9f-a3f9-8d2e73121c84','zh','33'),('21cb071e-4019-4d9f-a3f9-8d2e73121c84','yfksj','2013-07-31'),('21cb071e-4019-4d9f-a3f9-8d2e73121c84','jiadianhua','asdf'),('21cb071e-4019-4d9f-a3f9-8d2e73121c84','bfb5','3'),('21cb071e-4019-4d9f-a3f9-8d2e73121c84','bfb4','3'),('21cb071e-4019-4d9f-a3f9-8d2e73121c84','bfb3','3'),('21cb071e-4019-4d9f-a3f9-8d2e73121c84','yikaifuhang','sdafasd'),('21cb071e-4019-4d9f-a3f9-8d2e73121c84','bfb2','2'),('21cb071e-4019-4d9f-a3f9-8d2e73121c84','kfhmc','33'),('21cb071e-4019-4d9f-a3f9-8d2e73121c84','yfkze','3'),('21cb071e-4019-4d9f-a3f9-8d2e73121c84','wcksj','2013-07-31'),('21cb071e-4019-4d9f-a3f9-8d2e73121c84','yiwtdlr','asdf'),('21cb071e-4019-4d9f-a3f9-8d2e73121c84','jiazhanghao','sadfasdf'),('21cb071e-4019-4d9f-a3f9-8d2e73121c84','yizhanghong','fsadf'),('21cb071e-4019-4d9f-a3f9-8d2e73121c84','jineheji','69.00'),('21cb071e-4019-4d9f-a3f9-8d2e73121c84','wckkze','3'),('21cb071e-4019-4d9f-a3f9-8d2e73121c84','yifrdb','asdf'),('21cb071e-4019-4d9f-a3f9-8d2e73121c84','jiayoubian','fasdf'),('21cb071e-4019-4d9f-a3f9-8d2e73121c84','jiawtdlr','asdfasdf'),('21cb071e-4019-4d9f-a3f9-8d2e73121c84','yesj','2013-07-31'),('21cb071e-4019-4d9f-a3f9-8d2e73121c84','yeze','3'),('21cb071e-4019-4d9f-a3f9-8d2e73121c84','shuliangheji','23.0'),('21cb071e-4019-4d9f-a3f9-8d2e73121c84','zhmc','333'),('21cb071e-4019-4d9f-a3f9-8d2e73121c84','yidizhi','asdfasdf'),('21cb071e-4019-4d9f-a3f9-8d2e73121c84','djze','23'),('21cb071e-4019-4d9f-a3f9-8d2e73121c84','jiafrdb','asdf'),('21cb071e-4019-4d9f-a3f9-8d2e73121c84','djsj','2013-07-31'),('21cb071e-4019-4d9f-a3f9-8d2e73121c84','wckje','3'),('21cb071e-4019-4d9f-a3f9-8d2e73121c84','yeje','3'),('21cb071e-4019-4d9f-a3f9-8d2e73121c84','yidianhua','sdaf'),('21cb071e-4019-4d9f-a3f9-8d2e73121c84','jiadizhi','asdfasdf'),('21cb071e-4019-4d9f-a3f9-8d2e73121c84','yiachuanzhen','sadfasdf'),('21cb071e-4019-4d9f-a3f9-8d2e73121c84','jiakaifuhang','asdfasd'),('21cb071e-4019-4d9f-a3f9-8d2e73121c84','yfkje','3'),('21cb071e-4019-4d9f-a3f9-8d2e73121c84','yiyoubian','asdf'),('21cb071e-4019-4d9f-a3f9-8d2e73121c84','jiachuanzhen','asdfasdf'),('21cb071e-4019-4d9f-a3f9-8d2e73121c84','djje','32'),('efc8eef3-501e-4271-83ae-07b870f5d2cf','bfb1','23'),('efc8eef3-501e-4271-83ae-07b870f5d2cf','zh','33333333333'),('efc8eef3-501e-4271-83ae-07b870f5d2cf','yfksj','2013-07-23'),('efc8eef3-501e-4271-83ae-07b870f5d2cf','jiadianhua','3'),('efc8eef3-501e-4271-83ae-07b870f5d2cf','bfb5','3'),('efc8eef3-501e-4271-83ae-07b870f5d2cf','bfb4','3'),('efc8eef3-501e-4271-83ae-07b870f5d2cf','bfb3','3'),('efc8eef3-501e-4271-83ae-07b870f5d2cf','yikaifuhang','333'),('efc8eef3-501e-4271-83ae-07b870f5d2cf','bfb2','2'),('efc8eef3-501e-4271-83ae-07b870f5d2cf','kfhmc','3'),('efc8eef3-501e-4271-83ae-07b870f5d2cf','yfkze','3'),('efc8eef3-501e-4271-83ae-07b870f5d2cf','wcksj','2013-07-30'),('efc8eef3-501e-4271-83ae-07b870f5d2cf','yiwtdlr','3'),('efc8eef3-501e-4271-83ae-07b870f5d2cf','jiazhanghao','33'),('efc8eef3-501e-4271-83ae-07b870f5d2cf','yizhanghong','3333333'),('efc8eef3-501e-4271-83ae-07b870f5d2cf','jineheji','999.00'),('efc8eef3-501e-4271-83ae-07b870f5d2cf','wckkze','333'),('efc8eef3-501e-4271-83ae-07b870f5d2cf','yifrdb','3'),('efc8eef3-501e-4271-83ae-07b870f5d2cf','jiayoubian','3'),('efc8eef3-501e-4271-83ae-07b870f5d2cf','jiawtdlr','3'),('efc8eef3-501e-4271-83ae-07b870f5d2cf','yesj','2013-07-08'),('efc8eef3-501e-4271-83ae-07b870f5d2cf','yeze','33'),('efc8eef3-501e-4271-83ae-07b870f5d2cf','shuliangheji','333.0'),('efc8eef3-501e-4271-83ae-07b870f5d2cf','zhmc','3333'),('efc8eef3-501e-4271-83ae-07b870f5d2cf','yidizhi','3'),('efc8eef3-501e-4271-83ae-07b870f5d2cf','djze','3'),('efc8eef3-501e-4271-83ae-07b870f5d2cf','jiafrdb','3'),('efc8eef3-501e-4271-83ae-07b870f5d2cf','djsj','2013-07-31'),('efc8eef3-501e-4271-83ae-07b870f5d2cf','wckje','33'),('efc8eef3-501e-4271-83ae-07b870f5d2cf','yeje','3'),('efc8eef3-501e-4271-83ae-07b870f5d2cf','yidianhua','3'),('efc8eef3-501e-4271-83ae-07b870f5d2cf','jiadizhi','3'),('efc8eef3-501e-4271-83ae-07b870f5d2cf','yiachuanzhen','3'),('efc8eef3-501e-4271-83ae-07b870f5d2cf','jiakaifuhang','333'),('efc8eef3-501e-4271-83ae-07b870f5d2cf','yfkje','3'),('efc8eef3-501e-4271-83ae-07b870f5d2cf','yiyoubian','3'),('efc8eef3-501e-4271-83ae-07b870f5d2cf','jiachuanzhen','3'),('efc8eef3-501e-4271-83ae-07b870f5d2cf','djje','3');
/*!40000 ALTER TABLE `t_agreement_ext` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_agreement_item`
--

DROP TABLE IF EXISTS `t_agreement_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_agreement_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pcode` varchar(50) DEFAULT NULL,
  `proid` int(11) DEFAULT NULL,
  `shuliang` int(11) DEFAULT NULL,
  `danjia` int(11) DEFAULT NULL,
  `xiaoji` int(11) DEFAULT NULL,
  `jhsj` date DEFAULT NULL,
  `jhdd` varchar(256) DEFAULT NULL,
  `jflxr` varchar(56) DEFAULT NULL,
  `lxdh` varchar(20) DEFAULT NULL,
  `bz` varchar(2048) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_agreement_item`
--

LOCK TABLES `t_agreement_item` WRITE;
/*!40000 ALTER TABLE `t_agreement_item` DISABLE KEYS */;
INSERT INTO `t_agreement_item` VALUES (55,'a9683d7f-fed6-41b4-b16d-475983dbab57',99,333,1212,403596,'2013-07-30','12','3333','3333','3333'),(58,'22f9acca-2637-44f8-8140-e93f19090854',99,23,33,759,'2013-07-31','2323','333','33','333'),(59,'21cb071e-4019-4d9f-a3f9-8d2e73121c84',99,23,3,69,'2013-07-31','asdf','asdf','asdf','asdf'),(61,'efc8eef3-501e-4271-83ae-07b870f5d2cf',99,333,3,999,'2013-07-31','3','3333333','3333333','3');
/*!40000 ALTER TABLE `t_agreement_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_atta`
--

DROP TABLE IF EXISTS `t_atta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_atta` (
  `attaid` varchar(100) NOT NULL,
  `attaname` varchar(255) DEFAULT NULL,
  `newname` varchar(255) DEFAULT NULL,
  `contcode` varchar(100) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  PRIMARY KEY (`attaid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_atta`
--

LOCK TABLES `t_atta` WRITE;
/*!40000 ALTER TABLE `t_atta` DISABLE KEYS */;
INSERT INTO `t_atta` VALUES ('07af7d2c-f836-4333-94c6-0dee3b37cff2','Blue hills.jpg','07af7d2c-f836-4333-94c6-0dee3b37cff2.jpg','6add57c2-5550-4d74-9bc8-d8d4cbcdc5cc',800,600),('0d17347a-985f-4bc7-b086-ab5ef760d3f9','Winter.jpg','0d17347a-985f-4bc7-b086-ab5ef760d3f9.jpg','c208a729-6d1f-419c-907a-d4a8334c538d',800,600),('0ddf8de8-e1b9-4b95-975d-12fc63bdfd42','Blue hills.jpg','0ddf8de8-e1b9-4b95-975d-12fc63bdfd42.jpg','dd56c37c-81ac-42d3-9c06-13f8e8d4a54b',800,600),('1bd16412-2dc8-41aa-9ef0-42cad49e45e0','Winter.jpg','1bd16412-2dc8-41aa-9ef0-42cad49e45e0.jpg','c2f818ae-a597-4139-9535-415e77c82c0e',800,600),('1c27ccc8-3fd4-4003-923b-a4218685a1a5','table.html','1c27ccc8-3fd4-4003-923b-a4218685a1a5.html','9294c57e-edcd-4972-aaeb-d9bacb27a069',NULL,NULL),('22650a25-f856-4076-8f35-faad26315cd7','Sunset.jpg','22650a25-f856-4076-8f35-faad26315cd7.jpg','c4bbbd23-b974-4e1c-add6-9bf8a391d5b0',800,600),('2713e16c-eca6-4344-ad65-f130b0e2aba5','1337320778093.xls','2713e16c-eca6-4344-ad65-f130b0e2aba5.xls','83b4b46f-3f43-47e2-9f06-ba80a28fcd6e',0,0),('28ccd2df-2549-4827-89eb-8a0e4d9bb1e8','70283B5A76F3.jpg','28ccd2df-2549-4827-89eb-8a0e4d9bb1e8.jpg','e072eb3b-8cb7-4915-a500-e55141319549',500,331),('2a8839b3-d2f0-40c0-8d36-8040f295cc61','pic2.jpg','2a8839b3-d2f0-40c0-8d36-8040f295cc61.jpg','4c28af73-2f68-4331-95b3-225a601def92',800,533),('2d40f77b-cb51-4c13-91a5-6fb4ed4cea4b','{DE55A2F0-CB91-4E88-87AD-F6099783F765}.png','2d40f77b-cb51-4c13-91a5-6fb4ed4cea4b.png','',498,445),('30df85f1-727d-4935-99c8-82edac313c16','数据备份.bat','30df85f1-727d-4935-99c8-82edac313c16.bat','ba67a35f-c057-45a2-93e5-834547566f6b',NULL,NULL),('31fded39-a73d-4b8d-85d5-4d5195bb2412','ccccccccc.xls','31fded39-a73d-4b8d-85d5-4d5195bb2412.xls','83b4b46f-3f43-47e2-9f06-ba80a28fcd6e',0,0),('33ca1d69-be5a-433d-a21a-0b4df46bdab1','图片2.emf','33ca1d69-be5a-433d-a21a-0b4df46bdab1.emf','',0,0),('34ebd0ed-c015-4210-9dbf-e0c92503f6df','sssssssssssss3.jpg','34ebd0ed-c015-4210-9dbf-e0c92503f6df.jpg','ba602d6d-dc0a-4894-afd9-ad26fec41dcb',464,543),('3531e8c5-1af1-4417-a289-c05900cffc23','Tulips.jpg','3531e8c5-1af1-4417-a289-c05900cffc23.jpg','74637d8f-6ba1-4ecf-b076-5b70531957e6',1024,768),('355f4d85-3c76-473e-a51f-20231431eb9b','Winter.jpg','355f4d85-3c76-473e-a51f-20231431eb9b.jpg','1dcaf777-cd0d-4cf7-a5c9-660dffe2ab14',800,600),('39658325-9eba-4492-8ee0-93e75b78066a','NCC定制内容.xls','39658325-9eba-4492-8ee0-93e75b78066a.xls','e072eb3b-8cb7-4915-a500-e55141319549',0,0),('3cff4404-2a15-4dae-b314-2d4cc4207f34','jl简历.docx','3cff4404-2a15-4dae-b314-2d4cc4207f34.docx','12fff9f4-30c9-4f58-b8b0-31fc6180acc7',NULL,NULL),('3df6dd51-cdf5-4fee-bbf7-d4f80ade57d1','Water lilies.jpg','3df6dd51-cdf5-4fee-bbf7-d4f80ade57d1.jpg','a66304e1-72af-48a2-8419-d376ca68fa8b',800,600),('3ea3d8eb-51e6-46f0-9469-9943a124b79f','99ab5d64-96a3-4776-8526-4f6e9961e747.png','3ea3d8eb-51e6-46f0-9469-9943a124b79f.png','8d53d2c4-b1fd-46be-957b-3a07729f2fca',498,445),('3ed47636-7933-4784-80fe-c1849a0ff763','BatchImportVOD_zh.xls','3ed47636-7933-4784-80fe-c1849a0ff763.xls','83b4b46f-3f43-47e2-9f06-ba80a28fcd6e',0,0),('42726f75-08be-44ff-a07c-f187afda6dee','Winter.jpg','42726f75-08be-44ff-a07c-f187afda6dee.jpg','20e6e456-1a40-44ae-ad8c-4cefe59b2758',800,600),('452912e9-426f-4651-b243-0196cf45e849','70283B5A76F3.jpg','452912e9-426f-4651-b243-0196cf45e849.jpg','cab32363-0158-473f-b6cad-f3ac5cddde20',500,331),('46df2469-b244-496a-a6d5-a6334d7c8058','Winter.jpg','46df2469-b244-496a-a6d5-a6334d7c8058.jpg','da949dec-28c3-45ce-8f52-04f558f4262f',800,600),('472d98bd-05f5-4fd7-bd65-11d6cda2c4bd','112.jpg','472d98bd-05f5-4fd7-bd65-11d6cda2c4bd.jpg','98e2c5df-0edf-463c-aef1-a7e40964e983',NULL,NULL),('4c1fc653-7a6f-43c7-b6cc-694c7966d5cf','Sunset.jpg','4c1fc653-7a6f-43c7-b6cc-694c7966d5cf.jpg','ed589a24-b9a0-4739-9471-2ff071f4e949',800,600),('4fe63842-1f0f-424f-9390-ba66851a1a34','slider_pic1.jpg','4fe63842-1f0f-424f-9390-ba66851a1a34.jpg','a6b636e7-70b5-4f3a-8afb-667a099a12c3',960,420),('54f9ae31-52b7-4602-bcab-067553385a16','resume.docx','54f9ae31-52b7-4602-bcab-067553385a16.docx','089caedb-090a-44ef-bd33-0210d0696649',0,0),('55c7d071-24bb-4639-b26c-cc5e9ee919d7','Winter.jpg','55c7d071-24bb-4639-b26c-cc5e9ee919d7.jpg','c6ce5723-604a-4ceb-a263-b75244b09974',800,600),('56b64396-6109-4a29-8c78-e7ae605b0d17','3-12.doc','56b64396-6109-4a29-8c78-e7ae605b0d17.doc','e072eb3b-8cb7-4915-a500-e55141319549',0,0),('5700353a-b68a-4704-8231-ba9fbafbbde2','2012.jpg','5700353a-b68a-4704-8231-ba9fbafbbde2.jpg','8b7c1347-6eea-4e63-9800-75d7ea5621ea',145,220),('64ad6d31-dc26-4452-abb8-a2988c5db51a','IE7图片不能预览问题.txt','64ad6d31-dc26-4452-abb8-a2988c5db51a.txt','a7ad579a-b8ed-4636-b5ce-b6909ad990cd',NULL,NULL),('65569b2c-fc48-453c-88c7-b66f77206918','Desert.jpg','65569b2c-fc48-453c-88c7-b66f77206918.jpg','e73fd679-3f93-44e7-b395-ecf18c301d1b',1024,768),('6ab8e539-672b-425a-9e0a-e838fe0b3492','新建 Microsoft Office Excel 工作表.xlsx','6ab8e539-672b-425a-9e0a-e838fe0b3492.xlsx','dd8b7d6b-c553-45f6-b65f-ff88b1289230',NULL,NULL),('6bf4b9a2-9c57-417f-8e78-4d11cbc32df6','Chrysanthemum.jpg','6bf4b9a2-9c57-417f-8e78-4d11cbc32df6.jpg','b214acb8-e329-4fb0-ac30-092da204fc1f',1024,768),('725ecbb2-f3cf-4b40-a7e7-16eedf7c0ab7','Winter.jpg','725ecbb2-f3cf-4b40-a7e7-16eedf7c0ab7.jpg','aa428fdc-fb31-4293-a9da-ab63114c2c95',800,600),('73611b71-826e-4325-9acb-b4f3bedd0bcb','BatchImportVOD_zh.xls','73611b71-826e-4325-9acb-b4f3bedd0bcb.xls','83b4b46f-3f43-47e2-9f06-ba80a28fcd6e',0,0),('75fcf593-a292-4a74-939e-f38a28e0e666','1.jpg','75fcf593-a292-4a74-939e-f38a28e0e666.jpg','83b4b46f-3f43-47e2-9f06-ba80a28fcd6e',759,696),('761b40f1-bac5-4021-bbee-0af5beb0a7e8','Tulips.jpg','761b40f1-bac5-4021-bbee-0af5beb0a7e8.jpg','74637d8f-6ba1-4ecf-b076-5b70531957e6',1024,768),('7b1ff0a6-f19b-407b-8645-1a28cc76c76b','图片1.emf','7b1ff0a6-f19b-407b-8645-1a28cc76c76b.emf','',0,0),('7da5bdf1-29d7-48b0-bfd7-4e13fecb6b57','slider_pic2.jpg','7da5bdf1-29d7-48b0-bfd7-4e13fecb6b57.jpg','b741eea7-bfc0-442b-a7c4-95ca8d3d65ad',960,420),('81d4f443-eb7a-452f-8604-b43aeb49cf85','smoothtaste.css','81d4f443-eb7a-452f-8604-b43aeb49cf85.css','9294c57e-edcd-4972-aaeb-d9bacb27a069',NULL,NULL),('82d8ca3a-0772-4c6f-8a77-ee0e3ec8cb82','tapmodo-Jcrop-v0.9.10-8-gd8d0ed8.zip','82d8ca3a-0772-4c6f-8a77-ee0e3ec8cb82.9.10-8-gd8d0ed8.zip','026c2a08-e69c-4a44-a349-19f219b2ccc5',0,0),('8aa189c5-0576-481c-89e5-3e1bea7ca271','3-12.doc','8aa189c5-0576-481c-89e5-3e1bea7ca271.doc','e072eb3b-8cb7-4915-a500-e55141319549',0,0),('8dcccf6e-ea10-4507-91cd-278e6e2284a0','{DE55A2F0-CB91-4E88-87AD-F6099783F765}.png','8dcccf6e-ea10-4507-91cd-278e6e2284a0.png','83b4b46f-3f43-47e2-9f06-ba80a28fcd6e',498,445),('91ae45b5-117a-4918-9d40-80e896242caa','新建 Microsoft Office PowerPoint 演示文稿.pptx','91ae45b5-117a-4918-9d40-80e896242caa.pptx','ac7333f9-9259-4313-803b-bf9169866e61',NULL,NULL),('923a8c16-dedd-4a97-acc1-19fb4c868203','Blue hills.jpg','923a8c16-dedd-4a97-acc1-19fb4c868203.jpg','d7b3cfe0-1a4c-4eed-87cc-978038b3a0cf',800,600),('946bb806-13ca-4ee8-82d5-391a39225cbd','T2J3DcXltXXXXXXXXX_!!651632640.jpg','946bb806-13ca-4ee8-82d5-391a39225cbd.jpg','c1299bfe-abd9-4373-9eba-ca9f3e20acc7',750,800),('949eff5e-a72a-44a4-864a-7409e42e5d1e','beijing.jpg','949eff5e-a72a-44a4-864a-7409e42e5d1e.jpg','',1024,727),('998c2d6a-645e-4048-8bc8-a589c55219f5','3-12.doc','998c2d6a-645e-4048-8bc8-a589c55219f5.doc','e072eb3b-8cb7-4915-a500-e55141319549',0,0),('99ab5d64-96a3-4776-8526-4f6e9961e747','{DE55A2F0-CB91-4E88-87AD-F6099783F765}.png','99ab5d64-96a3-4776-8526-4f6e9961e747.png','83b4b46f-3f43-47e2-9f06-ba80a28fcd6e',498,445),('9a793173-6237-40d4-89aa-c47b38872905','Tulips.jpg','9a793173-6237-40d4-89aa-c47b38872905.jpg','3de02ec6-b5e6-46be-b0e2-763c6b9880a7',1024,768),('9d81b0a8-2c3b-4912-9fcb-8db1a383e4b5','1.jpg','9d81b0a8-2c3b-4912-9fcb-8db1a383e4b5.jpg','e1dd4c43-4303-4491-aede-be4688697600',NULL,NULL),('a0fe02db-ee78-4732-8b77-b8bf21c0003c','pic4.jpg','a0fe02db-ee78-4732-8b77-b8bf21c0003c.jpg','21cb071e-4019-4d9f-a3f9-8d2e73121c84',750,500),('a1172d38-09ac-4d05-aa02-555ae665af02','2012年度绩效考核表-BGHW（IPTV）.xlsx','a1172d38-09ac-4d05-aa02-555ae665af02.xlsx','62943ed6-fc54-4f39-85c7-208c1a465252',0,0),('a3962fbd-28d5-4a8b-a00e-200ec4744191','Blue hills.jpg','a3962fbd-28d5-4a8b-a00e-200ec4744191.jpg','04751671-5298-44f7-b382-9ac91b3c866a',800,600),('a44c93c2-4675-40ff-b27a-bf10196d72be','新建 Microsoft Office PowerPoint 演示文稿.pptx','a44c93c2-4675-40ff-b27a-bf10196d72be.pptx','a7ad579a-b8ed-4636-b5ce-b6909ad990cd',NULL,NULL),('a62bcfaa-7fcf-473c-9b3b-87b1fec9e48f','ORACLE性能AWR报告的使用和分析(2).docx','a62bcfaa-7fcf-473c-9b3b-87b1fec9e48f.docx','34ebd0ed-c015-4210-9dbf-e0c92503f6df',0,0),('a6c88490-dfd9-46de-82d7-67cbea6acb84','beijing.jpg','a6c88490-dfd9-46de-82d7-67cbea6acb84.jpg','',1024,727),('ac343f9c-5ca5-489e-b48f-06ae63200379','新建 Microsoft Office PowerPoint 演示文稿.pptx','ac343f9c-5ca5-489e-b48f-06ae63200379.pptx','a7ad579a-b8ed-4636-b5ce-b6909ad990cd',NULL,NULL),('b0ec2ae5-5e8d-407b-8469-4795be9d21d1','新建 Microsoft Office Excel 工作表.xlsx','b0ec2ae5-5e8d-407b-8469-4795be9d21d1.xlsx','dd8b7d6b-c553-45f6-b65f-ff88b1289230',NULL,NULL),('b214acb8-e329-4fb0-ac30-092da204fc1f','Tulips.jpg','b214acb8-e329-4fb0-ac30-092da204fc1f.jpg','7ccd318a-43d2-4f29-86b2-b1f983068b98',1024,768),('b363da20-18b7-4897-a07e-5195ac239c69','beijing.jpg','b363da20-18b7-4897-a07e-5195ac239c69.jpg','',1024,727),('b8d0fec2-9cc4-4f21-9de7-101eae3d35eb','BatchImportSitcomItem_zh.xls','b8d0fec2-9cc4-4f21-9de7-101eae3d35eb.xls','83b4b46f-3f43-47e2-9f06-ba80a28fcd6e',0,0),('bafd0cbc-c784-466e-a3fd-739d29b73746','70283B5A76F3.jpg','bafd0cbc-c784-466e-a3fd-739d29b73746.jpg','dcaa8f25-da8f-4c89-80fd-1d7ccbe1dad1',500,331),('bb40a3f7-b12b-40f1-bc3e-4fe1a28a8677','beijing.jpg','bb40a3f7-b12b-40f1-bc3e-4fe1a28a8677.jpg','',1024,727),('c0183612-9532-4ad4-a5bb-f0a808144573','BatchImportVOD_zh.xls','c0183612-9532-4ad4-a5bb-f0a808144573.xls','83b4b46f-3f43-47e2-9f06-ba80a28fcd6e',0,0),('c3eddac6-b5dd-4943-ae48-a8c96282a31f','Sunset.jpg','c3eddac6-b5dd-4943-ae48-a8c96282a31f.jpg','2a24ffb4-37e2-4833-93f0-657bc700b47b',800,600),('c4c2426e-0dda-461e-9bda-5f8cc3547300','bg1.jpg','c4c2426e-0dda-461e-9bda-5f8cc3547300.jpg','efc8eef3-501e-4271-83ae-07b870f5d2cf',1490,645),('c934d2b6-1b37-461c-946a-ac7a83448990','Blue hills.jpg','c934d2b6-1b37-461c-946a-ac7a83448990.jpg','7ae96112-7dcd-4090-a4ae-6f061e2a5ab7',800,600),('cb4613c9-a68b-43ea-b24d-521388e2d1b0','Koala.jpg','cb4613c9-a68b-43ea-b24d-521388e2d1b0.jpg','9a793173-6237-40d4-89aa-c47b38872905',1024,768),('cc71a96d-f1fc-4e71-8899-c0329be2168f','pic3.jpg','cc71a96d-f1fc-4e71-8899-c0329be2168f.jpg','4de6ecac-4d53-4754-8e20-40c38410c4f3',850,567),('ce4a0cfc-5748-4a24-b9c1-154f54c1cc12','afd.jpg','ce4a0cfc-5748-4a24-b9c1-154f54c1cc12.jpg','83cf49d8-af87-4ace-b53f-9dc48431a7d5',245,350),('ce7287b5-ce43-4785-bfd7-3d09943d877b','1337320778093.xls','ce7287b5-ce43-4785-bfd7-3d09943d877b.xls','83b4b46f-3f43-47e2-9f06-ba80a28fcd6e',0,0),('d003212b-6dd3-46a3-8f3d-12f9e738de5d','T2zBe8XaVaXXXXXXXX_!!651632640.jpg','d003212b-6dd3-46a3-8f3d-12f9e738de5d.jpg','8c1ca3ff-3151-4f22-8cac-1ac87545f3ae',750,958),('d4cb825d-2adc-4918-9044-275533c8e353','Blue hills.jpg','d4cb825d-2adc-4918-9044-275533c8e353.jpg','7054f986-a629-4917-a3c0-a518baf31bad',800,600),('d7e61cfa-30b5-4e25-a4ff-59fc9fb9adfb','99ab5d64-96a3-4776-8526-4f6e9961e747.png','d7e61cfa-30b5-4e25-a4ff-59fc9fb9adfb.png','4297953b-aede-4a91-81f7-02a90b71a5b9',498,445),('d9079c29-fb03-4a11-ae7c-85851fb677c7','cms20121219.sql','d9079c29-fb03-4a11-ae7c-85851fb677c7.sql','f263af52-028b-424d-81a5-42cc2e78caf0',NULL,NULL),('dc5d172f-7d7a-4874-b3f6-318e108452da','Hydrangeas.jpg','dc5d172f-7d7a-4874-b3f6-318e108452da.jpg','',1024,768),('e072eb3b-8cb7-4915-a500-e55141319549','dddd.jpg','e072eb3b-8cb7-4915-a500-e55141319549.jpg','a39468d8-3e8b-4a3f-9ed8-c7db32543436',460,471),('e4af9eab-9ecb-4361-8933-5f821d2cc1ab','新建 Microsoft Office PowerPoint 演示文稿.pptx','e4af9eab-9ecb-4361-8933-5f821d2cc1ab.pptx','a5d768e7-2cd0-4273-a191-075212c7e5b4',NULL,NULL),('ed914d87-41d5-4057-8363-1f89cf7dc3b3','Sunset.jpg','ed914d87-41d5-4057-8363-1f89cf7dc3b3.jpg','74456bae-51aa-4f7b-b5c3-6eb205f07696',800,600),('f03aca04-e7dc-4557-af4c-ebfddc4cc4c4','新建 Microsoft Office Excel 工作表.xlsx','f03aca04-e7dc-4557-af4c-ebfddc4cc4c4.xlsx','a5d768e7-2cd0-4273-a191-075212c7e5b4',NULL,NULL),('f653b7f3-5d3b-498f-abde-e8f00e33d617','IE7图片不能预览问题.txt','f653b7f3-5d3b-498f-abde-e8f00e33d617.txt','a7ad579a-b8ed-4636-b5ce-b6909ad990cd',NULL,NULL),('f8eb4b61-4c0f-4dd8-a731-7985c6118620','{72A97D6B-0277-422A-9EED-E6A36B367BD9}.jpg','f8eb4b61-4c0f-4dd8-a731-7985c6118620.jpg','3084d8ee-3290-4adc-82ad-de6f769b379a',663,389),('fa2cdb18-546e-4b9d-81b8-4c0cb3abd097','Tulips.jpg','fa2cdb18-546e-4b9d-81b8-4c0cb3abd097.jpg','b214acb8-e329-4fb0-ac30-092da204fc1f',1024,768),('fec0edd8-97e3-4301-a060-17f6a246907c','HUAWEI IPTV 解决方案 广东 升级指导书.doc','fec0edd8-97e3-4301-a060-17f6a246907c.doc','d7e61cfa-30b5-4e25-a4ff-59fc9fb9adfb',0,0);
/*!40000 ALTER TABLE `t_atta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_bgimg`
--

DROP TABLE IF EXISTS `t_bgimg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_bgimg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `newname` varchar(256) DEFAULT NULL,
  `url` varchar(512) DEFAULT NULL,
  `sequ` int(4) DEFAULT '0',
  `descri` varchar(512) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_bgimg`
--

LOCK TABLES `t_bgimg` WRITE;
/*!40000 ALTER TABLE `t_bgimg` DISABLE KEYS */;
INSERT INTO `t_bgimg` VALUES (1,'默认背景','e49569e2-443c-4edf-9354-94f2813ff9fa.jpg',NULL,1,'默认背景','2013-06-25',1),(3,'国庆','763c3313-ac15-4c9e-a356-61f0a841dba8.jpg',NULL,0,'','2013-06-25',1),(4,'清晰','f88d1c69-15ea-4bc2-80f4-3efd9ca70bff.jpg',NULL,0,'','2013-06-25',1),(5,'默认','f5bb8a8e-ec04-46c2-9811-f38837bf00c4.jpg',NULL,1,'','2013-06-24',2),(6,'清晰','ddf6d73d-f62d-4f2d-9dbf-fafe3f3a5d94.jpg',NULL,0,'','2013-06-23',2);
/*!40000 ALTER TABLE `t_bgimg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_content`
--

DROP TABLE IF EXISTS `t_content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_content` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text,
  `createdate` date DEFAULT NULL,
  `typeid` int(1) DEFAULT NULL,
  `coopid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_content`
--

LOCK TABLES `t_content` WRITE;
/*!40000 ALTER TABLE `t_content` DISABLE KEYS */;
INSERT INTO `t_content` VALUES (1,'<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;中国.南京凯之渡信息技术有限公司，从事信息技术产品研发及服务业务。我们基于经验资源，关注全行业商机，立足高校，以人才为根本，以信息技术为手段，以文化创意为灵魂，以创新创业为目标，以孵化项目为赢利点，通过不断创新，图谋民族产品及服务素质的提高。<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 在人才培育方向，面向高等学府，优选大学生，通过实战项目研发，提供精英职业和创新创业孵化等服务。<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 在项目研发方向，面向行业企业，以企业云门户平台为基础，提供软件系统的定制研发和技术数据服务外包。<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 在创新孵化方向，主要关注移动互联、计电数码、生态农植以及各类社会商机，开展创意生产、项目实施、投资和管理运作，推行项目产品入市。</p>\r\n<p>&nbsp;</p>\r\n<p>&nbsp;</p>\r\n<p style=\"text-align: center\"><input src=\"/userfiles/image/ggjj.gif\" width=\"560\" height=\"373\" type=\"image\" longdesc=\"undefined\" /></p>','2013-04-02',NULL,NULL),(2,'<p style=\"text-align: center\"><img alt=\"\" width=\"732\" height=\"343\" src=\"/userfiles/image/zuzhijiegou-4.gif\" /></p>\r\n<p style=\"text-align: center\">&nbsp;</p>\r\n<p class=\"f14 STYLE8\" align=\"center\">我们基于联合资源，基于营运平台，合理构建人才、项目及孵化业务的机构配置。</p>\r\n<p class=\"f14 STYLE8\" align=\"center\">&nbsp;</p>\r\n<p class=\"f14 STYLE8\" align=\"center\">&nbsp;</p>','2013-04-02',NULL,NULL),(3,'<p><img alt=\"\" src=\"/userfiles/image/%E6%9C%8D%E5%8A%A1%E4%BD%93%E7%B3%BB(5).png\" /></p>\r\n<p class=\"STYLE15\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>\r\n<p class=\"STYLE15\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;我们立足完备的业务资源，提供一套完整的创新研发服务体系。从创意生产、人才培育，到项目研发以及产品经营，最终孵化推向市场。其中，项目研发和产品经营，主要指以信息技术为手段的线上研发，以及以管理运作为根本的线下经营。</p>\r\n<p class=\"STYLE15\">&nbsp;</p>','2013-04-02',NULL,NULL),(4,'<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input src=\"/userfiles/image/rc.gif\" width=\"320\" height=\"213\" type=\"image\" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input src=\"/userfiles/image/tc.gif\" width=\"320\" height=\"213\" type=\"image\" /></p>\r\n<p style=\"text-align: left\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;热诚，一种生命不息的热力。&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 坦诚，一种开阔视野的胸怀。</p>\r\n<p style=\"text-align: left\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>\r\n<p style=\"text-align: left\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input src=\"/userfiles/image/zc.gif\" width=\"320\" height=\"213\" type=\"image\" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input src=\"/userfiles/image/zec.gif\" width=\"320\" height=\"213\" type=\"image\" /></p>\r\n<p style=\"text-align: left\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 忠诚，一种目标坚定的执着。&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 真诚，一种人文涵养的品质。</p>','2013-04-02',NULL,NULL),(5,'<p>&nbsp;<span style=\"font-size: small;\"><strong><a href=\"http://www.can2do.com/platform\" target=\"_blank\">创新创业孵化技术平台</a>&gt;&gt;&gt;</strong></span></p>\r\n<p>&nbsp;</p>\r\n<p><span style=\"font-size: small;\"><strong><img width=\"159\" height=\"131\" alt=\"\" src=\"/userfiles/image/%E5%88%9B%E6%96%B0%E4%B8%AD%E5%BF%83(2).gif\" /><img width=\"159\" height=\"131\" alt=\"\" src=\"/userfiles/image/xmzx.gif\" /><img width=\"159\" height=\"131\" alt=\"\" src=\"/userfiles/image/rczx.gif\" /><img width=\"159\" height=\"131\" alt=\"\" src=\"/userfiles/image/zczx.gif\" /><img width=\"159\" height=\"131\" alt=\"\" src=\"/userfiles/image/zbzx.gif\" /></strong></span></p>\r\n<p><span style=\"font-size: small;\"><strong><img width=\"159\" height=\"130\" alt=\"\" src=\"/userfiles/image/hylm.gif\" /><img width=\"159\" height=\"130\" alt=\"\" src=\"/userfiles/image/zjlm.gif\" /><img width=\"159\" height=\"131\" alt=\"\" src=\"/userfiles/image/gjlm.gif\" /><img width=\"159\" height=\"130\" alt=\"\" src=\"/userfiles/image/yqlm.gif\" /><img width=\"159\" height=\"130\" alt=\"\" src=\"/userfiles/image/thlm.gif\" /></strong></span></p>\r\n<p>&nbsp;</p>\r\n<p>&nbsp;</p>\r\n<p>&nbsp;</p>','2013-04-02',NULL,NULL),(6,'<ol>\r\n    <li><a href=\"/coop/userfiles/file/slider_pic3.jpg\" target=\"_blank\">按时得发卅多发生地方&nbsp;</a></li>\r\n    <li><a href=\"/coop/userfiles/file/fck.rar\" target=\"_blank\">哀伤地发射多发送方</a></li>\r\n</ol>\r\n<p>&nbsp;</p>','2013-04-02',NULL,NULL),(7,'<p align=\"left\" class=\"STYLE7\">如图，Can2DO拥有一套完整的项目研发体系，包括：项目数据平台、项目管理平台、项目经营机制、项目软件系统平台。</p>\r\n<p align=\"left\" class=\"STYLE7\">项目类别主要包括：人才项目、研发项目、孵化项目三类。人才、研发，都是为孵化项目集聚资源实力。</p>\r\n<p align=\"left\" class=\"STYLE7\">项目所关注行业分别在：软件外包、教育科技、移动互联、计电数码、生态农植以及各类社会商机上。</p>\r\n<p align=\"left\" class=\"STYLE7\">其中近期主要孵化创新项目包括：</p>\r\n<p align=\"left\" class=\"STYLE7\">MeBUS:Mobile electronic BUSiness移动电子商务系统，侧重移动项目管理。</p>\r\n<p align=\"left\" class=\"STYLE7\">PAP：Pillar Audio Platform移动互联创意应用平台，侧重音讯内容服务。</p>\r\n<p>FDIN：Family Digital Intelligence  Network家庭数字智能网络的项目产品。</p>\r\n<p align=\"left\" class=\"STYLE7\">MMPro：Materia Medica Product本草品味国际生态产品平台，侧重中华本草文化特产传播。</p>\r\n<p align=\"left\" class=\"STYLE7\">DOCrystal:DO Crystal青奥水晶礼品平台，侧重水晶材质的企业文化礼品设计。</p>\r\n<p align=\"left\" class=\"STYLE7\">TBP：Treasure Bidding Platform珍宝竞价平台，侧重民间刺绣藏品的自由竞价分享。</p>\r\n<p align=\"left\" class=\"STYLE7\">无限商机，无限创意策划，凝聚在一个DO字上。</p>\r\n<p align=\"left\" class=\"STYLE7\"><img style=\"width: 756px; height: 1019px;\" alt=\"\" src=\"/userfiles/image/%E9%A1%B9%E7%9B%AE%E7%A0%94%E5%8F%91(1).png\" /></p>','2013-04-02',NULL,NULL),(8,'<p style=\"text-align: center;\"><strong><span style=\"font-size: medium;\">移动互联方向研发项目需要，热推&ldquo;移动互联软件开发人才培养产品&rdquo;</span></strong></p>\r\n<p><img width=\"800\" height=\"600\" alt=\"\" src=\"/userfiles/image/%E4%BA%BA%E6%89%8D%E5%9F%B9%E5%85%BB.png\" /></p>\r\n<table width=\"100%\" border=\"1\" style=\"font-size: 12px;\">\r\n    <tbody>\r\n        <tr>\r\n            <td width=\"13%\" height=\"30\"><a href=\"#a1\"><strong>为您&quot;职业规划&quot;</strong></a></td>\r\n            <td width=\"13%\"><a href=\"#a2\"><strong>为我&quot;物色人才&quot;</strong></a></td>\r\n            <td width=\"12%\"><a href=\"#a3\"><strong>为您&quot;量身定做&quot;</strong></a></td>\r\n            <td width=\"14%\"><a href=\"#a4\"><strong>一起&quot;研发项目&quot;</strong></a></td>\r\n            <td width=\"12%\"><a href=\"#a5\"><strong>一起&quot;经营产品&quot;</strong></a></td>\r\n            <td width=\"12%\"><a href=\"#a6\"><strong>为您&quot;创建公司&quot;</strong></a></td>\r\n            <td width=\"12%\"><a href=\"#a7\"><strong>共同&quot;缔造平台&quot;</strong></a></td>\r\n            <td width=\"12%\"><a href=\"#a8\"><strong>成就&quot;青春之舞&quot;</strong></a></td>\r\n        </tr>\r\n    </tbody>\r\n</table>\r\n<div data-layout=\"right\">\r\n<h2 style=\"text-align: left;\">如图为基于项目实战的人才培养工作流程(请在线邮件或电话咨询)：</h2>\r\n<h2 style=\"text-align: center;\"><input width=\"600\" height=\"400\" type=\"image\" src=\"/userfiles/image/ssscccc.gif\" /></h2>\r\n<div class=\"f14\">\r\n<p align=\"center\">人才，是项目研发的保障。实践，是成才的关键。</p>\r\n</div>\r\n<h2><a id=\"a1\" name=\"a1\">为您&quot;职业规划&quot;</a></h2>\r\n<p align=\"left\">一边是旺盛的行业人才需求；<br />\r\n一边是未经人世的莘莘学子； <br />\r\n一边是急需匆匆上马的战场；<br />\r\n一边是渴望高高飞翔的迷茫。</p>\r\n<p align=\"left\">我们需要专家指点迷津，分析潜力、定位去向。<br />\r\n我们需要师傅带路，汲取经验，快速实现梦想。</p>\r\n<p align=\"left\">就业也好，创业也罢，都是劳动的权利和责任。<br />\r\n世界属于未来，未来属于你们，我们伴您舞动。</p>\r\n<p align=\"left\">我们将为您提供免费的职业规划专题讲堂。敬请关注相关资讯发布。</p>\r\n<p align=\"left\">&nbsp;</p>\r\n<p align=\"left\">&nbsp;</p>\r\n</div>\r\n<div>\r\n<h2><a id=\"a2\" name=\"a2\">为我&quot;物色人才&quot;</a></h2>\r\n<p>我们依据研发项目的岗位需求，将面向高等院校，基于前期的职业规划引导，激发大学生精英就业和创新创业的志趣，物色精英和创业人才。我们物色人才的标准只有四个：<strong> 志向、潜力、人格和基础技能</strong>。</p>\r\n<p><em>详细项目岗位人才需求，参见招聘信息发布。</em></p>\r\n<p>&nbsp;</p>\r\n<p>&nbsp;</p>\r\n</div>\r\n<div>\r\n<h2><a id=\"a3\" name=\"a3\">为您&quot;量身定做&quot;</a></h2>\r\n<p>因材施教、因地制宜、天生我材必拥有、行行出状元等等说法，自古都因找到最适合自己人格、潜力和志趣的目标方向之后，努力而成就人才。</p>\r\n<p>即便是IT(Information Technology 信息技术)专业和行业，也并非全部是技术特质的职能要求。因此，在专家的指引下，量身定做，选择最适合自己的目标，尤为重要。我们的人才培养步调是：</p>\r\n<p>1-强化行业分析。 2-锁定发展目标。3-梳理系统知识。</p>\r\n<p>4-奠定实战基础。5-研发项目经验。6-研发产品价值。</p>\r\n<p>7-获取发展信心。8-高端定制就业。9-孵化创新创业。</p>\r\n<p>&nbsp;</p>\r\n<p>&nbsp;</p>\r\n</div>\r\n<div>\r\n<h2><a id=\"a4\" name=\"a4\">一起&quot;研发项目&quot;</a></h2>\r\n<p>我们以信息技术为基础，通过创意策划立项、外包项目承接以及自主平台研发等方面，配备针对性项目人才和研发资源。无论创意项目还是承接项目，我们的视野聚焦在：</p>\r\n<p>&gt;关注传统产业链的变革</p>\r\n<p>&gt;关注热点产业发展动向</p>\r\n<p>&gt;捕捉行业外包项目商机</p>\r\n<p>&gt;面向眼下灵活见效适应性项目策划实施</p>\r\n<p>&gt;面向未来制高生长点自主创新项目研发</p>\r\n<p>&nbsp;</p>\r\n<p>&nbsp;</p>\r\n</div>\r\n<div>\r\n<h2><a id=\"a5\" name=\"a5\">一起&quot;经营产品&quot;</a></h2>\r\n<p>基于我司主营业务，我们将依据信息技术，提供各类产品的经营服务。产品类别包括：</p>\r\n<p>&gt;教育科技信息系统产品：<br />\r\n精品资源共享课程、实验室管理系统、教学管理系统、综合数字化校园等。</p>\r\n<p>&gt;热点行业创新产品：<br />\r\n家庭智能数字网络、移动互联网络、生态环保网络等。</p>\r\n<p>&gt;传统行业持续整合应用产品：<br />\r\n电信、电力、金融、交通、水利等 。</p>\r\n<p>&gt;网络经济平台产品：<br />\r\n信息数据应用（采集、整理、流转、智能）平台等。</p>\r\n<p>我们将为您提供免费的职业规划专题讲堂。敬请关注相关资讯发布。</p>\r\n<p>&nbsp;</p>\r\n<p>&nbsp;</p>\r\n</div>\r\n<div data-layout=\"right\">\r\n<h2><a id=\"a6\" name=\"a6\">为您&quot;创建公司&quot;</a></h2>\r\n<p>我们面向大学生，面向杰出青年，利用经验资源，基于孵化平台，提供创新创业孵化服务。主要步骤包括：</p>\r\n<p>&gt;通过创意生产：引导创意立项。</p>\r\n<p>&gt;通过技术辅导：研发并管理创意项目。</p>\r\n<p>&gt;通过孵化平台：提供投资、营运管理等孵化服务，促成创业成功入市。</p>\r\n<p>&nbsp;</p>\r\n<h2><a id=\"a7\" name=\"a7\">共同&quot;缔造平台&quot;</a></h2>\r\n<p>基于高新政府园区资源孵化器之上，我们正构建一个孵化技术平台。该技术平台，侧重技术内容的孵化服务。</p>\r\n<p>主要特征包括：<br />\r\n1-流程化网络平台服务系统 。 <br />\r\n2-兼容性行业应用技术体系。<br />\r\n3-无限的企业网络营运空间。<br />\r\n4-一个强壮可信的创业舞台。</p>\r\n<p>只要您有梦，随我来炫舞！</p>\r\n</div>\r\n<p>&nbsp;</p>\r\n<div>\r\n<h2><a id=\"a8\" name=\"a8\">成就&quot;青春之舞&quot;</a></h2>\r\n<p>人生是个舞台，世界是个舞台，<br />\r\n这里，也是一个舞台，一个实现创业价值大舞台。</p>\r\n<p>80%的财富积聚在20%的精英手里，<br />\r\n20%的精英超越了80%的大众。机会是均等的。</p>\r\n<p>最绚烂的炫舞，不在成功的精英们手中，<br />\r\n而是在立志成为精英的优秀青年的脚上。</p>\r\n<p>来吧，让前辈们，以其历经的经验引领你、搀扶你，<br />\r\n快速、健康、有力舞动起来。</p>\r\n<p>我们将为您提供免费的职业规划专题讲堂。敬请关注相关资讯发布。</p>\r\n</div>\r\n<p>&nbsp;</p>','2013-04-02',NULL,NULL),(9,'<p style=\"padding-bottom: 0px; line-height: 19px; margin: 0px; outline-style: none; outline-color: invert; padding-left: 0px; outline-width: medium; padding-right: 0px; font-family: Tahoma, 宋体; color: rgb(82,82,82); font-size: 13px; padding-top: 0px\">公司名称： 中国.南京凯之渡信息技术有限公司</p>\r\n<p style=\"padding-bottom: 0px; line-height: 19px; margin: 0px; outline-style: none; outline-color: invert; padding-left: 0px; outline-width: medium; padding-right: 0px; font-family: Tahoma, 宋体; color: rgb(82,82,82); font-size: 13px; padding-top: 0px\">地 址： 江苏省南京市浦口高新开发区</p>\r\n<p style=\"padding-bottom: 0px; line-height: 19px; margin: 0px; outline-style: none; outline-color: invert; padding-left: 0px; outline-width: medium; padding-right: 0px; font-family: Tahoma, 宋体; color: rgb(82,82,82); font-size: 13px; padding-top: 0px\">电话号码： 025-58746698</p>\r\n<p style=\"padding-bottom: 0px; line-height: 19px; margin: 0px; outline-style: none; outline-color: invert; padding-left: 0px; outline-width: medium; padding-right: 0px; font-family: Tahoma, 宋体; color: rgb(82,82,82); font-size: 13px; padding-top: 0px\">传 真： 025-58746698</p>\r\n<p style=\"padding-bottom: 0px; line-height: 19px; margin: 0px; outline-style: none; outline-color: invert; padding-left: 0px; outline-width: medium; padding-right: 0px; font-family: Tahoma, 宋体; color: rgb(82,82,82); font-size: 13px; padding-top: 0px\">电子信箱：<a href=\"mailto:HR@can2do.com\">HR@can2do.com</a></p>\r\n<p style=\"padding-bottom: 0px; line-height: 19px; margin: 0px; outline-style: none; outline-color: invert; padding-left: 0px; outline-width: medium; padding-right: 0px; font-family: Tahoma, 宋体; color: rgb(82,82,82); font-size: 13px; padding-top: 0px\">网 址： http://www.can2do.com</p>\r\n<p style=\"padding-bottom: 0px; line-height: 19px; margin: 0px; outline-style: none; outline-color: invert; padding-left: 0px; outline-width: medium; padding-right: 0px; font-family: Tahoma, 宋体; color: rgb(82,82,82); font-size: 13px; padding-top: 0px\">Q Q 号 码： 18913007572</p>\r\n<p style=\"padding-bottom: 0px; line-height: 19px; margin: 0px; outline-style: none; outline-color: invert; padding-left: 0px; outline-width: medium; padding-right: 0px; font-family: Tahoma, 宋体; color: rgb(82,82,82); font-size: 13px; padding-top: 0px\">邮政编码 ： 210032</p>','2013-04-02',NULL,NULL),(10,'<p><span style=\"color: rgb(82, 82, 82); font-family: Tahoma, 宋体; font-size: 14px; line-height: 19px; \">&nbsp; &nbsp; &nbsp; &nbsp;中国.南京凯之渡信息技术有限公司，从事信息技术产品研发及服务业务。我们基于经验资源，关注全行业商机，立足高校， 以人才为根本，以信息技术为手段，以文化创意为灵魂，以创新创业为目标，以孵化项目为赢利点，通过不断创新， 图谋民族产品及服务素质的提高。</span></p>\r\n<p style=\"margin: 0px; padding: 0px; outline: none; color: rgb(82, 82, 82); font-family: Tahoma, 宋体; font-size: 13px; line-height: 19px; \">&nbsp;</p>','2013-04-02',NULL,NULL),(11,'<p>ssssss多发撒旦发送方</p>','2013-04-02',0,22),(12,'<p>dddddddd哀伤地发射发大水都发生地方</p>','2013-04-02',1,22),(13,'','2013-07-16',0,29),(14,'','2013-07-16',1,29),(15,'','2013-07-18',0,30),(16,'','2013-07-18',1,30),(17,'','2013-07-18',0,32),(18,'','2013-07-18',1,32),(19,'','2013-07-18',0,33),(20,'','2013-07-18',1,33),(21,'','2013-07-18',0,34),(22,'','2013-07-18',1,34),(23,'','2013-07-18',0,35),(24,'','2013-07-18',1,35),(25,'','2013-07-18',0,36),(26,'','2013-07-18',1,36),(27,'','2013-07-18',0,37),(28,'','2013-07-18',1,37),(29,'','2013-07-18',0,38),(30,'','2013-07-18',1,38),(31,'','2013-07-18',0,39),(32,'','2013-07-18',1,39),(33,'','2013-07-18',0,40),(34,'','2013-07-18',1,40),(35,'','2013-07-18',0,41),(36,'','2013-07-18',1,41),(37,'','2013-07-18',0,42),(38,'','2013-07-18',1,42),(39,'','2013-07-18',0,43),(40,'','2013-07-18',1,43),(41,'','2013-07-18',0,48),(42,'','2013-07-18',1,48),(43,'','2013-07-18',0,49),(44,'','2013-07-18',1,49),(45,'','2013-07-18',0,50),(46,'','2013-07-18',1,50),(47,'','2013-07-18',0,51),(48,'','2013-07-18',1,51),(49,'','2013-07-18',0,52),(50,'','2013-07-18',1,52),(51,'','2013-07-18',0,53),(52,'','2013-07-18',1,53),(53,'','2013-07-18',0,54),(54,'','2013-07-18',1,54),(55,'','2013-07-18',0,59),(56,'','2013-07-18',1,59),(57,'','2013-07-19',0,60),(58,'','2013-07-19',1,60),(59,'','2013-07-19',0,61),(60,'','2013-07-19',1,61),(61,'','2013-07-19',0,63),(62,'','2013-07-19',1,63),(63,'','2013-07-19',0,64),(64,'','2013-07-19',1,64),(65,'<p>&nbsp;asdfasdfasdfasdf 是都发撒旦发射地方撒地方阿斯顿发撒旦发送地方</p>','2013-07-20',0,65),(66,'<p>&nbsp;阿斯顿发送地方撒地方撒都发撒旦发射地方阿斯顿发送地方</p>','2013-07-20',1,65),(67,'','2013-07-20',0,66),(68,'','2013-07-20',1,66),(69,'','2013-07-20',0,67),(70,'','2013-07-20',1,67),(71,'','2013-07-20',0,68),(72,'','2013-07-20',1,68),(73,'','2013-07-20',0,69),(74,'','2013-07-20',1,69),(75,'','2013-07-20',0,70),(76,'','2013-07-20',1,70),(77,'','2013-07-20',0,71),(78,'','2013-07-20',1,71),(79,'','2013-07-20',0,72),(80,'','2013-07-20',1,72),(81,'','2013-07-20',0,73),(82,'','2013-07-20',1,73),(83,'','2013-07-20',0,74),(84,'','2013-07-20',1,74),(85,'<p>&nbsp;哀伤地发射发送到发送到发哀伤地发射发撒旦发按时得发卅多发生地方</p>','2013-08-06',0,75),(86,'<p>&nbsp;按时得发卅多发生地方哀伤地发射多发送方</p>','2013-08-06',1,75),(87,'','2013-08-06',0,76),(88,'','2013-08-06',1,76);
/*!40000 ALTER TABLE `t_content` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_cooperation`
--

DROP TABLE IF EXISTS `t_cooperation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_cooperation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT NULL,
  `name` varchar(384) DEFAULT NULL,
  `address` varchar(384) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_cooperation`
--

LOCK TABLES `t_cooperation` WRITE;
/*!40000 ALTER TABLE `t_cooperation` DISABLE KEYS */;
INSERT INTO `t_cooperation` VALUES (1,1,'asdfa','asdf','400-8456-5236'),(2,1,'asdf','asdf','400-8456-5236'),(3,1,'asdf','asdf','400-8456-5236'),(4,1,'asdf','asdf','400-8456-5236'),(5,1,'asdf','asdf','400-8456-5236'),(6,1,'asdf','asdf','400-8456-5236'),(7,1,'asdf','asdf','400-8456-5236'),(8,1,'asdf','asfasf','400-8456-5236'),(9,1,'asdf','asdfasdfasdf','400-8456-5236'),(10,1,'asdf','asdfa','400-8456-5236'),(11,1,'sdf','asdfasdf','400-8456-5236'),(12,1,'sadf','sadfasdf','400-8456-5236'),(13,1,'asdf','asdfasdf','400-8456-5236'),(14,1,'asdf','asdfasdf','400-8456-5236'),(15,2,'asdf','asdf','400-8456-5236'),(16,2,'asdf','asdf','400-8456-5236'),(17,3,'sssssssssss','asdfssssssssss','400-8456-5236'),(18,3,'ss','asdfssss','400-8456-5236'),(19,4,'asdfsscccccccccc','asdfc','400-8456-5236'),(20,4,'asdfcccccccccc','asdfcccc','400-8456-5236'),(21,5,'asdf222','asdf23','400-8456-5236'),(22,5,'asdf222222','asdf3333333333','400-8456-5236'),(23,6,'asdfqqqqqqqq','asdfqqqqqqqqq','400-8456-5236'),(24,6,'asdfqqqqqq','asdfqqqq','400-8456-5236'),(25,1,'asdfasf','asdfa','400-8456-5236'),(26,2,'asdfas','dfasdfasdf','400-8456-5236');
/*!40000 ALTER TABLE `t_cooperation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_dictbuss`
--

DROP TABLE IF EXISTS `t_dictbuss`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_dictbuss` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dictId` int(11) DEFAULT NULL,
  `dictName` varchar(255) DEFAULT NULL,
  `dictType` int(11) DEFAULT NULL,
  `descript` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=152 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_dictbuss`
--

LOCK TABLES `t_dictbuss` WRITE;
/*!40000 ALTER TABLE `t_dictbuss` DISABLE KEYS */;
INSERT INTO `t_dictbuss` VALUES (1,1,'男',1,'性别'),(2,2,'女',1,'性别'),(3,0,'菜单',2,'权限类别'),(4,1,'按钮',2,'权限类别'),(18,1,'公司新闻',4,'行业资讯'),(19,2,'创新中心',4,'行业资讯'),(20,3,'项目中心',4,'行业资讯'),(33,1,'教育科技',9,'业务公告'),(34,2,'移动互联',9,'业务公告'),(35,3,'计电数码',9,'业务公告'),(52,1,'养身',15,'产品分类'),(53,2,'保健',15,'产品分类'),(54,3,'所属',15,'产品分类'),(55,1,'农场主',16,'合作分类'),(56,2,'加工厂',16,'合作分类'),(57,3,'供应商',16,'合作分类'),(64,4,'生态农植',9,'业务公告'),(82,4,'查出',15,'产品分类'),(83,5,'二二',15,'产品分类'),(84,4,'直销站',16,'合作分类'),(85,5,'国际站',16,'合作分类'),(134,5,'社会商机',9,'业务公告'),(135,4,'人才中心',4,'行业资讯'),(136,5,'资本中心',4,'行业资讯'),(137,6,'政策中心',4,'行业资讯'),(138,7,'行业联盟',4,'行业资讯'),(139,8,'专家联盟',4,'行业资讯'),(140,9,'高教联盟',4,'行业资讯'),(141,10,'园区联盟',4,'行业资讯'),(142,11,'同行联盟',4,'行业资讯'),(143,6,'丛丛簇簇',15,'产品分类'),(144,6,'其他',16,'合作分类'),(145,1,'党参',17,'产品热词'),(146,2,'核桃',17,'产品热词'),(147,3,'雪莲',17,'产品热词'),(148,4,'枸杞',17,'产品热词'),(149,5,'红枣',17,'产品热词'),(150,1,'采购合同',18,'合约类型'),(151,2,'加盟合同',18,'合约类型');
/*!40000 ALTER TABLE `t_dictbuss` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_divproper`
--

DROP TABLE IF EXISTS `t_divproper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_divproper` (
  `imgid` varchar(50) DEFAULT NULL,
  `title` varchar(384) DEFAULT NULL,
  `sequ` int(11) DEFAULT NULL,
  `attaname` varchar(64) DEFAULT NULL,
  `x1` int(11) DEFAULT NULL,
  `y1` int(11) DEFAULT NULL,
  `x2` int(11) DEFAULT NULL,
  `y2` int(11) DEFAULT NULL,
  `w` int(11) DEFAULT NULL,
  `h` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_divproper`
--

LOCK TABLES `t_divproper` WRITE;
/*!40000 ALTER TABLE `t_divproper` DISABLE KEYS */;
INSERT INTO `t_divproper` VALUES ('74637d8f-6ba1-4ecf-b076-5b70531957e6','阿斯蒂芬',0,'3531e8c5-1af1-4417-a289-c05900cffc23.jpg',373,22,596,216,223,194),('74637d8f-6ba1-4ecf-b076-5b70531957e6','222',0,'761b40f1-bac5-4021-bbee-0af5beb0a7e8.jpg',439,26,592,150,153,124),('b214acb8-e329-4fb0-ac30-092da204fc1f','222',0,'6bf4b9a2-9c57-417f-8e78-4d11cbc32df6.jpg',378,19,516,124,138,105),('b214acb8-e329-4fb0-ac30-092da204fc1f','222',0,'fa2cdb18-546e-4b9d-81b8-4c0cb3abd097.jpg',286,85,395,170,109,85),('b214acb8-e329-4fb0-ac30-092da204fc1f','333',1,NULL,721,691,791,749,70,58),('e072eb3b-8cb7-4915-a500-e55141319549','dddddd',1,'39658325-9eba-4492-8ee0-93e75b78066a.xls',162,1,287,69,125,68),('e072eb3b-8cb7-4915-a500-e55141319549','111',1,'56b64396-6109-4a29-8c78-e7ae605b0d17.doc',165,102,283,165,118,63),('e072eb3b-8cb7-4915-a500-e55141319549','222',1,'8aa189c5-0576-481c-89e5-3e1bea7ca271.doc',168,105,284,162,116,57),('e072eb3b-8cb7-4915-a500-e55141319549','222',1,'998c2d6a-645e-4048-8bc8-a589c55219f5.doc',160,101,291,169,131,68),('e072eb3b-8cb7-4915-a500-e55141319549','23',1,'28ccd2df-2549-4827-89eb-8a0e4d9bb1e8.jpg',235,299,369,366,134,67);
/*!40000 ALTER TABLE `t_divproper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_equipment`
--

DROP TABLE IF EXISTS `t_equipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_equipment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `orderNo` int(11) DEFAULT NULL,
  `sn` varchar(255) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK39E5A7436CD5B923` (`pid`),
  CONSTRAINT `FK39E5A7436CD5B923` FOREIGN KEY (`pid`) REFERENCES `t_equipment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_equipment`
--

LOCK TABLES `t_equipment` WRITE;
/*!40000 ALTER TABLE `t_equipment` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_equipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_information`
--

DROP TABLE IF EXISTS `t_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_information` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `type` int(3) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `content` text,
  `contcode` varchar(100) DEFAULT NULL,
  `ctype` char(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_information`
--

LOCK TABLES `t_information` WRITE;
/*!40000 ALTER TABLE `t_information` DISABLE KEYS */;
INSERT INTO `t_information` VALUES (1,'讲堂资讯',1,'2013-03-24','<p>讲堂资讯</p>','32d8515b-0a15-4258-b77e-19891d3cb00e','1'),(2,'赛场资讯',5,'2013-03-24','<p>&nbsp; &nbsp; sdsd&nbsp;</p>','a0e3055b-664f-47bd-90a2-f834c8d2b653','2'),(3,'行业资讯',2,'2013-03-24','<p>&nbsp;行业资讯</p>','3ea3217a-2a9e-4e6e-baf3-835e45c05748','3'),(4,'生态园林',2,'2013-03-24','<p>&nbsp;生态园林</p>','06b2ada0-4ce7-40ab-a781-42f031f8704b','4'),(5,'时局之窗',2,'2013-03-24','<p>&nbsp;时局之窗</p>','19aac228-aea0-498f-9b81-d59ae8bbe17d','5');
/*!40000 ALTER TABLE `t_information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_loginmess`
--

DROP TABLE IF EXISTS `t_loginmess`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_loginmess` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `preLoginIp` varchar(255) DEFAULT NULL,
  `preLoginDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_loginmess`
--

LOCK TABLES `t_loginmess` WRITE;
/*!40000 ALTER TABLE `t_loginmess` DISABLE KEYS */;
INSERT INTO `t_loginmess` VALUES (1,'admin','127.0.0.1','2013-08-08 15:43:12'),(2,'test','0.0.0.0','2012-12-23 16:01:01'),(3,'hly','117.88.114.6','2013-04-27 16:34:40');
/*!40000 ALTER TABLE `t_loginmess` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_member`
--

DROP TABLE IF EXISTS `t_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(40) DEFAULT NULL,
  `userName` varchar(20) NOT NULL,
  `password` varchar(48) DEFAULT NULL,
  `realName` varchar(32) DEFAULT NULL,
  `cooptype` int(2) DEFAULT NULL,
  `mphone` varchar(20) DEFAULT NULL,
  `fphone` varchar(20) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `address` varchar(384) DEFAULT NULL,
  `area` varchar(384) DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  `companyname` varchar(128) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `remark` varchar(384) DEFAULT NULL,
  `logo` varchar(128) DEFAULT NULL,
  `state` int(1) DEFAULT NULL,
  `flag` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_member`
--

LOCK TABLES `t_member` WRITE;
/*!40000 ALTER TABLE `t_member` DISABLE KEYS */;
INSERT INTO `t_member` VALUES (43,'d1b463b1-604b-4ff9-b9af-c7db2b9d79f9','12345678912','af895115d4d641bd6530b013db42daca','ccccc3',1,'',NULL,'','三亿三千三百三十三万三千三百三十三','山东 淄博 博山区',1,'文思海辉','2013-07-18','','088bf90c-3e4f-487d-a30e-f44f03e8ca14.jpg',0,0),(48,'9a8a3e9a-4bb8-4ef3-afbc-02ab891ab74b','11111111111','fa1d3eb08a879de9a4cd9995a1aa91e1','ccccc1',1,NULL,NULL,NULL,NULL,NULL,1,'dddddddd','2013-07-18',NULL,NULL,0,0),(49,'1c081257-8993-47e8-b030-e3efaa4e49f8','11111111222','fc37a68f62516440dc0260c894bf79a3','ccccc2',1,'1212121212',NULL,'21122@111.com','熬到沙发上都发生地方','河北 秦皇岛 昌黎县',1,'暗暗士大夫','2013-07-18','asfasf','1f7b0275-9f85-4334-988e-6a0989071eac.jpg',0,1),(50,'68be1837-aa37-4489-8f0b-e0040e7dbeea','32323233333','0bfb25eb2d201925abd40b8a2595b0bf','ccccc3',2,'33333333',NULL,'3331@111.com','3333','山西 长治 襄垣县',1,'按时得发','2013-07-18','333','844393b0-5da4-426c-8070-10a6429c350a.jpg',0,1),(51,'0a4651e2-e9ce-4fd3-a258-468d536254c8','33333333333','7a4d9780a49a7754c4b20d006c0dfd25','ccccc3',1,'23232323',NULL,'21122@111.com','按时得发','辽宁 抚顺 抚顺县',1,'杂事打分','2013-07-18','3333','9c7c50d5-fc9b-4f0a-bb5d-149e77f7acfc.jpg',0,1),(52,'d3671a4e-1947-4a01-9ad9-2c8ac6a7da85','11111222222','8e62fc1b62177e53fa7454508fa4c16a','ccccc2',1,'3333',NULL,'3331@111.com','333','天津 河西区',2,'33333','2013-07-18','333','cfaac3d7-c14f-408a-89d8-8c04afc36b0e.jpg',0,1),(53,'adcbe22d-c66a-429b-990a-d33f48d324fc','55555566666','97f9dadbd182e6373c6ad0a9ee9b13f5','ccccc2',2,'33333',NULL,'3331@111.com','3333333','天津 河西区',1,'2按时得发','2013-07-18','333','15b49b12-7ade-4eb9-b5f5-e69e499ce50e.jpg',0,1),(54,'fb38d4b7-34b5-4040-8dca-5e299abb8225','12122222222','6790dca4dca214b9ec82c75b1a678f86','ccccc2223',2,'',NULL,'','222','内蒙古 鄂尔多斯 伊金霍洛旗',2,'按时得发','2013-07-18','','4ecb1059-b2ad-4b75-8664-3cda25fa307e.jpg',0,1),(59,'d12c024c-7823-432d-8eec-80c2ae7ea20b','22222332323','404ba7258a3827012b6bcb8589de2556','ccccc33',1,NULL,NULL,NULL,NULL,NULL,1,NULL,'2013-07-18',NULL,NULL,0,0),(61,'f7dada68-8199-4712-8dab-feb006b00d33','44444444444','aa54c31a8b04dcd47e5573ea07b3c886','444444',2,NULL,NULL,NULL,NULL,NULL,1,NULL,'2013-07-19',NULL,NULL,0,0),(63,'439a8535-5eeb-424b-8a64-4d363583bf64','33333333322','457a7977fe0c1b183bff472243518723','2222222',1,NULL,NULL,NULL,NULL,NULL,1,NULL,'2013-07-19',NULL,NULL,1,0),(64,'c7a82c3e-c5bb-4418-ac20-849d86bfc3eb','12345678914','3931a3c90d5f15305b9db8b10892bd23','ccccc232',2,NULL,NULL,NULL,NULL,NULL,2,NULL,'2013-07-19',NULL,NULL,1,0),(65,'96010e88-cb24-454a-ad45-d23bbe4a3e17','22222222222','7176f86f8b73db63c51fc35cb412bb51','2222222222',1,'2222',NULL,'2222@36.com','222','河北 唐山 ',1,'阿斯蒂芬','2013-07-20','asdf','89949afa-5a15-4298-8c6c-757350eda335.jpg',2,1),(66,'3cf0c407-8809-4cd5-98ec-439d0b300538','12222224222','29719e06ec9ab391355433d4e56a280d','admin33',2,'',NULL,'','阿斯蒂芬','山西 阳泉 矿区',1,'阿斯蒂芬','2013-07-20','','6079add4-c80a-4193-af91-63ff7541697b.jpg',2,1),(67,'675eca9d-84de-4b5a-9c0c-35060be7cd4c','22222222211','b8a4585f98788bff6357113f1f9e5bce','admin33',2,NULL,NULL,NULL,NULL,NULL,1,NULL,'2013-07-20',NULL,NULL,2,0),(68,'1934d7ca-6594-446a-87df-eda91b127852','99999999999','6433e568d618d156d9d21489148af013','admin33',2,'',NULL,'','asdfasdf','河北 秦皇岛 ',1,'安徽太平湖有机农场','2013-07-20','','5bf88e48-9264-4d24-b625-e70413cf5ecb.jpg',1,1),(69,'78fdf10a-ef13-4ead-83d6-23a2a05fe2d2','77777777777','e68b7e9baa397595bf6d7c2b8682d2f3','admin33',2,'',NULL,'','22222 ','天津 滨海新区',1,'2222','2013-07-20','','f0752269-b723-4808-bddc-dcf1e4393d9f.jpg',2,1),(70,'ad0d3b9e-3ed1-4701-b8da-a23969ab5c32','45555555555','1356394c65fca38bd7d3a7f946a8d33e','admin33',2,NULL,NULL,NULL,NULL,NULL,1,NULL,'2013-07-20',NULL,NULL,2,0),(71,'c7fb59c9-ec08-40d3-ab43-fe9264537f5a','23322333333','835accfd47ad33a9e27db8afe1460639','admin33',2,NULL,NULL,NULL,NULL,NULL,1,NULL,'2013-07-20',NULL,NULL,2,0),(72,'a49ff1aa-0b45-4c17-a6cb-8e07cfaef33e','12334444444','7cebd4d4de4733a3e255bda643d55468','admin33',2,'',NULL,'','221212','天津 河西区',1,'22212','2013-07-20','','c457af9b-8f57-4bf1-879d-568c4e8469b3.jpg',2,1),(73,'931ef8b2-6aca-4a4e-8214-2e9ccdd46da8','33332222222','aa4d134e72744d10af991be17027dec0','admin33',2,NULL,NULL,NULL,NULL,NULL,2,NULL,'2013-07-20',NULL,NULL,2,0),(74,'76c5cd35-2cb5-4442-8195-b756a9e2fd63','23233333333','ae670eccbc231d356e4e818842c908a6','admin33',1,'',NULL,'','asdfasdfasdf','福建 龙岩 上杭县',1,'asdfasdfasdf','2013-07-20','','a799a476-0b40-4eb0-9312-a62d1f0ecbd6.jpg',2,1),(75,'47237b59-7c37-4e85-97ac-491bbda13420','13933333333','d80952aabfdb7674a73204e87be265b6','你好',1,'',NULL,'','哀伤地发射多发送方','山东 淄博 博山区',1,'按时得发','2013-08-06','','c039a83b-d9e6-4568-b762-723f18e90c85.jpg',0,1),(76,'7122be47-8609-417b-af2e-4ca346b690e9','13222222222','a75b6e8d4efaf6aa145e68bec5f3479a','按啊',1,'',NULL,'','按时得发','辽宁 抚顺 东洲区',1,'按时得发','2013-08-06','','93134929-ce72-492d-8c56-3f157f60aee6.jpg',0,1);
/*!40000 ALTER TABLE `t_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_module`
--

DROP TABLE IF EXISTS `t_module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_module` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `moduleType` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `orderNo` int(11) DEFAULT NULL,
  `sn` varchar(255) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK410348D77851822D` (`pid`),
  CONSTRAINT `FK410348D77851822D` FOREIGN KEY (`pid`) REFERENCES `t_module` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=763 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_module`
--

LOCK TABLES `t_module` WRITE;
/*!40000 ALTER TABLE `t_module` DISABLE KEYS */;
INSERT INTO `t_module` VALUES (1,'ROOT',0,NULL,2,'2',NULL),(2,'系统配置',0,NULL,22,'2',1),(201,'系统配置',0,NULL,3,'3333333333333',2),(202,'系统配置',0,'../sys/toSysConfing.action',4,'4',201),(221,'系统管理',0,NULL,7,'55',1),(322,'用户权限',0,NULL,2,'2',221),(324,'用户管理',0,'../contents/getUserInfoList.action',1,'1',322),(325,'角色管理',0,'../contents/getRoleInfoList.action',2,'2',322),(326,'机构管理',0,'../contents/getOrgInfoList.action',3,'3',322),(327,'模块管理',0,'../contents/getModuleInfoList.action',3,'4',322),(344,'新增',1,NULL,0,NULL,327),(345,'修改',1,NULL,0,NULL,327),(346,'查看',1,NULL,0,NULL,327),(347,'删除',1,NULL,0,NULL,327),(348,'查询',1,NULL,2,NULL,327),(349,'新增',1,NULL,0,NULL,326),(350,'修改',1,NULL,0,NULL,326),(351,'查看',1,NULL,0,NULL,326),(352,'删除',1,NULL,0,NULL,326),(353,'查询',1,NULL,0,NULL,326),(354,'新增',1,NULL,0,NULL,325),(355,'修改',1,NULL,0,NULL,325),(356,'查看',1,NULL,0,NULL,325),(357,'删除',1,NULL,0,NULL,325),(358,'查询',1,NULL,0,NULL,325),(359,'新增',1,NULL,0,NULL,324),(360,'修改',1,NULL,0,NULL,324),(361,'查看',1,NULL,0,NULL,324),(362,'删除',1,NULL,0,NULL,324),(363,'查询',1,NULL,0,NULL,324),(675,'菜单授权',1,'2222',222,'222',325),(676,'内容管理',0,'',3,'nrgl',1),(677,'首页',0,'',1,'crzq',676),(721,'业务字典',0,'../bussdict/toLoadList.action',1,'',322),(732,'业务公告',0,'../projectnews/toLoadList.action',1,'',677),(733,'行业资讯',0,'../news/getNewsList.action',2,'',677),(734,'顶部广告',0,'',1,'',676),(735,'样式1',0,'../ads/toLoadList.action?type=1',1,'',734),(736,'样式2',0,'../ads/toLoadList.action?type=2',1,'',734),(749,'本草品牌',0,'../manacont/toManacont.action?id=1',0,'',677),(750,'合作公告',0,'../manacont/toManacont.action?id=2',0,'',677),(751,'支付方式',0,'../manacont/toManacont.action?id=3',0,'',677),(752,'配送方式',0,'../manacont/toManacont.action?id=4',0,'',677),(753,'平台资质',0,'../manacont/toManacont.action?id=5',0,'',677),(754,'工具频道',0,'../manacont/toManacont.action?id=6',0,'',677),(755,'国际站点',0,'../manacont/toManacont.action?id=7',0,'',677),(756,'关于我们',0,'../manacont/toManacont.action?id=8',0,'',677),(757,'合作伙伴管理',0,'',0,'',676),(758,'合作伙伴管理',0,'../member/toLoadList.action',0,'',757),(759,'产品管理',0,'',0,'',676),(760,'产品管理',0,'../product/toLoadList.action',0,'',759),(762,'合约管理',0,'../agreement/toLoadList.action',1,'1',757);
/*!40000 ALTER TABLE `t_module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_news`
--

DROP TABLE IF EXISTS `t_news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `type` int(3) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `content` text,
  `contcode` varchar(100) DEFAULT NULL,
  `htmlpath` varchar(100) DEFAULT NULL,
  `state` int(1) DEFAULT '0',
  `coopid` int(11) DEFAULT NULL,
  `optddtime` datetime DEFAULT NULL,
  `zhiding` int(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_news`
--

LOCK TABLES `t_news` WRITE;
/*!40000 ALTER TABLE `t_news` DISABLE KEYS */;
INSERT INTO `t_news` VALUES (20,'教高厅[2012]4号',6,'2012-08-20','<div style=\"text-align: left\">\r\n<p style=\"text-align: center\"><span style=\"font-size: small\"><strong>教育部办公厅关于印发《普通本科学校创业教育教学基本要求（试行）》的通知 </strong></span><br />\r\n<br />\r\n各省、自治区、直辖市教育厅（教委），新疆生产建设兵团教育局，有关部门（单位）教育司（局），部属各高等学校：</p>\r\n<p>　　为深入贯彻落实《国家中长期教育改革和发展规划纲要（2010-2020年）》以及《教育部关于全面提高高等教育质量的若干意见》（教高[2012]4号）精神，推动高等学校创业教育科学化、制度化、规范化建设，切实加强普通高等学校创业教育工作，我部制定了《普通本科学校创业教育教学基本要求（试行）》（见附件），现印发给你们，请遵照执行。在执行中若有意见建议，请报我部高等教育司。</p>\r\n<p>　　附件：普通本科学校创业教育教学基本要求（试行）</p>\r\n<p style=\"text-align: right\">教育部办公厅</p>\r\n<p style=\"text-align: right\">2012年8月1日</p>\r\n<p style=\"text-align: left\">详情链接：<a href=\"http://www.moe.gov.cn/publicfiles/business/htmlfiles/moe/s5672/201208/xxgk_140455.html\">http://www.moe.gov.cn/publicfiles/business/htmlfiles/moe/s5672/201208/xxgk_140455.html</a></p>\r\n<p><br />\r\n<br />\r\n&nbsp;</p>\r\n</div>','298add6c-dd10-4e70-b56d-bf1328b29b11',NULL,1,-1,NULL,0),(33,'asfasdf',1,'2013-07-21','<p>&nbsp;asdfasdf</p>','12bfc792-7a55-4e9c-a319-e6a8e9d65380',NULL,1,-1,'2013-07-21 21:36:23',1),(34,'1111',1,'2013-07-21','<p>&nbsp;asdfasdf</p>','1cdf50ca-8160-4b93-a45a-4dd7f7ba2e26',NULL,1,-1,NULL,0),(35,'222',2,'2013-07-21','<p>&nbsp;asdfasdf</p>','25bf2ca3-38cd-4fc5-a91a-f1eab7816d1a',NULL,1,-1,NULL,0),(36,'3333',1,'2013-07-21','<p>&nbsp;asdfasdf</p>','88472bd5-7c0c-4438-b88b-ea9f1c055982',NULL,1,-1,'2013-07-21 22:00:06',1),(37,'asdfsadf',2,'2013-07-23','<p>&nbsp;asdfasdf</p>','7e8dd000-9c0c-4e76-974f-46948345b2fc',NULL,1,-1,NULL,0),(38,'asdfasf3333',2,'2013-07-23','<p>&nbsp;2323</p>','d8a6d01e-9fd3-4210-8d5b-c8d8052bafa5',NULL,1,68,'2013-07-23 10:38:49',1),(42,'asdfasdf',2,'2013-07-23','<p>&nbsp;asdfasdf</p>','3c04d35a-d4cd-4317-b8c1-aa92feca3535',NULL,0,68,NULL,0),(43,'asdfasdf',3,'2013-07-23','<p>&nbsp;asdfasdf<img src=\"/coop/userfiles/image/sssssss.gif\" width=\"600\" height=\"400\" alt=\"\" /></p>','16571740-8ca5-49f4-b229-dcbddafa7158',NULL,0,68,NULL,0),(44,'sssssssss',2,'2013-07-23','<p>&nbsp;sssssss</p>','a467a283-ae2a-46dc-ab35-faa96ff6383f',NULL,0,68,NULL,0),(45,'ddddddd',3,'2013-07-23','<p>&nbsp;dddddd</p>','e6a9a905-0d2e-4010-8f81-00b8cfb34d6c',NULL,0,68,NULL,0),(46,'dddddddddd',5,'2013-07-23','<p>&nbsp;ddddddddddd</p>','9bc25ee3-f354-456e-bad4-a5cca61ffee8',NULL,0,68,NULL,0),(47,'dddddddddd',4,'2013-07-23','<p>&nbsp;ddddddddd</p>','6a0bbd95-3137-490f-95a2-6f9c5bbc0ec7',NULL,0,68,NULL,0),(48,'ddddddddddd',4,'2013-07-23','<p>&nbsp;ddddddddddddd</p>','dd32f9bc-b33a-48f8-b071-238086e22895',NULL,0,68,NULL,0),(49,'dddddddddddd',9,'2013-07-23','<p>&nbsp;dddddddddddd</p>','4bbfed67-6f91-4613-854f-4ecb0520d984',NULL,0,68,NULL,0),(50,'dddddddddd',8,'2013-07-23','<p>&nbsp;dddddddddddddddd</p>','62aec82a-b356-4b61-b290-75c529b3b171',NULL,0,68,NULL,0),(51,'dddddddddd',6,'2013-07-23','<p>&nbsp;dddddddddddddd</p>','e77785b2-8165-4f2d-bd4c-27d8fadbbb7c',NULL,0,68,NULL,0),(52,'2222222222',4,'2013-07-23','<p>&nbsp;33333</p>','7c5825d2-50e2-4cc0-ae67-ea5fd1fac3bd',NULL,0,68,NULL,0),(53,'33333333333',5,'2013-07-23','<p>333333&nbsp;</p>','888abe2a-b7e0-4696-ab61-642170e257a7',NULL,0,68,NULL,0),(54,'33333333333',7,'2013-07-23','<p>&nbsp;3333333</p>','29edfd5a-6abd-427a-9ba5-6c5752f44fce',NULL,0,68,NULL,0),(55,'33333333333',5,'2013-07-23','<p>&nbsp;333333333333</p>','2bfc35c5-307d-4a01-bf95-5673eea6875b',NULL,0,68,NULL,0),(56,'33333333333',4,'2013-07-23','<p>&nbsp;3333333</p>','bd23987a-fe60-47c5-8cd1-8dbeae8c212b',NULL,0,68,NULL,0),(57,'33333333333',10,'2013-07-23','<p>&nbsp;3333333333</p>','efa9aea2-e7fb-44c7-839f-6e0aa441a756',NULL,0,68,NULL,0),(58,'按时得发',2,'2013-08-06','<p>&nbsp;按时得发</p>','080cf767-ac2a-4882-a9dd-3e2b13ace0cd',NULL,0,75,NULL,0);
/*!40000 ALTER TABLE `t_news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_organization`
--

DROP TABLE IF EXISTS `t_organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_organization` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKEF75D35ED993C874` (`pid`),
  CONSTRAINT `FKEF75D35ED993C874` FOREIGN KEY (`pid`) REFERENCES `t_organization` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1256 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_organization`
--

LOCK TABLES `t_organization` WRITE;
/*!40000 ALTER TABLE `t_organization` DISABLE KEYS */;
INSERT INTO `t_organization` VALUES (1,'ROOT','dddd',NULL),(1254,'系统管理','系统管理',1),(1255,'Can2DO信息技术有限公司','Can2DO信息技术有限公司2',1);
/*!40000 ALTER TABLE `t_organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product`
--

DROP TABLE IF EXISTS `t_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(60) DEFAULT NULL,
  `name` varchar(384) DEFAULT NULL,
  `hotword` varchar(512) DEFAULT NULL,
  `sort` int(2) DEFAULT NULL,
  `proarea` varchar(30) DEFAULT NULL,
  `state` int(2) DEFAULT NULL,
  `linestate` int(1) DEFAULT NULL,
  `sync` int(1) DEFAULT '0',
  `specinfo` text,
  `efficacyinfo` text,
  `remark` text,
  `createDate` date DEFAULT NULL,
  `typeimg` varchar(384) DEFAULT NULL,
  `weight` decimal(10,1) DEFAULT NULL,
  `markingprice` decimal(10,2) DEFAULT NULL,
  `ourprice` decimal(10,2) DEFAULT NULL,
  `mallurl` varchar(384) DEFAULT NULL,
  `coopid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product`
--

LOCK TABLES `t_product` WRITE;
/*!40000 ALTER TABLE `t_product` DISABLE KEYS */;
INSERT INTO `t_product` VALUES (1,'2','sss',NULL,1,'江苏 连云港 海州区',1,0,0,'222','','','2013-07-08','1.jpg',NULL,3.23,NULL,NULL,0),(2,'2','ss',NULL,1,'江苏 连云港 海州区',1,0,0,'','','','2013-07-08','2.jpg',NULL,NULL,NULL,NULL,0),(3,'','sss',NULL,0,'江苏 连云港 海州区',1,0,0,'','','','2013-07-08','3.jpg',NULL,NULL,NULL,NULL,0),(4,'','sss',NULL,0,'江苏 连云港 海州区',1,0,0,'','','','2013-07-08','4.jpg',NULL,NULL,NULL,NULL,0),(5,'','党参',NULL,0,'江苏 连云港 海州区',1,0,0,'党参','党参','党参','2013-07-08','5.jpg',NULL,NULL,NULL,NULL,0),(6,'','sss',NULL,0,'江苏 连云港 海州区',1,0,0,'','','','2013-07-08','6.jpg',NULL,NULL,NULL,NULL,0),(7,'','sss',NULL,0,'江苏 连云港 海州区',1,0,0,'','','','2013-07-08','7.jpg',NULL,NULL,NULL,NULL,0),(8,'','sss',NULL,0,'江苏 连云港 海州区',1,0,0,'','','','2013-07-08','8.jpg',NULL,NULL,NULL,NULL,0),(9,'','sss',NULL,0,'江苏 连云港 海州区',1,0,0,'','','','2013-07-08','9.jpg',NULL,NULL,NULL,NULL,0),(10,'','sss',NULL,0,'江苏 连云港 海州区',1,0,0,'','','','2013-07-08','10.jpg',NULL,NULL,NULL,NULL,0),(11,'','sss',NULL,0,'江苏 连云港 海州区',1,0,0,'','','','2013-07-08','11.jpg',NULL,NULL,NULL,NULL,0),(12,'','红枣',NULL,0,'江苏 连云港 海州区',1,0,0,'','','','2013-07-08','12.jpg',NULL,NULL,NULL,NULL,0),(13,'','sss',NULL,0,'江苏 连云港 海州区',1,0,0,'','','','2013-07-08','13.jpg',NULL,NULL,NULL,NULL,0),(14,'','sss',NULL,0,'江苏 连云港 海州区',1,0,0,'','','','2013-07-08','14.jpg',NULL,NULL,NULL,NULL,0),(15,'','枸杞',NULL,0,'江苏 连云港 海州区',1,0,0,'','','','2013-07-08','15.jpg',NULL,NULL,NULL,NULL,0),(16,'','sss',NULL,0,'江苏 连云港 海州区',1,0,0,'','','','2013-07-08','16.jpg',NULL,NULL,NULL,NULL,0),(17,'','sss',NULL,0,'江苏 连云港 海州区',1,0,0,'','','','2013-07-08','17.jpg',NULL,NULL,NULL,NULL,0),(18,'','核桃',NULL,0,'江苏 连云港 海州区',1,0,0,'','','','2013-07-08','18.jpg',NULL,NULL,NULL,NULL,0),(19,'','sss',NULL,0,'江苏 连云港 海州区',1,0,0,'','','','2013-07-08','19.jpg',NULL,NULL,NULL,NULL,0),(20,'','sss',NULL,0,'江苏 连云港 海州区',1,0,0,'','','','2013-07-08','20.jpg',NULL,NULL,NULL,NULL,0),(21,'','sss',NULL,0,'江苏 连云港 海州区',1,0,0,'','','','2013-07-08','21.jpg',NULL,NULL,NULL,NULL,0),(22,'','sss',NULL,0,'江苏 连云港 海州区',1,0,0,'','','','2013-07-08','22.jpg',NULL,NULL,NULL,NULL,0),(23,'','雪莲',NULL,0,'江苏 连云港 海州区',1,0,0,'','','','2013-07-08','23.jpg',NULL,NULL,NULL,NULL,0),(24,'','sss',NULL,0,'江苏 连云港 海州区',1,0,0,'','','','2013-07-08','1.jpg',NULL,NULL,NULL,NULL,0),(25,'','sss',NULL,0,'江苏 连云港 海州区',1,0,0,'','','','2013-07-08','2.jpg',NULL,NULL,NULL,NULL,0),(26,'','sss',NULL,0,'江苏 连云港 海州区',1,0,0,'','','','2013-07-08','3.jpg',NULL,NULL,NULL,NULL,0),(27,'','sss',NULL,0,'江苏 连云港 海州区',1,0,0,'','','','2013-07-08','4.jpg',NULL,NULL,NULL,NULL,0),(28,'','sss',NULL,0,'江苏 连云港 海州区',1,0,0,'','','','2013-07-08','5.jpg',NULL,NULL,NULL,NULL,0),(29,'','11',NULL,0,'江苏 连云港 海州区',1,0,0,'','','','2013-07-08','6.jpg',NULL,NULL,NULL,NULL,0),(30,'','22',NULL,0,'江苏 连云港 海州区',1,0,0,'','','','2013-07-08','7.jpg',NULL,NULL,NULL,NULL,0),(31,'','sss',NULL,0,'江苏 连云港 海州区',1,0,0,'','','','2013-07-08','8.jpg',NULL,NULL,NULL,NULL,0),(32,'','sss',NULL,0,'江苏 连云港 海州区',1,0,0,'','','','2013-07-08','9.jpg',NULL,NULL,NULL,NULL,0),(33,'','sss',NULL,0,'江苏 连云港 海州区',1,0,2,'','','','2013-07-08','10.jpg',NULL,NULL,NULL,NULL,0),(34,'','sss',NULL,0,'江苏 连云港 海州区',1,0,1,'','','','2013-07-08','11.jpg',NULL,NULL,NULL,NULL,0),(72,'8f586ced-131f-4c71-b88c-ae6a5e819718','测试二','党参, 核桃',2,'天津 河东区',1,1,1,'','','','2013-07-15','09780e34-2ce9-40dd-8c64-76f5fb0e996e.png',NULL,NULL,NULL,NULL,22),(73,'ff4575e0-f1be-4ca7-a978-e4715f9acaee','222222222','党参, 枸杞',1,'江苏 连云港 海州区',1,1,1,'<p>哀伤地发射多发送方</p>\r\n<p>&nbsp;</p>','<p>&nbsp;哀伤地发射发大水都发生地方</p>\r\n<p>&nbsp;</p>','<p>按时得发</p>','2013-07-15','f38dc7f9-5f09-43b4-aedb-c50187152679.jpg',NULL,NULL,NULL,NULL,22),(86,'3c3d98bf-22ad-4434-a285-8c7af9e54752','哀伤地发射发大水都发生地方','党参',2,'天津 ',1,0,1,'','','','2013-07-17','baa56187-98a1-47a2-933b-732ccc63c63b.jpg',NULL,NULL,NULL,NULL,22),(87,'4cd82949-3835-423e-9fef-795223480542','按时得发','党参',4,'天津 ',1,0,1,'','','','2013-07-17','5013a284-3c5c-43ff-9380-98f10b967882.jpg',NULL,NULL,NULL,NULL,22),(88,'dbf6de07-fcd2-4a6b-a276-d5aed71b5a1a','哀伤地发射多发送方','党参',1,'天津 ',1,0,1,'','','','2013-07-17','e5a83b1c-55d0-465f-aee5-29f77e6575cb.jpg',NULL,NULL,NULL,NULL,22),(89,'5b27cabc-5615-4ef0-8b43-84b3acc17b75','飒飒声','党参',1,'天津 ',1,0,1,'','','','2013-07-17','5c4c0f3b-e51b-44b2-993c-bf52c0233f06.jpg',NULL,NULL,NULL,NULL,22),(90,'66aa0fe6-3f83-48c8-b38d-e3e3dbd584f0','飒飒声','党参',2,'天津 ',1,0,1,'<p>&nbsp;哀伤地发射发大水都发生地方</p>','','','2013-07-17','d031e371-74ee-4857-8b0b-6782053227af.jpg',NULL,NULL,NULL,NULL,22),(91,'10f7aa2a-ffc9-4190-bd3b-0d066f7ae5e4','飒飒声','党参',1,'天津 ',1,0,1,'','','','2013-07-17','e0ebcb14-c8a9-44f2-9b39-6c7d2c6826be.jpg',NULL,NULL,NULL,NULL,22),(92,'f0604299-10cd-40f2-a1da-c2a57f21bdb3','222','党参',3,'天津 ',1,0,1,'','','','2013-07-17','211914b8-8fd3-49d1-8ae9-0c9607c862ba.jpg',NULL,NULL,NULL,NULL,22),(93,'cb40d284-937f-42c4-bf66-4001968cdb7c','二十二万二千二百二十二','党参',1,'天津 ',1,0,2,'<p>&nbsp;所属</p>','','','2013-07-17','87da5d67-e32e-4cfa-be4e-40501334512f.jpg',NULL,NULL,NULL,NULL,22),(94,'289bc9c1-a324-4dbe-970c-efb4b85850c0','sadf','党参',1,'河北 唐山 ',1,0,0,'<p>&nbsp;asdfasdf</p>','<p>&nbsp;asdf</p>','<p>&nbsp;asdfasdf</p>','2013-07-20','5c90ffb7-537f-48d6-9d92-2dfb1781b3fe.jpg',NULL,NULL,NULL,NULL,65),(95,'c2ea6d5f-eded-4362-845f-4d51f105ced4','asdfasdf','党参',2,'河北 唐山 ',1,0,2,'','','','2013-07-20','41d6abd1-9ece-483b-81ed-06f91ea91ba5.jpg',NULL,NULL,NULL,NULL,65),(96,'80293bdf-b6f7-4e18-9a99-a9d6063759df','asdasdf','党参',1,'河北 唐山 ',1,0,2,'','','','2013-07-20','5b898459-7019-4112-b5cc-30dba088074b.jpg',NULL,NULL,NULL,NULL,65),(97,'2b745dfb-7d40-495e-931a-c3c97e34c687','swww','党参',1,'河北 唐山 ',1,0,2,'','','','2013-07-20','466c5479-46e4-491e-adc6-d95493d8c305.jpg',NULL,NULL,NULL,NULL,65),(98,'587ad8cd-d8db-464f-aaff-73d47e6ab89e','asdf ','党参',1,'河北 唐山 ',1,0,2,'','','','2013-07-20','844d1c4f-0041-4d51-a2f7-90e8af13d588.jpg',NULL,NULL,NULL,NULL,65),(99,'14269139-380a-44ba-8831-9e06a86286a0','按时得发','党参',1,'河北 秦皇岛 山海关区',1,0,2,'55866','<p>&nbsp;多发撒旦发送方</p>','<p>&nbsp;asdf</p>','2013-07-30','36143668-9faa-4e18-9fdb-df0eb5c4f1a7.jpg',NULL,NULL,NULL,NULL,68),(100,'48dbc4b0-a9e8-47a7-9261-4eb39d677cd2','哀伤地发射多发送方','党参',1,'河北 秦皇岛 北戴河区',1,0,2,'按时得发','<p>&nbsp;三打发送到发生都发生地方</p>','<p>&nbsp;哀伤地发射多发送方</p>','2013-08-02','c44d6458-b1ec-458d-a045-f2803ae279f9.jpg',NULL,NULL,NULL,NULL,68),(101,'01f7a74b-f3f5-4afe-b8eb-536286478661','测试','党参',2,'河北 秦皇岛 海港区',1,0,1,'33','<p>&nbsp;33</p>','<p>&nbsp;33</p>','2013-08-05','f3b40094-a585-4f6b-a92c-501d51218d77.jpg',5.3,55.30,563.70,'http://localhost:8080/ecshop/goods.php?id=30',68),(102,'78dfaec2-986d-457f-8693-89985ab56ae1','按时得发','党参',2,'山东 淄博 博山区',1,0,1,'按时得发','<p>&nbsp;点点滴滴</p>','<p>&nbsp;哀死事生</p>','2013-08-06','b747771e-264d-4ddf-a182-17f9d4e005ea.jpg',NULL,NULL,NULL,'http://localhost:8080/ecshop/goods.php?id=33',75),(103,'06f579d6-026a-4187-aecd-bb0b59adc4a8','飒飒声','党参',2,'山东 淄博 博山区',1,0,1,'飒飒声','<p>&nbsp;上升</p>','<p>&nbsp;是</p>','2013-08-06','2acf9d5c-5f05-4d27-8a64-1cd81cdeb3f3.jpg',NULL,NULL,NULL,'http://localhost:8080/ecshop/goods.php?id=32',75),(104,'6a354c88-8f2e-4050-8c0c-ca2e40f61cf3','叮叮当当地对地导弹道导弹','党参, 红枣',1,'河北 秦皇岛 海港区',1,0,1,'sdfg','<p>&nbsp;asdf</p>','<p>&nbsp;asdf</p>','2013-08-08','3350ef2a-fcda-4517-88e0-64fc02345fff.jpg',56.0,78.00,23.00,'http://localhost:8080/ecshop/goods.php?id=34',68);
/*!40000 ALTER TABLE `t_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product_picture`
--

DROP TABLE IF EXISTS `t_product_picture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product_picture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productcode` varchar(60) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `scaledpath` varchar(384) DEFAULT NULL,
  `path` varchar(384) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_picture`
--

LOCK TABLES `t_product_picture` WRITE;
/*!40000 ALTER TABLE `t_product_picture` DISABLE KEYS */;
INSERT INTO `t_product_picture` VALUES (1,'20a5ab9c-f500-4b14-814d-cb2e6b542bc2',0,NULL,'1c8400f6-1ced-48ce-8898-a4c3dad9df0f.jpg',''),(2,'4cc03be8-9061-4e32-b78b-32dbac330d1c',0,NULL,'86ba541f-976d-4f88-bba8-d5cb1eb5da15.png',''),(3,'b278c83e-5195-4777-b20b-685cf0445209',0,NULL,'5fbe2dc3-4bfd-4869-97ab-26d14f489b8f.jpg',''),(4,'b278c83e-5195-4777-b20b-685cf0445209',1,NULL,'149b9e6c-9a8a-49bf-9592-617dd4af57e2.png',''),(5,'b278c83e-5195-4777-b20b-685cf0445209',2,NULL,'958aae9c-54aa-4226-882b-5de610c0dd8c.jpg',''),(6,'4205b993-a2a8-4107-91f0-7102ca0acb08',0,NULL,'83a77021-ab93-4889-ad22-e4a8b6274a4e.jpg',''),(7,'4205b993-a2a8-4107-91f0-7102ca0acb08',1,NULL,'b4bcea12-51ac-4db0-9e08-f2c578e56698.jpg',''),(8,'4205b993-a2a8-4107-91f0-7102ca0acb08',2,NULL,'a0cf7473-a8e5-49eb-b7c7-10bc488e8046.png',''),(9,'21d71fcd-875d-44a2-a2b8-0b75995a1270',0,NULL,'04560aaf-40a1-4457-8998-45562bcac7ca.jpg',''),(10,'21d71fcd-875d-44a2-a2b8-0b75995a1270',1,NULL,'d3e0a9f4-a6bc-4efb-ba3a-0560cdf35338.png',''),(11,'21d71fcd-875d-44a2-a2b8-0b75995a1270',2,NULL,'5ba49373-e45f-434a-84d7-8f73d5d0d2e5.jpg',''),(12,'5bd2a5af-bb59-4544-8e12-ef0b21225f63',0,NULL,'9236da11-6425-4c2f-8c58-dbc6ebcba175.png',''),(13,'5bd2a5af-bb59-4544-8e12-ef0b21225f63',1,NULL,'ae818ccc-e703-4a2e-89d0-c3df7724d06e.jpg',''),(14,'5bd2a5af-bb59-4544-8e12-ef0b21225f63',2,NULL,'734c3b18-b563-4a9a-a693-c812320dcdd2.jpg',''),(15,'fb9d4dcc-e6cc-48e1-90f7-70baa1f5a446',0,NULL,'f378b0b7-7de0-427b-9094-c2114d5ae302.jpg',''),(16,'30c32b37-f65f-4bab-bb97-372c16dd871c',0,NULL,'84faf64e-32fc-4480-8d8b-d708b25843b7.jpg',''),(17,'30c32b37-f65f-4bab-bb97-372c16dd871c',1,NULL,'cda558d4-74f0-44ed-ac4d-e944eee8b76d.jpg',''),(18,'1124d72c-d556-4166-bb88-ecb518d904d8',0,NULL,'ac0caa81-39de-427f-ad76-a83c89e9d666.jpg',''),(19,'2db0e9c3-7672-4eb1-b7a5-b8ada3f5ec29',0,NULL,'04f6e163-c6a6-4f6f-ac73-182ad7559544.jpg',''),(20,'96356754-2359-4ff2-9288-9b12f28c21c4',0,NULL,'0f49a408-55a4-47b3-be04-f5cfa2dcb901.jpg',''),(21,'96356754-2359-4ff2-9288-9b12f28c21c4',1,NULL,'bcd70af8-ec28-4177-84e0-7d6fcd5074f8.jpg',''),(22,'064aea58-3e3b-40ce-a28e-a59c185db44a',0,NULL,'477a7888-bf5d-4416-82e8-425ab426bcc0.jpg',''),(23,'064aea58-3e3b-40ce-a28e-a59c185db44a',1,NULL,'7c5e694d-cb69-4842-8a8a-05156ffb65f8.jpg',''),(24,'897e4e4a-fa82-4fa4-843d-7f2f2adeff00',0,NULL,'6fef2879-77a6-4dd4-a5ac-db0a2c53d3b7.jpg',''),(25,'897e4e4a-fa82-4fa4-843d-7f2f2adeff00',1,NULL,'2d45e41b-0a8c-4ece-bc68-d9d9da4c9fd6.jpg',''),(26,'87192795-0788-4fbc-9c0e-38e9b2e355c6',0,NULL,'490eac24-497b-4e0f-967a-fd8a10f11e73.jpg',''),(27,'87192795-0788-4fbc-9c0e-38e9b2e355c6',1,NULL,'f9c9e576-2bc5-4dde-bc7b-5530c80941d5.jpg',''),(28,'ac9d71d3-832a-456d-b8c8-5aad859f3feb',0,NULL,'45217951-d4bc-492f-b886-3598421fd82d.jpg',''),(29,'ac9d71d3-832a-456d-b8c8-5aad859f3feb',1,NULL,'ee0446fb-fac6-42a4-bb23-6eb2d4e79272.jpg',''),(30,'ac9d71d3-832a-456d-b8c8-5aad859f3feb',2,NULL,'ec968b99-1b51-4421-8e1c-4ba75e86d81b.jpg',''),(31,'ac9d71d3-832a-456d-b8c8-5aad859f3feb',3,NULL,'e2a1b63e-0d8b-422a-877d-4b1164fd1d18.jpg',''),(33,NULL,0,NULL,'01aab5fa-b761-42f3-a8b1-7c69d5ce9b83.jpg',''),(34,'8f586ced-131f-4c71-b88c-ae6a5e819718',0,NULL,'c5d4837f-91ff-4735-b55c-ef715001cd60.jpg',''),(35,NULL,0,NULL,'5229085b-0440-49eb-923d-e83c2262f27b.png',''),(51,NULL,0,'12401af4-34a4-466e-820b-4472f59041ed.jpg','134aa86a-b6d9-433c-99b5-8bae11b7d8d2.jpg',''),(52,NULL,1,'350c22ae-d2d9-4218-94c3-c2f7bbb1cc02.jpg','b1e7017a-8c9f-4813-971c-a57424b2b4b3.jpg',''),(53,NULL,2,'c69d6d24-4ed7-45e1-ace5-8f3d1c56b6f1.png','e4946a46-5e62-4720-b1f4-addca3e9f9fe.png',''),(54,NULL,0,'2209c22a-ea9b-4bb7-9e70-aa0ebc78519d.jpg','206ad8e8-2d96-4da3-9fa3-1d2a0bd3ada8.jpg',''),(55,NULL,0,'60c7d22a-2d84-4d03-bd33-561597cef857.png','5a9da53e-4097-4b09-9aaa-a37107db40a8.png',''),(73,'ff4575e0-f1be-4ca7-a978-e4715f9acaee',0,'1b1494a4-bac1-42ae-a934-c5a53c66a671.jpg','20f798fa-d1ef-4cec-a2ef-90f752fa8f60.jpg',''),(74,'ff4575e0-f1be-4ca7-a978-e4715f9acaee',1,'a7dac48d-d2c1-4afc-a745-850bd53bf659.jpg','5bca302c-7a93-4b83-baa1-9b196f3a6e04.jpg',''),(75,'ff4575e0-f1be-4ca7-a978-e4715f9acaee',2,'c8066f3a-5b35-463f-aab3-585e274a0ed6.jpg','b02d0e3a-216a-42eb-b6e7-90649aa56aa4.jpg',''),(76,'ff4575e0-f1be-4ca7-a978-e4715f9acaee',3,'a0e091fa-65e6-4009-ab20-6a29351a5ca3.jpg','fd536c28-22f8-4fb3-8e35-cbfe1a959f57.jpg',''),(77,'3c3d98bf-22ad-4434-a285-8c7af9e54752',0,'2db64662-9ce8-4cf8-a3e6-0a40858420bf.jpg','8b948267-f26e-4869-bc61-af5ff2aad00f.jpg',''),(78,'4cd82949-3835-423e-9fef-795223480542',0,'2c7f0e15-c4ba-43c4-859f-734dcd1f3085.jpg','e2429c97-d2e5-418b-b86f-93eee7fc684b.jpg',''),(79,'dbf6de07-fcd2-4a6b-a276-d5aed71b5a1a',0,'3e921cd1-7c9d-48d8-8971-d42d3cd8c8b1.jpg','9da15014-0484-461d-9ebe-cd08e374ea1f.jpg',''),(80,'5b27cabc-5615-4ef0-8b43-84b3acc17b75',0,'5656084a-5c89-4352-9def-ada6c8229f84.jpg','6d69ece9-2366-4b4a-83fc-e0f35f45d9bb.jpg',''),(81,'66aa0fe6-3f83-48c8-b38d-e3e3dbd584f0',0,'b48937f8-a7ef-4ae3-aa08-314414ae660d.jpg','9d47a3fc-c3ce-4c25-b493-b81f79ba6b30.jpg',''),(82,'10f7aa2a-ffc9-4190-bd3b-0d066f7ae5e4',0,'a9317cbc-da44-4ee1-8854-e0fbfc24bf4d.jpg','74b5347e-43db-4c1f-9d49-1cdcdd8a58ee.jpg',''),(83,'f0604299-10cd-40f2-a1da-c2a57f21bdb3',0,'f4770d01-c33e-4ab9-a6eb-5dd21d8cad88.jpg','f31b80b9-c4df-46f4-b29a-fbfc6710a6bf.jpg',''),(84,'f0604299-10cd-40f2-a1da-c2a57f21bdb3',1,'2c5292ab-177d-45ed-bc8f-e01b16bb4898.jpg','a565c51e-3cbf-4d55-a969-29fccfd99743.jpg',''),(85,'cb40d284-937f-42c4-bf66-4001968cdb7c',0,'7c0764ca-84f1-43cc-9897-3f09b4cb60eb.jpg','12b627ac-2e70-419b-8059-47d676a80096.jpg',''),(86,'289bc9c1-a324-4dbe-970c-efb4b85850c0',0,'4fe8ca0a-4a69-47bd-9459-2b41c3a4c1b6.jpg','bc95bf85-fd28-4bff-b479-520a480f22b0.jpg',''),(87,'289bc9c1-a324-4dbe-970c-efb4b85850c0',1,'2c27bbf5-38fd-4903-ba39-00543d391a8d.jpg','c8a46c3a-7dfe-486e-9fca-7b48e97dc09c.jpg',''),(88,'c2ea6d5f-eded-4362-845f-4d51f105ced4',0,'7ee4acb8-78c7-42f6-b708-6208ef68b232.jpg','7959c0c1-ba90-4f58-837e-9958e48be0e6.jpg',''),(89,'80293bdf-b6f7-4e18-9a99-a9d6063759df',0,'33deab51-ebe7-4b8c-a043-915f384cc8ad.jpg','49c04556-6513-4991-a3ef-29dabf943bc6.jpg',''),(90,'80293bdf-b6f7-4e18-9a99-a9d6063759df',1,'50ac3e71-4371-49c8-bfdb-377726c1e092.jpg','5bc857e2-b305-47be-97ac-6c052c4d539c.jpg',''),(91,'c2ea6d5f-eded-4362-845f-4d51f105ced4',0,'e3d4eb8e-1d77-4f21-ac29-fa4cdd43e946.jpg','a9a790ec-7833-4795-806b-362b3fe906c5.jpg',''),(92,'c2ea6d5f-eded-4362-845f-4d51f105ced4',0,'5e9b1193-e144-4fb4-b80f-ce774db0e281.jpg','ca255b76-8454-4e61-98b6-0df1866a3051.jpg',''),(93,'c2ea6d5f-eded-4362-845f-4d51f105ced4',1,'e80432a4-a90e-466d-83f4-bbcc2eb487de.jpg','b31cfbcb-8416-4775-9f84-aefc6d48542a.jpg',''),(94,'c2ea6d5f-eded-4362-845f-4d51f105ced4',2,'e590df86-fb76-4443-b422-eb296e690539.jpg','0bed666b-20ee-46d8-aae6-dce78cc26ca2.jpg',''),(95,'c2ea6d5f-eded-4362-845f-4d51f105ced4',3,'a648e4dd-2f4f-484b-bee8-8611e42b543e.jpg','0e465271-5f8b-48cd-8752-62956172ccc1.jpg',''),(96,'c2ea6d5f-eded-4362-845f-4d51f105ced4',4,'694d673a-2866-4994-8a13-f7d799cb40e1.jpg','19092106-48b3-4ede-a32d-5dfff0614950.jpg',''),(97,'c2ea6d5f-eded-4362-845f-4d51f105ced4',5,'035bf64c-1f10-4a38-89b1-5037bc097359.jpg','d9ea3221-4f73-47a8-98a3-fb4b74fb978f.jpg',''),(98,'2b745dfb-7d40-495e-931a-c3c97e34c687',0,'e58772ca-2ed7-4aa5-9185-755129032be2.png','467313ba-f987-46b1-af12-f111b4a7d09c.png',''),(99,'2b745dfb-7d40-495e-931a-c3c97e34c687',1,'804e968d-3791-4574-83f8-f62675eade5e.png','98f41cc0-5dbd-42ef-ac0b-40bb0a3258a6.png',''),(100,'587ad8cd-d8db-464f-aaff-73d47e6ab89e',0,'7e9f5242-57ac-47de-941d-7226163baaaf.jpg','23645ba9-48bb-44bd-90d9-eb932bacda34.jpg',''),(101,'14269139-380a-44ba-8831-9e06a86286a0',0,'7f12375a-c3c9-47de-86aa-1a33a4d63698.jpg','42a3ab83-5939-4c78-8e38-0396ce1e15d4.jpg',''),(102,'14269139-380a-44ba-8831-9e06a86286a0',1,'1c03cc51-de5c-45d1-a9f3-98436f745ad2.jpg','70314f83-21bf-44af-9c6b-47b703b54b97.jpg',''),(103,'48dbc4b0-a9e8-47a7-9261-4eb39d677cd2',0,'785c4f29-c6ce-4a9d-89b1-dab6b508dcd7.jpg','1a43541a-78c6-4352-802d-e5cee316be49.jpg',''),(104,'48dbc4b0-a9e8-47a7-9261-4eb39d677cd2',1,'11c4b1db-aeab-436d-a6a9-7785e8b634ad.jpg','16617623-4f33-4638-bc76-49968ee38b86.jpg',''),(105,'01f7a74b-f3f5-4afe-b8eb-536286478661',0,'420b4847-8c3c-495e-95a2-ca7436042eac.jpg','80075ec8-a58a-4392-b4c8-adbe7edcac93.jpg',''),(106,'01f7a74b-f3f5-4afe-b8eb-536286478661',1,'33cf4d02-5574-4484-aee5-2e51e0a356b3.jpg','88eed272-ff63-495c-8db6-3f4e44e652b9.jpg',''),(107,'01f7a74b-f3f5-4afe-b8eb-536286478661',2,'8339f692-6961-4403-abcf-db65920cc351.jpg','51e482cb-8b92-464e-9b4e-ecee278be7d1.jpg',''),(108,'78dfaec2-986d-457f-8693-89985ab56ae1',0,'3cee9f52-e3f0-4ddb-9a8b-208f4231bc93.jpg','1091d838-bc41-4226-92b6-537cc85f530c.jpg',''),(109,'78dfaec2-986d-457f-8693-89985ab56ae1',1,'80e3bf09-f665-4eec-975f-8e4eeb74f459.jpg','90a37903-b55b-4a86-82bf-8bc8e5db9296.jpg',''),(110,'78dfaec2-986d-457f-8693-89985ab56ae1',2,'55a30254-e4b3-4e2b-a97c-f7015da85f7c.jpg','2dc1cacc-11b9-48d4-9447-988fba9e2e57.jpg',''),(111,'06f579d6-026a-4187-aecd-bb0b59adc4a8',0,'c26af6ac-1cbe-42aa-91f8-93f50b5d34f0.jpg','3fb2e714-f695-419b-9de2-5d5c791f3326.jpg',''),(112,'6a354c88-8f2e-4050-8c0c-ca2e40f61cf3',0,'2bd9aa51-d953-4453-81d2-4327d8f1c6db.jpg','6c96153b-21f4-42cb-9fd9-e348976a3378.jpg',''),(113,'6a354c88-8f2e-4050-8c0c-ca2e40f61cf3',1,'832f68c0-286f-4b4f-a201-f484c57db6aa.jpg','0d8aa763-210c-4886-be5a-950861939db8.jpg','');
/*!40000 ALTER TABLE `t_product_picture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_projectnews`
--

DROP TABLE IF EXISTS `t_projectnews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_projectnews` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `type` int(3) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `content` text,
  `contcode` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_projectnews`
--

LOCK TABLES `t_projectnews` WRITE;
/*!40000 ALTER TABLE `t_projectnews` DISABLE KEYS */;
INSERT INTO `t_projectnews` VALUES (21,'asfdasdf',3,'2013-07-08','<p>&nbsp;2323r23r23</p>','3f1aacf7-2023-43ee-94a8-c733ec203135'),(25,'asdfasdf',1,'2013-07-08','<p>&nbsp;asdfasdf</p>','fb7c0eeb-07b7-4427-a21f-c273ab577ea0'),(26,'哀伤地发射多发送方 ',1,'2013-07-08','<p>&nbsp;asdfasdfasdf</p>','26c8a5aa-c85d-4541-99df-f902de38a4c7'),(27,'飒飒声按时得发',3,'2013-07-08','<p>&nbsp;ssssss</p>','7326da6a-74ba-4700-b4f5-e52c754bfd40'),(31,'暗暗士大夫',2,'2013-07-08','<p>&nbsp;asdfasdfasdf</p>','ec28d71b-2895-42a9-acec-40dc26dc86b9'),(32,'飒飒声达到',2,'2013-07-08','<p>&nbsp;asdfasdfsadf</p>','077ab42a-baa3-4c72-8422-950694384808'),(33,'按时得发送到发生地发',3,'2013-07-08','<p>&nbsp;asdfasdfdf</p>','a6b636e7-70b5-4f3a-8afb-667a099a12c3');
/*!40000 ALTER TABLE `t_projectnews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_resource`
--

DROP TABLE IF EXISTS `t_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `type` int(3) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `content` text,
  `contcode` varchar(100) DEFAULT NULL,
  `ctype` char(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_resource`
--

LOCK TABLES `t_resource` WRITE;
/*!40000 ALTER TABLE `t_resource` DISABLE KEYS */;
INSERT INTO `t_resource` VALUES (4,'阿萨德发放',1,'2012-12-29','<p><img alt=\"\" style=\"width: 238px; height: 170px\" src=\"/pcms/userfiles/image/Penguins.jpg\" /></p>\r\n<p>&nbsp;阿斯顿发沙发大师傅</p>\r\n<p>&nbsp;</p>\r\n<p>&nbsp;</p>','be81ebcf-db6b-48e4-ac78-ebea2d1e0b0a','3'),(5,'太太',2,'2012-12-29','<p><img width=\"200\" height=\"150\" alt=\"\" src=\"/pcms/userfiles/image/Jellyfish.jpg\" />阿斯顿发生的发生地方</p>\r\n<p>阿斯顿发生非法</p>','884aff81-a49c-40b7-a358-067399b9ffdf','4'),(12,'资源视图',6,'2013-04-06','<p style=\"text-align: center;\"><img alt=\"\" style=\"width: 600px; height: 407px;\" src=\"/userfiles/image/业务资源.gif\" /></p>\r\n<p><span style=\"font: 14px/21px Tahoma, 宋体; color: rgb(82, 82, 82); text-transform: none; text-indent: 0px; letter-spacing: normal; word-spacing: 0px; float: none; display: inline !important; white-space: normal; orphans: 2; widows: 2; font-size-adjust: none; font-stretch: normal; -webkit-text-size-adjust: auto; -webkit-text-stroke-width: 0px;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;我们打造一个技术平台，侧重创新内容服务；立足行业联盟，洞察行业商机；基于专家团队，凝聚研发实力；联合人才基地，保障人才供给；关注高校创新中心建设，致力青年创新服务；通过创新项目，奠定价值盈利模式。</span></p>\r\n<p><span style=\"font: 14px/21px Tahoma, 宋体; color: rgb(82, 82, 82); text-transform: none; text-indent: 0px; letter-spacing: normal; word-spacing: 0px; float: none; display: inline !important; white-space: normal; orphans: 2; widows: 2; font-size-adjust: none; font-stretch: normal; -webkit-text-size-adjust: auto; -webkit-text-stroke-width: 0px;\">企业立身的业务资源包括：</span></p>\r\n<ul>\r\n    <li><span style=\"font: 14px/21px Tahoma, 宋体; color: rgb(82, 82, 82); text-transform: none; text-indent: 0px; letter-spacing: normal; word-spacing: 0px; float: none; display: inline !important; white-space: normal; orphans: 2; widows: 2; font-size-adjust: none; font-stretch: normal; -webkit-text-size-adjust: auto; -webkit-text-stroke-width: 0px;\"><span id=\"1365235468588S\" style=\"display: none;\">&nbsp;</span>1个系统创新创业孵化技术平台</span></li>\r\n    <li><span style=\"font: 14px/21px Tahoma, 宋体; color: rgb(82, 82, 82); text-transform: none; text-indent: 0px; letter-spacing: normal; word-spacing: 0px; float: none; display: inline !important; white-space: normal; orphans: 2; widows: 2; font-size-adjust: none; font-stretch: normal; -webkit-text-size-adjust: auto; -webkit-text-stroke-width: 0px;\">5+行业集团战略联盟合作业务</span></li>\r\n    <li><span style=\"font: 14px/21px Tahoma, 宋体; color: rgb(82, 82, 82); text-transform: none; text-indent: 0px; letter-spacing: normal; word-spacing: 0px; float: none; display: inline !important; white-space: normal; orphans: 2; widows: 2; font-size-adjust: none; font-stretch: normal; -webkit-text-size-adjust: auto; -webkit-text-stroke-width: 0px;\">50+专家团队资源共同发展</span></li>\r\n    <li><span style=\"font: 14px/21px Tahoma, 宋体; color: rgb(82, 82, 82); text-transform: none; text-indent: 0px; letter-spacing: normal; word-spacing: 0px; float: none; display: inline !important; white-space: normal; orphans: 2; widows: 2; font-size-adjust: none; font-stretch: normal; -webkit-text-size-adjust: auto; -webkit-text-stroke-width: 0px;\">3+人才培养及研发基地联合营运</span></li>\r\n    <li><span style=\"font: 14px/21px Tahoma, 宋体; color: rgb(82, 82, 82); text-transform: none; text-indent: 0px; letter-spacing: normal; word-spacing: 0px; float: none; display: inline !important; white-space: normal; orphans: 2; widows: 2; font-size-adjust: none; font-stretch: normal; -webkit-text-size-adjust: auto; -webkit-text-stroke-width: 0px;\">10+合作高校创新中心共同建设</span></li>\r\n    <li><span style=\"font: 14px/21px Tahoma, 宋体; color: rgb(82, 82, 82); text-transform: none; text-indent: 0px; letter-spacing: normal; word-spacing: 0px; float: none; display: inline !important; white-space: normal; orphans: 2; widows: 2; font-size-adjust: none; font-stretch: normal; -webkit-text-size-adjust: auto; -webkit-text-stroke-width: 0px;\">10+科技创新项目在线研发<span id=\"1365235469273E\" style=\"display: none;\">&nbsp;</span></span></li>\r\n</ul>','ab825863-d32e-4824-b42e-d83de11dc12f','1'),(13,'创新项目经理',5,'2013-06-06','<p>负责公司创新孵化项目的推进管理。详情面谈。</p>\r\n<p><font face=\"宋体\"><span style=\"mso-bookmark: OLE_LINK1;\"><span style=\"mso-bookmark: OLE_LINK2;\"><span style=\"font-size: 9pt; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial; mso-bidi-font-family: Arial;\">联系方式：</span></span></span></font><a href=\"mailto:HR@can2do.com\"><span style=\"mso-bookmark: OLE_LINK1;\"><span style=\"mso-bookmark: OLE_LINK2;\"><span lang=\"EN-US\" style=\"font-family: &quot;Arial&quot;,&quot;sans-serif&quot;; font-size: 9pt;\">HR@can2do.com</span></span></span></a><span style=\"mso-bookmark: OLE_LINK1;\"><span style=\"mso-bookmark: OLE_LINK2;\"><span style=\"font-size: 9pt; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial; mso-bidi-font-family: Arial;\"><font face=\"宋体\">，</font></span></span></span><span style=\"mso-bookmark: OLE_LINK1;\"><span style=\"mso-bookmark: OLE_LINK2;\"><span lang=\"EN-US\" style=\"font-family: &quot;Arial&quot;,&quot;sans-serif&quot;; font-size: 9pt;\">18913007572</span></span></span><span style=\"mso-bookmark: OLE_LINK1;\"><span style=\"mso-bookmark: OLE_LINK2;\"><span style=\"font-size: 9pt; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial; mso-bidi-font-family: Arial;\"><font face=\"宋体\">，冯小姐。</font></span></span></span></p>\r\n<p><span style=\"font-family: 宋体; font-size: 9pt; \">截至日期：2013-08-10</span></p>','c92686b9-766f-4584-8f56-89ebb525ee56','2'),(14,'商务专员',1,'2013-06-06','<p>协助公司领导外部商务活动，包括商务洽谈、业务拓展、市场调研等。详情面谈。</p>\r\n<p><font face=\"宋体\"><span style=\"mso-bookmark: OLE_LINK1;\"><span style=\"mso-bookmark: OLE_LINK2;\"><span style=\"font-size: 9pt; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial; mso-bidi-font-family: Arial;\">联系方式：</span></span></span></font><a href=\"mailto:HR@can2do.com\"><font color=\"#0000ff\"><span style=\"mso-bookmark: OLE_LINK1;\"><span style=\"mso-bookmark: OLE_LINK2;\"><span lang=\"EN-US\" style=\"font-family: &quot;Arial&quot;,&quot;sans-serif&quot;; font-size: 9pt;\">HR@can2do.com</span></span></span></font></a><span style=\"mso-bookmark: OLE_LINK1;\"><span style=\"mso-bookmark: OLE_LINK2;\"><span style=\"font-size: 9pt; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial; mso-bidi-font-family: Arial;\"><font face=\"宋体\">，</font></span></span></span><span style=\"mso-bookmark: OLE_LINK1;\"><span style=\"mso-bookmark: OLE_LINK2;\"><span lang=\"EN-US\" style=\"font-family: &quot;Arial&quot;,&quot;sans-serif&quot;; font-size: 9pt;\">18913007572</span></span></span><span style=\"mso-bookmark: OLE_LINK1;\"><span style=\"mso-bookmark: OLE_LINK2;\"><span style=\"font-size: 9pt; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial; mso-bidi-font-family: Arial;\"><font face=\"宋体\">，冯小姐。</font></span></span></span></p>\r\n<p><span style=\"font-family: 宋体; font-size: 9pt; \">截至日期：2013-08-10</span></p>','0162b016-5402-4fc9-9abe-69325a994d34','2'),(15,'技术专员',1,'2013-06-06','<pre>\r\n负责公司网络系统平台的技术维护、数据维护，以及外包团队的接口联系。详情面谈。\r\n<font face=\"宋体\"><span style=\"mso-bookmark: OLE_LINK1;\"><span style=\"mso-bookmark: OLE_LINK2;\"><span style=\"font-size: 9pt; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial; mso-bidi-font-family: Arial;\">  联系方式：</span></span></span></font><a href=\"mailto:HR@can2do.com\"><span style=\"mso-bookmark: OLE_LINK1;\"><span style=\"mso-bookmark: OLE_LINK2;\"><span lang=\"EN-US\" style=\"font-family: &quot;Arial&quot;,&quot;sans-serif&quot;; font-size: 9pt;\">HR@can2do.com</span></span></span></a><span style=\"mso-bookmark: OLE_LINK1;\"><span style=\"mso-bookmark: OLE_LINK2;\"><span style=\"font-size: 9pt; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial; mso-bidi-font-family: Arial;\"><font face=\"宋体\">，</font></span></span></span><span style=\"mso-bookmark: OLE_LINK1;\"><span style=\"mso-bookmark: OLE_LINK2;\"><span lang=\"EN-US\" style=\"font-family: &quot;Arial&quot;,&quot;sans-serif&quot;; font-size: 9pt;\">18913007572</span></span></span><span style=\"mso-bookmark: OLE_LINK1;\"><span style=\"mso-bookmark: OLE_LINK2;\"><span style=\"font-size: 9pt; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial; mso-bidi-font-family: Arial;\"><font face=\"宋体\">，冯小姐。   </font></span></span></span><span style=\"font-family: 宋体; font-size: 9pt; \"> </span></pre>\r\n<p><br />\r\n截至日期：2013-08-10</p>','f7a8709f-b5b8-4448-b56c-4975955530e9','2'),(16,'业务副总',2,'2013-06-06','<pre>\r\n负责公司市场业务拓展与管理。详情面谈。\r\n\r\n<span><span style=\"font-size: 9pt;\">联系方式：</span></span><a href=\"mailto:HR@can2do.com\"><font color=\"#0000ff\"><span><span style=\"font-size: 9pt;\">HR@can2do.com</span></span></font></a><span><span style=\"font-size: 9pt;\">，</span></span><span><span style=\"font-size: 9pt;\">18913007572</span></span><span><span style=\"font-size: 9pt;\">，冯小姐。   </span></span><span style=\"font-family: 宋体; font-size: 9pt; \"> </span></pre>\r\n\r\n<br>\r\n截至日期：2013-08-10','56b4370f-b36d-4d2b-9891-3ae7f81e61d5','2'),(17,'美学专员',1,'2013-06-06','<pre>\r\n负责公司网络系统美学元素设计及公司市场广告美学设计。详情面谈。\r\n\r\n<font face=\"宋体\"><span style=\"mso-bookmark: OLE_LINK1;\"><span style=\"mso-bookmark: OLE_LINK2;\"><span style=\"font-size: 9pt; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial; mso-bidi-font-family: Arial;\">联系方式：</span></span></span></font><a href=\"mailto:HR@can2do.com\"><font color=\"#0000ff\"><span style=\"mso-bookmark: OLE_LINK1;\"><span style=\"mso-bookmark: OLE_LINK2;\"><span lang=\"EN-US\" style=\"font-family: &quot;Arial&quot;,&quot;sans-serif&quot;; font-size: 9pt;\">HR@can2do.com</span></span></span></font></a><span style=\"mso-bookmark: OLE_LINK1;\"><span style=\"mso-bookmark: OLE_LINK2;\"><span style=\"font-size: 9pt; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial; mso-bidi-font-family: Arial;\"><font face=\"宋体\">，</font></span></span></span><span style=\"mso-bookmark: OLE_LINK1;\"><span style=\"mso-bookmark: OLE_LINK2;\"><span lang=\"EN-US\" style=\"font-family: &quot;Arial&quot;,&quot;sans-serif&quot;; font-size: 9pt;\">18913007572</span></span></span><span style=\"mso-bookmark: OLE_LINK1;\"><span style=\"mso-bookmark: OLE_LINK2;\"><span style=\"font-size: 9pt; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial; mso-bidi-font-family: Arial;\"><font face=\"宋体\">，冯小姐。      <br type=\"_moz\" /></font></span></span></span></pre>\r\n<br>\r\n截至日期：2013-08-10','af999bf6-abb6-44c6-83c4-1b85499fedf0','2'),(18,'1个系统化创新技术平台',6,'2013-04-06','<p>立足面向青年，服务未来的企业价值，我们构建了一套专业的床戏创业孵化体系，打造一个侧重创新创业内容服务的技术平台。</p>\r\n<p>创新创业孵化，需要借助各硬件孵化器，包括场地、服务、管理等，但更重要的是创意、项目、运作管理。因此，我们从关注创意理论和实践的创新中心开始，提供人才中心、项目中心、政策中心和资本中心的内容服务，并整合行业联盟、专家联盟、高教联盟、园区联盟以及同行联盟，提供强大经验背景资源。</p>\r\n<p>详情参见<a href=\"http://www.can2do.com/platform\">创新技术平台系统</a>。</p>','4755bbae-1284-4349-8479-3ac9ad2f8628','1'),(19,'5+行业集团战略合作',1,'2013-04-06','<p>截止目前，已经与5+行业集团达成战略合作关系。基于凯之渡创新体系，我们将持续打造&ldquo;行业联盟&rdquo;，与志同道合的行业企业集团，达成战略务实合作，为杰出青年、创新项目提供行业资源。同时，凯之渡深入行业，保持创新敏锐，使得创意拥有坚实土壤。</p>','aabb444e-99a1-42f3-85a9-540d39d985d4','1'),(20,'50+专家团队支撑',2,'2013-04-06','<p>再好的创业团队潜质，再卓越的外部培训，没有务实专家支撑，青年创新创业都势单力薄。</p>\r\n<p>青年创新创业，离不开经验专家的支撑。截止目前，已经有20+资深专家团队，主要包括技术专家、金融专家、法务专家以及管理专家。我们将持续构建专家联盟，一期要拥有50+专家，切实介入创新项目，提供支撑和经验辅导。</p>','7e1ebb64-c3dc-4521-b498-1d8d1148021a','1'),(21,'10+创新基地',3,'2013-04-06','<p>通过校企合作，与各地高校在创新创业人才培养、创新项目训练、创业孵化实践三个方面，共建创新中心，对内对外大学生提供创新创业孵化服务，一期将联合共建10+创新中心。同时，通过行业联盟，与各行业集团共建人才培养及研发基地，对内承接项目研发，对外承接大学生创新创业孵化服务。&nbsp;</p>\r\n<p>截止目前，已有3+行业联盟基地，可合作营运。这些不仅仅是场地资源，更是多方协作创新的人、财、物的立体联合资源。</p>','044c6e9a-c9df-4885-b51b-2db10c7ea4f6','1'),(22,'n+创意项目',6,'2013-04-06','<p>凯之渡基于经验背景，关注全行业商机，重点在移动互联、计电数码、生态农植、教育科技以及综合社会商机领域，策划设计创新创意，立项推动。并以孵化技术平台的&ldquo;创新中心&rdquo;子系统为依托，凝聚创意生产氛围，以&ldquo;项目中心&rdquo;子系统为依托，推行项目运作。</p>\r\n<p>创意来自四方，创新无处不在。我们开放维护一套创新项目资源库，可为杰出青年创业项目选择，提供引导、辅导和合作。</p>\r\n<p>截止目前，并发在研有10+创意项目。</p>','8017d145-8fe4-41e7-a66e-6c8dde8caa05','1');
/*!40000 ALTER TABLE `t_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_role`
--

DROP TABLE IF EXISTS `t_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1249 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_role`
--

LOCK TABLES `t_role` WRITE;
/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;
INSERT INTO `t_role` VALUES (372,'系统管理员','系统管理员'),(1248,'Can2DO','Can2DO操作员');
/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_sysconfig`
--

DROP TABLE IF EXISTS `t_sysconfig`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_sysconfig` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `keycol` varchar(255) DEFAULT NULL,
  `valuecol` varchar(255) DEFAULT NULL,
  `keywordcol` varchar(255) DEFAULT NULL,
  `groupcol` varchar(255) DEFAULT NULL,
  `editor` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_sysconfig`
--

LOCK TABLES `t_sysconfig` WRITE;
/*!40000 ALTER TABLE `t_sysconfig` DISABLE KEYS */;
INSERT INTO `t_sysconfig` VALUES (1,'顶部广告样式','1','topstyle','基本配置','text'),(2,'标题','南京凯之渡信息技术有限公司','title','基本配置','text'),(3,'采购合同甲方','南京渡之珍国际生态开发有限公司','jiafang','基本配置','text'),(4,'商城产品地址','http://localhost:8080/ecshop/goods.php','mallurl','基本配置','text'),(5,'MMPro平台图片存放路径','C:\\tomcat6.0.32\\webapps\\coop\\attach\\productpic','frompath','基本配置','text'),(6,'shop商城图片存放路径','D:\\Easy2PHP5\\WebSite\\ecshop\\images','topath','基本配置','text'),(7,'shop商城数据库地址','jdbc:mysql://localhost:3306/eshop','databaseurl','基本配置','text'),(8,'shop商城数据库用户名','root','databaseusername','基本配置','text'),(9,'shop商城数据库密码','root','databasepassword','基本配置','text');
/*!40000 ALTER TABLE `t_sysconfig` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_userinfo`
--

DROP TABLE IF EXISTS `t_userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `realname` varchar(255) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `officePhone` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `orga` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK21719AC4D9C644E6` (`orga`),
  CONSTRAINT `FK21719AC4D9C644E6` FOREIGN KEY (`orga`) REFERENCES `t_organization` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1279 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_userinfo`
--

LOCK TABLES `t_userinfo` WRITE;
/*!40000 ALTER TABLE `t_userinfo` DISABLE KEYS */;
INSERT INTO `t_userinfo` VALUES (1274,'admin','f3e717fec152f065339778cba0a517aa','汤定一',1,'12312312312','123123','123@qwe.cim','','2012-12-10 20:44:17',1254),(1277,'hly','26992d5fe1343669b1d3b7fd55cd2634','黄丽媛',2,'23562323','23232323','liyuan.huang@can2do.com','','2013-01-15 16:16:48',1255),(1278,'can2do','50fed5e616972bdfa21562596fe8e3f6','王学强',1,'13337818730','02558746698','xueqiang.wang@can2do.com','Manager','2013-03-21 15:03:45',1255);
/*!40000 ALTER TABLE `t_userinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_usersroles`
--

DROP TABLE IF EXISTS `t_usersroles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_usersroles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roles` int(11) DEFAULT NULL,
  `users` int(11) DEFAULT NULL,
  `orderNo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKD19B0A80BE61E9D7` (`users`),
  KEY `FKD19B0A807F054EE9` (`roles`),
  CONSTRAINT `FKD19B0A807F054EE9` FOREIGN KEY (`roles`) REFERENCES `t_role` (`id`),
  CONSTRAINT `FKD19B0A80BE61E9D7` FOREIGN KEY (`users`) REFERENCES `t_userinfo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10598 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_usersroles`
--

LOCK TABLES `t_usersroles` WRITE;
/*!40000 ALTER TABLE `t_usersroles` DISABLE KEYS */;
INSERT INTO `t_usersroles` VALUES (10590,372,1274,0),(10594,372,1278,0),(10597,1248,1277,0);
/*!40000 ALTER TABLE `t_usersroles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-08-08 16:54:27
