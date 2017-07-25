public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return Integer.MAX_VALUE;
        }
        long distance = Long.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ++i) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                long sum = (long)(nums[i] + nums[left] + nums[right]);
                long d = Math.abs(sum - target);
                if (d == 0) {
                    return target;
                } else if (sum - target > 0) {
                    right--;
                } else {
                    left++;
                }
                if (d < distance) {
                    distance = d;
                    res = (int)sum;
                }
            }
        }
        return res;
    }
}