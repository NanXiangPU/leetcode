class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] letters = new int[128];
        int num = 0, j = 0, res = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (letters[s.charAt(i)]++ == 0) {
                num++;
            }
            if (num > k) {
                while (--letters[s.charAt(j++)] > 0);
                num--;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}