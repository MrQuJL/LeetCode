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
 * 题目名称：linked-list-cycle-ii
 * 题目描述：Given a linked list, return the node where the cycle begins.
 * If there is no cycle, returnnull.
 * Follow up:
 * Can you solve it without using extra space?
 */
public class Solution {
    
    /**
     * 思路：
     * 1.定义两个快慢指针，慢的一次走一步，快的一次走两步，快的能追上慢的说明有环
     * 2.在相遇时，让其中一个指针指向头结点，然后两个指针一起以同样的步频走，再次相遇的那个节点便是环的入口节点
     */
    public ListNode detectCycle(ListNode head) {
        // 定义两个快慢指针
        ListNode pSlow = head;
        ListNode pFast = head;
        while (pFast != null && pFast.next != null) {
            pSlow = pSlow.next;
            pFast = pFast.next.next;
            if (pSlow == pFast) {
                break;
            }
        }
        // 先判断链表中是否有环，没有环就直接返回
        if (pFast == null || pFast.next == null) {
            return null;
        }
        // 将pSlow指向头结点，然后两个指针一起走，相遇的节点即链表中环的入口节点
        pSlow = head;
        while (pSlow != pFast) {
            pSlow = pSlow.next;
            pFast = pFast.next;
        }
        return pFast;
    }
    
}