func twoSum(nums []int, target int) []int {
    var m  = make(map[int]int)
    for i := 0; i < len(nums); i++ {
        if val, ok := m[target - nums[i]]; ok{
            return []int{val, i}
        }else {
            m[nums[i]] = i
        }    
    }
    return []int{-1,-1}
}
