public class LRUCache {
    private class DoubleListNode {
        int key;
        int val;
        DoubleListNode prev;
        DoubleListNode next;
        
        public DoubleListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
    
    DoubleListNode head;
    DoubleListNode tail;
    Map<Integer, DoubleListNode> map;
    int capacity;
    int count;
    
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.head = new DoubleListNode(0, -1);
        this.tail = new DoubleListNode(0, -1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        this.count = 0;
    }
    
    public void moveToHead(DoubleListNode node) {
        DoubleListNode prev = node.prev;
        if (prev.equals(head)) {
            return;
        } else {
            DoubleListNode next = node.next;
            prev.next = next;
            next.prev = prev;
            
            DoubleListNode first = head.next;
            node.next = first;
            first.prev = node;
            head.next = node;
            node.prev = head;
        }
    }
    
    public void removeLast() {
        DoubleListNode node = tail.prev;
        DoubleListNode prev = node.prev;
        prev.next = tail;
        tail.prev = prev;
    }
    
    public void addNode(DoubleListNode node) {
        DoubleListNode next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }
    
    public void removeNode(DoubleListNode node) {
        DoubleListNode prev = node.prev;
        DoubleListNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        moveToHead(map.get(key));
        return map.get(key).val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            moveToHead(map.get(key));
            map.get(key).val = value;
        } else {
            count++;
            map.put(key, new DoubleListNode(key, value));
            if (count > capacity) {
                DoubleListNode node = tail.prev;
                map.remove(node.key);
                removeLast();
                count--;
            }
            addNode(map.get(key));
        }
    }
}