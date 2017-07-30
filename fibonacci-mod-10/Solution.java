public class Solution {
	public int[] generateFib(int size) {
		int[] res = new int[size];
		res[0] = 1;
		res[1] = 1;
		for (int i = 2; i < size; ++i) {
			res[i] = res[i - 1] + res[i - 2];
		}
		return res;
	}

	public int findRemain(int[] fib, int index) {
		return fib[index - 1];
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] fib = s.generateFib(40);
		for (int i = 0; i < 30; ++i) {
			System.out.println(fib[i] % 10);
		}
	}
}