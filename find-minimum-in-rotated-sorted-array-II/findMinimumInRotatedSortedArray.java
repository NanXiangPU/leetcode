public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) {
            return Integer.MAX_VALUE;
        }
        int left = 0, right = nums.length - 1;
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right]) {
                left = mid;
            }else if(nums[mid] < nums[right]) {
                right = mid;
            }else{
                right--;
            }
        }
        
        if(nums[left] < nums[right]) {
            return nums[left];
        }else {
            return nums[right];
        }
    }
}