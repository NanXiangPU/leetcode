/**
 * @param {number[]} nums
 * @return {number}
 */
var findLHS = function(nums) {
    if (nums === null || nums.length === 0) {
        return 0;
    }
    map = {};
    var res = 0;
    for (var i = 0; i < nums.length; ++i) {
        if (map[nums[i]] === undefined) {
            map[nums[i]] = 1;
        } else {
            map[nums[i]] += 1;
        }
    }
    for (var key in map) {
        if (map[parseInt(key) + 1] !== undefined) {
            res = Math.max(res, map[key] + map[parseInt(key) + 1]);
        }
    }
    return res;
};