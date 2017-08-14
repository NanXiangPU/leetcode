import java.util.*;

public class Solution2 {
	public List<List<Integer>> multiply(int[] A) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		helper(res, new ArrayList<>(), A, 0);
		return res;
	}

	public void helper(List<List<Integer>> res, List<Integer> currList, int[] A, int start) {
		if (currList.size() > 0) {
			res.add(new ArrayList<>(currList));
		}
		for (int i = start; i < A.length; ++i) {
			currList.add(A[i]);
			helper(res, currList, A, i + 1);
			currList.remove(currList.size() - 1);
		}
	}

	public static void main(String[] args) {
		Solution2 s = new Solution2();
		int[] A = {2,3,5};
		System.out.println(s.multiply(A));
	}
}