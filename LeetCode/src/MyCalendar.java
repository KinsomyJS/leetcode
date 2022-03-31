import java.util.*;

class MyCalendar {
    Set<Integer> time;

    public MyCalendar() {
        time = new HashSet<>();
    }

    public boolean book(int start, int end) {
        if (time.contains(start) || time.contains(end - 1)) {
            return false;
        }
        for (int i = start; i < end; i++) {
            time.add(i);
        }
        return true;
    }
}