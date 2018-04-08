import java.util.LinkedList;
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
/**
 * 题目名称：populating-next-right-pointers-in-each-node
 * 题目描述：
 * Note:
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree
 * (ie, all leaves are at the same level, and every parent has two children).
 * For example,
 * Given the following perfect binary tree,
 *          1
 *        /  \
 *       2    3
 *      / \  / \
 *     4  5  6  7
 * After calling your function, the tree should look like:
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \  / \
 *     4->5->6->7 -> NULL
 */
public class Solution {
    /**
     * 思路：
     * 考察二叉树的广度优先搜索，搜索到每一层的时候改变next指针的指向
     */
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return ;
        }
        // 通过队列来保存搜索到的节点
        LinkedList<TreeLinkNode> layer = new LinkedList<TreeLinkNode>();
        LinkedList<TreeLinkNode> layerList = new LinkedList<TreeLinkNode>();
        TreeLinkNode temp = null;
        int start = 0;
        int end = 1;
        layer.addFirst(root);
        while (!layer.isEmpty()) {
            temp = layer.removeLast();
            start++;
            layerList.addFirst(temp);
            if (temp.left != null) {
                layer.addFirst(temp.left);
            }
            if (temp.right != null) {
                layer.addFirst(temp.right);
            }
            if (start == end) { // 已经遍历完一层
                start = 0;
                end = layer.size();
                // 改变next的指向
                changeNodesNext(layerList);
                layerList = new LinkedList<TreeLinkNode>();
            }
        }
    }
    
    // 改变栈内节点的指向
    public void changeNodesNext(LinkedList<TreeLinkNode> layerList) {
        TreeLinkNode pre = null;
        while (!layerList.isEmpty()) {
            TreeLinkNode temp = layerList.removeFirst();
            temp.next = pre;
            pre = temp;
        }
    }
    
}