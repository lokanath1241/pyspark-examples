package com.anantapur.hotel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reservation {
    private final int id;
    private final Guest guest;
    private final Room room;
    private final LocalDate checkIn;
    private final LocalDate checkOut;

    public Reservation(int id, Guest guest, Room room, LocalDate checkIn, LocalDate checkOut) {
        this.id = id;
        this.guest = guest;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public int getId() {
        return id;
    }

    public Room getRoom() {
        return room;
    }

    public BigDecimal totalAmount() {
        long nights = Math.max(1, ChronoUnit.DAYS.between(checkIn, checkOut));
        return room.getPricePerNight().multiply(BigDecimal.valueOf(nights));
    }

    @Override
    public String toString() {
        return String.format("Reservation #%d | %s | Room %d | %s to %s | Total: Rs. %.2f",
                id, guest, room.getNumber(), checkIn, checkOut, totalAmount());
    }
}
