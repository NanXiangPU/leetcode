public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (lower > upper) {
            return res;
        }
        if (nums == null || nums.length == 0) {
            if (lower == upper) {
                String s = lower + "";
                res.add(s);
            } else {
                String s = lower + "->" + upper;  
                res.add(s);
            }
            return res;
        }
        int start = nums[0];
        if (start > lower) {
            if (start - 1 == lower) {
                String s = "" + lower;
                res.add(s);
            } else {
                String s = lower + "->" + (start - 1);
                res.add(s);
            }
        }
        for (int i = 1; i < nums.length; ++i) {
            long distance = (long)nums[i] - (long)nums[i - 1];
            if (distance <= 1) {
                continue;
            } else {
                if (distance == 2) {
                    String str = nums[i] - 1 + "";
                    res.add(str);
                } else {
                    String str = (nums[i - 1] + 1) + "->" + (nums[i] - 1);
                    res.add(str);
                }
            }
        }
        int end = nums[nums.length - 1];
        if (upper > end) {
            if (upper - 1 == end) {
                String last = "" + upper;
                res.add(last);
            } else {
                String last = (end + 1) + "->" + upper;
                res.add(last);
            }
        }
        
        return res;
    }
}