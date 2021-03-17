import java.util.*;

public class medium12整数转罗马数字 {
    Map<Integer, String> map = new HashMap<>();
    int[] key = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public String intToRoman(int num) {
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        StringBuilder res = new StringBuilder();
        recurse(num, res);
        return res.toString();
    }

    public void recurse(int num, StringBuilder res) {
        if (num == 0) {
            return;
        }
        for (int i : key) {
            if (num >= i) {
                recurse(num - i, res.append(map.get(i)));
                break;
            }
        }
    }

    public void main(String[] args) {
        intToRoman(4);
    }
}
