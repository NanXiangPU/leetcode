class Solution(object):
    def shortestWordDistance(self, words, word1, word2):
        """
        :type words: List[str]
        :type word1: str
        :type word2: str
        :rtype: int
        """
        hashmap = {}
        for index, w in enumerate(words):
            hashmap[w] = hashmap.get(w, []) + [index]
        res = (1 << 31) - 1
        if word1 == word2:
            positions = hashmap[word1]
            for i in range(1, len(positions)):
                res = min(res, positions[i] - positions[i - 1])
            return res
        else:
            return min(abs(p1 - p2) for p1 in hashmap[word1] for p2 in hashmap[word2])