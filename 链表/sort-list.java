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
 * 题目名称：sort-list
 * 题目描述：Sort a linked list in O(n log n) time using constant space complexity.
 */
public class Solution {
    /**
     * 思路：
     * 对单链表进行快速排序，对单链表排序不一定一定要修改每个节点的指向，修改节点对应的属性即可
     */
    public ListNode sortList(ListNode head) {
        quickSort(head, null);
        return head;
    }
    
    public static void quickSort(ListNode head, ListNode end) {
        if (head != end) {
            ListNode partion = partion(head);
            quickSort(head, partion);
            quickSort(partion.next, end);
        }
    }
    
    public static ListNode partion(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            if (fast.val < head.val) { // 从后往前找比slow小的
                slow = slow.next;
                swapNodeVal(slow, fast);
            }
            fast = fast.next;
        }
        swapNodeVal(slow, head);
        return slow;
    }
    
    /**
     * 交换两个节点的元素的val值
     */
    public static void swapNodeVal(ListNode pNode1, ListNode pNode2) {
        int temp = pNode1.val;
        pNode1.val = pNode2.val;
        pNode2.val = temp;
    }
    
}