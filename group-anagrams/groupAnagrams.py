class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        hashmap = {}
        for i in range(len(strs)):
            word = strs[i]
            letters = ''.join(sorted(word))
            if letters not in hashmap:
                hashmap[letters] = [word]
            else:
                hashmap[letters] += [word]
        res = []
        for letters in hashmap:
            res.append(hashmap[letters])
        return res