import java.util.*;

public class Solution {
	public void setBits(int[][] A, int offset, int len) {
		if (A == null || A.length == 0 || A[0] == null || A[0].length == 0) {
			return;
		}
		int level = A.length - 1;
		int maxLen = A[level].length;
		int left = offset;
		int right = offset + len - 1;
		if (right > maxLen - 1) {
			right = maxLen - 1;
		}
		while (level >= 0) {
			if (left > right) {
				break;
			}
			for (int i = left; i <= right; ++i) {
				A[level][i] = 1;
			}
			int cousin_left = left % 2 == 0 ? left + 1 : left - 1;
			int cousin_right = right % 2 == 0 ? right + 1 : right - 1;
			int upper_left = A[level][left] * A[level][cousin_left];
			int upper_right = A[level][right] * A[level][cousin_right];
			level--;
			left /= 2;
			right /= 2;
			if (upper_left == 0) {
				left++;
			}
			if (upper_right == 0) {
				right--;
			}
		}
	}

	public void clearBits(int[][] A, int offset, int len) {
		if (A == null || A.length == 0 || A[0] == null || A[0].length == 0) {
			return;
		}
		int level = A.length - 1;
		int maxLen = A[level].length;
		int left = offset;
		int right = offset + len - 1;
		if (right > maxLen - 1) {
			right = maxLen - 1;
		}
		while (level >= 0) {
			for (int i = left; i <= right; ++i) {
				A[level][i] = 0;
			}
			level--;
			left /= 2;
			right /= 2;
		}
	}

	public void printTree(int[][] A) {
		for (int i = 0; i < A.length; ++i) {
			for (int j = 0; j < A[0].length; ++j) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] A = new int[3][4];
		for (int i = 0; i < A.length; ++i) {
			Arrays.fill(A[i], -1);
		}
		A[0][0] = 0;
		A[1][0] = 0;
		A[1][1] = 1;
		A[2][0] = 1;
		A[2][1] = 0;
		A[2][2] = 1;
		A[2][3] = 1;
		Solution s = new Solution();
		s.printTree(A);
		s.setBits(A, 1, 1);
		System.out.println();
		s.printTree(A);
		s.clearBits(A, 0, 4);
		System.out.println();
		s.printTree(A);
		System.out.println();
		s.setBits(A, 0, 2);
		s.printTree(A);
		s.setBits(A, 2, 2);
		System.out.println();
		s.printTree(A);
	}
}