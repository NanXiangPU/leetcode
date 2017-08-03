public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            char a = s.charAt(left);
            char b = s.charAt(right);
            if (Character.isLetter(a)) {
                a = Character.toLowerCase(a);
            }
            if (Character.isLetter(b)) {
                b = Character.toLowerCase(b);
            }
            if (a != b) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}