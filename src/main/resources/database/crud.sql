USE airport;

UPDATE `airport`.`Booking` SET `Status` = 'Occupied' WHERE `Booking_Id` = 1;

UPDATE `airport`.`Booking` SET `Seat_Number` = 'C5' WHERE `Booking_Id` = 2;

UPDATE `airport`.`Airplane` SET `Capacity` = '300' WHERE `AirplaneId` = 1;

UPDATE `airport`.`Airplane` SET `Capacity` = '300' WHERE `AirplaneId` = 1;

UPDATE `airport`.`PassengerDetails` SET `Last_Name` = 'Smith' WHERE `Passenger_Id` = 1;

UPDATE `airport`.`Flight` SET `Arrival` = '2023-06-01 14:30:00' WHERE `Flight_Id` = 1;

UPDATE `airport`.`Flight` SET `Departure` = '2023-06-01 15:00:00' WHERE `Flight_Id` = 2;

UPDATE `airport`.`Tickets` SET `Seat_Number` = 'D5' WHERE `Ticket_Id` = 3;

UPDATE `airport`.`Booking` SET `Status` = 'Occupied' WHERE `Booking_Id` = 4;

UPDATE `airport`.`Airplane` SET `Capacity` = '300' WHERE `AirplaneId` = 5;

DELETE FROM `airport`.`Booking` WHERE `Booking_Id` = 1;

DELETE FROM `airport`.`Airlines` WHERE `Airline_Id` = 2;

DELETE FROM `airport`.`Payment` WHERE `Payment_Id` = 3;

DELETE FROM `airport`.`Payment` WHERE `Payment_Id` = 3;

DELETE FROM `airport`.`Flight` WHERE `Flight_Id` = 2;

SELECT *
FROM Airport
JOIN Airport_has_Airlines ON Airport.Airport_Id = Airport_has_Airlines.Airport_Airport_Id
JOIN Airlines ON Airport_has_Airlines.Airlines_Airline_Id = Airlines.Airline_Id
JOIN Flight ON Flight.Airport_Airport_Id = Airport.Airport_Id
JOIN Airplane ON Flight.Airplane_AirplaneId = Airplane.AirplaneId
JOIN Seat ON Seat.Airplane_AirplaneId = Airplane.AirplaneId
JOIN Booking ON Booking.Flight_Id = Flight.Flight_Id
JOIN PassengerDetails ON Booking.PassengerDetails_Passenger_Id = Passenger_Details.Passenger_Id
JOIN Payment ON Payment.Booking_Booking_Id = Booking.Booking_Id AND Payment.Booking_Passenger_Details_Passenger_Id = Booking.Passenger_Details_Passenger_Id
JOIN Tickets ON Tickets.Seat_Seat_Id = Seat.Seat_Id AND Tickets.Passenger_Details_Passenger_Id = Passenger_Details.Passenger_Id
LIMIT 0, 1000;


SELECT Flight.Flight_Id, Airport.Name
FROM Flight
INNER JOIN Airport ON Flight.Airport_Airport_Id = Airport.Airport_Id;


SELECT Flight.Flight_Id, Airport.Name
FROM Flight
LEFT JOIN Airport ON Flight.Airport_Airport_Id = Airport.Airport_Id;

SELECT Flight.Flight_Id, Airport.Name
FROM Flight
RIGHT JOIN Airport ON Flight.Airport_Airport_Id = Airport.Airport_Id;

SELECT Flight.Flight_Id, Airport.Name
FROM Flight
CROSS JOIN Airport;

SELECT Airport_Airport_Id, COUNT(*) AS TotalFlights
FROM Flight
GROUP BY Airport_Airport_Id;

SELECT Seat_Id, COUNT(*) AS TotalSeatsAvailable
FROM Seat
GROUP BY Seat_Id;

SELECT Flight_Id, COUNT(*) AS TotalPassengers
FROM Booking
GROUP BY Flight_Id;

SELECT Flight_Id, AVG(Age) AS AverageAge
FROM PassengerDetails
JOIN Booking ON PassengerDetails.Passanger_Id = Booking.Passanger_Id
GROUP BY Flight_Id;

SELECT Airplane_AirplaneId, SUM(Duration) AS Totaltime
FROM Flight
GROUP BY Airplane_AirplaneId;

SELECT Airport_Airport_Id, COUNT(*) AS TotalFlights
FROM Flight
GROUP BY Airport_Airport_Id
HAVING COUNT(*) > 100;

SELECT Flight_Id, COUNT(*) AS TotalPassengers
FROM Booking
GROUP BY Flight_Id
HAVING COUNT(*) > 50;

SELECT Flight_Id, AVG(Age) AS AverageAge
FROM PassengerDetails
JOIN Booking ON PassengerDetails.Passenger_Id = Booking.Passenger_Id
GROUP BY Flight_Id
HAVING AVG(Age) > 30;

SELECT Payment_Method, SUM(Amount) AS TotalRevenue
FROM Payment
GROUP BY Payment_Method
HAVING SUM(Amount) > 5000;

SELECT Passenger_Id, COUNT(*) AS TotalBookings
FROM Booking
GROUP BY Passenger_Id
HAVING COUNT(*) > 5;

SELECT MAX(Capacity) AS MaxSeatingCapacity
FROM Airplane
WHERE Capacity >= 100;
