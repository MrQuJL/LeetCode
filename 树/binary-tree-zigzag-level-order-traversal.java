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
 * 题目名称：binary-tree-zigzag-level-order-traversal
 * 题目描述：就是按照之字形顺序打印二叉树，剑指offer上也有这道题
 */
public class Solution {
    /**
     * 思路：
     * 广度优先搜索，通过队列保存遍历到的每一个节点
     * 记录层数，奇数层从左向右，偶数层从右向左
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
       ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> layer = new LinkedList<TreeNode>();
        LinkedList<Integer> layerList = new LinkedList<Integer>();
        TreeNode pHead = null;
        // start和end记录每一层的节点数
        int start = 0;
        int end = 1;
        // layer记录当前是第几层
        int lay = 0;
        layer.addFirst(root);
        while (!layer.isEmpty()) {
            pHead = layer.removeLast();
            start++;
            if ((lay & 0x1) == 1) { // 偶数层从右向左
                layerList.addFirst(pHead.val);
            } else { // 奇数层从左向右
                layerList.addLast(pHead.val);
            }
            if (pHead.left != null) {
                layer.addFirst(pHead.left);
            }
            if (pHead.right != null) {
                layer.addFirst(pHead.right);
            }
            // 本层节点已经遍历完毕
            if (start == end) {
                lay++;
                start = 0;
                end = layer.size();
                ArrayList<Integer> list = new ArrayList<Integer>(layerList);
                result.add(list);
                // 这里一定要重新new一个LinkedList，否则之后修改的就是原来的LinkedList的内容
                layerList = new LinkedList<Integer>();
            }
        }
        return result;
    }
}