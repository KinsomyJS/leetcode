import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class medium216组合总合III {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        for (int i = 9; i > 0; i--) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            combine(k, n - i, list);
        }
        return result;
    }

    private void combine(int k, int total, List<Integer> list) {
        if (total < 0 || list.size() > k) {
            return;
        }
        if (list.size() == k && total == 0) {
            List<Integer> res = new ArrayList<>(list);
            Collections.sort(list);
            if (result.contains(list)) {
                return;
            }
            result.add(res);
            return;
        }
        for (int i = 1; i <= (total < 10 ? total : 9); i++) {
            if (list.contains(i)) {
                continue;
            }
            list.add(i);
            combine(k, total - i, list);
            list.remove(new Integer(i));
        }
    }
}
