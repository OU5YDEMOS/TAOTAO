/*
SQLyog Ultimate v8.32 
MySQL - 5.0.83-community-nt : Database - accp
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`accp` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `accp`;

/*Table structure for table `orderdetail` */

DROP TABLE IF EXISTS `orderdetail`;

CREATE TABLE `orderdetail` (
  `ID` bigint(20) NOT NULL auto_increment,
  `ORDERMAINID` bigint(20) default NULL,
  `PRODUCTNAME` varchar(50) default NULL,
  `NUM` bigint(20) default NULL,
  `PRICE` double default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK800A61D9707367E` (`ORDERMAINID`),
  CONSTRAINT `FK800A61D9707367E` FOREIGN KEY (`ORDERMAINID`) REFERENCES `ordermain` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `orderdetail` */

insert  into `orderdetail`(`ID`,`ORDERMAINID`,`PRODUCTNAME`,`NUM`,`PRICE`) values (1,1,'刚刚修改',50,30),(2,1,'java编程思想',33,33),(3,1,'abc',4,4),(4,2,'土豆',3,3),(5,2,'黄瓜',4,4);

/*Table structure for table `ordermain` */

DROP TABLE IF EXISTS `ordermain`;

CREATE TABLE `ordermain` (
  `ID` bigint(20) NOT NULL auto_increment,
  `CUSTNAME` varchar(50) default NULL,
  `ADDRESS` varchar(200) default NULL,
  `TELPHONE` varchar(50) default NULL,
  `SENDDATE` datetime default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `ordermain` */

insert  into `ordermain`(`ID`,`CUSTNAME`,`ADDRESS`,`TELPHONE`,`SENDDATE`) values (1,'中科软','中关村','2222-222222','2222-02-02 00:00:00'),(2,'联想','北京','333-3333333','3333-03-03 00:00:00');

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `ID` bigint(20) NOT NULL auto_increment,
  `PRODUCTNAME` varchar(50) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `product` */

insert  into `product`(`ID`,`PRODUCTNAME`) values (1,'java编程思想'),(2,'深入浅出JBPM'),(3,'深入浅出ExtJs'),(4,'设计模式之禅'),(5,'C#编程思想');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
