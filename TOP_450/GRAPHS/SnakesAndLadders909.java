package TOP_450.GRAPHS;

import java.util.LinkedList;
import java.util.Queue;

/*
    Problem-909: https://leetcode.com/problems/snakes-and-ladders/description/

    Reach from start=1 to end=n*n
    Approach: Use BFS
    Time complexity: O(n*n)
    Space Complexity: O(n*n)
 */
public class SnakesAndLadders909 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int minSteps = 0;

        boolean[] visited = new boolean[n * n + 1];
        Queue<Integer> Q = new LinkedList<>();

        Q.add(1);
        visited[1] = true;

        while (!Q.isEmpty()) {
            int size = Q.size();

            for (int i = 0; i < size; i++) {
                int current = Q.poll();
                if (current == n * n) return minSteps;

                int min = current + 1;
                int max = Math.min(current + 6, n * n);

                for (int next = min; next <= max; next++) {

                    int value = findValue(board, next);
                    int dest = value != -1 ? value : next;

                    if (!visited[dest]) {
                        visited[dest] = true;
                        Q.add(dest);
                    }
                }
            }
            minSteps += 1;
        }
        return -1;
    }

    int findValue(int[][] board, int num) {
        int n = board.length;

        int r = (n - 1) - ((num - 1) / n);
        int c = (num - 1) % n;
        // Since values are in zigzag manner
        // if current row and number both are even or both are odd
        if (r % 2 == n % 2) {
            c = n - 1 - c;
        }
        return board[r][c];
    }

    public static void main(String[] args) {
        //Test-Case-1: Ans 4
        int[][] board = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}};

//        int[][] board = {
//                {-1, -1, 19, 10, -1},
//                {2, -1, -1, 6, -1},
//                {-1, 17, -1, 19, -1},
//                {25, -1, 20, -1, -1},
//                {-1, -1, -1, -1, 15}
//        };
        System.out.println(new SnakesAndLadders909().snakesAndLadders(board));
    }
}