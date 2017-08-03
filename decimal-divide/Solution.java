public class Solution {
	public String add(String a, String b) {
		if (a == null || a.length() == 0) {
			return b;
		}
		if (b == null || b.length() == 0) {
			return a;
		}
		int divident1 = Integer.parseInt(a.split("/")[0]);
		int divisor1 = Integer.parseInt(a.split("/")[1]);
		int divident2 = Integer.parseInt(b.split("/")[0]);
		int divisor2 = Integer.parseInt(b.split("/")[1]);

		int divisor = divisor1 * divisor2;
		int divident = divident1 * divisor2 + divident2 * divisor1;
		int gcd = gcd(divisor, divident);
		String res = (divident / gcd) + "/" + (divisor / gcd);
		return res;
	}

	public int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a%b);
	}

	public static void main(String[] args) {
		String a = "1/4";
		String b = "3/2";
		Solution s = new Solution();
		System.out.println(s.add(a, b));
	}
}