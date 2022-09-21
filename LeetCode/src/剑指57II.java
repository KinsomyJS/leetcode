import java.util.ArrayList;
import java.util.List;

public class 剑指57II {
    public int[][] findContinuousSequence(int target) {
        List<int[]> resList = new ArrayList<>();
        int l = 1;
        int r = 2;
        int sum = 3;
        while (l < r && r < (target / 2 + 1)) {

            if (sum > target) {
                sum -= l;
                l++;
            } else if (sum < target) {
                r++;
                sum += r;
            } else {
                int[] res = new int[r - l + 1];
                for (int i = l; i <= r; ++i) {
                    res[i - l] = i;
                }
                resList.add(res);
                l++;
                r++;
            }
        }
        return resList.toArray(new int[resList.size()][]);
    }
}
