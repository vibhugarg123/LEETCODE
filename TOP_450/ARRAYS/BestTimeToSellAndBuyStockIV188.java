package TOP_450.ARRAYS;

/*
    Problem-188: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

    You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

    Find the maximum profit you can achieve. You may complete at most k transactions.

    Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

    Example 1:

    Input: k = 2, prices = [2,4,1]
    Output: 2
    Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
    Example 2:

    Input: k = 2, prices = [3,2,6,5,0,3]
    Output: 7
    Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
    Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.

    Solution:
    - No Stock State ---
                        1. BUY: BOUGHT STATE
                        2. SKIP: NO STOCK STATE
    - BOUGHT-------------
                        1. SELL: NO STOCK STATE
                        2. SKIP: BOUGHT STATE

    Maintain 3 states-
    1. Number of Transactions
    2. Bought or not a Stock (0/1)
    3. Day number

    OPERATIONS
    1. BUY
    2. SELL
    3. SKIP

    STATES
    1. NO STOCK STATE
    2. BOUGHT STOCK STATE

            ______________Buy_______________>>>
            |                                 |
     Skip---- A(No Stock in Hand)             B (Stock in Hand)--Skip---|
             <<<_____________Sell_____________|


      Transactions=K
        - Maximum Buy=K + Maximum Sell=K
        - Total Buy and Sell<=2K

        Time Complexity: O(N*K)
        Space Complexity: O(2*K)
 */
public class BestTimeToSellAndBuyStockIV188 {
    public int maxProfit(int k, int[] prices) {

        int[] dp = new int[2 * k];
        for (int i = 0; i < 2 * k; i++) {
            if (i % 2 == 0) {
                //EVEN: BUY
                dp[i] = Integer.MIN_VALUE;
            } else {
                //ODD: SELL
                dp[i] = 0;
            }
        }

        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (j == 0) {
                    //On 1st transaction, we can either skip or buy
                    dp[j] = Math.max(dp[j], -prices[i]);
                } else if (j % 2 == 0) {
                    //For even number transaction, we can either skip or buy.
                    //buying a stock means decrease of price[i] in profit
                    dp[j] = Math.max(dp[j], dp[j - 1] - prices[i]);
                } else {
                    //For odd number transaction, we can either skip or sell.
                    //selling a stock means addition of price[i] in profit.
                    dp[j] = Math.max(dp[j], dp[j - 1] + prices[i]);
                }
            }
        }

        return dp[2 * k - 1];
    }

    public static void main(String[] args) {
        int[] prices = {3, 2, 6, 5, 0, 3};
        System.out.println(new BestTimeToSellAndBuyStockIV188().maxProfit(2, prices));
    }
}