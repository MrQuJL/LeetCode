/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/**
 * 题目名称：linked-list-cycle
 * 题目描述：Given a linked list, determine if it has a cycle in it.
 * Follow up:
 * Can you solve it without using extra space?
 */
public class Solution {
    /**
     * 思路：
     * 定义两个快慢指针，一个走一步，一个走两步，走的快的能追上走的慢的说明有环
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode pSlow = head;
        ListNode pFast = head;
        while (pFast != null && pFast.next != null) {
            pSlow = pSlow.next;
            pFast = pFast.next.next;
            if (pSlow == pFast) {
                return true;
            }
        }
        return false;
    }
}