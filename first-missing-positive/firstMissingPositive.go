func firstMissingPositive(nums []int) int {
    var i int = 0
    for i < len(nums) {
        if nums[i] > 0 && nums[i] <= len(nums) && nums[nums[i] - 1] != nums[i] {
            swap(nums[0:], i, nums[i] - 1) 
        }else {
            i++
        }    
    }
    
    for i := 0; i < len(nums); i++ {
        if nums[i] != i + 1 {
            return i + 1
        }
    }
    return i + 1
}

func swap(A []int, i int, j int) {
    var tmp int = A[i]
    A[i] = A[j]
    A[j] = tmp
}

