# Anantapur Town Hotel Management

A small Java 17 console application for managing rooms and guest stays at a local hotel in Anantapur town.

## Features

- View room numbers, room types, prices, and status
- Book a room for a guest
- Calculate the stay amount from check-in and check-out dates
- View active reservations
- Check out a guest and make the room available again
- Mark an available room for maintenance

The current version uses in-memory data, so reservations are cleared when the application exits. A database can be added later.

## Requirements

- Java Development Kit (JDK) 17 or newer
- Apache Maven 3.9 or newer

## Run

From this folder:

```powershell
mvn clean compile
mvn exec:java
```

The application starts with five sample rooms and displays a menu.

## Project structure

```text
src/main/java/com/anantapur/hotel/
  App.java             Console menu and application entry point
  Guest.java           Guest details
  HotelService.java    Room and reservation business logic
  Reservation.java     Booking details and bill calculation
  Room.java            Room information and status
  RoomStatus.java      Available, occupied, or maintenance
  RoomType.java        Single, double, or family room
```

## Future improvements

- Store data in SQLite or MySQL
- Add staff login and roles
- Add room availability by date instead of one current status
- Generate printed receipts
- Add Telugu and English language options
