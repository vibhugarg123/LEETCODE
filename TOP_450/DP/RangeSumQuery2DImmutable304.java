package TOP_450.DP;

/*
    Problem-304:  Range Sum Query 2D - Immutable
    Given a 2D matrix, handle multiple queries of the following type:

    Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1)
    and lower right corner (row2, col2).

    int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the rectangle defined
    by its upper left corner (row1, col1) and lower right corner (row2, col2).
 */
public class RangeSumQuery2DImmutable304 {

    int[][] matrix;
    int[][] dp;

    public RangeSumQuery2DImmutable304(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;

        this.matrix = matrix;

        int nRows = matrix.length;
        int nCols = matrix[0].length;

        // No need to initialize extra added row and column since it's by default 0 in Java
        this.dp = new int[nRows + 1][nCols + 1];

        for (int i = 1; i <= nRows; i++) {
            for (int j = 1; j <= nCols; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        /*                 0  1  2  3
              0  1  2   0  0  0  0  0
            0 1  2  3   1  0  1  3  6
            1 1  2  3   2  0  2  6  12
            2 1  2  3   3  0  3  9  18   (r1,c1)= (1,1) (r2,c2) = (2,2)
         */
        // Add 1 to calculate
        // sum from (0,0) to (r2,c2)= dp[row2+1][col2+1]
        // sum from (0,0) to (0,2) i.e row=row1-1+1   col= col2+1
        // sum from (0,0) to (2,0) i.e row=row2+1     col=col-1+1
        // sum from (0,0) to (r1-1,c1-1) i.e (r1,c1)
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 1, 2, 0},
                {5, 3, 3, 1, 0},
                {3, 1, 2, 5, 2},
                {0, 4, 1, 4, 3},
                {1, 3, 2, 3, 1},
                {2, 4, 0, 4, 2}};
        System.out.println(new RangeSumQuery2DImmutable304(matrix).sumRegion(2, 1, 4, 3));
    }
}