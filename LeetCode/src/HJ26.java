import java.util.*;

public class HJ26 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        Map<Integer, StringBuilder> map = new HashMap<>();
        List<Integer> idxList = new ArrayList<>();
        List<Character> otherChars = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            //是字母
            int idx = -1;
            if (c >= 'a' && c <= 'z') {
                idx = c - 'a';
            } else if (c >= 'A' && c <= 'Z') {
                idx = c - 'A';
            } else {
                idxList.add(i);
                otherChars.add(c);
            }
            if (idx > -1) {
                if (map.containsKey(idx)) {
                    map.put(idx, map.get(idx).append(c));
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(c);
                    map.put(idx, stringBuilder);
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (map.containsKey(i)) {
                stringBuilder.append(map.get(i).toString());
            }
        }
        int count = 0;
        for (int idx : idxList) {
            if (idx < stringBuilder.length()) {
                stringBuilder.insert(idx, otherChars.get(count));
            } else {
                stringBuilder.append(otherChars.get(count));
            }
            count++;

        }
        System.out.println(stringBuilder.toString());
    }
}
//gjo%%CGP-A+@-krz~dhxWb$qVev+!W^)~--U+ysdA^ZA~y^SxF!PUu&k