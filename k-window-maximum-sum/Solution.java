public class Solution {
	public int maxSum(int[] A, int k) {
		if (A == null || A.length < k) {
			return 0;
		}
		int sum = 0, res = 0;
		for (int i = 0; i < k; ++i) {
			sum += A[i];
		}
		res = Math.max(sum, res);
		for (int i = k; i < A.length; ++i) {
			sum -= A[i - k];
			sum += A[i];
			res = Math.max(sum, res);
		}
		return res;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] A = {1, 4, 2, 10, 23, 3, 1, 0, 20};
		System.out.println(s.maxSum(A, 4));
	}
}