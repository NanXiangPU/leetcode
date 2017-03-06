class Solution(object):
    def shortestDistance(self, words, word1, word2):
        """
        :type words: List[str]
        :type word1: str
        :type word2: str
        :rtype: int
        """
        shortest = len(words)
        index1 = -1
        index2 = -1
        for i in range(len(words)):
            if words[i] == word1:
                index1 = i
            if words[i] == word2:
                index2 = i
            if index1 != -1 and index2 != -1:
                shortest = min(shortest, abs(index1 - index2))
        
        return shortest