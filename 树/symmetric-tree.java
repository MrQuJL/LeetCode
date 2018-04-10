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
 * 题目名称：symmetric-tree
 * 题目描述：Given a binary tree, check whether it is a mirror of itself
 * (ie, symmetric around its center).
 * For example, this binary tree is symmetric:
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following is not:
 *    1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 */
public class Solution {
    /**
     * 思路：
     * 判断左子树的左与右子树的右是否相等，左子树的右与右子树的左是否相等
     */
    public boolean isSymmetric(TreeNode root) {
        return (root == null) || isSymmetric(root.left, root.right);
    }
    
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) { // 两个都为空就对称
            return true;
        }
        if (left == null || right == null) { // 一个为空一个不为空就一定不对称
            return false;
        }
        if (left.val != right.val) { // 不相等就返回false
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
    
}