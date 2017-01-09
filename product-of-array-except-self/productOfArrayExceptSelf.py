class Solution(object):
    #hashmap
    def productExceptSelf1(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        output = []
        p = 1
        n = len(nums)
        for i in range(0,n):
            output.append(p)
            p = p * nums[i]
        p = 1
        for i in range(n - 1,-1,-1):
            output[i] = output[i] * p
            p = p * nums[i]
        return output

    #moore voting
    def majorityElement2(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        major = nums[0]
        count = 1
        for i in range(1,len(nums)):
            if count == 0:
                count = 1
                major = nums[i]
            elif nums[i] == major:
                count += 1
            else:
                count -= 1
        return major

    #bit manipulation
    bit = [0] * 32
        for i in nums:
            for j in range(32):
                bit[j] += (i >> j) & 1
        output = 0
        for i in range(32):
            if bit[i] > len(nums) / 2:
                if i == 31:
                    output = -((1 << 31) - output)
                else:
                    output |= 1 << i
        return output
        
    #divide and conquer
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return None
        if len(nums) == 1:
            return nums[0]
        a = self.majorityElement(nums[:len(nums)//2])
        b = self.majorityElement(nums[len(nums)//2:])
        if a == b:
            return a
        return [b,a][nums.count(a) > len(nums)//2]