public class Solution {
    //iterative
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.offer("");
        for (int i = 0; i < digits.length(); ++i) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (res.peek().length() == i) {
                String str = res.poll();
                for (char c : mapping[x].toCharArray()) {
                    res.offer(str + c);
                }
            }
        }
        return res;
    }

    //recursive
    private String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        helper(res, "", 0, digits);
        return res;
    }
    
    public void helper(List<String> res, String curr, int index, String digits) {
        if (index == digits.length()) {
            res.add(curr);
            return;
        }
        String str = mapping[Integer.parseInt("" + digits.charAt(index))];
        for (int i = 0; i < str.length(); ++i) {
            helper(res, curr + str.charAt(i), index + 1, digits);
        }
    }
}