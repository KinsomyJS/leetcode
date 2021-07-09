import java.util.ArrayList;
import java.util.List;

public class medium131分割回文串 {
    static List<List<String>> res = new ArrayList<>();
    static boolean[][] dp;
    static int len;

    public static List<List<String>> partition(String s) {
        len = s.length();
        dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
            }
        }
        dfs(s, 0, new ArrayList<>());
        return res;
    }

    private static void dfs(String s, int i, List<String> list) {
        if (i == len) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int idx = i; idx < len; idx++) {
            if (dp[i][idx]) {
                list.add(s.substring(i, idx + 1));
                dfs(s, idx + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        partition("aab");
    }
}
