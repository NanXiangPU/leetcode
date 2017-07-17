public class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < candies.length; ++i) {
            if (!set.contains(candies[i])) {
                set.add(candies[i]);
                count++;
                if (count >= candies.length / 2) {
                    return count;
                }
            }
        }
        return count;
    }
}