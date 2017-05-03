public class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int start = 0, end = 0, step = 0;
        while (end < nums.length - 1) {
            step++;
            int maxEnd = Integer.MIN_VALUE;
            for (;start <= end; ++start) {
                maxEnd = Math.max(maxEnd, start + nums[start]);
                if (maxEnd >= nums.length - 1) {
                    return step;
                }
            }
            end = maxEnd;
            if (end < start) {
                return -1;
            }
        }
        return 0;
    }
}