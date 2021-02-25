public class 在排序数组中查找元素的第一个和最后一个位置 {
    public static int[] searchRange(int[] nums, int target) {
        int start = -1;
        int end = -1;
        int len = nums.length;
        for (int i = 0, j = len - 1; i <= j; i++, j--) {
            if (nums[i] == target) {
                if (start == -1 || i < start) {
                    start = i;
                } else if (end == -1 || i > end) {
                    end = i;
                }
            }
            if (nums[j] == target) {
                if (end == -1 || j > end) {
                    end = j;
                } else if (start == -1 || j < start) {
                    start = j;
                }
            }
        }
        if (end == -1) {
            end = start;
        }

        if (start == -1) {
            start = end;
        }
        return new int[]{start, end};
    }

    public static void main(String[] args) {
        searchRange(new int[]{1, 2, 3, 3, 3, 3, 4, 5, 9}, 3);
    }

    private void search(int s, int e, int[] nums, int target) {
        if (nums[s] > target || nums[e] < target) {
            return;
        }
        if (s == e && nums[s] != target) {
            return;
        }

    }
}
