class Solution(object):
    def computeArea(self, A, B, C, D, E, F, G, H):
        """
        :type A: int
        :type B: int
        :type C: int
        :type D: int
        :type E: int
        :type F: int
        :type G: int
        :type H: int
        :rtype: int
        """
        if A == B and B == C and C == D:
            return abs((E - G) * (F - H))
        elif E == F and F == G and G == H:
            return abs((A - C) * (B - D))
        if B >= H or F >= D or A >= G or C <= E:
            return abs((A - C) * (B - D)) + abs((E - G) * (F - H))
        
        x = [A, C, E, G]
        y = [B, D, F, H]
        x.sort()
        y.sort()
        return abs((A - C) * (B - D)) + abs((E - G) * (F - H)) - (x[2] - x[1]) * (y[2] - y[1])