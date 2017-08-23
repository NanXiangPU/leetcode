class Solution {
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        String[] paths = input.split("\n");
        stack.push(0);
        for (int i = 0; i < paths.length; ++i) {
            int level = paths[i].lastIndexOf("\t") + 1;
            while (level + 1 < stack.size()) {
                stack.pop();
            }
            int len = stack.peek() + paths[i].length() - level + 1;
            stack.push(len);
            if (paths[i].contains(".")) {
                res = Math.max(res, len - 1);
            }
        }
        return res;
    }
}