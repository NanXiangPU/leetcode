public class Solution {
    //iterative
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        res.add("()");
        for (int i = 1; i < n; ++i) {
            int size = res.size();
            Set<String> visited = new HashSet<>();
            for (int j = 0; j < size; ++j) {
                String str = res.remove(0);
                for (int k = 0; k <= str.length(); ++k) {
                    String newStr = str.substring(0,k) + "()" + str.substring(k,str.length());
                    if (!visited.contains(newStr)) {
                        visited.add(newStr);
                        res.add(newStr);
                    }
                }
            }
        }
        return res;
    }

    //backTracking
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTrack(res, "", 0, 0, n);
        return res;
    }
    
    public void backTrack(List<String> list, String str, int open, int close, int max) {
        if (str.length() == max * 2) {
            list.add(str);
            return;
        }
        
        if (open < max) {
            backTrack(list, str + "(", open + 1, close, max);
        }
        if (close < open) {
            backTrack(list, str + ")", open, close + 1, max);
        }
    }
}