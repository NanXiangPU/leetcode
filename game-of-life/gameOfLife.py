class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        direction = [[-1,-1],[-1,0],[-1,1],[0,-1],[0,1],[1,-1],[1,0],[1,1]]
        for i in range(len(board)):
            for j in range(len(board[0])):
                count = 0
                for vec in direction:
                    m = i + vec[0]
                    n = j + vec[1]
                    if m >= 0 and m < len(board) and n >= 0 and n < len(board[0]):
                        if board[m][n] & 1 == 1:
                            count += 1
                if board[i][j] == 1 and count >= 2 and count <= 3:
                    board[i][j] = 3
                elif board[i][j] == 0 and count == 3:
                    board[i][j] = 2
        for i in range(len(board)):
            for j in range(len(board[0])):
                board[i][j] >>= 1