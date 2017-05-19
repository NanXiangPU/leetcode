public class Solution {
    public int lengthOfLongestSubstring(String s) {
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
    }
}