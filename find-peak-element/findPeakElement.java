public class Solution {
    public int findPeakElement(int[] nums) {
        int res = 0, left = 0, right = nums.length - 1;
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }else if(nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                left = mid;
            }else{
                right = mid;
            }
        }
        if(nums[left] > nums[right]) {
            return left;
        }else{
            return right;
        }
    }
}