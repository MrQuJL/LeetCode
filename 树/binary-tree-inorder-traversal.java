import java.util.ArrayList;
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
 * 题目名称：binary-tree-inorder-traversal
 * 题目描述：就是二叉树的中序遍历（非递归）
 */
public class Solution {
    /**
     * 思路：
     * 通过一个栈来模拟递归调用
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        // 模拟实现一个栈
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode pHead = root;
        TreeNode pTemp = null;
        while (!stack.isEmpty() || pHead != null) {
            if (pHead != null) {
                stack.addFirst(pHead);
                pHead = pHead.left;
            } else {
                pTemp = stack.removeFirst();
                result.add(pTemp.val);
                pHead = pTemp.right;
            }
        }
        return result;
    }
}