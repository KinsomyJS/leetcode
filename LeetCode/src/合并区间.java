import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 合并区间 {
    public static int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len <= 1) {
            return intervals;
        }
//        for (int i = 0; i < len - 1; i++) {
//            for (int j = 0; j < len - 1 - i; j++) {
//                if (intervals[j][0] > intervals[j + 1][0]) {
//                    int[] temp = intervals[j];
//                    intervals[j] = intervals[j + 1];
//                    intervals[j + 1] = temp;
//                }
//            }
//        }
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        List<int[]> res = new ArrayList<>();
        for (int m = 0; m < len; m++) {
            int start = intervals[m][0];
            int end = intervals[m][1];
            for (int n = m ; n < len; n++) {
                if (end >= intervals[n][0]) {
                    end = Math.max(end, intervals[n][1]);
                    if (n == len - 1) {
                        res.add(new int[]{start, end});
                        return res.toArray(new int[res.size()][]);
                    }
                    continue;
                }
                res.add(new int[]{start, end});
                m = n - 1;
                break;
            }

        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        merge(new int[][]{{1, 4}, {4, 5}});
    }
}
