public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int best = 0;
        for(int i : nums) {
            if(map.containsKey(i)) {
                continue;
            }
            int left = map.containsKey(i - 1) ? map.get(i - 1) : 0;
            int right = map.containsKey(i + 1) ? map.get(i + 1) : 0;
            int sum = left + right + 1;
            map.put(i, sum);
            best = Math.max(sum, best);
            map.put(i - left, sum);
            map.put(i + right, sum);
        }
        return best;
    }
}