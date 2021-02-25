public class 把数字翻译成字符串 {
    public int translateNum(int num) {
        String numStr = String.valueOf(num);
        int temp1 = 1;
        int temp2 = 1;
        for (int i = 2; i <= numStr.length(); i++) {
            String str = numStr.substring(i - 2, i);
            int temp = (Integer.parseInt(str) >= 10 && Integer.parseInt(str) <= 25) ? temp1 + temp2 : temp2;
            temp1 = temp2;
            temp2 = temp;
        }
        return temp2;
    }
}
