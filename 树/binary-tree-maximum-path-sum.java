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
 * 题目名称：binary-tree-maximum-path-sum
 * 题目描述：Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 * For example:
 * Given the below binary tree,
 *        1
 *       / \
 *      2   3
 * Return6.（这个6其实就是所经过的节点的和）
 */
public class Solution {
    /**
     * 思路：
     * 求出左子树的最大路径和与右子树的最大路径和加上当前节点的值
     * 与当前的最大值进行比较，保留最大值
     */
    int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathDown(root);
        return maxValue;
    }
    
    // 递归求出二叉树的最大路径和
    public int maxPathDown(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 分别求出左子树的最大路径和与右子树的最大路径和
        int left = Math.max(0, maxPathDown(root.left));
        int right = Math.max(0, maxPathDown(root.right));
        // 记录当前的最大路径和
        maxValue = Math.max(maxValue, left + right + root.val);
        // 返回包含当前节点的值在内的左子树或者右子树中最大的那个路径和
        return Math.max(left, right) + root.val;
    }
    
}