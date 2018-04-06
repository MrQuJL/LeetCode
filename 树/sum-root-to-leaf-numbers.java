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
 * 题目名称：sum-root-to-leaf-numbers
 * 题目描述：
 * Given a binary tree containing digits from0-9only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path1->2->3which represents the number123.
 * Find the total sum of all root-to-leaf numbers.
 * For example,
 *     1
 *    / \
 *   2   3
 * The root-to-leaf path1->2represents the number12.
 * The root-to-leaf path1->3represents the number13.
 * Return the sum = 12 + 13 =25.
 */
public class Solution {
    /**
     * 思路：
     * 深度优先搜索，每一层都在上一层的基础上 * 10 再加上当前层的val
     */
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 0);
    }
    
    public int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum *10 + root.val; // 核心，每一层都在上一层的基础上 * 10 再加上当前层的val
        if (root.left == null && root.right == null) {
            return sum;
        }
        return dfs(root.left, sum) + dfs(root.right, sum);
    }
    
}