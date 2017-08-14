<<<<<<< HEAD
pupublic class Solution {
    //2-way bfs
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
=======
ppublic class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
>>>>>>> 0cbaf2991569390e007da138983014843bc40b51
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
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
<<<<<<< HEAD
            Set<String> neighbors = new HashSet<>();
            for (String str : beginSet) {
                visited.add(str);
=======
            Set<String> tmp = new HashSet<>();
            for (String str : beginSet) {
>>>>>>> 0cbaf2991569390e007da138983014843bc40b51
                char[] letters = str.toCharArray();
                for (int i = 0; i < letters.length; ++i) {
                    char old = letters[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
<<<<<<< HEAD
                        if (c == old) {
                            continue;
                        }
                        letters[i] = c;
                        String neighbor = String.valueOf(letters);
                        if (endSet.contains(neighbor)) {
                            return len + 1;
                        }
                        if (!visited.contains(neighbor) && wordPool.contains(neighbor)) {
                            neighbors.add(neighbor);
                        }
                    }
                    letters[i] = old;
                }
            }
            len++;
            beginSet = neighbors;
        }
        return 0;
    }


    //BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) {
            return 0;
        }
        Set<String> wordPool = new HashSet<>(wordList);
        if (!wordPool.contains(endWord)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Deque<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int len = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String curr = queue.poll();
                visited.add(curr);
                char[] array = curr.toCharArray();
                for (int j = 0; j < array.length; ++j) {
                    char old = array[j];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        if (c == old) {
                            continue;
                        }
                        array[j] = c;
                        String str = String.valueOf(array);
                        if (str.equals(endWord)) {
                            return len + 1;
                        }
                        if (wordPool.contains(str) && !visited.contains(str)) {
                            queue.offer(str);
                        }
                    }
                    array[j] = old;
                }
            }
            len++;
=======
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
>>>>>>> 0cbaf2991569390e007da138983014843bc40b51
        }
        
        return 0;
    }
}