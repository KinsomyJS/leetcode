import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class medium841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<Integer> closeList = new ArrayList<>();
        int len = rooms.size();
        for (int i = 1; i < len; i++) {
            closeList.add(i);
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> room0 = rooms.get(0);
        for (int key : room0) {
            queue.offer(key);
        }
        while (!queue.isEmpty()) {
            int key = queue.poll();
            if (!closeList.contains(key)) {
                continue;
            }
            List<Integer> keys = rooms.get(key);
            for (int k : keys) {
                if (queue.contains(k) || k == 0) {
                    continue;
                }
                queue.offer(k);
            }
            closeList.remove(new Integer(key));
            if (closeList.isEmpty()) {
                return true;
            }
        }
        return closeList.isEmpty();
    }
}
