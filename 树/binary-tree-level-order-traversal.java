import java.util.*;
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
 * 题目名称：binary-tree-level-order-traversal
 * 题目描述：二叉树的bfs，把每一层的节点放入一个list集合
 */
public class Solution {
    /**
     * 考点：
     * 二叉树的广度优先遍历
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        // 合法性判断
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> layerList = new ArrayList<Integer>();
        TreeNode temp = null;
        int start = 0;
        int end = 1;
        queue.addFirst(root);
        while (!queue.isEmpty()) {
            temp = queue.removeLast();
            start++;
            layerList.add(temp.val);
            if (temp.left != null) {
                queue.addFirst(temp.left);
            }
            if (temp.right != null) {
                queue.addFirst(temp.right);
            }
            if (start == end) {
                start = 0;
                end = queue.size();
                result.add(layerList);
                layerList = new ArrayList<Integer>();
            }
        }
        return result;
    }
}