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
 * 题目名称：same-tree
 * 题目描述：Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical
 * and the nodes have the same value.
 */
public class Solution {
    /**
     * 思路：
     * 同时递归判断两颗二叉树的左子树是否相同，右子树是否相同
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}