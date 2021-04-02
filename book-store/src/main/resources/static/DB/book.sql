   CREATE TABLE `book` (
  `bookId` int(20) NOT NULL AUTO_INCREMENT,
  `isbn` varchar(1000) DEFAULT NULL,
  `name` varchar(1000) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `author` varchar(1000) DEFAULT NULL,
  `type` varchar(1000) DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`bookId`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;