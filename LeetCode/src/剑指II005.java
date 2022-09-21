public class 剑指II005 {
    public int maxProduct(String[] words) {
        int res = 0;
        for (int i = 0; i < words.length - 1; i++) {
            String wi = words[i];
            for (int j = i + 1; j < words.length; j++) {
                String wj = words[j];
                boolean flag = true;
                for (int k = 0; k < wi.length(); k++) {
                    if (wj.contains(wi.subSequence(k, k + 1))) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    res = Math.max(res, wi.length() * wj.length());
                }
            }
        }
        return res;
    }
}
