public class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        String[] mapping = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        helper(res, digits, 0, "", mapping);
        return res;
    }
    
    private void helper(List<String> list, String digits, int index, String curStr, String[] mapping) {
        if (curStr.length() == digits.length()) {
            list.add(curStr);
            return;
        }
        char c = digits.charAt(index);
        String letter = mapping[c - '0' - 2];
        for (int i = 0; i < letter.length(); ++i) {
            helper(list, digits, index + 1, curStr + letter.charAt(i), mapping);
        }
    }
}