CREATE TABLE `come_back_late` (
  `Lno` int(10) NOT NULL AUTO_INCREMENT,
  `Ltime` char(20) NOT NULL,
  `Sno` int(10) NOT NULL,
  `Ddor` int(10) NOT NULL,
  `Drea` char(40) NOT NULL,
  PRIMARY KEY (`Lno`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
CREATE TABLE `damage_goods` (
  `Dno` int(10) NOT NULL AUTO_INCREMENT,
  `Ddor` int(10) NOT NULL,
  `Dgoods` char(20) NOT NULL,
  `Dtime` char(40) NOT NULL,
  PRIMARY KEY (`Dno`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
CREATE TABLE `dorm` (
  `Ddor` int(10) NOT NULL,
  `Dbuil` int(10) NOT NULL,
  `Dbednum` int(10) NOT NULL,
  `Dunused` int(10) NOT NULL,
  PRIMARY KEY (`Ddor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `management` (
  `Password` char(10) DEFAULT NULL,
  `Llogin` char(10) DEFAULT NULL,
  `Mno` int(10) NOT NULL,
  `Mname` char(20) NOT NULL,
  `Msex` char(2) NOT NULL,
  `Mtel` char(11) NOT NULL,
  `Dbuil` int(10) NOT NULL,
  PRIMARY KEY (`Mno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `sanitary` (
  `Ddor` int(10) NOT NULL,
  `Sanitary` char(40) NOT NULL,
  `Stime` char(40) NOT NULL,
  PRIMARY KEY (`Ddor`),
  CONSTRAINT `1` FOREIGN KEY (`Ddor`) REFERENCES `dorm` (`Ddor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `student` (
  `Password` char(10) DEFAULT NULL,
  `Llogin` char(10) DEFAULT NULL,
  `Sno` int(10) NOT NULL,
  `Sname` char(20) NOT NULL,
  `Ssex` char(2) NOT NULL,
  `Sclass` char(10) NOT NULL,
  `Sdept` char(20) NOT NULL,
  `Stel` char(11) NOT NULL,
  PRIMARY KEY (`Sno`)
CREATE TABLE `student_dorm` (
  `No` int(10) NOT NULL AUTO_INCREMENT,
  `Sno` char(10) NOT NULL,
  `Dbuil` int(10) NOT NULL,
  `Ddor` char(10) NOT NULL,
  `Check_in` char(40) NOT NULL,
  `Check_out` char(40) DEFAULT NULL,
  PRIMARY KEY (`No`,`Dbuil`,`Ddor`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
CREATE TABLE `visitor` (
  `Vno` int(10) NOT NULL AUTO_INCREMENT,
  `Vname` char(20) NOT NULL,
  `Vtel` char(11) NOT NULL,
  `Sname` char(20) NOT NULL,
  `Vtime` char(20) NOT NULL,
  PRIMARY KEY (`Vno`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;




