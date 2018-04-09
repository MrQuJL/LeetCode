import java.util.LinkedList;
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
 * 题目名称：validate-binary-search-tree
 * 题目描述：Given a binary tree, determine if it is a valid binary search tree (BST).
 */
public class Solution {
    /**
     * 思路：
     * 考察二叉树与的中序遍历序列
     */
    public boolean isValidBST(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode currNode = root;
        TreeNode preNode = null;
        while (!stack.isEmpty() || currNode != null) {
            if (currNode != null) { // 当前节点不为空
                stack.addFirst(currNode);
                currNode = currNode.left;
            } else { // 栈中有元素
                currNode = stack.removeFirst();
                if (preNode != null && preNode.val >= currNode.val) {
                    return false;
                }
                preNode = currNode;
                currNode = currNode.right;
            }
        }
        return true;
    }
    
}