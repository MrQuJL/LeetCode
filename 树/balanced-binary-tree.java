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
 * 题目名称：balanced-binary-tree
 * 题目描述：Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class Solution {
    /**
     * 思路：
     * 在计算这颗二叉树的深度的时候一并判断出这颗二叉树是否平衡
     */
    public boolean balancedFlag = true;
    
    public boolean isBalanced(TreeNode root) {
        getTreeDepth(root);
        return balancedFlag;
    }
    
    /**
     * 获取二叉树的高度
     */
    public int getTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getTreeDepth(root.left);
        int right = getTreeDepth(root.right);
        if (Math.abs(left - right) > 1) {
            balancedFlag = false;
        }
        return Math.max(left, right) + 1;
    }
    
}