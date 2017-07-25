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

    //Solution 2
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1 || s.equals(t)) {
            return false;
        } else if (Math.abs(s.length() - t.length()) == 0) {
            return isOneChange(s, t);
        } else {
            return isOneDelete(s, t);
        }
    }
    
    public boolean isOneChange(String s, String t) {
        int diff = 0;
        for (int i = 0, j = 0; i < s.length() && j < t.length(); ++i, ++j) {
            if (s.charAt(i) != t.charAt(j)) {
                diff += 1;
            }
        }
        return diff > 1 ? false : true;
    }
    
    public boolean isOneDelete(String s, String t) {
        if (s.length() > t.length()) {
            for (int i = 0, j = 0; i < s.length() && j < t.length(); ++i, ++j) {
                if (s.charAt(i) != t.charAt(j)) {
                    return s.substring(i + 1, s.length()).equals(t.substring(j, t.length()));
                }
            }
            return true;
        } else {
            return isOneDelete(t, s);   
        }
    }
}