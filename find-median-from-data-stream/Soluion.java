public class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Long> small = new PriorityQueue<>();
    PriorityQueue<Long> large = new PriorityQueue<>();
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        large.offer((long)num);
        small.offer(-large.poll());
        if (large.size() < small.size()) {
            large.offer(-small.poll());
        }
    }
    
    public double findMedian() {
        if (large.size() == small.size()) {
            return (large.peek() - small.peek()) / 2.0;
        } else {
            return (double)large.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */