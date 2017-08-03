public class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0, num = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            if (Character.isDigit(s.charAt(i))) {
                num = 10 * num + s.charAt(i) - '0';
            }
            if (i == s.length() - 1 || (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ')) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    int prev = stack.pop();
                    stack.push(prev * num);
                } else if (sign == '/') {
                    int prev = stack.pop();
                    stack.push(prev / num);
                }
                num = 0;
                sign = s.charAt(i);
            }
        }
        for (int i : stack) {
            res += i;
        }
        return res;
    }
}