public class medium80删除排序数组中的重复项 {
    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        boolean isDuplicate = false;
        int point1 = 0; // 去重后指针
        for (int point2 = 1; point2 < nums.length; point2++) {
            if (nums[point2] == nums[point1] && isDuplicate) {
                continue;
            }
            if (nums[point2] == nums[point1]) {
                point1++;
                isDuplicate = true;
            } else {
                isDuplicate = false;
                point1++;
            }
            nums[point1] = nums[point2];
        }
        return point1 + 1;
    }

    public static void main(String[] args) {
        removeDuplicates(new int[]{1, 1, 1, 2, 2, 3});
    }
}
