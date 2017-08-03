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
        Collections.sort(intervals, new Comparator<Interval>(){
           public int compare(Interval a, Interval b) {
               return a.start - b.start;
           } 
        });
        res.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); ++i) {
            Interval interval = intervals.get(i);
            Interval last = res.get(res.size() - 1);
            if (last.end >= interval.start) {
                last.end = Math.max(last.end, interval.end);
            } else {
                res.add(interval);
            }
        }
        return res;
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        List<Interval> copy = new ArrayList<>();
        copy.add(newInterval);
        if (intervals == null || intervals.size() == 0) {
            return copy;
        }
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            res.add(intervals.get(i++));
        }
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval(Math.min(newInterval.start, intervals.get(i).start), Math.max(newInterval.end, intervals.get(i).end));
            i++;
        }
        res.add(newInterval);
        while(i < intervals.size() && intervals.get(i).start > newInterval.end) {
            res.add(intervals.get(i++));
        }
        return res;
    }
}