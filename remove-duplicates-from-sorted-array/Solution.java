public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return nums.length;
        }
        int i = 1, j = 1;
        while (j < nums.length) {
            if (nums[j] == nums[j - 1]) {
                j++;
                continue;
            }
            nums[i++] = nums[j++];
        }
        return i;
    }
}