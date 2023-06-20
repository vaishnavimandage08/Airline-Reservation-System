
CREATE DATABASE airport;

USE airport;

CREATE TABLE IF NOT EXISTS `airport`.`Airlines` (
  `Airline_Id` INT PRIMARY KEY NOT NULL,
  `Airline_Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Airline_Id`));


CREATE TABLE IF NOT EXISTS `airport`.`Airport` (
  `Airport_Id` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `Country` VARCHAR(45) NOT NULL,
  `City` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Airport_Id`));

CREATE TABLE IF NOT EXISTS `airport`.`PassengerDetails` (
  `Passenger_Id` INT NOT NULL,
  `First_Name` VARCHAR(45) NULL,
  `Last_Name` VARCHAR(45) NULL,
  `Passport_Number` VARCHAR(45) NOT NULL,
  `EmailAddress` VARCHAR(75) NOT NULL,
  `Phone_Number` VARCHAR(90) NOT NULL,
  `Age` SMALLINT(8) NOT NULL,
  `Gender` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`Passenger_Id`));


CREATE TABLE IF NOT EXISTS `airport`.`Booking` (
  `Booking_Id` INT NOT NULL,
  `Flight_Id` INT NOT NULL,
  `Passenger_Id` INT NOT NULL,
  `Seat_Number` CHAR(8) NOT NULL,
  `Status` ENUM('Available', 'Booked', 'Occupied') NOT NULL,
  `PassengerDetails_Passenger_Id` INT NOT NULL,
  PRIMARY KEY (`Booking_Id`, `PassengerDetails_Passenger_Id`),
    FOREIGN KEY (`PassengerDetails_Passenger_Id`)
    REFERENCES `airport`.`PassengerDetails` (`Passenger_Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE IF NOT EXISTS `airport`.`Airplane` (
  `AirplaneId` INT NOT NULL,
  `Capacity` VARCHAR(95) NOT NULL,
  PRIMARY KEY (`AirplaneId`));


CREATE TABLE IF NOT EXISTS `airport`.`Flight` (
  `Flight_Id` INT NOT NULL,
  `Arrival` DATETIME NULL DEFAULT NULL,
  `From` INT NOT NULL,
  `To` INT NOT NULL,
  `Departure` DATETIME NULL DEFAULT NULL,
  `Duration` VARCHAR(45) NOT NULL,
  `Airport_Airport_Id` INT NOT NULL,
  `Airplane_AirplaneId` INT NOT NULL,
  PRIMARY KEY (`Flight_Id`, `Airport_Airport_Id`, `Airplane_AirplaneId`),
    FOREIGN KEY (`Airport_Airport_Id`)
    REFERENCES `airport`.`Airport` (`Airport_Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (`Airplane_AirplaneId`)
    REFERENCES `airport`.`Airplane` (`AirplaneId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `airport`.`Payment` (
  `Payment_Id` INT NOT NULL,
  `Payment_Method` VARCHAR(45) NOT NULL,
  `Payment_Date` DATETIME NOT NULL,
  `Amount` INT NOT NULL,
  `Booking_Booking_Id` INT NOT NULL,
  `Booking_PassengerDetails_Passenger_Id` INT NOT NULL,
  PRIMARY KEY (`Payment_Id`, `Booking_Booking_Id`, `Booking_PassengerDetails_Passenger_Id`),
    FOREIGN KEY (`Booking_Booking_Id` , `Booking_PassengerDetails_Passenger_Id`)
    REFERENCES `airport`.`Booking` (`Booking_Id` , `PassengerDetails_Passenger_Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE IF NOT EXISTS `airport`.`Seat` (
  `Seat_Id` INT NOT NULL,
  `Seat_Number` VARCHAR(45) NOT NULL,
  `Class` ENUM('Economy', 'Business', 'First') NOT NULL,
  `Status` VARCHAR(45) NOT NULL,
  `Airplane_AirplaneId` INT NOT NULL,
  PRIMARY KEY (`Seat_Id`, `Airplane_AirplaneId`),
    FOREIGN KEY (`Airplane_AirplaneId`)
    REFERENCES `airport`.`Airplane` (`AirplaneId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE IF NOT EXISTS `airport`.`Tickets` (
  `Ticket_Id` INT NOT NULL,
  `Seat_Number` VARCHAR(45) NULL,
  `Price` INT NULL,
  `Purchase_date` DATETIME NOT NULL,
  `Seat_Seat_Id` INT NOT NULL,
  `PassengerDetails_Passenger_Id` INT NOT NULL,
  PRIMARY KEY (`Ticket_Id`, `Seat_Seat_Id`, `PassengerDetails_Passenger_Id`),
    FOREIGN KEY (`Seat_Seat_Id`)
    REFERENCES `airport`.`Seat` (`Seat_Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (`PassengerDetails_Passenger_Id`)
    REFERENCES `airport`.`PassengerDetails` (`Passenger_Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE IF NOT EXISTS `airport`.`Airport_has_Airlines` (
  `Airport_Airport_Id` INT NOT NULL,
  `Airlines_Airline_Id` INT NOT NULL,
  PRIMARY KEY (`Airport_Airport_Id`, `Airlines_Airline_Id`),
    FOREIGN KEY (`Airport_Airport_Id`)
    REFERENCES `airport`.`Airport` (`Airport_Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (`Airlines_Airline_Id`)
    REFERENCES `airport`.`Airlines` (`Airline_Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `airport`.`PassengerAddress` (
  `Id` INT NOT NULL,
  `Address` VARCHAR(45) NOT NULL,
  `Country` VARCHAR(45) NOT NULL,
  `PassengerDetails_Passenger_Id` INT NOT NULL,
  PRIMARY KEY (`Id`, `Passenger_Details_Passenger_Id`),
    FOREIGN KEY (`PassengerDetails_Passenger_Id`)
    REFERENCES `airport`.`PassengerDetails` (`Passenger_Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
INSERT INTO `airport`.`Airlines` (`Airline_Id`, `Airline_Name`)
VALUES
    (1, 'Delta Air Lines'),
    (2, 'British Airways'),
    (3, 'Emirates'),
    (4, 'Lufthansa'),
    (5, 'Air France'),
    (6, 'Qatar Airways'),
    (7, 'United Airlines'),
    (8, 'Singapore Airlines'),
    (9, 'Cathay Pacific'),
    (10, 'American Airlines');
    
INSERT INTO `airport`.`Seat` (`Seat_Id`, `Seat_Number`, `Class`, `Status`)
VALUES
    (1, 'A1', 'Economy', 'Available'),
    (2, 'A2', 'Economy', 'Available'),
    (3, 'B1', 'Business', 'Reserved'),
    (4, 'B2', 'Business', 'Available'),
    (5, 'C1', 'First ', 'Available'),
    (6, 'C2', 'First ', 'Reserved'),
    (7, 'D1', 'Economy', 'Available'),
    (8, 'D2', 'Economy', 'Available'),
    (9, 'E1', 'Business', 'Reserved'),
    (10, 'E2', 'Business', 'Available');
    
INSERT INTO airport.Airport (Airport_Id, Name, City, Country)
VALUES
(1, 'JFK Airport', 'New York', 'United States'),
(2, 'LAX Airport', 'Los Angeles', 'United States'),
(3, 'Heathrow', 'London', 'United Kingdom'),
(4, 'Charles de Gaulle', 'Paris', 'France');

INSERT INTO `airport`.`Flight` (`Flight_Id`, `Flight_No`, `Arrival`, `Price`, `From`, `To`, `Airline_Id`, `Departure`, `Duration`, `Stops`, `Airport_Airport_Id`, `Airlines_Airline_Id`)
VALUES
   (1, 'ABC123', '2023-05-30 09:00:00', 500, 'Airport1', 'Airport2', 1, '2023-05-30 07:30:00', '2h 30m', 'Non-stop', 1, 1),
   (2, 'DEF456', '2023-05-31 14:30:00', 700, 'Airport2', 'Airport3', 2, '2023-05-31 12:00:00', '2h 30m', '1 stop', 2, 2),
   (3, 'GHI789', '2023-06-01 18:45:00', 900, 'Airport3', 'Airport1', 3, '2023-06-01 16:15:00', '2h 30m', 'Non-stop', 3, 3);
   
INSERT INTO `airport`.`Payment` (`Payment_Id`, `Payment_Method`, `Payment_Date`, `Amount`, `Booking_Booking_Id`, `Booking_PassengerDetails_Passenger_Id`)
VALUES (1, 'Credit Card', '2023-05-31 14:30:00', 100, 1, 1),
       (2, 'JFK Airport', 'New York', 'United States');
       
INSERT INTO `airport`.`Tickets` (`Ticket_Id`, `Seat_Number`, `Price`, `Purchase_date`, `Seat_Seat_Id`, `PassengerDetails_Passenger_Id`)
VALUES (1, 'A1', 100, '2023-05-31 14:30:00', 1, 1),
       (2, 'B2', 150, '2023-06-01 09:45:00', 2, 2);



