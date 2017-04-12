/*
CREATE TABLE car (
	id bigint NOT NULL,
	make varchar(100),
	model varchar(100),
	year int,
	PRIMARY KEY (id)
);

DROP TABLE IF EXISTS `acc_user`;
CREATE TABLE `acc_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`,`name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Table structure for table `card_details`
--

DROP TABLE IF EXISTS `card_details`;
CREATE TABLE `card_details` (
  `card_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `card_number` int(16) unsigned NOT NULL,
  `card_name` varchar(255) DEFAULT NULL,
  `start_date` varchar(5) DEFAULT NULL,
  `expire_date` varchar(5) DEFAULT NULL,
  `user_id` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`card_id`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `acc_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

*/