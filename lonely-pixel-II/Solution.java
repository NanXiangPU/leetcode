class Solution {
    public int findBlackPixel(char[][] picture, int N) {
        Map<String, Integer> map = new HashMap<>();
        int[] colCount = new int[picture[0].length];
        for (int i = 0; i < picture.length; ++i) {
            int count = 0;
            String pattern = "";
            for (int j = 0; j < picture[0].length; ++j) {
                if (picture[i][j] == 'B') {
                    count++;
                    colCount[j]++;
                }
                pattern += picture[i][j];
            }
            if (count == N) {
                if (!map.containsKey(pattern)) {
                    map.put(pattern, 1);
                } else {
                    map.put(pattern, map.get(pattern) + 1);
                }
            }
        }
        
        int res = 0;
        for (String str : map.keySet()) {
            if (map.get(str) == N) {
                for (int i = 0; i < colCount.length; ++i) {
                    if (str.charAt(i) == 'B' && colCount[i] == N) {
                        res += N;
                    }
                }
            }
        }
        
        return res;
    }
}