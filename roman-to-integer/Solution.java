public class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < s.length(); ++i) {
            int c = s.charAt(i);
            if (c == 'M') {
                res += 1000;
            } else if (c == 'D') {
                res += 500;
            } else if (c == 'C') {
                if (i + 1 < s.length() && s.charAt(i + 1) == 'M') {
                    res += 900;
                    i++;
                } else if (i + 1 < s.length() && s.charAt(i + 1) == 'D') {
                    res += 400;
                    i++;
                } else {
                    res += 100;
                }
            } else if (c == 'L') {
                res += 50;
            } else if (c == 'X') {
                if (i + 1 < s.length() && s.charAt(i + 1) == 'C') {
                    res += 90;
                    i++;
                } else if (i + 1 < s.length() && s.charAt(i + 1) == 'L') {
                    res += 40;
                    i++;
                } else {
                    res += 10;
                }
            } else if (c == 'V') {
                res += 5;
            } else {
                if (i + 1 < s.length() && s.charAt(i + 1) == 'X') {
                    res += 9;
                    i++;
                } else if (i + 1 < s.length() && s.charAt(i + 1) == 'V') {
                    res += 4;
                    i++;
                } else {
                    res += 1;
                }
            }
            System.out.println(res);
        }
        return res;
    }

        public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < s.length(); ++i) {
            int c = s.charAt(i);
            if (c == 'M') {
                res += 1000;
            } else if (c == 'D') {
                res += 500;
            } else if (c == 'C') {
                if (i + 1 < s.length() && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
                    res -= 100;
                } else {
                    res += 100;
                }
            } else if (c == 'L') {
                res += 50;
            } else if (c == 'X') {
                if (i + 1 < s.length() && (s.charAt(i + 1) == 'C' || s.charAt(i + 1) == 'L')) {
                    res -= 10;
                } else {
                    res += 10;
                }
            } else if (c == 'V') {
                res += 5;
            } else {
                if (i + 1 < s.length() && (s.charAt(i + 1) == 'X' || s.charAt(i + 1) == 'V')) {
                    res -= 1;
                } else {
                    res += 1;
                }
            }
        }
        return res;
    }
}