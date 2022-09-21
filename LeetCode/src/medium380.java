import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class medium380 {
    HashMap<Integer, Integer> map;
    Random random;
    List<Integer> list;

    public medium380() {
        map = new HashMap<>();
        random = new Random();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, val);
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            map.remove(val);
            list.remove(new Integer(val));
            return true;
        }
        return false;
    }

    public int getRandom() {
        int len = map.size();
        int rNum = random.nextInt(len);
        return map.get(list.get(rNum));
    }
}
