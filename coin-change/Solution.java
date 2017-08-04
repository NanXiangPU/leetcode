public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) {
            return -1;
        }
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; ++i) {
            for (int num : coins) {
                if (i >= num) {
                    dp[i] = Math.min(dp[i], dp[i - num] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}