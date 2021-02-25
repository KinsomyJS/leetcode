import java.util.*;

public class medium40组合总和Ⅱ {

    private Set<List<Integer>> res = new HashSet<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        recursive(0, 0, candidates, target, new ArrayList<Integer>());
        return new ArrayList<>(res);
    }

    private void recursive(int sIndex, int sum, int[] candiates, int target, List<Integer> combination) {
        int len = candiates.length;
        if (sIndex >= len) {
            return;
        }
        for (int i = sIndex; i < len; i++) {
            int s = sum + candiates[i];
            if (s == target) {
                List<Integer> list = new ArrayList<>();
                list.addAll(combination);
                list.add(candiates[i]);
                Collections.sort(list);
                res.add(list);
                continue;
            }
            if (s > target) {
                break;
            }
            List<Integer> list = new ArrayList<>();
            list.addAll(combination);
            list.add(candiates[i]);
            recursive(i + 1, s, candiates, target, list);
        }
    }
}
