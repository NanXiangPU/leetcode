public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        backTrack(nums, 0, new ArrayList<>(), res);
        return res;
    }
    
    public void backTrack(int[] nums, int cur, List<Integer> currList, List<List<Integer>> res) {
        res.add(new ArrayList<>(currList));
        for (int i = cur; i < nums.length; ++i) {
            currList.add(nums[i]);
            backTrack(nums, i + 1, currList, res);
            currList.remove(currList.size() - 1);
        }
    }
}