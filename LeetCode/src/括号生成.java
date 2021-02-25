import java.util.ArrayList;
import java.util.List;

public class 括号生成 {

    static List<String> res = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        if (n == 0) {
            return res;
        }
        generate(1, n * 2 - 1, "(");
        return res;
    }

    private static void generate(int sum, int n, String str) {
        if (n == 0) {
            if (sum == 0) {
                res.add(str);
            }
            return;
        }
        if (sum > 0) {
            generate(sum - 1, n - 1, str + ")");
        }
        if (sum < n) {
            generate(sum + 1, n - 1, str + "(");
        }
    }

    public static void main(String[] args) {
        List<String> res = generateParenthesis(2);
        System.out.println(res);
    }
}
