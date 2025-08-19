package vaccine;

public class User {
    private String name;
    private String bookedDate;

    public User(String name) {
        this.name = name;
        this.bookedDate = null;
    }

    public boolean hasBooking() {
        return bookedDate != null;
    }

    public void book(String date) {
        this.bookedDate = date;
    }

    public void cancelBooking() {
        this.bookedDate = null;
    }

    public String getBookingDetails() {
        if (bookedDate == null) {
            return "No booking found.";
        } else {
            return "Booked on: " + bookedDate;
        }
    }

    public String getBookedDate() {
        return bookedDate;
    }

    public String getName() {
        return name;
    }
}
