public class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int curLocation = 0;
        int maxReach = 0;
        int step = 0;
        while (maxReach < nums.length - 1) {
            step++;
            int maxEnd = Integer.MIN_VALUE;
            for (; curLocation <= maxReach; ++curLocation) {
                int end = curLocation + nums[curLocation];
                maxEnd = Math.max(maxEnd, end);
                if (maxEnd >= nums.length - 1) {
                    return step;
                }
            }
            maxReach = maxEnd;
        }
        return 0;
    }

}