func Max(a int, b int) int {
    if a > b {
        return a
    }else {
        return b
    }
}

func findMaxConsecutiveOnes(nums []int) int {
    var max int
    var count int
    for i := 0; i < len(nums); i++ {
        if nums[i] == 0 {
            max = Max(count, max)
            count = 0
        }else {
            count++
        }
    }
    return Max(count, max)
}
