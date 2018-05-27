import java.util.*;
/**
 * 题目名称：candy
 * 题目描述：There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 */
public class Solution {
    /**
     * 思路：
     * 动态规划，状态转移方程：
     * candies[i] = max{candies[i-1], candies[i+1]} + 1
     */
    public int candy(int[] ratings) {
        int sum = 0;
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        //从左向右使得当ratings[i] > ratings[i-1]时，candies[i] > candies[i-1]
        for (int i = 1; i < candies.length; i++) {
            if (ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
                candies[i] = Math.max(candies[i], candies[i - 1]) + 1;
            }
        }
        sum += candies[candies.length - 1];
		//从右向左扫描，使得ratings[i] > ratings[i+1]时，candies[i] > candies[i+1]
        for (int i = candies.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1]) + 1;
            }
            sum += candies[i];
        }
        return sum;
    }
}