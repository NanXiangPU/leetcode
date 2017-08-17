public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return 0;
        }
        return partition(nums, 0, nums.length - 1, k);
    }
    
    public int partition(int[] nums, int left, int right, int k) {
        if (left > right) {
            return Integer.MAX_VALUE;
        }
        int pivot = nums[right];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && nums[i] < pivot) {
                i++;
            }
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            swap(i, j, nums);
        }
        swap(i, right, nums);
        if (right - i + 1 == k) {
            return nums[i];
        } else if (right - i + 1 < k) {
            return partition(nums, left, i - 1, k - (right - i + 1));
        } else {
            return partition(nums, i + 1, right, k);
        }
    }
    
    public void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}