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
public class Solution {
    /**
     * 思路：
     * 1.遍历一遍链表，得出链表长度len，n可能大于len，所以n=n%len
     * 2.将尾节点的next指向头结点，形成一个环，接着向后跑len-n步，从这里断开，返回即可
     */
    public ListNode rotateRight(ListNode head, int n) {
        // 合法性判断
        if (head == null || n == 0) {
            return head;
        }
        int len = 1;
        ListNode pHead = head;
        // 遍历一遍链表，得出链表长度len
        while (pHead.next != null) {
            len++;
            pHead = pHead.next;
        }
        n = len - n % len;
        // 首尾相连
        pHead.next = head;
        for (int i = 0; i < n; i++) {
            pHead = pHead.next;
        }
        head = pHead.next;
        pHead.next = null;
        return head;
    }
}