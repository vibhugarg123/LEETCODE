package TOP_450.BACKTRACKING;

/*
        Problem- 490: https://leetcode.com/problems/the-maze/description/
        There is a ball in a maze with empty spaces (represented as 0) and walls (represented as 1).
        The ball can go through the empty spaces by rolling up, down, left or right,
        but it won't stop rolling until hitting a wall.
        When the ball stops, it could choose the next direction.
        Given the m x n maze, the ball's start position and the destination,
        return true if the ball can stop at the destination, otherwise return false.



 */
public class TheMaze490 {
    private static final int[] xDir = {0, 0, 1, -1};
    private static final int[] yDir = {-1, 1, 0, 0};

    private boolean isValidPoint(int x, int y, int nRows, int nCols, int[][] maze) {
        // point is inside boundary of matrix and point does not have wall
        return x >= 0 && x < nRows && y >= 0 && y < nCols && maze[x][y] == 0;
    }

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int nRows = maze.length;
        int nCols = maze[0].length;
        boolean[][] visited = new boolean[nRows][nCols];

        return dfsUtils(maze, start, destination, nRows, nCols, visited);
    }

    private boolean dfsUtils(int[][] maze, int[] start, int[] destination,
                             int nRows, int nCols, boolean[][] visited) {
        // start is already visited.
        if (visited[start[0]][start[1]]) return false;

        // if start is same as destination, we have found a path
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }

        // mark current node as visited
        visited[start[0]][start[1]] = true;
        for (int i = 0; i < 4; i++) {
            int x = start[0];
            int y = start[1];
            while (isValidPoint(x, y, nRows, nCols, maze)) {
                x = x + xDir[i];
                y = y + yDir[i];
            }
            // (x,y) is the wall point till ball can roll, now we want to go to a previous
            // valid point from where can again start dfs. Previous point is { x- xDir[i], y - yDir[i]};
            // Revert the last move to get the cell to which the ball rolls.
            if (dfsUtils(maze, new int[]{x - xDir[i], y - yDir[i]}, destination, nRows, nCols, visited))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] maze = {new int[]{0, 0, 1, 0, 0}, new int[]{0, 0, 0, 0, 0}, new int[]{0, 0, 0, 1, 0}, new int[]{1, 1, 0, 1, 1}, new int[]{0, 0, 0, 0, 0}};
        int[] start = {0, 4};
        int[] destination = {3, 2};
        TheMaze490 theMaze490 = new TheMaze490();
        System.out.println(theMaze490.hasPath(maze, start, destination));
    }
}
