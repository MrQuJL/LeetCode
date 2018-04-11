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
 * 题目名称：merge-two-sorted-lists
 * 题目描述：
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class Solution {
    /**
     * 思路：
     * 同时遍历两个链表将value小的节点放入新的节点中
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 合法性判断
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode pNew = new ListNode(-1);
        ListNode pReturn = pNew;
        // 用于遍历两个排序的链表
        ListNode pFirst = l1;
        ListNode pSecond = l2;
        while (pFirst != null && pSecond != null) {
            if (pFirst.val < pSecond.val) {
                pNew.next = pFirst;
                pFirst = pFirst.next;
            } else {
                pNew.next = pSecond;
                pSecond = pSecond.next;
            }
            pNew = pNew.next;
        }
        if (pFirst != null) {
            pNew.next = pFirst;
        }
        if (pSecond != null) {
            pNew.next = pSecond;
        }
        return pReturn.next;
    }
}