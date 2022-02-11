import java.util.ArrayList;
import java.util.List;

public class medium260只出现一次的数字III {
    public static int[] singleNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (list.contains(num)) {
                list.remove(new Integer(num));
                continue;
            }
            list.add(num);
        }
        int[] res = new int[]{list.get(0), list.get(1)};
        return res;
    }

    public static void main(String[] args) {
        singleNumber(new int[]{1, 2, 1, 3, 2, 5});
    }
}
