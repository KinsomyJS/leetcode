import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        String res = output("abccabcdabcde");
        System.out.println(res);
    }

    private static String output(String testCase) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = testCase.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(testCase.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(testCase.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(testCase.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            if(rk - i + 1 > ans) {
                ans = rk - i + 1;
                start = i;
                end = rk;
            }
        }
        return testCase.substring(start,end + 1);
    }


    // abcabcbb
}
