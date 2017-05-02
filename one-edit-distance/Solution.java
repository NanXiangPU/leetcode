public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s == null && t == null || s == null && t.length() == 1 || t == null && s.length() == 1) {
            return true;
        }
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        for (int i = 0; i < Math.min(s.length(),t.length()); ++i) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else {
                    if (s.length() < t.length()) {
                        return t.substring(i + 1).equals(s.substring(i));
                    } else {
                        return s.substring(i + 1).equals(t.substring(i));
                    }
                }
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }
}