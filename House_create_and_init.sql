DROP DATABASE IF EXISTS `House`;
CREATE DATABASE `House` DEFAULT charset utf8 COLLATE utf8_bin;
USE `House`;

DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `userid` integer NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` char(32) NOT NULL,
  `realname` varchar(255),
  `tel` char(11),
  `isadmin` bit DEFAULT 0,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB;

ALTER TABLE `tb_user` ADD CONSTRAINT `uni_username` UNIQUE (`username`);

DROP TABLE IF EXISTS `tb_login_log`;
CREATE TABLE `tb_login_log` (
	`loginid` integer NOT NULL AUTO_INCREMENT,
	`user_id` integer NOT NULL,
	`ipaddr` varchar(255) NOT NULL,
	`logdate` datetime NOT NULL,
	PRIMARY KEY (`loginid`)
);

ALTER TABLE `tb_login_log` ADD CONSTRAINT `fk_log_user` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`userid`);

DROP TABLE IF EXISTS `tb_province`;
CREATE TABLE `tb_province` (
	`provid` integer NOT NULL AUTO_INCREMENT,
	`provname` varchar(255) NOT NULL,
	PRIMARY KEY (`provid`)
);

DROP TABLE IF EXISTS `tb_city`;
CREATE TABLE `tb_city` (
	`cityid` integer NOT NULL AUTO_INCREMENT,
	`cityname` varchar(255) NOT NULL,
	`prov_id` integer NOT NULL,
	PRIMARY KEY (`cityid`)
);

ALTER TABLE `tb_city` ADD CONSTRAINT `fk_city_prov` FOREIGN KEY (`prov_id`) REFERENCES `tb_province` (`provid`);

DROP TABLE IF EXISTS `tb_district`;
CREATE TABLE `tb_district` (
  `distid` integer NOT NULL AUTO_INCREMENT,
  `distname` varchar(255) NOT NULL,
	`city_id` integer NOT NULL,
  PRIMARY KEY (`distid`)
) ENGINE=InnoDB;

ALTER TABLE `tb_district` ADD CONSTRAINT `fk_district_city` FOREIGN KEY (`city_id`) REFERENCES `tb_city` (`cityid`);

DROP TABLE IF EXISTS `tb_house_type`;
CREATE TABLE `tb_house_type` (
  `typeid` int(11) NOT NULL,
  `typename` varchar(10) NOT NULL,
  PRIMARY KEY (`typeid`)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `tb_house`;
CREATE TABLE `tb_house` (
  `houseid` int(11) NOT NULL AUTO_INCREMENT,
  `area` int(11) NOT NULL,
  `contacterEmail` varchar(50),
  `contacterName` varchar(10) NOT NULL,
  `contacterQQ` varchar(12),
  `contacterTel` varchar(20) NOT NULL,
  `detail` varchar(200),
  `floor` int(11) NOT NULL,
  `mainPhoto` varchar(255),
  `price` float NOT NULL,
  `pubDate` datetime,
  `street` varchar(255) NOT NULL,
  `title` varchar(50) NOT NULL,
  `totalFloor` int(11),
  `district_id` int(11),
  `house_type_id` int(11),
  `user_id` integer NOT NULL,
  PRIMARY KEY (`houseid`)
) ENGINE=InnoDB;

ALTER TABLE `tb_house` ADD CONSTRAINT `fk_house_district` FOREIGN KEY (`district_id`) REFERENCES `tb_district` (`distid`) ON UPDATE CASCADE ON DELETE SET NULL;
ALTER TABLE `tb_house` ADD CONSTRAINT `fk_house_type` FOREIGN KEY (`house_type_id`) REFERENCES `tb_house_type` (`typeid`) ON UPDATE CASCADE ON DELETE SET NULL;
ALTER TABLE `tb_house` ADD CONSTRAINT `fk_house_user` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`userid`);

DROP TABLE IF EXISTS `tb_house_photo`;
CREATE TABLE `tb_house_photo` (
  `photoid` integer NOT NULL AUTO_INCREMENT,
  `photoname` varchar(255) NOT NULL,
  `house_id` integer NOT NULL,
  PRIMARY KEY (`photoid`)
) ENGINE=InnoDB;

ALTER TABLE `tb_house_photo` ADD CONSTRAINT `fk_photo_house` FOREIGN KEY (`house_id`) REFERENCES `tb_house` (`houseid`) ON DELETE CASCADE;

INSERT INTO `tb_province` VALUES (1, '北京'), (2, '重庆'), (3, '四川省');
INSERT INTO `tb_city` VALUES (1, '北京', 1), (2, '重庆', 2), (3, '成都', 3), (4, '绵阳', 3), (5, '德阳', 3);
INSERT INTO `tb_district` VALUES (1, '东城区', 1), (2, '海淀区', 1), (3, '大兴区', 1), (4, '其他', 1), (5, '渝北区', 2), (6, '江北区', 2), (7, '沙坪坝区', 2), (8, '万州区', 2), (9, '其他', 2), (10, '成华区', 3), (11, '武侯区', 3), (12, '金牛区', 3), (13,'锦江区', 3), (14, '青羊区', 3), (15, '其他', 3), (16, '涪城区', 4), (17, '游仙区', 4), (18, '三台县', 4), (19, '其他', 5), (20, '旌阳区', 5), (21, '绵竹市', 5), (22, '其他', 5);
INSERT INTO `tb_house_type` VALUES ('1','单间'), ('2','一室一厅'), ('3','二室一厅'), ('4','三室一厅'), ('5','三室两厅'), ('6','四室两厅'), ('7','别墅'), ('8','其他');
INSERT INTO `tb_user` VALUES (default, 'admin','e10adc3949ba59abbe56e057f20f883e','王大锤','13800112233', 1);
