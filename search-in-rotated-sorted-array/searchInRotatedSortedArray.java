public class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            
            if(nums[left] < nums[mid]) {
                if(target >= nums[left] && target < nums[mid]) {
                    right = mid;
                }else {
                    left = mid;
                }
            }else{
                if(target <= nums[right] && nums[mid] < target) {
                    left = mid;
                }else {
                    right = mid;
                }
            }
        }
        if(nums[right] == target) {
            return right;
        }else if(nums[left] == target) {
            return left;
        }else {
            return -1;
        }
    }
}