public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t != null || s != null && t == null) {
            return false;
        }
        if (s == null && t == null) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] letter = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            letter[s.charAt(i) - 'a']++;
            letter[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; ++i) {
            if (letter[i] != 0) {
                return false;
            }
        }
        return true;
    }
}