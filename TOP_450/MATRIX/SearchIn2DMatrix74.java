package TOP_450.MATRIX;

/*
[Problem-74]
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.


Example 1:


Input: matrix = [   [1,3,5,7],
                    [10,11,16,20],
                    [23,30,34,60]
                ], target = 3
Output: true


Observation: Since all rows are sorted and last element of each row is <= first element of next row.
Hence, complete matrix is sorted.
Apply binary search over the full matrix i.e first element=matrix[0][0] , last element=matrix[matrix.length-1][matrix[0].length-1]
For eg : In linear order, middle element is 11/2=5.
            nCols=4
            to find row and column index of 11-
                row(middle)=5/4=1
                col(middle)=5%4=1
                [1,1]= 11 element

Assuming number of rows=m, columns=n
Number of elements=m*n
Time Complexity: O(log(mn))
 */

class SearchIn2DMatrix74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int nRows = matrix.length;
        int nColumns = matrix[0].length;
        int start = 0, end = (nRows * nColumns) - 1;

        while (start <= end) {
            int middle = start + (end - start) / 2;

            int row = middle / nColumns;
            int column = middle % nColumns;
            int currentElement = matrix[row][column];

            if (target == currentElement) {
                return true;
            } else if (target > matrix[row][column]) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60},
        };
        SearchIn2DMatrix74 searchIn2DMatrix74 = new SearchIn2DMatrix74();
        System.out.println(searchIn2DMatrix74.searchMatrix(matrix, 100));
    }
}