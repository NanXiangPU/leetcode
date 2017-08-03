public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        helper(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> currList, int[] nums, boolean[] used) {
        if (currList.size() == nums.length) {
            res.add(new ArrayList<>(currList));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            currList.add(nums[i]);
            helper(res, currList, nums, used);
            currList.remove(currList.size() - 1);
            used[i] = false;
        }
    }
}