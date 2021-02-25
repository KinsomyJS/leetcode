import java.util.*;

public class 电话号码的字母组合 {

    Map<String, String[]> map = new HashMap() {{
        put("2", new String[]{"a", "b", "c"});
        put("3", new String[]{"d", "e", "f"});
        put("4", new String[]{"g", "h", "i"});
        put("5", new String[]{"j", "k", "l"});
        put("6", new String[]{"m", "n", "o"});
        put("7", new String[]{"p", "q", "r", "s"});
        put("8", new String[]{"t", "u", "v"});
        put("9", new String[]{"w", "x", "y", "z"});
    }};
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (!digits.isEmpty()) {
            combine(digits, "");
        }
        return res;
    }

    private void combine(String digits, String combination) {
        if (digits.isEmpty()) {
            res.add(combination);
            return;
        }

        String digit = digits.substring(0, 1);
        String[] letters = map.get(digit);
        for (int i = 0; i < letters.length; i++) {
            combine(digits.substring(1), combination + letters[i]);
        }
    }
}
