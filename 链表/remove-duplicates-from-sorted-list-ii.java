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
 * 题目名称：remove-duplicates-from-sorted-list-ii
 * 题目描述：Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * For example,
 * Given1->2->3->3->4->4->5, return1->2->5.
 * Given1->1->1->2->3, return2->3.
 */
public class Solution {
    /**
     * 思路：
     * 由于只要有重复的节点就要把对应的所有节点删除（一个不留）
     * 这种情况下就有可能头结点就是重复的节点
     * 所以要创建一个dumy节点作为头节点
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        // 定义一个dumy节点指向原头结点
        ListNode dumy = new ListNode(-1);
        dumy.next = head;
        // 用于遍历
        ListNode pHead = head;
        ListNode last = dumy;
        while (pHead != null && pHead.next != null) {
            if (pHead.val == pHead.next.val) {
                int val = pHead.val;
                while (pHead != null && pHead.val == val) {
                    pHead = pHead.next;
                }
                last.next = pHead;
            } else {
                last = pHead;
                pHead = pHead.next;
            }
        }
        return dumy.next;
    }
}