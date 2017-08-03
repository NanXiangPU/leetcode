public class Solution {
    public int jump(int[] nums) {
<<<<<<< HEAD
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int start = 0, end = 0, step = 0;
        while (end < nums.length - 1) {
            step++;
            int maxEnd = Integer.MIN_VALUE;
            for (;start <= end; ++start) {
                maxEnd = Math.max(maxEnd, start + nums[start]);
=======
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
>>>>>>> 75d039f8ce5568327b34ac1908041a60c42506f9
                if (maxEnd >= nums.length - 1) {
                    return step;
                }
            }
<<<<<<< HEAD
            end = maxEnd;
            if (end < start) {
                return -1;
            }
        }
        return 0;
    }
=======
            maxReach = maxEnd;
        }
        return 0;
    }

>>>>>>> 75d039f8ce5568327b34ac1908041a60c42506f9
}