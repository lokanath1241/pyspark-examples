package com.anantapur.hotel;

import java.math.BigDecimal;

public class Room {
    private final int number;
    private final RoomType type;
    private final BigDecimal pricePerNight;
    private RoomStatus status;

    public Room(int number, RoomType type, BigDecimal pricePerNight) {
        this.number = number;
        this.type = type;
        this.pricePerNight = pricePerNight;
        this.status = RoomStatus.AVAILABLE;
    }

    public int getNumber() {
        return number;
    }

    public RoomType getType() {
        return type;
    }

    public BigDecimal getPricePerNight() {
        return pricePerNight;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("Room %d | %-7s | Rs. %-7.2f | %s", number, type,
                pricePerNight, status);
    }
}
