public class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        if (n == 0 || logs == null || logs.size() == 0) {
            return res;
        }
        Stack<Integer> stack = new Stack<>();
        int stackTop = 0;
        for (String log : logs) {
            if (!stack.isEmpty()) {
                res[stack.peek()] += Integer.parseInt(log.split(":")[2]) - stackTop;
            }
            stackTop = Integer.parseInt(log.split(":")[2]);
            if (log.split(":")[1].equals("start")) {
                stack.push(Integer.parseInt(log.split(":")[0]));
            } else {
                res[stack.pop()]++;
                stackTop++;
            }
        }
        return res;
    }
}