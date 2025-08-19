package vaccine;

import java.util.Scanner;

public class VaccinationSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SlotManager manager = new SlotManager();

        // Predefined slots
        manager.addSlot("2025-08-20", 10);
        manager.addSlot("2025-08-21", 8);
        manager.addSlot("2025-08-22", 12);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        User user = new User(name);

        int choice;
        do {
            System.out.println("\n--- Vaccination Slot Booking ---");
            System.out.println("1. View Available Slots");
            System.out.println("2. Book a Slot");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View My Booking");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    manager.viewSlots();
                    break;
                case 2:
                    if (user.hasBooking()) {
                        System.out.println("You already have a booking on: " + user.getBookingDetails());
                    } else {
                        System.out.print("Enter date to book (YYYY-MM-DD): ");
                        String date = scanner.nextLine();
                        if (manager.bookSlot(date, user)) {
                            System.out.println("Booking successful!");
                        } else {
                            System.out.println("Booking failed. Either date is invalid or no slots available.");
                        }
                    }
                    break;
                case 3:
                    if (manager.cancelSlot(user)) {
                        System.out.println("Booking cancelled successfully.");
                    } else {
                        System.out.println("No booking to cancel.");
                    }
                    break;
                case 4:
                    System.out.println(user.getBookingDetails());
                    break;
                case 0:
                    System.out.println("Thank you for using the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
