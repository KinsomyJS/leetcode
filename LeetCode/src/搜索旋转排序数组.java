public class 搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int middle = (r + l) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < nums[r]) {
                if(target > nums[middle] && target <= nums[r]){
                    l = middle + 1;
                }else {
                    r = middle - 1;
                }
            }else {
                if(target < nums[middle] && target >= nums[l]){
                    r = middle - 1;
                }else {
                    l = middle + 1;
                }
            }
        }
        return -1;
    }
}
