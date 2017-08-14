public class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int sign = 1;
        int prev = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(prev);
                stack.push(sign);
                prev = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                prev = stack.pop() * prev + stack.pop();
            } else {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = 10 * num + Character.getNumericValue(s.charAt(i++));
                }
                prev = prev + sign * num;
                i -= 1;
            }
        }
        return prev;
    }
}