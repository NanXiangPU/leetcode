public class Solution {
    //O(n2)
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            int sum = nums[i];
            int j = i + 1;
            while (j < nums.length && sum < s) {
                sum += nums[j++];
            }
            if (sum >= s) {
                res = Math.min(j - i, res);
            }
        }
        
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    //O(nlog(n))

    //O(n)
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }        
        int i = 0, j = 0;
        int res = Integer.MAX_VALUE, sum = 0;
        while (j < nums.length) {
            sum += nums[j++];
            
            while (sum >= s) {
                res = Math.min(res, j - i);
                sum -= nums[i++];
            }
        }
        
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}