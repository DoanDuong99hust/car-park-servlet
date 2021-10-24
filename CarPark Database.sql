use carparkservlet;

CREATE TABLE `employee` (
  `employeeId` bigint(20) PRIMARY KEY AUTO_INCREMENT,
  `emplyeeName` varchar(50),
  `account` varchar(50),
  `department` varchar(10),
  `employeeAddress` varchar(50),
  `employeeBirthday` date,
  `employeeEmail` varchar(50),
  `employeePhone` varchar(10),
  `password` varchar(20),
  `sex` varchar(1)
);

CREATE TABLE `bookingoffice` (
  `officeId` bigint(20) PRIMARY KEY AUTO_INCREMENT,
  `endContractDate` date,
  `officeName` varchar(50),
  `officePhone` varchar(11),
  `officePlace` varchar(50),
  `officePrice` bigint(20),
  `startContractDate` date,
  `tripId` bigint(20)
);

CREATE TABLE `cars` (
  `licensePlate` varchar(50),
  `carColor` varchar(11),
  `carType` varchar(50),
  `company` varchar(50),
  `parkId` bigint(20)
);

CREATE TABLE `trips` (
  `tripId` bigint(20) PRIMARY KEY AUTO_INCREMENT,
  `bookedTicketNumber` int(11),
  `carType` varchar(11),
  `departureDate` date,
  `departureTime` timestamp,
  `destination` varchar(50),
  `driver` varchar(11),
  `maximumOnlineTicketNumber` int(11)
);

CREATE TABLE `tickets` (
  `ticketId` bigint(20) PRIMARY KEY AUTO_INCREMENT,
  `bookingTime` timestamp,
  `customerName` varchar(11),
  `licensePlate` varchar(11),
  `tripId` bigint(20)
);

CREATE TABLE `parkinglots` (
  `parkId` bigint(20) PRIMARY KEY AUTO_INCREMENT,
  `parkArea` bigint(20),
  `parkName` varchar(50),
  `parkPlace` varchar(11),
  `parkPrice` bigint(20),
  `parkStatus` varchar(50)
);

ALTER TABLE `cars` ADD FOREIGN KEY (`licensePlate`) REFERENCES `tickets` (`licensePlate`);

ALTER TABLE `trips` ADD FOREIGN KEY (`tripId`) REFERENCES `tickets` (`tripId`);

ALTER TABLE `parkinglots` ADD FOREIGN KEY (`parkId`) REFERENCES `cars` (`parkId`);

ALTER TABLE `trips` ADD FOREIGN KEY (`tripId`) REFERENCES `bookingoffice` (`tripId`);
