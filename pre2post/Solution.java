import java.util.*;

public class Solution {
	private Set<Character> operators;
	public String[] pre2post(String[] prefixs) {
		if (prefixs == null || prefixs.length == 0) {
			return null;
		}
		int size = prefixs.length;
		String[] res = new String[size];
		operators = new HashSet<Character>();
		operators.add('+');
		operators.add('-');
		operators.add('*');
		operators.add('/');

		for (int i = 0; i < size; ++i) {
			String postfix = helper(prefixs[i]);
			res[i] = postfix;
		}
		return res;
	}

	//iterative
	public String helper(String prefix) {
		Stack<String> stack = new Stack<>();
		for (int i = prefix.length() - 1; i >= 0; --i) {
			if (operators.contains(prefix.charAt(i))) {
				String a = stack.pop();
				String b = stack.pop();
				stack.push(a + b + prefix.charAt(i));
			} else {
				stack.push("" + prefix.charAt(i));
			}
		}
		return stack.pop();
	}

	//recursive
	public String helper2(String prefix) {
		if (prefix.length <= 1) {
			return prefix;
		}
		if (!operators.contains(prefix.charAt(0)) && operators.contains(prefix.charAt(1))) {
			return prefix.charAt(0) + helper2(prefix.charAt(1)) + prefix.charAt(1);
		} else if ()
	}

	public static void main(String[] args) {
		String[] a = {"*12","+-231","+1**32/14"};
		Solution s = new Solution();
		String[] b = s.pre2post(a);
		for (int i = 0; i < b.length; ++i) {
			System.out.println(b[i]);
		}
	}
}