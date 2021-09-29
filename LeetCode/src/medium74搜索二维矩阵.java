public class medium74搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] targetArr = null;
        for (int[] rowArr : matrix) {
            if (target >= rowArr[0] && target <= rowArr[col - 1]) {
                targetArr = rowArr;
                break;
            }
        }
        if (targetArr == null) {
            return false;
        }
        for (int num : targetArr) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}
