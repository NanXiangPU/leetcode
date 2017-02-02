class Solution(object):
	#dictionary
    def lengthLongestPath(self, input):
        """
        :type input: str
        :rtype: int
        """
        pathLen = {0: 0}
        maxLen = 0
        for line in input.splitlines():
            name = line.lstrip("\t")
            depth = len(line) - len(name)
            if '.' in name:
                maxLen = max(maxLen, pathLen[depth] + len(name))
            else:
                pathLen[depth + 1] = pathLen[depth] + len(name) + 1
        return maxLen

	#stack
    def lengthLongestPath(self, input):
        """
        :type input: str
        :rtype: int
        """
        stack = []
        stack.append(0)
        maxLen = 0
        for line in input.splitlines():
            depth = line.rfind('\t') + 1
            while depth + 1 < len(stack):
                stack.pop()
            length = stack[len(stack) - 1] + len(line) - depth + 1
            stack.append(length)
            if '.' in line:
                maxLen = max(maxLen, length - 1)
        return maxLen
