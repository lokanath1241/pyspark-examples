package com.anantapur.hotel;


import java.time.LocalDate;
import java.time.LocalDate;
import java.time.LocalDate;

public class HotelServiceTest {
    public static void main(String[] args) {
        HotelService service = new HotelService();
        Reservation reservation = service.bookRoom(
                "Test Guest", "9000000000", 101,
                LocalDate.of(2026, 9, 14), LocalDate.of(2026, 9, 16));

        assert reservation.totalAmount().doubleValue() == 1800.0;
        assert service.getRooms().get(0).getStatus() == RoomStatus.OCCUPIED;

        service.checkOut(reservation.getId());
        assert service.getRooms().get(0).getStatus() == RoomStatus.AVAILABLE;
        System.out.println("HotelServiceTest passed.");
    }
}
