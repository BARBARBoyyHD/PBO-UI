/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 10.4.24-MariaDB : Database - kemahasiswaan_m.nahrul.hayat_10121074
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`kemahasiswaan_m.nahrul.hayat_10121074` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `kemahasiswaan_m.nahrul.hayat_10121074`;

/*Table structure for table `mahasiswa` */

DROP TABLE IF EXISTS `mahasiswa`;

CREATE TABLE `mahasiswa` (
  `nim` varchar(8) NOT NULL,
  `nama` varchar(30) DEFAULT NULL,
  `tempatlahir` varchar(20) DEFAULT NULL,
  `tanggallahir` varchar(15) DEFAULT NULL,
  `alamat` text DEFAULT NULL,
  PRIMARY KEY (`nim`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Table structure for table `matakuliah` */

DROP TABLE IF EXISTS `matakuliah`;

CREATE TABLE `matakuliah` (
  `nomormk` varchar(10) NOT NULL,
  `namamk` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`nomormk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Table structure for table `nilai` */

DROP TABLE IF EXISTS `nilai`;

CREATE TABLE `nilai` (
  `no` int(3) NOT NULL AUTO_INCREMENT,
  `nama` varchar(30) DEFAULT NULL,
  `namamk` varchar(20) DEFAULT NULL,
  `absensi` int(2) DEFAULT NULL,
  `tugas1` int(3) DEFAULT NULL,
  `tugas2` int(3) DEFAULT NULL,
  `tugas3` int(3) DEFAULT NULL,
  `uts` int(3) DEFAULT NULL,
  `uas` int(3) DEFAULT NULL,
  `nilaiabsen` int(3) DEFAULT NULL,
  `nilaitugas` int(3) DEFAULT NULL,
  `nilaiuts` int(3) DEFAULT NULL,
  `nilaiuas` int(3) DEFAULT NULL,
  `nilaiakhir` int(3) DEFAULT NULL,
  `index` varchar(1) DEFAULT NULL,
  `keterangan` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `nilaiakhir` */

DROP TABLE IF EXISTS `nilaiakhir`;

CREATE TABLE `nilaiakhir` (
  `no` int(3) NOT NULL AUTO_INCREMENT,
  `namamk` varchar(20) DEFAULT NULL,
  `kodemk` varchar(10) DEFAULT NULL,
  `percentaseabsen` int(3) DEFAULT NULL,
  `percentasetugas` int(3) DEFAULT NULL,
  `percentaseuts` int(3) DEFAULT NULL,
  `percentaseuas` int(3) DEFAULT NULL,
  `kehadiran` int(2) DEFAULT NULL,
  `tugas1` int(3) DEFAULT NULL,
  `tugas2` int(3) DEFAULT NULL,
  `tugas3` int(3) DEFAULT NULL,
  `uts` int(3) DEFAULT NULL,
  `uas` int(3) DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `no` int(3) NOT NULL AUTO_INCREMENT,
  `username` varchar(10) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
