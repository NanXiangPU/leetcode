func threeSum(nums []int) [][]int {
    sort.Ints(nums)
    var res [][]int
    for i := 0; i < len(nums) - 2; i++ {
        if i > 0 && nums[i - 1] == nums[i] {
            continue
        }
        var target int = 0 - nums[i]
        var left int = i + 1
        var right int = len(nums) - 1
        for left < right {
            if nums[left] + nums[right] == target {
                res = append(res, []int{nums[i],nums[left],nums[right]})
                for left < right && nums[left] == nums[left + 1] {left++}
                for left < right && nums[right] == nums[right - 1] {right--}
                left++
                right--
            }else if nums[left] + nums[right] < target {
                left++
            }else {
                right--
            }
        }
    }
    return res;
}
