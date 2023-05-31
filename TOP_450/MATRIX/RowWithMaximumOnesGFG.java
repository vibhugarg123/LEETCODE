package TOP_450.MATRIX;

/*
       Problem-GFG: https://practice.geeksforgeeks.org/problems/row-with-max-1s0023/1
       Given a boolean 2D array of n x m dimensions where each row is sorted.
       Find the 0-based index of the first row that has the maximum number of 1's.

        Example 1:

        Input:
        N = 4 , M = 4
        Arr[][] = {{0, 1, 1, 1},
                   {0, 0, 1, 1},
                   {1, 1, 1, 1},
                   {0, 0, 0, 0}}

        Output: 2
        Explanation: Row 2 contains 4 1's (0-based indexing).

        Solution:
        Following method works in O(m+n) time complexity in worst case.

        Step1: Get the index of first (or leftmost) 1 in the first row.
        Step2: Do following for every row after the first row
                …IF the element on left of previous leftmost 1 is 0, ignore this row.
                …ELSE Move left until a 0 is found. Update the leftmost index to this index and max_row_index to be the current row.

        The time complexity is O(m+n) because we can possibly go as far left as we came ahead in the first step.
 */
public class RowWithMaximumOnesGFG {
    public int rowAndMaximumOnes(int[][] mat) {
        int nRows = mat.length;
        int nCols = mat[0].length;

        int rowWithMaximumOnes = -1;
        int maximumOnes = 0;
        int row = 0;

        int col = mat[0].length - 1;
        while (row < nRows) {
            while (col >= 0 && mat[row][col] == 1) {
                col--;
            }

            int numberOfOnesInCurrentRow = nCols - col - 1;
            if (numberOfOnesInCurrentRow != 0 && numberOfOnesInCurrentRow > maximumOnes) {
                maximumOnes = numberOfOnesInCurrentRow;
                rowWithMaximumOnes = row;
            }
            row++;
        }
        return rowWithMaximumOnes;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {0, 1, 1, 1},
                {0, 0, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0}};
        System.out.println(new RowWithMaximumOnesGFG().rowAndMaximumOnes(mat));
    }
}