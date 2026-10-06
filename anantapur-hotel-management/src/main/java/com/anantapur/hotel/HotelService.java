package com.anantapur.hotel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelService {
    private final List<Room> rooms = new ArrayList<>();
    private final List<Reservation> reservations = new ArrayList<>();
    private int nextReservationId = 1001;

    public HotelService() {
        addSampleRooms();
    }

    private void addSampleRooms() {
        rooms.add(new Room(101, RoomType.SINGLE, new BigDecimal("900")));
        rooms.add(new Room(102, RoomType.SINGLE, new BigDecimal("900")));
        rooms.add(new Room(201, RoomType.DOUBLE, new BigDecimal("1500")));
        rooms.add(new Room(202, RoomType.DOUBLE, new BigDecimal("1500")));
        rooms.add(new Room(301, RoomType.FAMILY, new BigDecimal("2400")));
    }

    public List<Room> getRooms() {
        return List.copyOf(rooms);
    }

    public List<Reservation> getReservations() {
        return List.copyOf(reservations);
    }

    public Reservation bookRoom(String guestName, String phone, int roomNumber,
                                LocalDate checkIn, LocalDate checkOut) {
        if (!checkOut.isAfter(checkIn)) {
            throw new IllegalArgumentException("Check-out must be after check-in.");
        }

        Room room = findRoom(roomNumber);
        if (room.getStatus() != RoomStatus.AVAILABLE) {
            throw new IllegalStateException("Room is not available.");
        }

        Reservation reservation = new Reservation(nextReservationId++,
                new Guest(guestName, phone), room, checkIn, checkOut);
        reservations.add(reservation);
        room.setStatus(RoomStatus.OCCUPIED);
        return reservation;
    }

    public Reservation checkOut(int reservationId) {
        Reservation reservation = reservations.stream()
                .filter(item -> item.getId() == reservationId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Reservation not found."));
        reservation.getRoom().setStatus(RoomStatus.AVAILABLE);
        reservations.remove(reservation);
        return reservation;
    }

    public void markRoomForMaintenance(int roomNumber) {
        Room room = findRoom(roomNumber);
        if (room.getStatus() == RoomStatus.OCCUPIED) {
            throw new IllegalStateException("Occupied room cannot be marked for maintenance.");
        }
        room.setStatus(RoomStatus.MAINTENANCE);
    }

    private Room findRoom(int roomNumber) {
        return rooms.stream()
                .filter(room -> room.getNumber() == roomNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Room not found."));
    }
}
