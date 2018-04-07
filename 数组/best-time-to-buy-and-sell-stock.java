/**
 * 题目名称：best-time-to-buy-and-sell-stock
 * 题目描述：Say you have an array for which the i th element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction
 * (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * 题意：做一次买入卖出的最大收益
 */
public class Solution {
    /**
     * 思路：
     * 扫描一次找出最小值和最大值的差值
     */
    public int maxProfit(int[] prices) {
        // 合法性判断
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // 记录最小值
        int low = prices[0]; // 记录最小的进价
        int ans = 0; // 记录最大收益
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < low) { // 找出一个最小的进价
                low = prices[i];
            } else if (prices[i] - low > ans) { // 找出最大的收益
                ans = prices[i] - low;
            }
        }
        return ans;
    }
}