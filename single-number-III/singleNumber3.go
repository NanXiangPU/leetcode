func singleNumber(nums []int) []int {
    var diff int = 0
    var a,b int = 0,0
    for _,i := range nums {
        diff ^= i
    }
    diff &= -diff
    for _,i := range nums {
        if i & diff == 0 {
            a ^= i
        }else {
            b ^= i
        }
    }
    return []int{a,b}
}
