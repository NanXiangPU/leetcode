import java.util.*;

public class Solution {
	public int[] multiplication(int[] primes) {
		if (primes == null || primes.length < 2) {
			return primes;
		}
		List<List<Integer>> lists = new ArrayList<>();
		Arrays.sort(primes);
		helper(primes, lists, 0, new ArrayList<>());
		int[] res = new int[lists.size()];
		for (int i = 0; i < lists.size(); ++i) {
			List<Integer> list = lists.get(i);
			int product = 1;
			for (Integer integer : list) {
				product *= integer;
			}
			res[i] = product;
		}
		return res;
	}

	public void helper(int[] primes, List<List<Integer>> lists, int curr, List<Integer> currList) {
		if (currList.size() > 1) {
			lists.add(new ArrayList<>(currList));
		}
		for (int i = curr; i < primes.length; ++i) {
			if (i > curr && primes[i] == primes[i - 1]) {
				continue;
			}
			currList.add(primes[i]);
			helper(primes, lists, i + 1, currList);
			currList.remove(currList.size() - 1);
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] primes = {5,3,2,3};
		int[] res = s.multiplication(primes);
		for (int i = 0; i < res.length; ++i) {
			System.out.println(res[i]);
		}
	}
}