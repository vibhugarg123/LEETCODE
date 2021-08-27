package DP;
/*
[Problem-64]
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example 1:


Input: grid = [[1,3,1],
               [1,5,1],
               [4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
Example 2:

Input: grid = [[1,2,3],
               [4,5,6]]
Output: 12


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 100

From a particular cell, we can move either right or down.
i.e if we are at cell [i,j], probably we have come either from a[i-1][j] (up) or a[i][j-1] (left)
a[i][j]=c[i][j]+min(a[i][j-1],a[i-1][j]), left, up

so, grid[i][j] maintains minimum sum from grid[0][0] to grid[i][j]
grid[i][j]=grid[i][j]+ min(left,up)
grid[i][j]=grid[i][j]+ min(left,up)

grid[i][j]=grid[i][j]+min(a[i-1][j] (up), a[i][j-1] (left))

Time Complexity: O(N*M) if N=number of rows & M = number of columns.
Space Complexity: O(1)
 */

class MinimumPathSum64 {
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int left = (j - 1 >= 0) ? grid[i][j - 1] : Integer.MAX_VALUE;
                int up = (i - 1 >= 0) ? grid[i - 1][j] : Integer.MAX_VALUE;
                if (left == Integer.MAX_VALUE && up == Integer.MAX_VALUE) {
                    left = up = 0;
                }
                grid[i][j] = grid[i][j] + Math.min(left, up);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        MinimumPathSum64 minimumPathSum64 = new MinimumPathSum64();
        System.out.println(minimumPathSum64.minPathSum(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        }));
    }
}