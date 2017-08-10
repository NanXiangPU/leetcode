public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }
        int[] count = new int[256];
        int num = 0, i = 0, res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (count[s.charAt(j)]++ == 0) num++;
            while (num > k) {
                if (i < s.length() && count[s.charAt(i)] > 0) {
                    count[s.charAt(i)]--;
                    if (count[s.charAt(i)] == 0) {
                        num--;
                    }
                    i++;
                }
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}