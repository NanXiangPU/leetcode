/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
class Solution {
public:
    static bool cmp(const Interval& a, const Interval& b) {
        return a.start < b.start;
    }
    vector<Interval> merge(vector<Interval>& intervals) {
        vector<Interval> res;
        if (intervals.empty()) {
            return res;
        }
        stack<Interval> stack;
        int count;
        sort(intervals.begin(), intervals.end(), cmp);
        stack.push(intervals[count++]);
        while (count < intervals.size()) {
            Interval curr = stack.top();
            Interval next = intervals[count++];
            if (curr.end < next.start) {
                stack.push(next);
            } else {
                stack.pop();
                int start = curr.start;
                int end = max(curr.end, next.end);
                Interval new_interval = Interval(start, end);
                stack.push(new_interval);
            }
        }
        while (!stack.empty()) {
            res.insert(res.begin(), stack.top());
            stack.pop();
        }
        return res;
    }
};