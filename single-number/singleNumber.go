func singleNumber(nums []int) int {
    var single int = 0
    for _,num := range nums {
        single ^= num
    }
    return single
}
