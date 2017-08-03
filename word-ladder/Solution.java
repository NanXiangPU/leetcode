public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        for (String str : wordList) {
            wordSet.add(str);
        }
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int len = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> temp = new HashSet<>();
            for (String word : beginSet) {
                char[] wordArray = word.toCharArray();
                for (int i = 0; i < wordArray.length; ++i) {
                    for (char c = 'a'; c <= 'z'; ++c) {
                        char old = wordArray[i];
                        wordArray[i] = c;
                        String str = String.valueOf(wordArray);
                        if (endSet.contains(str)) {
                            return len + 1;
                        }
                        if (!visited.contains(str) && wordSet.contains(str)) {
                            temp.add(str);
                            visited.add(str);
                        }
                        wordArray[i] = old;
                    }   
                }
            }
            beginSet = temp;
            len++;
        }
        return 0;
    }
}