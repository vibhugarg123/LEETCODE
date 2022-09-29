package TOP_450.ARRAYS;

/*
        Problem-121: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
        You are given an array prices where prices[i] is the price of a given stock on the ith day.

        You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

        Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

        Example 1:

        Input: prices = [7,1,5,3,6,4]
        Output: 5
        Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
        Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

        Suppose I sell on day 1, minimum price of stock so far=7, profit=0
        Suppose I sell on day 2, minimum price of stock so far=1, profit=0
        Suppose I sell on day 3, minimum price of stock so far=1, profit=4
        Suppose I sell on day 4, minimum price of stock so far=1, profit=2
        Suppose I sell on day 5, minimum price of stock so far=1, profit=5
        Suppose I sell on day 6, minimum price of stock so far=1, profit=3


        Example 2:

        Input: prices = [7,6,4,3,1]
        Output: 0
        Explanation: In this case, no transactions are done and the max profit = 0.

        Time Complexity: O(N)
 */
public class BestTimeToBuyAndSellStock121 {
    public int maxProfit(int[] prices) {
        int max_profit = 0;

        int possiblePurchasingPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            possiblePurchasingPrice = Math.min(possiblePurchasingPrice, price);
            //If we sell buy at minimum price so far day and sell it on current day
            int margin = price - possiblePurchasingPrice;
            if (margin > max_profit) {
                max_profit = margin;
            }
        }
        return max_profit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 6, 4, 3, 1};
        System.out.println(new BestTimeToBuyAndSellStock121().maxProfit(prices));
    }
}