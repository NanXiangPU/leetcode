public class Solution {
	public String maxSection(String[] strs, int m, int n) {
		if (strs == null || strs.length == 0) {
			return m + "*" + n;
		}
		int a = m, b = n;
		for (String str : strs) {
			int index = str.indexOf("*");
			String str_a = str.substring(0, index);
			a = Math.min(Integer.parseInt(str_a), a);
			String str_b = str.substring(index + 1, str.length());
			b = Math.min(Integer.parseInt(str_b), b);
		}
		return a + "*" + b;
	}

	public static void main(String[] args) {
		int m = 100, n = 50;
		String[] strs = {"5*5", "8*10", "2*10", "30*3", "5*5"};
		Solution s = new Solution();
		System.out.println(s.maxSection(strs, m, n));
	}
}

/*
static long countX(String[] steps) {
        long a = Long.MAX_VALUE, b = Long.MAX_VALUE;
        for (String str : steps) {
            String[] parts = str.split(" ");
            a = Math.min(a, Long.parseLong(parts[0]));
            b = Math.min(b, Long.parseLong(parts[1]));
        }
        return a*b;
    }
*/