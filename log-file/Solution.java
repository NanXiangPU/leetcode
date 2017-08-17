import java.util.*;

public class Solution {
	private class Result {
		int first;
		int second;
		public Result(int i, int j) {
			this.first = i;
			this.second = j;
		}
	}
	public Map<String, Result> parseLog(String log) {
		Map<String, Result> res = new HashMap<>();
		if (log == null || log.length() == 0) {
			return res;
		}
		String[] strs = log.split("\n");
		Stack<String> stack = new Stack<>();
		int stackTop = 0;
		for (int i = 0; i < strs.length; ++i) {
			String[] parts = strs[i].split(" ");
			String func = parts[0];
			String op = parts[1];
			int time = Integer.parseInt(parts[2]);
			if (op.equals("enter")) {
				res.put(func, new Result(0,0));
				stack.push(strs[i]);
			} else {
				String last = stack.peek();
				String funcName = last.split(" ")[0];
				if (!funcName.equals(func)) {
					System.out.println("Unexcepted exit");
					stack.push(last);
				}
				int t = time - Integer.parseInt(last.split(" ")[2]);
				res.get(funcName).first += t;
				res.get(funcName).second += t;
				stack.pop();
				if (!stack.isEmpty()) {
					res.get(stack.peek().split(" ")[0]).second -= t;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String log = "f1 enter 1\nf2 enter 2\nf2 exit 3\nf1 exit 4";
		Solution s = new Solution();
		Map<String, Result> map = s.parseLog(log);
		for (String str : map.keySet()) {
			System.out.println("func " + str + ": " + "\ninclusive time is " + map.get(str).first + "\nexclusive time is " + map.get(str).second);
		}
	} 
}