class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        if nums == None or len(nums) == 0:
            return None
        
        hashmap = {}
        for i in nums:
            if i in hashmap:
                hashmap[i] += 1
            else:
                hashmap[i] = 1
        
        res = []
        buckets = [[] for i in range(len(nums) + 1)]
        for i in hashmap.keys():
            count = hashmap[i]
            buckets[count].append(i)
        
        for i in range(len(buckets) - 1, 0, -1):
            if len(buckets[i]) != 0:
                res += buckets[i]
            if len(res) >= k:
                break;
        
        return res