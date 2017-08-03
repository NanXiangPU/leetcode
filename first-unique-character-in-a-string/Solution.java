public class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), Integer.MAX_VALUE);
            } else {
                map.put(s.charAt(i), i);
            }
        }
        for (Character c : map.keySet()) {
            res = Math.min(res, map.get(c));
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}