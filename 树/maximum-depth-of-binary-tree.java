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
 * 题目名称：maximum-depth-of-binary-tree
 * 题目描述：Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from 
 * the root node down to the farthest leaf node.
 */
public class Solution {
    /**
     * 思:1：
     * 深度优先搜索（递归）
     * 运行时间：90~109ms
     * 占用内存：12000k左右
     */
    public int maxDepth(TreeNode root) {
        if (root != null) {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
        return 0;
    }
    
    /**
     * 思路2：
     * 通过队列来实现非递归的广度优先搜索
     * 运行时间：80~89ms
     * 占用内存：12000k左右
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode pHead = null;
        queue.addFirst(root);
        int start = 0;
        int end = 1;
        int layer = 0;
        while (!queue.isEmpty()) {
            pHead = queue.removeLast();
            start++;
            if (pHead.left != null) {
                queue.addFirst(pHead.left);
            }
            if (pHead.right != null) {
                queue.addFirst(pHead.right);
            }
            if (start == end) {
                layer++;
                start = 0;
                end = queue.size();
            }
        }
        return layer;
    }
    
}