public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] letters = new int[128];
        for (int i = 0; i < s.length(); ++i) {
            letters[s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); ++i) {
            letters[t.charAt(i)]--;
        }
        for (int i = 0; i < 128; ++i) {
            if (letters[i] != 0) {
                return false;
            }
        }
        return true;
    }
}