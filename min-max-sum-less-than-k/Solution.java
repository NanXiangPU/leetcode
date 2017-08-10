import java.util.*;

public class Solution {
	public int count(int[] A, int k) {
		if (A == null || A.length == 0) {
			return 0;
		}
		Arrays.sort(A);
		int left = 0, right = A.length - 1;
		Map<Integer, Integer> map = new HashMap<>();
		while (left <= right) {
			if (A[left] + A[right] >= k) {
				right--;
			} else {
				break;
			}
		}
		if (right < 0) {
			return 0;
		}
		int res = calculateSubSet(A, left, right);
		while (left < right) {
			
		}
		
		return res.size();
	}

	public int calculateSubSet(int[] A, int i, int j) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int p = i; p <= j; ++p) {
			map.put(A[p], map.getOrDefault(A[p],0) + 1);
		}
		int res = 1;
		for (Integer i : map.keySet()) {
			res *= map.get(i) + 1;
		}
		return res;
	}

	public void subset(List<List<Integer>> res, List<Integer> currList, int[] A, int index) {
		if (currList.size() > 0) {
			res.add(new ArrayList<>(currList));
		}
		for (int i = index; i < A.length; ++i) {
			if (i > index && A[i] == A[i - 1]) {
				continue;
			}
			currList.add(A[i]);
			subset(res, currList, A, i + 1);
			currList.remove(currList.size() - 1);
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] A = {1,2,3,4,5};
		int k = 5;
		System.out.println(s.count(A, k));
	}	
}