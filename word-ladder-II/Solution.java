public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (wordList == null || wordList.size() == 0) {
            return res;
        }
        Set<String> wordPool = new HashSet<>(wordList);
        if (!wordPool.contains(endWord)) {
            return res;
        }
        Map<String, Set<String>> neighborsMapping = new HashMap<>();
        for (String str : wordList) {
            neighborsMapping.put(str, new HashSet<>());
        }
        neighborsMapping.put(beginWord, new HashSet<>());
        
        Map<String, Integer> distanceMapping = new HashMap<>();
        distanceMapping.put(beginWord, 0);
        bfs(beginWord, endWord, wordPool, neighborsMapping, distanceMapping);
        dfs(res, new ArrayList<>(), beginWord, endWord, neighborsMapping, distanceMapping);
        return res;
    }
    
    public void bfs(String beginWord, String endWord, Set<String> wordPool, Map<String, Set<String>> neighborsMapping, Map<String, Integer> distanceMapping) {
        Deque<String> queue = new LinkedList<>();
        queue.add(beginWord);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean found = false;
            for (int i = 0; i < size; ++i) {
                String curr = queue.poll();
                Set<String> neighbors = getNeighbors(curr, wordPool);
                for (String neighbor : neighbors) {
                    neighborsMapping.get(curr).add(neighbor);
                    if (!distanceMapping.containsKey(neighbor)) {
                        distanceMapping.put(neighbor, distanceMapping.get(curr) + 1);
                        queue.offer(neighbor);
                        if (neighbor.equals(endWord)) {
                            found = true;
                        } else {
                            queue.offer(neighbor);
                        }
                    }
                }
                if (found = true) {
                    break;
                }
            }
        }
    }
    
    public Set<String> getNeighbors(String word, Set<String> wordPool) {
        char[] letters = word.toCharArray();
        Set<String> res = new HashSet<>();
        for (int i = 0; i < word.length(); ++i) {
            char old = letters[i];
            for (char c = 'a'; c <= 'z'; ++c) {
                if (letters[i] == c) {
                    continue;
                }
                letters[i] = c;
                String str = String.valueOf(letters);
                if (wordPool.contains(str)) {
                    res.add(str);
                }
            }
            letters[i] = old;
        }
        return res;
    }
    
    public void dfs(List<List<String>> res, List<String> currList, String curr, String endWord, Map<String, Set<String>> neighborsMapping, Map<String, Integer> distanceMapping) {
        currList.add(curr);
        if (curr.equals(endWord)) {
            res.add(new ArrayList<>(currList));
            return;
        }
        for (String neighbor : neighborsMapping.get(curr)) {
            if (distanceMapping.get(neighbor) == distanceMapping.get(curr) + 1) {
                dfs(res, currList, neighbor, endWord, neighborsMapping, distanceMapping);
                currList.remove(currList.size() - 1);
            }
        }
    }
}