/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/**
 * 题目名称：partition-list
 * 题目描述：Given a linked list and a value x, partition it such that all nodes less than x 
 * come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * For example,
 * Given1->4->3->2->5->2and x = 3,
 * return1->2->2->3->4->5.
 */
public class Solution {
    /**
     * 思路：
     * 定义两个链表一个用来保存比x小的，一个用来保存大于等于x的（注：对于大的那部分的尾节点的next要置空，否则会死循环）
     * 时间复杂度：O(n)
     * 空间复杂度：o(1)
     */
    public ListNode partition(ListNode head, int x) {
        // 合法性判断
        if (head == null) {
            return null;
        }
        // 1.建立两个链表来保存比x小的以及大于等于x的
        ListNode pSmall = new ListNode(-1);
        ListNode pBig = new ListNode(-1);
        ListNode pReturn = pSmall;
        ListNode pBigTemp = pBig;
        // 2.遍历链表将比x小的放到pSmall，比大于等于x的放到pBig里
        while (head != null) {
            if (head.val < x) {
                pSmall.next = head;
                pSmall = pSmall.next;
            } else {
                pBig.next = head;
                pBig = pBig.next;
            }
            head = head.next;
        }
        pSmall.next = pBigTemp.next;
        pBig.next = null; // 很关键的一句，需要把大于等于x的那部分节点的尾节点置空
        return pReturn.next;
    }
}