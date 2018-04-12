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
 * 题目名称：binary-tree-preorder-traversal
 * 题目描述：
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * For example:
 * Given binary tree{1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * return[1,2,3].
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class Solution {
    /**
     * 思路：
     * 考察二叉树的先序非递归，用栈来模拟递归调用
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        // 合法性判断
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        // 用来记录弹栈的节点
        TreeNode pTemp = null;
        // 用来记录当前节点
        TreeNode pHead = root;
        while (!stack.isEmpty() || pHead != null) {
            if (pHead != null) {
                result.add(pHead.val);
                stack.addFirst(pHead);
                pHead = pHead.left;
            } else {
                pTemp = stack.removeFirst();
                pHead = pTemp.right;
            }
        }
        
        return result;
    }
}