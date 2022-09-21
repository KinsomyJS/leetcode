public class medium59 {
    public int[][] generateMatrix(int n) {
        int current = 1;
        int[][] matrix = new int[n][n];
        int topBoundry = 0;
        int rightBoundry = n - 1;
        int bottomBoundry = n - 1;
        int leftBoundry = 0;
        while (current <= n * n) {
            for (int i = leftBoundry; i <= rightBoundry; i++) {
                matrix[topBoundry][i] = current;
                current++;
            }
            topBoundry++;

            for (int i = topBoundry; i <= bottomBoundry; i++) {
                matrix[i][rightBoundry] = current;
                current++;
            }
            rightBoundry--;

            for (int i = rightBoundry; i >= leftBoundry; i--) {
                matrix[bottomBoundry][i] = current;
                current++;
            }
            bottomBoundry--;

            for (int i = bottomBoundry; i >= topBoundry; i--) {
                matrix[i][leftBoundry] = current;
                current++;
            }
            leftBoundry++;
        }
        return matrix;
    }
}
