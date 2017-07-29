import java.util.*;

public class Solution {
	public List<Integer> findIntervals(int[][] A, int target) {
		List<Integer> res = new ArrayList<>();
		if (A == null || A.length == 0 || A[0] == null || A[0].length == 0) {
			return res;
		}
		for (int i = 0; i < A.length; ++i) {
			int[] nums = A[i];
			int index = -1;
			int left = 0, right = nums.length - 1;
			if (target < nums[left] || target > nums[right]) {
				continue;
			}
			while (left + 1 < right) {
				int mid = left + (right - left) / 2;
				if (target == nums[mid]) {
					break;
				} else if (target < nums[mid]) {
					right = mid;
				} else {
					left = mid;
				}
			}
			if (left % 2 == 0) {
				res.add(i);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] A = {{0,2,4,6}, {2,5,8,10,11,13},{1,3,4,8},{1,2,4,5},{5,7,9,14}};
		List<Integer> res = s.findIntervals(A, 3);
		for (Integer i : res) {
			System.out.println(i);
		}
	}
}