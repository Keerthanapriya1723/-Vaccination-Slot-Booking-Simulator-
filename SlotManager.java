package vaccine;

import java.util.HashMap;
import java.util.Map;

public class SlotManager {
    private Map<String, Slot> slots = new HashMap<>();

    public void addSlot(String date, int count) {
        slots.put(date, new Slot(date, count));
    }

    public void viewSlots() {
        System.out.println("Available Slots:");
        for (Slot slot : slots.values()) {
            System.out.println(slot.getDate() + " - " + slot.getAvailable() + " slots");
        }
    }

    public boolean bookSlot(String date, User user) {
        Slot slot = slots.get(date);
        if (slot != null && slot.book()) {
            user.book(date);
            return true;
        }
        return false;
    }

    public boolean cancelSlot(User user) {
        String date = user.getBookedDate();
        if (date != null && slots.containsKey(date)) {
            Slot slot = slots.get(date);
            slot.cancel();
            user.cancelBooking();
            return true;
        }
        return false;
    }
}
