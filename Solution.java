public class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        map.put(0, set1);
        for (int i = 1; i < stones.length - 1; ++i) {
            map.put(stones[i], new HashSet<Integer>());
        }
        for (int i = 0; i < stones.length - 1; ++i) {
            Set<Integer> possibleSteps = map.get(stones[i]);
            for (Integer step : possibleSteps) {
                int reach = stones[i] + step;
                if (reach == stones[stones.length - 1]) {
                    return true;
                } else if (map.containsKey(reach)) {
                    Set<Integer> set = map.get(reach);
                    set.add(step + 1);
                    set.add(step);
                    if (step - 1 > 0) {
                        set.add(step - 1);
                    }
                }
            }
        }
        return false;
    }
}