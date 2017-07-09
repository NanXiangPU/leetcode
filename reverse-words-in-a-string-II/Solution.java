public class Solution {
    public void reverseWords(char[] s) {
        if (s == null || s.length < 2) {
            return;
        }
        int left = 0, right = s.length - 1;
        while (left < right) {
            swap(s, left++, right--);
        }
        int start = 0;
        for (int i = 0; i < s.length; ++i) {
            if (i == s.length - 1) {
                int p = start, q = i;
                while (p < q) {
                    swap(s, p++, q--);
                }
            }
            if (s[i] == ' ') {
                int p = start, q = i - 1;
                while (p < q) {
                    swap(s, p++, q--);
                }
                start = i + 1;
            }
        }
    }
    
    public void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}