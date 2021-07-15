/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 5.7.11 : Database - onlinetaxi
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`onlinetaxi` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `onlinetaxi`;

/*Table structure for table `t_comment` */

DROP TABLE IF EXISTS `t_comment`;

CREATE TABLE `t_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `content` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_comment` */

insert  into `t_comment`(`id`,`name`,`content`) values (1,'driver','nice'),(2,'driver','a little expensive'),(3,'driver','very nice!'),(4,'driver','good!'),(5,'driver','cheap');

/*Table structure for table `t_demand` */

DROP TABLE IF EXISTS `t_demand`;

CREATE TABLE `t_demand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `departure` varchar(20) DEFAULT NULL,
  `destination` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `t_demand` */

insert  into `t_demand`(`id`,`departure`,`destination`,`name`) values (16,'A2','A8','passenger1');

/*Table structure for table `t_driver` */

DROP TABLE IF EXISTS `t_driver`;

CREATE TABLE `t_driver` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(11) DEFAULT NULL,
  `password` varchar(11) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_driver` */

insert  into `t_driver`(`id`,`username`,`password`,`address`) values (3,'driver','123456','A1'),(4,'driver1','123456','A2');

/*Table structure for table `t_order` */

DROP TABLE IF EXISTS `t_order`;

CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `departure` varchar(20) DEFAULT NULL,
  `destination` varchar(20) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `passenger` varchar(20) DEFAULT NULL,
  `driver` varchar(20) DEFAULT NULL,
  `price` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=dec8;

/*Data for the table `t_order` */

insert  into `t_order`(`id`,`departure`,`destination`,`state`,`passenger`,`driver`,`price`) values (6,'A1','B1',1,'passenger','driver',16),(8,'A1','F1',1,'passenger','driver',80),(10,'A1','A9',1,'passenger','driver',8),(11,'A1','A3',1,'passenger','driver',2);

/*Table structure for table `t_passenger` */

DROP TABLE IF EXISTS `t_passenger`;

CREATE TABLE `t_passenger` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(11) DEFAULT NULL,
  `password` varchar(11) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_passenger` */

insert  into `t_passenger`(`id`,`username`,`password`,`address`) values (1,'passenger','123456','A1'),(2,'passenger1','123456','A2');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
