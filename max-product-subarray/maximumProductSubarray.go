func max(a, b int) int{
    if a < b {
        return b
    }
    return a
}

func min(a, b int) int{
    if a < b {
        return a
    }
    return b
}

func maxProduct(nums []int) int {
    var maxHerePre int = nums[0]
    var minHerePre int = nums[0]
    var maxSoFar int = nums[0]
    var maxHere, minHere int
    for i := 1; i < len(nums); i++ {
        maxHere = max(max(maxHerePre * nums[i], minHerePre * nums[i]), nums[i]);
        minHere = min(min(maxHerePre * nums[i], minHerePre * nums[i]), nums[i]);
        maxSoFar = max(maxSoFar, maxHere)
        maxHerePre = maxHere
        minHerePre = minHere
    }
    return maxSoFar
}
