public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null && p == null) {
            return true;
        }
        if (p == null && (s != null || s.length() != 0)) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); ++i) {
            if(p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < s.length(); ++i) {
            for (int j = 0; j < p.length(); ++j) {
                if (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1];
                    }
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    } 
}