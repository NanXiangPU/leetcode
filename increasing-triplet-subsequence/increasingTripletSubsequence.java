public class Solution {
    //O(n2)
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] >= 3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //O(nlogn)
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int left = 0, right = size;
            while (left != right) {
                int mid = left + (right - left) / 2;
                if (tails[mid] < x) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            tails[left] = x;
            if (left == size) {
                size++;
                if (size >= 3) {
                    return true;
                }
            }
        }
        return false;
    }

    //O(n)
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] <= first) {
                first = nums[i];
            } else if (nums[i] <= second) {
                second = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}