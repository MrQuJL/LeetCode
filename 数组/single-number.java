/**
 * 题目名称：single-number
 * 题目描述：Given an array of integers, every element appears twice except for one.
 * Find that single one.
 * Note: 
 * Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 */
public class Solution {
    /**
     * 思路：
     * 一个数异或同一个数字两次结果还是原来的数，把数组从头到尾异或一遍
     */
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int target = A[0];
        for (int i = 1; i < A.length; i++) {
            target = target ^ A[i];
        }
        return target;
    }
}