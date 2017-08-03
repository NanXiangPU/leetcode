/**
 * Definition for an interval.
 * function Interval(start, end) {
 *     this.start = start;
 *     this.end = end;
 * }
 */
/**
 * @param {Interval[]} intervals
 * @return {Interval[]}
 */
var merge = function(intervals) {
    if (intervals === null || intervals.length === 0) {
        return [];
    }
    var res = [];
    intervals.sort(function(a, b) {
        return a.start - b.start; 
    });
    res.push(intervals[0]);
    for (var i = 1; i < intervals.length; ++i) {
        var curr = res[res.length - 1];
        var next = intervals[i];
        if (curr.end < next.start) {
            res.push(next);
        } else {
            res.pop();
            res.push(new Interval((curr.start), Math.max(next.end, curr.end)));
        }
    }
    return res;
};