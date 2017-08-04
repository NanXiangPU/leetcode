public class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (target == 0) {
            return 1;
        }
        int[] dp = new int[target + 1];
        Arrays.sort(nums);
        dp[0] = 1;
        for (int i = 1; i < dp.length; ++i) {
            for (int num : nums) {
                if (i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}