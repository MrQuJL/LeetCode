
/**
 * 题目名称：merge-sorted-array
 * 题目描述：
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Note: 
 * You may assume that A has enough space to hold additional elements from B.
 * The number of elements initialized in A and B are m and n respectively.
 */
public class Solution {
    /**
     * 思路：
     * 从后往前插入，时间复杂度O(m+n)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, index = m + n - 1;
        while (i >= 0 && j >= 0)
            nums1[index--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        // tips：这里如果A数组中的元素剩下了就不需要移动了，因为A数组中的元素已经在它排好序后的位置上了
        while (j >= 0)
            nums1[index--] = nums2[j--];
    }
}