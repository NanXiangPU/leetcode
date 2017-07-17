public class Solution {
    public int lengthOfLongestSubstring(String s) {
<<<<<<< HEAD
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                start = Math.max(map.get(c) + 1, start);
            }
            map.put(c, i);
            maxLen = Math.max(maxLen, i - start + 1);
        }
        return maxLen;
=======
        if(s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int res = Integer.MIN_VALUE, start = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                res = Math.max(res,  i - start);
                start = Math.max(start, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
        }
        res = Math.max(res, s.length() - start);
        return res;
>>>>>>> 75d039f8ce5568327b34ac1908041a60c42506f9
    }
}