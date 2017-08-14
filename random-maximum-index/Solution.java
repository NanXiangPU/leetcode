public class Solution {
	public int randomMax(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int max = A[0];
		int index = -1;
		int count = 0;
		for (int i = 1; i < A.length; ++i) {
			if (max < A[i]) {
				count = 0;
				max = A[i];
			}
			if (max == A[i]) {
				count++;
				if (Math.random() < 1.0 / count) {
					index = i;
				}
			}
		}
		return index;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] A = {1,4,3,6,3,6,4,6};
		System.out.println(s.randomMax(A));
	}
}