public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null || wall.size() == 0) {
            return 0;
        }
        int height = wall.size();
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < wall.size(); ++i) {
            List<Integer> list = wall.get(i);
            int sum = 0;
            for (int j = 0; j < list.size() - 1; ++j) {
                sum += list.get(j);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
                max = Math.max(map.get(sum), max);
            }
        }
        return height - max;
    }
}