public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        helper(nums, res, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }
    
    public void helper(int[] nums, List<List<Integer>> res, List<Integer> currList, boolean[] used) {
        if (currList.size() == nums.length) {
            res.add(new ArrayList<>(currList));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (used[i] || (i > 0 && nums[i - 1] == nums[i] && !used[i - 1])) {
                continue;
            }
            used[i] = true;
            currList.add(nums[i]);
            helper(nums, res, currList, used);
            currList.remove(currList.size() - 1);
            used[i] = false;
        }
    }
}