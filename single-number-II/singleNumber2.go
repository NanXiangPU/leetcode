func singleNumber(nums []int) int {
    var a,b int = 0,0
    for _,c := range nums {
        var tmp int = (^a&b&c)|(a&^b&^c)
        b = (b^c)&^a
        a = tmp
    }
    return b
}
