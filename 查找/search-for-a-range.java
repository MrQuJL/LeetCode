/**
 * 题目名称：search-for-a-range
 * 题目描述：
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return[-1, -1].
 * For example,
 * Given[5, 7, 7, 8, 8, 10]and target value 8,
 * return[3, 4].
 */
public class Solution {
    /**
     * 思路：
     * 使用二分查找法分别找到第一个小于target的元素的位置和
	 * 第一个大于target的元素的位置进行插入（真正的logn解法）
     */
    public int[] searchRange(int[] A, int target) {
        if (A == null || A.length == 0) {
            return null;
        }
        int[] result = new int[2];
        result[0] = result[1] = -1;
        if (findTargetNum(A, target) >= 0) { // 存在该数
            result[0] = -(findTargetNum(A, target - 0.5) + 1);
            result[1] = -(findTargetNum(A, target + 0.5) + 1) - 1;
        }
        return result;
    }
    
    public int findTargetNum(int[] num, double target) {
        int start = 0;
        int end = num.length - 1;
        int middle = 0;
        while (start <= end) {
            middle = (start + end) / 2;
            if (num[middle] > target) {
                end = middle - 1;
            } else if (num[middle] < target) {
                start = middle + 1;
            } else {
                return middle;
            }
        }
        return -start - 1;
    }
    
    
    
}