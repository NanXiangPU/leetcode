class Solution(object):
    #dp1
    def countBits(self, num):
        """
        :type num: int
        :rtype: List[int]
        """
        bits = []
        bits.append(0)
        offset = 1
        index = 1
        while index <= num:
            if offset * 2 == index:
                offset *= 2
            bits.append(bits[index - offset] + 1)
            index += 1
        return bits

    #dp2
    def countBits(self, num):
        """
        :type num: int
        :rtype: List[int]
        """
        bits = []
        bits.append(0)
        index = 1
        while index <= num:
            bits.append(bits[index >> 1] + (index & 1))
            index += 1
        return bits
            