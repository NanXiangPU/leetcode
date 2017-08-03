public class Solution {
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length < m) {
            return 0;
        }
        long sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            max = Math.max(nums[i], max);
        }
        if (m == 1) {
            return (int)sum;
        }
        if (m == nums.length) {
            return max;
        }
        long left = max, right = sum;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (valid(nums, m, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int)left;
    }
    
    public boolean valid(int[] nums, int count, long target) {
        int total = 1;
        long sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum > target) {
                sum = num;
                total++;
                if (total > count) {
                    return false;
                }
            }
        }
        return true;
    }
}