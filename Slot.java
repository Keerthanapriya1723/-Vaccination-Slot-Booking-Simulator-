package vaccine;

public class Slot {
    private String date;
    private int available;

    public Slot(String date, int available) {
        this.date = date;
        this.available = available;
    }

    public String getDate() {
        return date;
    }

    public int getAvailable() {
        return available;
    }

    public boolean book() {
        if (available > 0) {
            available--;
            return true;
        }
        return false;
    }

    public void cancel() {
        available++;
    }
}
