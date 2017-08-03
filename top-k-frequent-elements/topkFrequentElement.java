public class Solution {
    //O(n) priority queue
    class Pair {
        int value;
        int count;
        
        public Pair(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return b.count - a.count;
            }
        });
        
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i : nums) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                int count = map.get(i);
                map.put(i, count + 1);
            }
        }
        
        for (Integer i : map.keySet()) {
            int count = map.get(i);
            Pair p = new Pair(i, count);
            pq.add(p);
        }
        for (int i = 0; i < k; ++i) {
            res.add(pq.poll().value);
        }
        return res;
    }

    //O(n) buckets
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        List<Integer>[] buckets = new List[nums.length + 1];
        for (Integer i : map.keySet()) {
            int count = map.get(i);
            if (buckets[count] == null) {
                buckets[count] = new ArrayList<>();
            }
            buckets[count].add(i);
        }
        
        int size = k;
        List<Integer> res = new ArrayList<>();
        for (int i = buckets.length - 1; i > 0 && size > 0; --i) {
            if (buckets[i] != null) {
                res.addAll(buckets[i]);
                size -= buckets[i].size();
            }
        }
        return res;
    }
}