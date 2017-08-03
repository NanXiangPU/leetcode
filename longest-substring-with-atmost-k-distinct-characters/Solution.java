public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }
        int[] ASCII = new int[128];
        int size = 0;
        int res = Integer.MIN_VALUE, start = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (ASCII[s.charAt(i)]++ == 0) {
                size++;
            }
            while (size == k + 1) {
                res = Math.max(res, i - start);
                if (--ASCII[s.charAt(start++)] == 0) {
                    size--;
                }
            }
        }
        if (size == k) {
            res = Math.max(res, s.length() - start);
        }
        return res == Integer.MIN_VALUE ? s.length() : res;
    }
}