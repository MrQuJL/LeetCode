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
 * 题目名称：insertion-sort-list
 * 题目描述：Sort a linked list using insertion sort.
 */
public class Solution {
    /**
     * 思路：
     * 将一个节点插入到已经排好序的链表内（前插法）
     */
    public ListNode insertionSortList(ListNode head) {
        // 哑节点
        ListNode dumy = new ListNode(Integer.MIN_VALUE);
        // 记录当前的节点
        ListNode cur = head;
        // 记录新链表中的节点的位置
        ListNode pre = dumy;
        while (cur != null) {
            ListNode next = cur.next;
            // 每次都从哑节点（也就是新链表的头结点）开始
            pre = dumy;
            // 找到待插入节点再新链表中的位置
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            // 插入新节点（此处考察单链表的前插法插入节点）
            cur.next = pre.next;
            pre.next = cur;
            // 旧链表中的指针下移
            cur = next;
        }
        return dumy.next;
    }
}