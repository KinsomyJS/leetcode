import com.sun.corba.se.impl.protocol.giopmsgheaders.TargetAddressHelper;

public class medium81搜索旋转排序数组II {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[start] == nums[mid]) {
                start++;
                continue;
            }

            if (nums[mid] > nums[start]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }else {
                if(target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                }else  {
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}
