package BACKTRACKING;

/*
[Problem-79]
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are
horizontally or vertically neighboring. The same letter cell may not be used more than once.

Input: board = [["A","B","C","E"],
                ["S","F","C","S"],
                ["A","D","E","E"]]

       word = "ABCCED"
Output: true

Input: board = [["A","B","C","E"],
                ["S","F","C","S"],
                ["A","D","E","E"]],

       word = "SEE"
Output: true
 */

class WordSearch79 {

    int[] rows_indexes = {0, -1, 0, 1};
    int[] cols_indexes = {-1, 0, 1, 0};
    boolean[][] visited;

    public boolean isValidCell(int i, int j, int rows, int columns) {
        return (i >= 0 && i < rows && j >= 0 && j < columns);
    }

    public boolean existUtils(int i, int j, int index, String word, char[][] board, int rows, int cols) {
        if (index == word.length()) {
            return true;
        }
        if (!isValidCell(i, j, rows, cols) || visited[i][j] || word.charAt(index) != board[i][j]) {
            return false;
        }

        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            if (existUtils(i + rows_indexes[k], j + cols_indexes[k], index + 1, word, board, rows, cols)) {
                return true;
            }
        }

        visited[i][j] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (word.charAt(0) == board[i][j] && existUtils(i, j, 0, word, board, rows, cols)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordSearch79 wordSearch79 = new WordSearch79();

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},
        };

        String word = "ABCB";
        System.out.println(wordSearch79.exist(board, word));
    }
}