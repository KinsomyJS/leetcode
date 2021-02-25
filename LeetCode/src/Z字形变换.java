public class Z字形变换 {
    public static String convert(String s, int numRows) {
        if(s.isEmpty()) {
            return "";
        }
        int tempVal1 = s.length() - s.length() / (2 * numRows - 2) * (2 * numRows - 2);
        int numCols = s.length() / (2 * numRows - 2) * (numRows - 1) + (s.length() % (2 * numRows - 2) <= numRows ? 1 : (s.length() % (2 * numRows - 2) % numRows + 1));
        if (tempVal1 == 0) {
            numCols -= 1;
        }
        char[][] arr = new char[numRows][numCols];

        for (int i = 0; i < s.length(); i++) {
            int idxCol = (i + 1) / (2 * numRows - 2) * (numRows - 1) + ((i + 1) % (2 * numRows - 2) <= numRows ? 1 : ((i + 1) % (2 * numRows - 2) % numRows + 1)) - 1;
            int tempVal = (i + 1) - (i + 1) / (2 * numRows - 2) * (2 * numRows - 2);
            if (tempVal == 0) {
                tempVal = 2 * numRows - 2;
                idxCol -= 1;
            }
            int idxRow = 0;
            if (tempVal < numRows) {
                idxRow = tempVal - 1;
            } else {
                idxRow = numRows * 2 - tempVal - 1;
            }
            arr[idxRow][idxCol] = s.charAt(i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                if (arr[r][c] != '\0') {
                    stringBuilder.append(arr[r][c]);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        convert("PAYPALISHIRING", 3);
    }
}
