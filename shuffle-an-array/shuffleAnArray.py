class Solution(object):
    
    def __init__(self, nums):
        """
        :type nums: List[int]
        """
        self.original = nums    

    def reset(self):
        """
        Resets the array to its original configuration and return it.
        :rtype: List[int]
        """
        return self.original

    def shuffle(self):
        """
        Returns a random shuffling of the array.
        :rtype: List[int]
        """
        array = self.original[:]
        if len(array) == 0:
            return []
        for i in range(1, len(array)):
            j = random.randint(0, i)
            array[i], array[j] = array[j], array[i]
        return array
        

# Your Solution object will be instantiated and called as such:
# obj = Solution(nums)
# param_1 = obj.reset()
# param_2 = obj.shuffle()