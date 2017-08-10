ppublic class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) {
            return 0;
        }
        Set<String> wordPool = new HashSet<>(wordList);
        if (!wordPool.contains(endWord)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        int step = 1;
        
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> tmp = new HashSet<>();
            for (String str : beginSet) {
                char[] letters = str.toCharArray();
                for (int i = 0; i < letters.length; ++i) {
                    char old = letters[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        letters[i] = c;
                        String neighbor = String.valueOf(letters);
                        if (endSet.contains(neighbor)) {
                            return step + 1;
                        }
                        if (wordPool.contains(neighbor) && !visited.contains(neighbor)) {
                            visited.add(neighbor);
                            tmp.add(neighbor);
                        }
                    }
                    letters[i] = old;
                }
            }
            
            step++;
            beginSet = tmp;
        }
        
        return 0;
    }
}