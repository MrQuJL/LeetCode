/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * 题目名称：convert-sorted-array-to-binary-search-tree
 * 题目描述：Given an array where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 */
public class Solution {
    /**
     * 思路：
     * 每次找到数组的中间元素创建根节点，递归的操作左右子树
     */
    public TreeNode sortedArrayToBST(int[] num) {
        // 合法性判断
        if (num == null || num.length == 0) {
            return null;
        }
        TreeNode root = buildBST(num, 0, num.length);
        return root;
    }
    
    /**
     * 创建数组当前范围内的中间元素的节点
     */
    public TreeNode buildBST(int[] num, int start, int end) {
        // 合法性判断
        if (start >= end) {
            return null;
        }
        int middle = (start + end) / 2;
        TreeNode root = new TreeNode(num[middle]);
        root.left = buildBST(num, start, middle);
        root.right = buildBST(num, middle + 1, end);
        return root;
    }
    
}