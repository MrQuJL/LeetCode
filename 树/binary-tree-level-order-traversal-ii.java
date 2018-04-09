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
 * 题目名称：binary-tree-level-order-traversal-ii
 * 题目描述：
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 * For example:
 * Given binary tree{3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7]
 *   [9,20],
 *   [3],
 * ]
 */
public class Solution {
    /**
     * 思路：
     * 考察二叉树的层次遍历，通过LinkedList后插法创建list
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        LinkedList<ArrayList<Integer>> tempResult = new LinkedList<ArrayList<Integer>>();
        // 合法性判断
        if (root == null) {
            return result;
        }
        // 保存所有节点的一个队列
        LinkedList<TreeNode> layer = new LinkedList<TreeNode>();
        // 用来保存每一层的节点
        ArrayList<Integer> layerList = new ArrayList<Integer>();
        TreeNode temp = null;
        // 记录每一层的节点数
        int start = 0;
        int end = 1;
        layer.addFirst(root);
        while (!layer.isEmpty()) {
            start++;
            temp = layer.removeLast();
            layerList.add(temp.val);
            if (temp.left != null) {
                layer.addFirst(temp.left);
            }
            if (temp.right != null) {
                layer.addFirst(temp.right);
            }
            if (start == end) {
                start = 0;
                end = layer.size();
                // 后插法先放入LinkedList，再拷贝到原来的list中
                tempResult.addFirst(layerList);
                layerList = new ArrayList<Integer>();
            }
        }
        while (!tempResult.isEmpty()) {
            result.add(tempResult.removeFirst());
        }
        return result;
    }
}