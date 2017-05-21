/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return res;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            } 
        });
        Stack<Interval> stack = new Stack<>();
        int count = 0;
        stack.push(intervals.get(count++));
        while (count < intervals.size()) {
            Interval curr = stack.peek();
            Interval next = intervals.get(count++);
            if (curr.end < next.start) {
                stack.push(next);
            } else {
                stack.pop();
                int start = curr.start;
                int end = Math.max(curr.end, next.end);
                Interval new_interval = new Interval(start, end);
                stack.push(new_interval);
            }
        }
        while (!stack.isEmpty()) {
            res.add(0, stack.pop());
        }
        return res;
    }
}