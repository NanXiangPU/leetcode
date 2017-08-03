public class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int start = 0, end = 0, step = 0;
        List<Integer> path = new ArrayList<>();
        while (end < nums.length - 1) {
            step++;
            int maxEnd = Integer.MIN_VALUE;
            int index = -1;
            for (;start <= end; ++start) {
                if (start + nums[start] > maxEnd) {
                    index = start;
                    maxEnd = start + nums[start];
                }
                if (maxEnd >= nums.length - 1) {
                    break;
                }
            }
            end = maxEnd;
            if (end < start) {
                return -1;
            }
            path.add(index);
        }
        for (int i = 0; i < path.size(); ++i) {
            System.out.println(path.get(i));
        }
        return 0;
    }
}