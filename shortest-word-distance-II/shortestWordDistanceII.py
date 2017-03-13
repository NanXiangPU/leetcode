class WordDistance(object):

    def __init__(self, words):
        """
        :type words: List[str]
        """
        self.hashmap = {}
        for index, w in enumerate(words):
            self.hashmap[w] = self.hashmap.get(w, []) + [index]

    def shortest(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: int
        """
        return min(abs(i1 - i2) for i1 in self.hashmap[word1] for i2 in self.hashmap[word2])
