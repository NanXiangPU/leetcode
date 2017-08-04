public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        helper(res, new ArrayList<>(), candidates, 0, target);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> currList, int[] candidates, int start, int target) {
        if (target <= 0) {
            if (target == 0) {
                res.add(new ArrayList<>(currList));    
            }
            return;
        }
        for (int i = start; i < candidates.length; ++i) {
            currList.add(candidates[i]);
            helper(res, currList, candidates, i, target - candidates[i]);
            currList.remove(currList.size() - 1);
        }
    }
}