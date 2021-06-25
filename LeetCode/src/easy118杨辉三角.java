import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class easy118杨辉三角 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows < 1) {
            return res;
        }
        res.add(Collections.singletonList(1));
        for (int i = 2; i <= numRows; i++) {
            List<Integer> prevList = res.get(i - 2);
            List<Integer> curList = new ArrayList<>();
            curList.add(1);
            for (int j = 1; j < i - 1; j++) {
                curList.add(j, prevList.get(j - 1) + prevList.get(j));
            }
            curList.add(1);
            res.add(curList);
        }
        return res;
    }
}
