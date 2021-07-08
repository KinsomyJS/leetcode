import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class medium字符串的排列 {
    boolean[] vis;
    List<String> resList = new ArrayList<>();

    public String[] permutation(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        int len = s.length();
        vis = new boolean[len];
        StringBuilder builder = new StringBuilder();
        backTrack(arr, 0, len, builder);
        String[] res = new String[resList.size()];
        return resList.toArray(res);
    }

    private void backTrack(char[] arr, int i, int len, StringBuilder stringBuilder) {
        if (i == len) {
            resList.add(stringBuilder.toString());
            return;
        }
        for (int j = 0; j < len; j++) {
            if (vis[j] || (j > 0 && !vis[j - 1] && arr[j - 1] == arr[j])) {
                continue;
            }
            vis[j] = true;
            stringBuilder.append(arr[j]);
            backTrack(arr, i + 1, len, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            vis[j] = false;
        }
    }
}
