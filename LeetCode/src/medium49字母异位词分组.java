import java.util.*;

/**
 * https://leetcode-cn.com/problems/group-anagrams/
 */
public class medium49字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                map.put(key, new ArrayList<String>() {
                    {
                        add(str);
                    }
                });
            }
        }
        return new ArrayList<>(map.values());
    }
}
