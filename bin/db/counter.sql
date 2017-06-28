DROP SCHEMA IF EXISTS `counter` ;
CREATE SCHEMA IF NOT EXISTS `counter` DEFAULT CHARACTER SET utf8 ;
USE `counter` ;
DROP TABLE IF EXISTS `counterRecord` ;
CREATE TABLE `counterRecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uniqueKey` varchar(255) DEFAULT NULL,
  `serverHost` varchar(255) DEFAULT NULL,
  `serverIp` varchar(255) DEFAULT NULL,
  `clientHost` varchar(255) DEFAULT NULL,
  `clientIp` varchar(255) DEFAULT NULL,
  `os` varchar(255) DEFAULT NULL,
  `browser` varchar(255) DEFAULT NULL,
  `creatTime` datetime DEFAULT NULL,
  `executeTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

