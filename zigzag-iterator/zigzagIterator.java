public class ZigzagIterator {
    ArrayDeque<Integer> queue;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new ArrayDeque<>();
        int i = 0, j = 0;
        while (i < v1.size() || j < v2.size()) {
            if (i < v1.size()) {
                queue.add(v1.get(i++));
            }
            if (j < v2.size()) {
                queue.add(v2.get(j++)); 
            }
        }
    }

    public int next() {
        return (int)queue.poll();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */