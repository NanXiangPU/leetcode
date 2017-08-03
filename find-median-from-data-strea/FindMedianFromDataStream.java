public class MedianFinder {
    private PriorityQueue<Integer> large;
    private PriorityQueue<Integer> small;
    /** initialize your data structure here. */
    public MedianFinder() {
        this.large = new PriorityQueue<>();
        this.small = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        this.large.add(num);
        this.small.add(-large.poll());
        if (small.size() > large.size()) {
            large.add(-small.poll());
        }
    }
    
    public double findMedian() {
        if ((large.size() + small.size()) % 2 == 0) {
            return (large.peek() - small.peek()) / 2.0;
        } else {
            return large.peek();
        }
    }
}