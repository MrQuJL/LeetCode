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
 * 题目名称：construct-binary-tree-from-inorder-and-postorder-traverse
 * 题目描述：
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note: 
 * You may assume that duplicates do not exist in the tree.
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 合法性判断
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
            return null;
        }
        return reConstructBinaryTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    /**
     * 通过中序遍历序列和后序遍历序列重构二叉树
     */
    public TreeNode reConstructBinaryTree(int[] in, int startIn, int endIn, int[] post, int startPost, int endPost) {
        if (startIn > endIn || startPost > endPost) {
            return null;
        }
        TreeNode root = new TreeNode(post[endPost]);
        for (int i = startIn; i <= endIn; i++) {
            if (post[endPost] == in[i]) {
                root.left = reConstructBinaryTree(in, startIn, i - 1, post, startPost, startPost + i - startIn - 1);
                root.right = reConstructBinaryTree(in, i + 1, endIn, post, startPost + i - startIn, endPost - 1);
            }
        }
        return root;
    }
    
}