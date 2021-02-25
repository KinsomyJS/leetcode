public class 字符串转换整数atoi {
    public static int myAtoi(String str) {
        char[] charArr = str.toCharArray();
        int beigin = -1;
        int end = -1;
        int multi = 1;
        for (int i = 0; i < charArr.length; i++) {
            int ascii = (int) charArr[i];
            if (beigin == -1) {
                if (ascii == 43 || ascii == 45) {
                    if (i + 1 < charArr.length && 48 <= (int) charArr[i + 1] && (int) charArr[i + 1] <= 57) {
                        multi = 44 - ascii;
                        beigin = i + 1;
                        end = i + 1;
                        continue;
                    }
                    break;
                } else if (48 <= ascii && ascii <= 57) {
                    beigin = i;
                    end = i;
                } else if (ascii != 32) {
                    break;
                }
            } else {
                if (48 <= ascii && ascii <= 57) {
                    end = i;
                    continue;
                }
                break;
            }
        }
        if (beigin == -1) {
            return 0;
        }
        long result = 0;
        for (int j = end; j >= beigin; j--) {
            result = (long) (result + ((int) charArr[j] - 48) * Math.pow(10, end - j));
        }
        result *= multi;
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) result;
        }
    }

    public static void main(String[] args) {
        int result = myAtoi("3.14159");
        System.out.println(result);
    }
}
