public class Solution {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String res = "";
        for (int i = 0; i < s.length(); i += 2 * k) {
            if (i + k > s.length()) {
                res += new StringBuilder(s.substring(i, s.length())).reverse().toString();
            } else {
                res += new StringBuilder(s.substring(i, i + k)).reverse().toString();
                res += s.substring(i + k, i + 2 * k < s.length() ? i + 2 * k : s.length());
            }
        }
        return res;
    }
}