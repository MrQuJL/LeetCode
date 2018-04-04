import java.util.ArrayList;

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
 * 题目名称：reorder-list
 * 题目描述：Given a singly linked list L: L 0→L 1→…→L n-1→L n,
 * reorder it to: L 0→L n →L 1→L n-1→L 2→L n-2→…
 * You must do this in-place without altering the nodes' values.
 * For example,
 * Given{1,2,3,4}, reorder it to{1,4,2,3}.
 */
public class Solution {
    /**
     * 思路：
     * 1.遍历一遍单链表将每个节点放入list集合中
     * 2.定义两个指针，一头一尾（遍历一遍单链表获取尾）
     * 3.定义一个伪头结点（trick），循环进行如下操作：
     *  (3.1) trick.next = 头
     *  (3.2)头.next = 尾
     *  (3.3)trick = 尾
     * 4.需要注意：循环结束时要把trick指向的节点的next域设为空；
     */
    public void reorderList(ListNode head) {
        // 合法性判断
        if (head == null) {
            return;
        }
        // 保存遍历后的单链表
        ArrayList<ListNode> list = new ArrayList<ListNode>();
        // 将单链表放入ArrayList
        ListNode pNode = head;
        while (pNode != null) {
            list.add(pNode);
            pNode = pNode.next;
        }
        // 定义头尾指针来进行遍历
        int pHead = 0;
        int pTail = list.size() - 1;
        // 定义一个伪头结点
        ListNode pTrick = new ListNode(-1);
        // 将指针的next指向头，将头的next指向尾，然后把指针移动到尾，头++，尾--，然后指针的next等于头...
        while (pHead <= pTail) {
            pTrick.next = list.get(pHead);
            list.get(pHead).next = list.get(pTail);
            pTrick = list.get(pTail);
            pHead++;
            pTail--;
        }
        pTrick.next = null;
        
    }
}