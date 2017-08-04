public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (!map.containsKey(nums[i])) {
                int left = map.containsKey(nums[i] - 1) ? map.get(nums[i] - 1) : 0;
                int right = map.containsKey(nums[i] + 1) ? map.get(nums[i] + 1) : 0;
                int sum = left + right + 1;
                map.put(nums[i], sum);
                res = Math.max(res, sum);
                map.put(nums[i] - left, sum);
                map.put(nums[i] + right, sum);
            }
        }
        return res;
    }
}