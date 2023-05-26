package TOP_450.BIT_MANIPULATION;

/*
    Problem: 338- Given an integer n, return an array, ans of length n + 1 such that for each i (0 <= i <= n),
     ans[i] is the number of 1's in the binary representation of i.

    Example 1:

    Input: n = 2
    Output: [0,1,1]

    Explanation:
    0 --> 0
    1 --> 1
    2 --> 10
    Example 2:

    Input: n = 5
    Output: [0,1,1,2,1,2]

    Explanation:
    0 --> 0
    1 --> 1
    2 --> 10
    3 --> 11
    4 --> 100
    5 --> 101
 */
public class CountingBits338 {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];

        // set bits in case of 0 are 0
        res[0] = 0;
        for (int i = 1; i <= n; i++) {
            // In case the num is even, set bits are equal to set bits in number/2
            if (i % 2 == 0) {
                res[i] = res[i / 2];
            } else {
                // In case the num is odd, set bits are equal to set bits in number/2 +1
                res[i] = res[i / 2] + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] ans = new CountingBits338().countBits(n);
        for (int i = 0; i <= n; i++) {
            System.out.println("set bits in num " + i + " are " + ans[i]);
        }
    }
}