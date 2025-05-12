package TOP_450.BACKTRACKING;

import java.util.ArrayList;
import java.util.List;

/*  Problem: 51: https://leetcode.com/problems/n-queens/description/?source=submission-noac
    The n-queens puzzle is the problem of placing n queens on an n x n chessboard such
    that no two queens attack each other.
    Given an integer n, return all distinct solutions to the n-queens puzzle.

    Each solution contains a distinct board configuration of the n-queens' placement,
    where 'Q' and '.' both indicate a queen and an empty space, respectively.

    Input: n = 4
    Output: [[".Q..", "...Q", "Q...", "..Q."],

             ["..Q.", "Q...", "...Q", ".Q.."]]
     Algorithm: Backtracking Two Approaches:
     1. isQueenSafe- O(3n)
     2. isQueenSafe- O(1)
 */
public class NQueens51 {

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
            }
            list.add(sb.toString());
        }
        return list;
    }

    private boolean isQueenSafe(int[][] board, int i, int j, int n) {
        int copyRow = i;
        int copyCol = j;

        while (copyRow < n && copyCol >= 0) {        // top left diagonal
            if (board[copyRow][copyCol] == 1) {
                return false;
            }
            // matrix (row-based)
            copyRow++;
            copyCol--;
        }

        copyRow = i;
        copyCol = j;

        while (copyCol >= 0) {                        // negative x-axis
            if (board[copyRow][copyCol] == 1) {
                return false;
            }
            copyCol--;
        }

        copyCol = j; // row is not changed above

        while (copyRow >= 0 && copyCol >= 0) {        // bottom left diagonal
            if (board[copyRow][copyCol] == 1) {
                return false;
            }
            copyRow--;
            copyCol--;
        }

        return true;
    }

    private void recur(int[][] board, int col, int n, List<List<String>> res) {
        if (col >= n) {
            res.add(printBoard(board));
            return;
        }
        for (int row = 0; row < n; row++) {
            if (isQueenSafe(board, row, col, n)) {
                board[row][col] = 1;
                recur(board, col + 1, n, res);
                board[row][col] = 0;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        List<List<String>> res = new ArrayList<>();

        recur(board, 0, n, res);
        return res;
    }
}