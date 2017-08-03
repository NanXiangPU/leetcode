public class Solution {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        
        long res = 0;
        boolean negative = str.charAt(0) == '-' ? true : false;
        for (int i = 0; i < str.length(); ++i) {
            if (i == 0 && (str.charAt(0) == '+' || str.charAt(0) == '-')) {
                continue;
            }
            if ((str.charAt(i) - '0') > 9 || (str.charAt(i) - '0') < 0) {
                return negative ? (int)-res : (int)res;
            }
            res = res * 10 + (str.charAt(i) - '0');
            if (!negative && res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (negative && -res < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return negative ? (int)-res : (int)res;
    }
}