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
 * 题目名称：construct-binary-tree-from-preorder-and-inorder-traverse
 * 题目描述：
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note: 
 * You may assume that duplicates do not exist in the tree.
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 合法性判断
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        return reConstructBinaryTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    /**
     * 重构二叉树
     */
    public TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        // 递归出口
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        // 新建根节点
        TreeNode root = new TreeNode(pre[startPre]);
        // 在中序遍历序列中查找根节点的位置
        for (int i = startIn; i <= endIn; i++) {
            if (pre[startPre] == in[i]) {
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
                break;
            }
        }
        return root;
    }
    
}