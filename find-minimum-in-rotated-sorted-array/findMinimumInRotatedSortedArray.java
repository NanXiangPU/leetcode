public class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[mid + 1] && nums[mid] < nums[mid - 1]){
                return nums[mid];
            }else if(nums[left] > nums[right] && nums[mid] > nums[left]) {
                left = mid;
            }else{
                right = mid;
            }
        }
        return nums[left] < nums[right] ? nums[left] : nums[right];
    }
}