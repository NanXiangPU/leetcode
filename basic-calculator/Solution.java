public class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int num = 0, res = 0;
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        for (int i = 0; i < s.length(); ++i) {
            if (Character.isDigit(s.charAt(i))) {
                num = 10 * num + (s.charAt(i) - '0');
            } else if (s.charAt(i) == '+') {
                res += sign * num;
                sign = 1;
                num = 0;
            } else if (s.charAt(i) == '-') {
                res += sign * num;
                sign = -1;
                num = 0;
            } else if (s.charAt(i) == '(') {
                stack.push(res);
                stack.push(sign);
                sign = 1;
                res = 0;
            } else if (s.charAt(i) == ')') {
                res += sign * num;
                num = 0;
                res *= stack.pop();
                res += stack.pop();
            }
        }
        if (num != 0) {
            res += sign * num;
        }
        return res;
    }
}