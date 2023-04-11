package TOP_450.MATRIX;

import java.util.*;

/*
    Problem: Given an m x n matrix, find all common elements present in all rows in O(mn) time and one traversal of matrix.

        Example:

        Input:
        mat[4][5] = {{1, 2, 1, 4, 8},
                     {3, 7, 8, 5, 1},
                     {8, 7, 7, 3, 1},
                     {8, 1, 2, 7, 9},
                    };

        Output:
        1 8 or 8 1
        8 and 1 are present in all rows.

        The time complexity of this solution is O(m * n) and we are doing only one traversal of the matrix.
        Auxiliary Space: O(N)
        Solution:

            1. We can maintain a map of map<element,rowNum>
            2. Insert all unique elements in map and mark the current row as 0.
            3. For remaining rows, check below condition, if the current element is in map and the current row against that element
               is the previous row which means that it was already present for above rows, hence we'll update the row of existing element to
               mark it's present in current row as well.
                - if (mp.containsKey(matrix[row][col]) && mp.get(matrix[row][col]) == row - 1)
            4. From the map, if the value is equal of nRows, we'll print those elements.

 */
public class CommonElementsAllRows {
    int[][] matrix;

    public CommonElementsAllRows(int[][] matrix) {
        this.matrix = matrix;
    }

    public void printCommonElementsAllRows() {
        if (matrix.length == 0) return;
        Map<Integer, Integer> mp = new HashMap<>();

        int nRows = matrix.length;
        int nCols = matrix[0].length;

        for (int col = 0; col < nCols; col++) {
            mp.put(matrix[0][col], 0);
        }

        for (int row = 1; row < nRows; row++) {
            for (int col = 0; col < nCols; col++) {
                if (mp.containsKey(matrix[row][col]) && mp.get(matrix[row][col]) == row - 1) {
                    mp.put(matrix[row][col], row);
                }
            }
        }

        // printing the common elements
        mp.forEach((k, v) -> {
            if (v == nRows - 1) {
                System.out.print(k + " ");
            }
        });
    }

    public static void main(String[] args) {
        CommonElementsAllRows commonElementsAllRows = new CommonElementsAllRows(new int[][]
                {
                        {1, 2, 1, 4, 8},
                        {3, 7, 8, 5, 1},
                        {8, 7, 7, 3, 1},
                        {8, 1, 2, 7, 9},
                });
        commonElementsAllRows.printCommonElementsAllRows();
    }
}
