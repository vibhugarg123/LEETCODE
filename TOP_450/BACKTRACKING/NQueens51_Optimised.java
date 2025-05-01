package TOP_450.BACKTRACKING;

import java.util.ArrayList;
import java.util.List;

/*
    Problem: 51 (Optimised): https://leetcode.com/problems/n-queens/description/?source=submission-noac
    The n-queens puzzle is the problem of placing n queens on an n x n chessboard such
    that no two queens attack each other.
    Given an integer n, return all distinct solutions to the n-queens puzzle.
    You may return the answer in any order.

    Each solution contains a distinct board configuration of the n-queens' placement,
    where 'Q' and '.' both indicate a queen and an empty space, respectively.

    Input: n = 4
    Output: [[".Q..",
              "...Q",
             "Q...",
             "..Q."],

             ["..Q.",
             "Q...",
             "...Q",
             ".Q.."]]

     Algorithm: Backtracking Two Approaches:
     1. isQueenSafe- O(3n)
     2. isQueenSafe- O(1)
 */
public class NQueens51_Optimised {

    private List<String> printBoard(int[][] board) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
            list.add(sb.toString());
        }
        System.out.println();
        return list;
    }

    private void recurOptimised(int[][] board, int col, int n, List<List<String>> res,
                                int[] upperDiagonal, int[] left, int[] bottomDiagonal) {
        if (col >= n) {
            res.add(printBoard(board));
            return;
        }
        for (int row = 0; row < n; row++) {
            if (upperDiagonal[row + col] == 0 &&
                    left[row] == 0 &&
                    bottomDiagonal[(n - 1) + (col - row)] == 0) {

                board[row][col] = 1;
                upperDiagonal[row + col] = 1;
                left[row] = 1;
                bottomDiagonal[(n - 1) + (col - row)] = 1;

                //backtrack
                recurOptimised(board, col + 1, n, res, upperDiagonal, left, bottomDiagonal);

                //reset indexes
                board[row][col] = 0;
                upperDiagonal[row + col] = 0;
                left[row] = 0;
                bottomDiagonal[(n - 1) + (col - row)] = 0;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        List<List<String>> res = new ArrayList<>();

        recurOptimised(board, 0, n, res, new int[2 * n - 1], new int[n], new int[2 * n - 1]);
        return res;
    }

    public static void main(String[] args) {
        NQueens51_Optimised nQueens51 = new NQueens51_Optimised();
        List<List<String>> result = nQueens51.solveNQueens(4);
    }
}
