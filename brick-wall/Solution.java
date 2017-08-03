public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null || wall.size() == 0 || wall.get(0) == null || wall.get(0).size() == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> list : wall) {
            int sum = 0;
            for (int i = 0; i < list.size() - 1; ++i) {
                sum += list.get(i);
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                } else {
                    map.put(sum, 1);
                }
            }
        }
        int max = wall.size();
        int res = Integer.MAX_VALUE;
        for (Integer i : map.keySet()) {
            res = Math.min(max - map.get(i), res);
        }
        return res == Integer.MAX_VALUE ? wall.size() : res;
    }
}