package com.anantapur.hotel;

import java.time.LocalDate;
import java.util.Scanner;

public class App {
    private final HotelService hotelService = new HotelService();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        System.out.println("============================================");
        System.out.println("     ANANTAPUR TOWN HOTEL MANAGEMENT");
        System.out.println("============================================");

        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();
            try {
                switch (choice) {
                    case "1" -> listRooms();
                    case "2" -> makeReservation();
                    case "3" -> listReservations();
                    case "4" -> checkOut();
                    case "5" -> markMaintenance();
                    case "0" -> running = false;
                    default -> System.out.println("Please choose a valid option.");
                }
            } catch (IllegalArgumentException | IllegalStateException exception) {
                System.out.println("Operation failed: " + exception.getMessage());
            }
        }
        System.out.println("Thank you for using the hotel management system.");
    }

    private void printMenu() {
        System.out.println("\n1. List rooms");
        System.out.println("2. Book a room");
        System.out.println("3. List active reservations");
        System.out.println("4. Check out a guest");
        System.out.println("5. Mark room for maintenance");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    private void listRooms() {
        System.out.println("\nRooms in Anantapur Town Hotel:");
        hotelService.getRooms().forEach(System.out::println);
    }

    private void makeReservation() {
        System.out.println("\nNew reservation");
        System.out.print("Guest name: ");
        String name = scanner.nextLine();
        System.out.print("Phone number: ");
        String phone = scanner.nextLine();
        System.out.print("Room number: ");
        int roomNumber = Integer.parseInt(scanner.nextLine());
        System.out.print("Check-in date (YYYY-MM-DD): ");
        LocalDate checkIn = LocalDate.parse(scanner.nextLine());
        System.out.print("Check-out date (YYYY-MM-DD): ");
        LocalDate checkOut = LocalDate.parse(scanner.nextLine());

        Reservation reservation = hotelService.bookRoom(name, phone, roomNumber, checkIn, checkOut);
        System.out.println("Reservation created successfully:");
        System.out.println(reservation);
    }

    private void listReservations() {
        System.out.println("\nActive reservations:");
        if (hotelService.getReservations().isEmpty()) {
            System.out.println("No active reservations.");
            return;
        }
        hotelService.getReservations().forEach(System.out::println);
    }

    private void checkOut() {
        System.out.print("Reservation number: ");
        int reservationId = Integer.parseInt(scanner.nextLine());
        Reservation reservation = hotelService.checkOut(reservationId);
        System.out.println("Guest checked out. Final amount: Rs. " + reservation.totalAmount());
    }

    private void markMaintenance() {
        System.out.print("Room number: ");
        int roomNumber = Integer.parseInt(scanner.nextLine());
        hotelService.markRoomForMaintenance(roomNumber);
        System.out.println("Room marked for maintenance.");
    }
}
