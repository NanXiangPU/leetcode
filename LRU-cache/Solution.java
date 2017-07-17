public class LRUCache {
<<<<<<< HEAD
    class DLinkedList {
        DLinkedList pre;
        DLinkedList next;
        int key;
        int value;
        
        public DLinkedList(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private void add(DLinkedList node) {
        DLinkedList next = head.next;
        
        head.next = node;
        node.pre = head;
        node.next = next;
        next.pre = node;
    }
    
    private void remove(DLinkedList node) {
        DLinkedList pre = node.pre;
        DLinkedList next = node.next;
        
        pre.next = next;
        next.pre = pre;
    }
    
    private void moveToHead(DLinkedList node) {
        remove(node);
        add(node);
    }
    
    private void removeLast() {
        remove(tail.pre);
    }
    
    private Map<Integer, DLinkedList> map;
    private DLinkedList head;
    private DLinkedList tail;
    private int capacity;
    private int count;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.head = new DLinkedList(0,0);
        this.tail = new DLinkedList(0,0);
        head.next = tail;
        tail.pre = head;
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        DLinkedList node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DLinkedList node = new DLinkedList(key, value);
        if(map.containsKey(key)) {
            DLinkedList tmp = map.get(key);
            tmp.value = value;
            moveToHead(tmp);
        } else {
            map.put(key, node);
            add(node);
            count++;
            if (count > capacity) {
                map.remove(tail.pre.key);
                removeLast();
                count--;
            }
        }
    }
}
=======
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
>>>>>>> 75d039f8ce5568327b34ac1908041a60c42506f9
