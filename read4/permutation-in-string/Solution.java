public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] map = new int[26];
        int diff = 0;
        for (int i = 0; i < s1.length(); ++i) {
            map[s1.charAt(i) - 'a']++;
            map[s2.charAt(i) - 'a']--;
        }
        if (allZero(map)) {
            return true;
        }
        for (int i = s1.length(); i < s2.length(); ++i) {
            map[s2.charAt(i) - 'a']--;
            map[s2.charAt(i - s1.length()) - 'a']++;
            if (allZero(map)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean allZero(int[] A) {
        for (int i = 0; i < A.length; ++i) {
            if (A[i] != 0) {
                return false;
            }
        }
        return true;
    }
}