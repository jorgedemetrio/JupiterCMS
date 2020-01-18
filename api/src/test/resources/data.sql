DROP TABLE IF EXISTS `tb_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_category` (
  `id` varchar(200) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `ip_creator` varchar(20) NOT NULL,
  `version` varchar(250) NOT NULL,
  `id_user_created` varchar(200) DEFAULT NULL,
  `id_site` varchar(200) DEFAULT NULL,
  `updated_date` datetime(6) NOT NULL,
  `ip_alterator` varchar(20) DEFAULT NULL,
  `id_user_altered` varchar(200) DEFAULT NULL,
  `access` varchar(20) NOT NULL,
  `hits` bigint DEFAULT NULL,
  `likes` bigint DEFAULT NULL,
  `idiom` varchar(5) NOT NULL,
  `meta_description` varchar(250) DEFAULT NULL,
  `file_name` varchar(250) NOT NULL,
  `meta_keywords` varchar(250) DEFAULT NULL,
  `status` varchar(250) NOT NULL,
  `name` varchar(200) NOT NULL,
  `id_parent` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg7k3n1emkh7nmlvgf824iqwxk` (`id_parent`),
  KEY `FK_syd543fem2vr6ov59rq75b949` (`id_user_altered`),
  KEY `FK_l5nd2dw6kp68y3heuwrqsb71d` (`id_user_created`),
  KEY `FK_jseg14tgmcxirj2bhxx0e6cby` (`id_site`),
  CONSTRAINT `FK_jseg14tgmcxirj2bhxx0e6cby` FOREIGN KEY (`id_site`) REFERENCES `tb_site` (`id`),
  CONSTRAINT `FK_l5nd2dw6kp68y3heuwrqsb71d` FOREIGN KEY (`id_user_created`) REFERENCES `tb_usuario` (`id`),
  CONSTRAINT `FK_syd543fem2vr6ov59rq75b949` FOREIGN KEY (`id_user_altered`) REFERENCES `tb_usuario` (`id`),
  CONSTRAINT `FKg7k3n1emkh7nmlvgf824iqwxk` FOREIGN KEY (`id_parent`) REFERENCES `tb_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_category`
--

LOCK TABLES `tb_category` WRITE;
/*!40000 ALTER TABLE `tb_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_content`
--

DROP TABLE IF EXISTS `tb_content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_content` (
  `id` varchar(200) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `ip_creator` varchar(20) NOT NULL,
  `version` varchar(250) NOT NULL,
  `id_user_created` varchar(200) DEFAULT NULL,
  `id_site` varchar(200) DEFAULT NULL,
  `updated_date` datetime(6) NOT NULL,
  `ip_alterator` varchar(20) DEFAULT NULL,
  `id_user_altered` varchar(200) DEFAULT NULL,
  `access` varchar(20) NOT NULL,
  `hits` bigint DEFAULT NULL,
  `likes` bigint DEFAULT NULL,
  `idiom` varchar(5) NOT NULL,
  `meta_description` varchar(250) DEFAULT NULL,
  `file_name` varchar(250) NOT NULL,
  `meta_keywords` varchar(250) DEFAULT NULL,
  `status` varchar(250) NOT NULL,
  `content` varchar(200) NOT NULL,
  `spotlight` varchar(200) NOT NULL,
  `images` varchar(2000) DEFAULT NULL,
  `title` varchar(200) NOT NULL,
  `id_category` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbnlw61ur1evqk7yd1g0kih5pl` (`id_category`),
  KEY `FK_g8maa0gjrjk5rn6g28d1sc39y` (`id_user_altered`),
  KEY `FK_34qg14afh5bdhhoxmcaetihnj` (`id_user_created`),
  KEY `FK_3rhmn5cu788f5120eyj96ogvq` (`id_site`),
  CONSTRAINT `FK_34qg14afh5bdhhoxmcaetihnj` FOREIGN KEY (`id_user_created`) REFERENCES `tb_usuario` (`id`),
  CONSTRAINT `FK_3rhmn5cu788f5120eyj96ogvq` FOREIGN KEY (`id_site`) REFERENCES `tb_site` (`id`),
  CONSTRAINT `FK_g8maa0gjrjk5rn6g28d1sc39y` FOREIGN KEY (`id_user_altered`) REFERENCES `tb_usuario` (`id`),
  CONSTRAINT `FKbnlw61ur1evqk7yd1g0kih5pl` FOREIGN KEY (`id_category`) REFERENCES `tb_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_content`
--

LOCK TABLES `tb_content` WRITE;
/*!40000 ALTER TABLE `tb_content` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_content` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_content_terms`
--

DROP TABLE IF EXISTS `tb_content_terms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_content_terms` (
  `id_content` varchar(200) NOT NULL,
  `id_term` varchar(200) NOT NULL,
  UNIQUE KEY `UKl77gixkobunee7dfdebo187r` (`id_content`,`id_term`),
  KEY `FKjwlttvuvjoxsgtaaw5h7fl3e5` (`id_term`),
  CONSTRAINT `FK9w1kphukw3dkm4l77ex5sm4tp` FOREIGN KEY (`id_content`) REFERENCES `tb_content` (`id`),
  CONSTRAINT `FKjwlttvuvjoxsgtaaw5h7fl3e5` FOREIGN KEY (`id_term`) REFERENCES `tb_term` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_content_terms`
--

LOCK TABLES `tb_content_terms` WRITE;
/*!40000 ALTER TABLE `tb_content_terms` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_content_terms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_group`
--

DROP TABLE IF EXISTS `tb_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_group` (
  `id` varchar(200) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `ip_creator` varchar(20) NOT NULL,
  `version` varchar(250) NOT NULL,
  `id_user_created` varchar(200) DEFAULT NULL,
  `id_site` varchar(200) DEFAULT NULL,
  `updated_date` datetime(6) NOT NULL,
  `ip_alterator` varchar(20) DEFAULT NULL,
  `id_user_altered` varchar(200) DEFAULT NULL,
  `name` varchar(200) NOT NULL,
  `status` varchar(20) DEFAULT NULL,
  `id_parent` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8d3pvv3vc5idimau552ra186p` (`id_parent`),
  KEY `FK_9kym3i5pw2xg3hbf76s41cirt` (`id_user_altered`),
  KEY `FK_f4yle18fpr72hhlm89tpavj5y` (`id_user_created`),
  KEY `FK_kopd5m9ml9nex0ila111k8bnd` (`id_site`),
  CONSTRAINT `FK8d3pvv3vc5idimau552ra186p` FOREIGN KEY (`id_parent`) REFERENCES `tb_group` (`id`),
  CONSTRAINT `FK_9kym3i5pw2xg3hbf76s41cirt` FOREIGN KEY (`id_user_altered`) REFERENCES `tb_usuario` (`id`),
  CONSTRAINT `FK_f4yle18fpr72hhlm89tpavj5y` FOREIGN KEY (`id_user_created`) REFERENCES `tb_usuario` (`id`),
  CONSTRAINT `FK_kopd5m9ml9nex0ila111k8bnd` FOREIGN KEY (`id_site`) REFERENCES `tb_site` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_group`
--

LOCK TABLES `tb_group` WRITE;
/*!40000 ALTER TABLE `tb_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_group_permissions`
--

DROP TABLE IF EXISTS `tb_group_permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_group_permissions` (
  `permission` int NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `ip_creator` varchar(20) NOT NULL,
  `id_group` varchar(200) NOT NULL,
  `id_user_created` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_group`,`permission`),
  KEY `FKimfrix5vv2mhl5tpyen2c496n` (`id_user_created`),
  CONSTRAINT `FKimfrix5vv2mhl5tpyen2c496n` FOREIGN KEY (`id_user_created`) REFERENCES `tb_usuario` (`id`),
  CONSTRAINT `FKnlmp4gfo5iemq52ctgbyffxod` FOREIGN KEY (`id_group`) REFERENCES `tb_group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_group_permissions`
--

LOCK TABLES `tb_group_permissions` WRITE;
/*!40000 ALTER TABLE `tb_group_permissions` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_group_permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_history_access`
--

DROP TABLE IF EXISTS `tb_history_access`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_history_access` (
  `id` varchar(200) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `ip_creator` varchar(20) NOT NULL,
  `version` varchar(250) NOT NULL,
  `id_user_created` varchar(200) DEFAULT NULL,
  `id_site` varchar(200) DEFAULT NULL,
  `log` varchar(2000) NOT NULL,
  `page` varchar(250) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_475r0jp9xkmr6pyjxp3ewc1lf` (`id_user_created`),
  KEY `FK_6s4n2vtiq8n7s1out7tnkm5qi` (`id_site`),
  CONSTRAINT `FK_475r0jp9xkmr6pyjxp3ewc1lf` FOREIGN KEY (`id_user_created`) REFERENCES `tb_usuario` (`id`),
  CONSTRAINT `FK_6s4n2vtiq8n7s1out7tnkm5qi` FOREIGN KEY (`id_site`) REFERENCES `tb_site` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_history_access`
--

LOCK TABLES `tb_history_access` WRITE;
/*!40000 ALTER TABLE `tb_history_access` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_history_access` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_history_pass`
--

DROP TABLE IF EXISTS `tb_history_pass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_history_pass` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created` datetime(6) NOT NULL,
  `pass` varchar(255) NOT NULL,
  `id_user` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3r0iaue7e7jpqk85u3d0xu7e4` (`id_user`),
  CONSTRAINT `FK3r0iaue7e7jpqk85u3d0xu7e4` FOREIGN KEY (`id_user`) REFERENCES `tb_usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_history_pass`
--

LOCK TABLES `tb_history_pass` WRITE;
/*!40000 ALTER TABLE `tb_history_pass` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_history_pass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_menu`
--

DROP TABLE IF EXISTS `tb_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_menu` (
  `id` varchar(200) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `ip_creator` varchar(20) NOT NULL,
  `version` varchar(250) NOT NULL,
  `id_user_created` varchar(200) DEFAULT NULL,
  `id_site` varchar(200) DEFAULT NULL,
  `updated_date` datetime(6) NOT NULL,
  `ip_alterator` varchar(20) DEFAULT NULL,
  `id_user_altered` varchar(200) DEFAULT NULL,
  `access` varchar(20) NOT NULL,
  `hits` bigint DEFAULT NULL,
  `likes` bigint DEFAULT NULL,
  `idiom` varchar(5) NOT NULL,
  `meta_description` varchar(250) DEFAULT NULL,
  `file_name` varchar(250) NOT NULL,
  `meta_keywords` varchar(250) DEFAULT NULL,
  `status` varchar(250) NOT NULL,
  `startpage` bit(1) NOT NULL,
  `layout` varchar(50) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `parameters` tinyblob NOT NULL,
  `type` int NOT NULL,
  `parent` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbsqyu02i49bmhctv7w809dasv` (`parent`),
  KEY `FK_owl3yce9hsxgca65q5w1hi87c` (`id_user_altered`),
  KEY `FK_dvtj1bd2apy4tn1fw1lsxc4de` (`id_user_created`),
  KEY `FK_1kg6nus7nua7lfe08yqfo8lmm` (`id_site`),
  CONSTRAINT `FK_1kg6nus7nua7lfe08yqfo8lmm` FOREIGN KEY (`id_site`) REFERENCES `tb_site` (`id`),
  CONSTRAINT `FK_dvtj1bd2apy4tn1fw1lsxc4de` FOREIGN KEY (`id_user_created`) REFERENCES `tb_usuario` (`id`),
  CONSTRAINT `FK_owl3yce9hsxgca65q5w1hi87c` FOREIGN KEY (`id_user_altered`) REFERENCES `tb_usuario` (`id`),
  CONSTRAINT `FKbsqyu02i49bmhctv7w809dasv` FOREIGN KEY (`parent`) REFERENCES `tb_menu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_menu`
--

LOCK TABLES `tb_menu` WRITE;
/*!40000 ALTER TABLE `tb_menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_site`
--

DROP TABLE IF EXISTS `tb_site`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_site` (
  `id` varchar(200) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `ip_creator` varchar(20) NOT NULL,
  `version` varchar(250) NOT NULL,
  `id_user_created` varchar(200) DEFAULT NULL,
  `id_site` varchar(200) DEFAULT NULL,
  `updated_date` datetime(6) NOT NULL,
  `ip_alterator` varchar(20) DEFAULT NULL,
  `id_user_altered` varchar(200) DEFAULT NULL,
  `colmuns` smallint DEFAULT NULL,
  `dns` varchar(250) NOT NULL,
  `facebook_api_key` varchar(200) DEFAULT NULL,
  `facebook_pixel` varchar(200) DEFAULT NULL,
  `google_analytics` varchar(200) DEFAULT NULL,
  `google_api_authenticator_key` varchar(200) DEFAULT NULL,
  `google_api_authenticator_secret` varchar(200) DEFAULT NULL,
  `google_api_recaptcha_key` varchar(200) DEFAULT NULL,
  `google_api_recaptcha_secret` varchar(200) DEFAULT NULL,
  `headers` varchar(2000) DEFAULT NULL,
  `name` varchar(200) NOT NULL,
  `footers` varchar(2000) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `type` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_5kitfpdbgac6urswv9db0j9w8` (`dns`),
  KEY `FK_8bdgyiihyjwr92kunevrr99` (`id_user_altered`),
  KEY `FK_n5jbv0u0uqyou89fmtqc9yy4h` (`id_user_created`),
  KEY `FK_gbjgrlevayeumhhab1atmmkv9` (`id_site`),
  CONSTRAINT `FK_8bdgyiihyjwr92kunevrr99` FOREIGN KEY (`id_user_altered`) REFERENCES `tb_usuario` (`id`),
  CONSTRAINT `FK_gbjgrlevayeumhhab1atmmkv9` FOREIGN KEY (`id_site`) REFERENCES `tb_site` (`id`),
  CONSTRAINT `FK_n5jbv0u0uqyou89fmtqc9yy4h` FOREIGN KEY (`id_user_created`) REFERENCES `tb_usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_site`
--

LOCK TABLES `tb_site` WRITE;
/*!40000 ALTER TABLE `tb_site` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_site` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_term`
--

DROP TABLE IF EXISTS `tb_term`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_term` (
  `id` varchar(200) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `ip_creator` varchar(20) NOT NULL,
  `version` varchar(250) NOT NULL,
  `id_user_created` varchar(200) DEFAULT NULL,
  `id_site` varchar(200) DEFAULT NULL,
  `updated_date` datetime(6) NOT NULL,
  `ip_alterator` varchar(20) DEFAULT NULL,
  `id_user_altered` varchar(200) DEFAULT NULL,
  `access` varchar(20) NOT NULL,
  `hits` bigint DEFAULT NULL,
  `likes` bigint DEFAULT NULL,
  `idiom` varchar(5) NOT NULL,
  `meta_description` varchar(250) DEFAULT NULL,
  `file_name` varchar(250) NOT NULL,
  `meta_keywords` varchar(250) DEFAULT NULL,
  `status` varchar(250) NOT NULL,
  `name` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_pc8l26q1w40j2l4sar2v23q0w` (`id_user_altered`),
  KEY `FK_eb86k70b10socyuihbiciocbv` (`id_user_created`),
  KEY `FK_s5y846ivuruvj4xfp0rdgn52b` (`id_site`),
  CONSTRAINT `FK_eb86k70b10socyuihbiciocbv` FOREIGN KEY (`id_user_created`) REFERENCES `tb_usuario` (`id`),
  CONSTRAINT `FK_pc8l26q1w40j2l4sar2v23q0w` FOREIGN KEY (`id_user_altered`) REFERENCES `tb_usuario` (`id`),
  CONSTRAINT `FK_s5y846ivuruvj4xfp0rdgn52b` FOREIGN KEY (`id_site`) REFERENCES `tb_site` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_term`
--

LOCK TABLES `tb_term` WRITE;
/*!40000 ALTER TABLE `tb_term` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_term` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user_permissions`
--

DROP TABLE IF EXISTS `tb_user_permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_user_permissions` (
  `permission` int NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `ip_creator` varchar(20) NOT NULL,
  `id_user` varchar(200) NOT NULL,
  `id_user_created` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`permission`,`id_user`),
  KEY `FK70af03syn3k2j90ktq9ro8j1` (`id_user`),
  KEY `FKi4wyyydeq7dw1tnhgcsmspl0j` (`id_user_created`),
  CONSTRAINT `FK70af03syn3k2j90ktq9ro8j1` FOREIGN KEY (`id_user`) REFERENCES `tb_usuario` (`id`),
  CONSTRAINT `FKi4wyyydeq7dw1tnhgcsmspl0j` FOREIGN KEY (`id_user_created`) REFERENCES `tb_usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user_permissions`
--

LOCK TABLES `tb_user_permissions` WRITE;
/*!40000 ALTER TABLE `tb_user_permissions` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_user_permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuario`
--

DROP TABLE IF EXISTS `tb_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_usuario` (
  `id` varchar(200) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `ip_creator` varchar(20) NOT NULL,
  `version` varchar(250) NOT NULL,
  `id_user_created` varchar(200) DEFAULT NULL,
  `id_site` varchar(200) DEFAULT NULL,
  `updated_date` datetime(6) NOT NULL,
  `ip_alterator` varchar(20) DEFAULT NULL,
  `id_user_altered` varchar(200) DEFAULT NULL,
  `key_google` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `pass` varchar(200) NOT NULL,
  `status` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_apy7khvml3r5ub9ph8v8h3bli` (`id_user_altered`),
  KEY `FK_t259blq15yf41jryx7n328ri6` (`id_user_created`),
  KEY `FK_albyrvjru0dhcy984dw26myw2` (`id_site`),
  CONSTRAINT `FK_albyrvjru0dhcy984dw26myw2` FOREIGN KEY (`id_site`) REFERENCES `tb_site` (`id`),
  CONSTRAINT `FK_apy7khvml3r5ub9ph8v8h3bli` FOREIGN KEY (`id_user_altered`) REFERENCES `tb_usuario` (`id`),
  CONSTRAINT `FK_t259blq15yf41jryx7n328ri6` FOREIGN KEY (`id_user_created`) REFERENCES `tb_usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuario`
--

LOCK TABLES `tb_usuario` WRITE;
/*!40000 ALTER TABLE `tb_usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_usuario` ENABLE KEYS */;
UNLOCK TABLES;













INSERT INTO `jupiter`.`tb_site`
(`id`,`created_date`,`ip_creator`,`version`,`id_user_created`,`id_site`,`updated_date`,`ip_alterator`,`id_user_altered`,`colmuns`,
`dns`,`facebook_api_key`,`facebook_pixel`,`google_analytics`,`google_api_authenticator_key`,`google_api_authenticator_secret`,
`google_api_recaptcha_key`,`google_api_recaptcha_secret`,`headers`,`name`,`footers`,`status`,`type`)
VALUES
(UUID(), NOW(), '127.0.0.1', '1', null, null, NOW(), '127.0.0.1', null,3,'localhost',null,null,null,null,null,null,null,null,
'Site Teste','','ATIVO','PORTAL');


