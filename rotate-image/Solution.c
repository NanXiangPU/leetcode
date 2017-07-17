void rotate(int** matrix, int matrixRowSize, int matrixColSize) {
    if (matrix == NULL || matrixRowSize == 0 || matrix[0] == NULL || matrixColSize == 0) {
        return;
    }
    for (int i = 0; i < matrixRowSize; ++i) {
        for (int j = 0; j < matrixColSize - i; ++j) {
            swap(matrix, i, j, matrixRowSize - j - 1, matrixColSize - i - 1);
        }
    }
    for (int i = 0; i < matrixRowSize / 2; ++i) {
        for (int j = 0; j < matrixColSize; ++j) {
            swap(matrix, i, j, matrixRowSize - i - 1, j);
        }
    }
}

void swap(int** matrix, int i, int j, int p, int q) {
    int tmp = matrix[i][j];
    matrix[i][j] = matrix[p][q];
    matrix[p][q] = tmp;
}s