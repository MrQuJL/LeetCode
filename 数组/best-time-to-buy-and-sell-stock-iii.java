/**
 * 题目名称：best-time-to-buy-and-sell-stock-iii
 * 题目描述：Say you have an array for which the i th element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * Note: 
 * You may not engage in multiple transactions at the same time
 * (ie, you must sell the stock before you buy again).
 * 题目大意：数组下标为i的元素存储股票第i天的价格，只进行两次买入卖出的最大收益
 * 注：在买入第二只股票的时候必须卖出第一支股票
 */
public class Solution {
    /**
     * 思路：
     * 统计每次买或者卖之后拥有的钱数
     */
    public int maxProfit(int[] prices) {
        // 合法性判断
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int buy1 = Integer.MIN_VALUE;
        int sell1 = 0;
        int buy2 = Integer.MIN_VALUE;
        int sell2 = 0;
        for (int i = 0; i < prices.length; i++) {
            // 1.获得第一次买入的最少价格
            buy1 = Math.max(buy1, -prices[i]);
            // 2.获得第一卖出的最大收益 = 当前价格 - 买入价格，因为buy1是负数，所以直接相加
            sell1 = Math.max(sell1, prices[i] + buy1);
            // 3.获得第二次买入的最少价格，经过第一次的买入卖出已经有了一定的收益，所以使当前手中流失的钱最少即可
            // 也就是手中的拥有的钱最大
            buy2 = Math.max(buy2, sell1 - prices[i]);
            // 4.第二次卖出的钱最多 = 已经持有的收益 + 卖出去的价格
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}