public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        String[] parts = s.split(" ");
        String res = "";
        for (int i = 0; i < parts.length; ++i) {
            if (i == parts.length - 1) {
                res += new StringBuilder(parts[i]).reverse().toString();
            } else {
                res += new StringBuilder(parts[i]).reverse().toString() + " ";
            }
        }
        return res;
    }
}