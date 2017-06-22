public class LRUCache {
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
