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
 * 题目名称：remove-duplicates-from-sorted-list
 * 题目描述：Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given1->1->2, return1->2.
 * Given1->1->2->3->3, return1->2->3.
 */
public class Solution {
    /**
     * 思路：
     * 遍历单链表，每遍历到一个节点的时候判断后面的节点是否和它相等，找到第一个不相等的节点
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pHead = head;
        ListNode pre = head;
        while (head != null) {
            head = head.next;
            while (head != null && head.val == pre.val) { // 继续向后搜索是否有与当前节点相同的节点
                head = head.next;
            }
            pre.next = head;
            pre = head;
        }
        return pHead;
    }
}