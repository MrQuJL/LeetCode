/**
 * 题目名称：best-time-to-buy-and-sell-stock-ii
 * 题目描述：
 * Say you have an array for which the i th element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times).
 * However, you may not engage in multiple transactions at the same time
 * (ie, you must sell the stock before you buy again).
 * 题意：可以不断买入卖出的最大收益
 */
public class Solution {
    /**
     * 思路：
     * 按理说找出每一段上升序列的头尾差，但是发现头尾差其实就是相邻两个数字的差（保证后一个比前一个大）
     */
    public int maxProfit(int[] prices) {
        // 合法性判断
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int ans = 0;
        // 循环求出后一个数比当前数的差值（保证后一个比前一个大）
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                ans += prices[i + 1] - prices[i];
            }
        }
        return ans;
    }
}