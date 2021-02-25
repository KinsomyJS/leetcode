public class 最长回文数_暴力破解 {
    public String longest(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        char[] charArr = s.toCharArray();

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((j - i + 1) > maxLen && validate(charArr, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    private boolean validate(char[] charArr, int left, int right) {
        while (left < right) {
            if (charArr[left] != charArr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
