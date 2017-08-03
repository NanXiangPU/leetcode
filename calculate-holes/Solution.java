import java.util.*;

public class Solution {
	public List<Integer> findHoles(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		int[] holes = {1, 0, 0, 0, 1, 0, 1, 0, 2, 1};
		for (int i = 0; i < nums.length; ++i) {
			int num = nums[i];
			int count = 0;
			while (num != 0) {
				count += holes[num % 10];
				num = num / 10;
			}
			res.add(count);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] test = {123, 424, 8140, 12334};
		Solution s = new Solution();
		List<Integer> res = s.findHoles(test);
		for (Integer i : res) {
			System.out.println(i);
		}
	}
}