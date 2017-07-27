public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null) {
            return -1;
        }
        if (needle == null || needle.length() > haystack.length()) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); ++i) {
            String substring = haystack.substring(i, i + needle.length());
            if (substring.equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}