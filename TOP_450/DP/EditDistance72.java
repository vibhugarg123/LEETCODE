package TOP_450.DP;

public class EditDistance72 {

    private int findMinimum(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public int minDistance(String word1, String word2) {

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int col = 0; col <= word2.length(); col++) {
            dp[0][col] = col;
        }
        for (int row = 0; row <= word1.length(); row++) {
            dp[row][0] = row;
        }
        for (int row = 1; row <= word1.length(); row++) {
            for (int col = 1; col <= word2.length(); col++) {
                if (word1.charAt(row - 1) == word2.charAt(col - 1)) {
                    dp[row][col] = dp[row - 1][col - 1];
                } else {
                    dp[row][col] = 1 + findMinimum(dp[row][col - 1], dp[row - 1][col], dp[row - 1][col - 1]);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        System.out.println(new EditDistance72().minDistance("horse", "ros"));
    }

}