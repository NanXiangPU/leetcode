public class MinStack {
    long min;
    Stack<Long> stack;
    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new Stack<>();
    }
    
    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = x;
            return;
        }
        stack.push(x - min);
        if (x < min) {
            min = x;
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        long tmp = stack.pop();
        if (tmp < 0) {
            min = min - tmp;
        }
    }
    
    public int top() {
        if (stack.peek() < 0) {
            return (int)min;
        } else {
            return (int)(stack.peek() + min);
        }
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */