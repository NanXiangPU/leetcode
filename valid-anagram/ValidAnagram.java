public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        } else if ( s == null && t != null
                    || s != null && t == null
                    || s.length() != t.length()
        ) {
            return false;        
        }
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); ++i) {
            if (!map.containsKey(t.charAt(i))) {
                return false;
            } else {
                int count = map.get(t.charAt(i));
                if (count == 1) {
                    map.remove(t.charAt(i));
                } else {
                    map.put(t.charAt(i), count - 1);
                }
            }
        }
        return map.size() == 0;
    }
}