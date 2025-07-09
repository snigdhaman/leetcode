package arraysandhashing;

public class LC304RangeSumQuery2D {
    int[][] mat;

    public LC304RangeSumQuery2D (int[][] matrix) {
        //Initialize a matrix of size +1 rows & cols to cover the boundary condition
        //These new rows will be initialized with 0
        mat = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            int prefix = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                //Prefix sum of element = sum of all elements to the left cols + sum of prefix sum at above position mat[row-1][col]
                prefix = prefix + matrix[i][j];
                mat[i + 1][j + 1] = prefix + mat[i][j + 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1 = row1 + 1;
        col1 = col1 + 1;
        row2 = row2 + 1;
        col2 = col2 + 1;

        //sum of submatrix
        int subMatrixSum = mat[row2][col2];
        //prefix sum of above matrix
        int aboveMatrixSum = mat[row1 - 1][col2];
        //prefix sum of left matrix
        int leftMatrixSum = mat[row2][col1 - 1];
        //Remove the common elements counted twice
        int topLeftSum = mat[row1 - 1][col1 - 1];

        return subMatrixSum - aboveMatrixSum - leftMatrixSum + topLeftSum;

    }
}
