public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        int[] dp = new int[s.length() + 1];
        int n = dp.length - 1;
        dp[n] = 1;
        dp[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;
        for (int i = n - 2; i >= 0; --i) {
            if (s.charAt(i) == '0') {
                continue;
            } else {
                int num = Integer.parseInt(s.substring(i, i + 2));
                dp[i] = num <=26 ? dp[i + 1] + dp[i + 2] : dp[i + 1];
            }
        }
        return dp[0];
    }
}