package TOP_450.ARRAYS;

/*
    Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
    You are given an array prices where prices[i] is the price of a given stock on the ith day.
    Find the maximum profit you can achieve. You may complete at most two transactions.

    Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

    Example 1:

    Input: prices = [3,3,5,0,0,3,1,4]
    Output: 6
    Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
    Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
    Example 2:

    Input: prices = [1,2,3,4,5]
    Output: 4
    Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
    Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
    Example 3:

    Input: prices = [7,6,4,3,1]
    Output: 0
    Explanation: In this case, no transaction is done, i.e. max profit = 0.

    Solution:
    - 1 Transaction means 1 buy followed by sell.
    - Max profit with at most two transactions =
                    MAX {max profit with one transaction and subarray price[0..j-1] +
                        max profit with one transaction and subarray price[j..n-1] }
                j varies from 0 to n-1.

                1. Preprocess left profit in an array:
                    Keep tracking of minimum seen so far in LMin.
                    profit if we sell at ith day= current_price - LMin

                    leftProfit[i] = Math.max(leftProfit[i - 1], prices[i] - LMin);

                2. Preprocess right profit in an array:
                    Keep tracking of maximum seen so far in RMax.
                    profit if we buy at jth day= RMax - current_price

                3. Assuming maxProfit=rightProfit[0]
                   Keep tracking rightProfit array from j=1 to j=length-1
                   If we assume j is the point, left side of j brings 1 transaction & right side of j gives one transaction

                     maxProfit = Math.max(maxProfit, leftProfit[j - 1] + rightProfit[j]);

                     Time Complexity:  O(N)
                     Space Complexity: O(N)
 */
public class BestTimeToBuyAndSellStockIII123 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int LMin = prices[0];
        int[] leftProfit = new int[prices.length];
        leftProfit[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            LMin = Math.min(LMin, prices[i]);
            leftProfit[i] = Math.max(leftProfit[i - 1], prices[i] - LMin);
        }

        int RMax = prices[prices.length - 1];
        int[] rightProfit = new int[prices.length];
        prices[prices.length - 1] = 0;
        for (int j = prices.length - 2; j >= 0; j--) {
            RMax = Math.max(RMax, prices[j]);
            rightProfit[j] = Math.max(rightProfit[j + 1], RMax - prices[j]);
        }

        int maxProfit = rightProfit[0];
        for (int j = 1; j < prices.length; j++) {
            maxProfit = Math.max(maxProfit, leftProfit[j - 1] + rightProfit[j]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        BestTimeToBuyAndSellStockIII123 bestTimeToSellAndBuyStockIII123 = new BestTimeToBuyAndSellStockIII123();
        System.out.println(bestTimeToSellAndBuyStockIII123.maxProfit(prices));
    }
}