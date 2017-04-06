public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                } else {
                    return a[0] - b[0];
                }
            } 
        });
        
        int size = 0;
        int[] dp = new int[envelopes.length];
        for (int[] x : envelopes) {
            int left = 0, right = size;
            int index = Arrays.binarySearch(dp, 0, size, x[1]);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = x[1];
            if (index == size) {
                size++;
            }
        }
        return size;
    }
}