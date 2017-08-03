public class Solution {
    public int findLHS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Integer i : map.keySet()) {
            if (map.containsKey(i + 1)) {
                res = Math.max(res, map.get(i) + map.get(i + 1));
            }
        }
        return res;
    }
}