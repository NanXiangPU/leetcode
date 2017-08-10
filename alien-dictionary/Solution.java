public class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        String res = "";
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();
        for (String str : words) {
            for (int i = 0; i < str.length(); ++i) {
                degree.put(str.charAt(i), 0);
            }
        }
        for (int i = 0; i < words.length - 1; ++i) {
            String word = words[i];
            String next = words[i + 1];
            int len = Math.min(word.length(), next.length());
            for (int j = 0; j < len; ++j) {
                char c1 = word.charAt(j);
                char c2 = next.charAt(j);
                if (c1 != c2) {
                    Set<Character> set = new HashSet<>();
                    if (map.containsKey(c1)) {
                        set = map.get(c1);
                    }
                    if (!set.contains(c2)) {
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2) + 1);
                    }
                    break;
                }
            }
        }
        Deque<Character> queue = new LinkedList<>();
        for (Character c : degree.keySet()) {
            if (degree.get(c) == 0) {
                queue.offer(c);
            }
        }
        while (!queue.isEmpty()) {
            char c = queue.poll();
            res += c;
            if (map.containsKey(c)) {
                for (char next : map.get(c)) {
                    degree.put(next, degree.get(next) - 1);
                    if (degree.get(next) == 0) {
                        queue.offer(next);
                    }   
                }
            }
        }
        if (res.length() != degree.size()) {
             return "";
        }
        return res;
    }
}