package arraysandhashing;

public class LC498DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[] res = new int[rows * cols];

        int idx = 0;
        int currRow = 0, currCol = 0;
        boolean goingUp = true;
        while (idx < rows * cols) {
            if (goingUp) {
                while (currRow >= 0 && currCol < cols) {
                    res[idx++] = mat[currRow][currCol];
                    currRow--;
                    currCol++;
                }

                if (currCol >= cols) {
                    currRow += 2;
                    currCol--;
                }
                else {
                    currRow++;
                }
                goingUp = false;
            }
            else {
                while (currCol >= 0 && currRow < rows) {
                    res[idx++] = mat[currRow][currCol];
                    currRow++;
                    currCol--;
                }

                if (currRow >= rows) {
                    currRow--;
                    currCol += 2;
                }
                else {
                    currCol++;
                }
                goingUp = true;
            }
        }
        return res;
    }
}
