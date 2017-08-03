public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (t == null || s.length() < t.length()) {
            return "";
        }
        int[] ASCII = new int[128];
        for (int i = 0; i < t.length(); ++i) {
            ASCII[t.charAt(i)]++;
        }
        int start = 0, end = 0, d = Integer.MAX_VALUE, head = 0, count = t.length();
        
        while (end < s.length()) {
            if (ASCII[s.charAt(end++)]-- > 0) count--;
            while (count == 0) {
                if (end - start < d) {
                    head = start;
                    d = end - start;
                }
                if (ASCII[s.charAt(start++)]++ == 0) count++;
            }
        }
        
        return d == Integer.MAX_VALUE ? "" : s.substring(head, head + d);
    }
}