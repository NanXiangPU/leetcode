/**
 * @param {number[]} nums
 * @return {number}
 */
var arrayPairSum = function(nums) {
    if (nums === null || nums.length === 0) {
        return 0;
    }
    nums.sort(function(a, b) {
        return a - b;
    });
    var sum = 0;
    for (var i = 0; i < nums.length; i += 2) {
        sum += nums[i];
    }
    return sum;
};