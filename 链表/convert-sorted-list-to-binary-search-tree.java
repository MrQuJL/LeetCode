/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
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
 * 题目名称：convert-sorted-list-to-binary-search-tree
 * 题目描述：Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 */
public class Solution {
    /**
     * 思路：
     * 通过快慢指针查找到中间节点作为根节点，然后左右子树进行递归操作
     */
    public TreeNode sortedListToBST(ListNode head) {
        return head == null ? null : toBST(head, null);
    }
    
    public TreeNode toBST(ListNode head, ListNode tail) {
        // 递归出口
        if (head == tail) {
            return null;
        }
        ListNode pSlow = head;
        ListNode pFast = head;
        // 通过快慢指针找到中间节点
        while (pFast != tail && pFast.next != tail) {
            pSlow = pSlow.next;
            pFast = pFast.next.next;
        }
        // 创建根节点
        TreeNode root = new TreeNode(pSlow.val);
        // 递归创建左右子树
        root.left = toBST(head, pSlow);
        root.right = toBST(pSlow.next, tail);
        return root;
    }
    
}