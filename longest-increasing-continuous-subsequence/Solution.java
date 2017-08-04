public class Solution {
	public int longestSubsequence(int[] A) {
		int res = 1;
		int start = 0;
		int len = 1;
		for (int i = 1; i < A.length; ++i) {
			if (A[i] == A[i - 1] + 1) {
				len++;
				res = Math.max(len, res);
			} else {
				len = 1;
				start = i;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] A = {2,3,4,1,6,4,5,6,7};
		Solution s = new Solution();
		System.out.println(s.longestSubsequence(A));
	}
}