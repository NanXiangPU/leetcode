public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        helper(res, s, 0, 0, new char[]{'(', ')'});
        return res;
    }
    
    public void helper(List<String> res, String s, int last_i, int last_j, char[] pars) {
        for (int stack = 0, i = last_i; i < s.length(); ++i) {
            if (s.charAt(i) == pars[0]) stack++;
            else if (s.charAt(i) == pars[1]) stack--;
            if (stack >= 0) continue;
            for (int j = last_j; j <= i; ++j) {
                if (s.charAt(j) == pars[1] && (j == last_j || s.charAt(j - 1) != pars[1])) {
                    helper(res, s.substring(0, j) + s.substring(j + 1, s.length()), i, j, pars);
                }
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (pars[0] == '(') {
            helper(res, reversed, 0, 0, new char[]{')', '('});
        } else {
            res.add(reversed);
        }
    }
}