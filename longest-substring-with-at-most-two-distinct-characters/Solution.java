public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
       if (s == null || s.length() == 0) {
           return 0;
       }
       Map<Character, Integer> map = new HashMap<>();
       int res = Integer.MIN_VALUE, start = 0;
       for (int i = 0; i < s.length(); ++i) {
           char c = s.charAt(i);
           map.put(c, i);
           if (map.size() > 2) {
                res = Math.max(i - start, res);
                int leastRecentIndex = Integer.MAX_VALUE;
                for (Character ch : map.keySet()) {
                    leastRecentIndex = Math.min(leastRecentIndex, map.get(ch));
                }
                Iterator it = map.keySet().iterator();
                while (it.hasNext()) {
                    Character letter = (Character)it.next();
                    if (map.get(letter) == leastRecentIndex) {
                        it.remove();
                        start = leastRecentIndex + 1;
                    }
                }
           }
       }
       res = Math.max(res, s.length() - start);
        
       return res;
    }
}