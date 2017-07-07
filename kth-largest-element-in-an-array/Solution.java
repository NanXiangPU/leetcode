public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        return quickSort(nums, nums.length - k + 1, 0, nums.length - 1);
    }
    
    public int quickSort(int[] nums, int k, int lo, int hi) {
        int pivot = nums[hi];
        int i = lo, j = hi;
        while (i < j) {
            if (nums[i++] > pivot) {
                swap(nums, --i, --j);
            }
        }
        swap(nums, i, hi);
        int m = i - lo + 1;
        if (m == k) {
            return nums[i];
        } else if (m < k) {
            return quickSort(nums, k - m, i + 1, hi);
        } else {
            return quickSort(nums, k, lo, i - 1);
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}