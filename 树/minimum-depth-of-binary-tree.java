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
 * 题目名称：minimum-depth-of-binary-tree
 * 题目描述：Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path
 * from the root node down to the nearest leaf node.
 */
public class Solution {

    /**
     * 思路1：
     * 深度优先搜索（DFS）
     * 二叉树的最小深度为左右子树最矮的那一颗加1
     */
    public int run(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 递归求左子树
        int left = run(root.left);
        // 递归求右子树
        int right = run(root.right);
        // （关键）如果左右子树中有一颗深度为0，那这颗二叉树的深度就是另一颗的深度+1
        if (left == 0 || right == 0) {
            return left + right + 1;
        }
        return left < right ? left + 1 : right + 1;
    }
    
    /**
     * 思路2：
     * 广度优先遍历（BFS）
     * 找到第一个叶子结点就可以停止遍历
     * 效率高
     */
    public int run1(TreeNode root) {
        // 合法性判断
        if (root == null) {
            return 0;
        }
        // 模拟一个队列
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addFirst(root);
        // 记录每一层有多少个节点（end - start）
        int start = 0;
        int end = 1;
        // 当前的层数
        int level = 1;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.removeLast();
            start++;
            if (temp.left == null && temp.right == null) {
                return level;
            }
            if (temp.left != null) {
                queue.addFirst(temp.left);
            }
            if (temp.right != null) {
                queue.addFirst(temp.right);
            }
            // start == end 说明这一层已经遍历完毕
            if (start == end) {
                // 层数+1
                level++;
                // 重置start和end的值
                start = 0;
                end = queue.size();
            }
        }
        return level;
    }
}