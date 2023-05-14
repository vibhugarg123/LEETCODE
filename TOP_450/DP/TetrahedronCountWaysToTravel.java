package TOP_450.DP;

/*
    Problem[GFG]- https://practice.geeksforgeeks.org/problems/aa0000a5f710ce8d41366b714341eef644ec7b82/1?
    Given a triangular pyramid with its vertices marked as O, A, B and C and a number N, the task is to find the number of ways such that a
    person starting from the origin O initially, reaches back to the origin in N steps. In a single step,
    a person can go to any of its adjacent vertices.

    Time Complexity: O(steps*3)  ~ O(steps)
    Space Complexity: O(steps*3) ~ O(steps)
 */
public class TetrahedronCountWaysToTravel {
    static int mod = 1000000007;

    public int countPaths(int steps) {
        int[][] dp = new int[4][steps + 1];
        dp[0][0] = 1;
        for (int step = 1; step <= steps; step++) {
            for (int state = 0; state <= 3; state++) {
                dp[state][step] = (dp[state][step] + (dp[(state + 1) % 4][step - 1])) % mod;
                dp[state][step] = (dp[state][step] + (dp[(state + 2) % 4][step - 1])) % mod;
                dp[state][step] = (dp[state][step] + (dp[(state + 3) % 4][step - 1])) % mod;
            }
        }
        return dp[0][steps];
    }

    public static void main(String[] args) {
        System.out.println(new TetrahedronCountWaysToTravel().countPaths(3));
    }
}