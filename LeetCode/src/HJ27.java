import com.sun.deploy.util.StringUtils;

import java.util.*;

public class HJ27 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] inputArr = input.split(" ");
        int n = Integer.parseInt(inputArr[0]);
        String x = inputArr[n + 1];
        int xLen = x.length();
        int k = Integer.parseInt(inputArr[n + 2]);
        char[] xChars = x.toCharArray();
        Arrays.sort(xChars);
        List<String> res = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            String str = inputArr[i];
            if (str.length() != xLen || x.equals(str)) {
                continue;
            }
            char[] strChars = str.toCharArray();
            Arrays.sort(strChars);
            if (Arrays.equals(strChars, xChars)) {
                res.add(str);
            }
        }

        Collections.sort(res);
        System.out.println(res.size());
        if (k - 1 < res.size()) {
            System.out.println(res.get(k - 1));
        }
    }
}
