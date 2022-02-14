public class medium167两数之和II {
    public static int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        for (int i = 0; i < len - 1; i++) {
            int t = target - numbers[i];
            int left = i + 1;
            int right = len - 1;
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                if (numbers[mid] == t) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > t) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return new int[]{1, 1};
    }

    public static void main(String[] args) {
        twoSum(new int[]{2,7,11,15}, 17);
    }
}
