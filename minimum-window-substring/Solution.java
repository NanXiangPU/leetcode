public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        int[] ASCII = new int[128];
        for (int i = 0; i < t.length(); ++i) {
            ASCII[t.charAt(i)]++;
        }
        int start = 0, end = 0, count = t.length(), min_len = Integer.MAX_VALUE;
        String res = "";
        while (end < s.length()) {
            if (ASCII[s.charAt(end++)]-- > 0) {
                count--;
            }
            while (count == 0) {
                if (end - start < min_len) {
                    min_len = end - start;
                    res = s.substring(start, end);
                }
                if (ASCII[s.charAt(start++)]++ == 0) {
                    count++;
                }
            }
        }
        return res;
    }
}