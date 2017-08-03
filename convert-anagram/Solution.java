import java.util.Map;
import java.util.HashMap;

public class Solution {
	public int findStep(String a, String b) {
		if (a == null && (b == null || b.length() == 0)) {
			return 0;
		}
		if (a != null && (b == null || b.length() == 0)) {
			return a.length();
		}
		int res = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < b.length(); ++i) {
			map.put(b.charAt(i), map.getOrDefault(b.charAt(i), 0) + 1);
		}
		for (int i = 0; i < a.length(); ++i) {
			if (!map.containsKey(a.charAt(i)) || map.get(a.charAt(i)) == 0) {
				res++;
			} else {
				map.put(a.charAt(i), map.get(a.charAt(i)) - 1);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String a = "abcde";
		String b = "bbbab";
		Solution s = new Solution();
		System.out.println(s.findStep(a, b));
	}
}