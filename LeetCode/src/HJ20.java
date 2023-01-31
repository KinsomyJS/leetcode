import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HJ20 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String pwd = in.nextLine();
            // 包含的字符类型标记 0 大写字母 1 小写字母 2数字 3 其他符号
            int[] flag = new int[4];
            if (pwd.length() < 9) {
                System.out.println("NG");
                continue;
            }
            resolveChar(pwd.charAt(0), flag);
            resolveChar(pwd.charAt(1), flag);
            boolean pass = true;
            for (int i = 2; i < pwd.length(); i++) {
                resolveChar(pwd.charAt(i), flag);
                if (pwd.indexOf(pwd.substring(i - 2, i + 1)) < i - 3) {
                    System.out.println("NG");
                    pass = false;
                    break;
                }
            }
            if (!pass) {
                continue;
            }
            int count = 0;
            for (int f : flag) {
                count += f;
            }
            if (count > 2) {
                System.out.println("OK");
            } else {
                System.out.println("NG");
            }
        }
    }

    private static void resolveChar(char c, int[] flag) {
        if (c >= 'A' && c <= 'Z') {
            flag[0] = 1;
        } else if (c >= 'a' && c <= 'z') {
            flag[1] = 1;
        } else if (c >= '0' && c <= '9') {
            flag[2] = 1;
        } else {
            flag[3] = 1;
        }
    }
}
