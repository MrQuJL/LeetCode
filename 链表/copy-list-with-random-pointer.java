/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
/**
 * 题目名称：copy-list-with-random-pointer（复杂链表的复制，剑指offer上也有，再练一遍）
 * 题目描述：A linked list is given such that each node contains an additional random pointer 
 * which could point to any node in the list or null.
 * Return a deep copy of the list.
 */
public class Solution {
    /**
     * 思路：
     * 1.将每个节点后面增加一份原节点的拷贝
     * 2.调整新节点的 random 域
     * 3.将整个单链表进行拆分
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        // 1.将每个节点后面增加一份原节点的拷贝
        cloneNodes(head);
        // 2.调整新节点的 random 域
        connectRandomNodes(head);
        // 3.将整个单链表进行拆分
        RandomListNode ans = reconnectNodes(head);
        return ans;
    }
    
    /**
     * 将每个节点后面增加一份原节点的拷贝
     */
    public void cloneNodes(RandomListNode head) {
        while (head != null) {
            RandomListNode nextNode = new RandomListNode(head.label);
            // 单链表插入节点
            nextNode.next = head.next;
            head.next = nextNode;
            head = head.next.next;
        }
    }
    
    /**
     * 调整新节点的 random 域
     */
    public void connectRandomNodes(RandomListNode head) {
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }
    
    /**
     * 将整个单链表进行拆分，返回的是新链表的指向
     */
    public RandomListNode reconnectNodes(RandomListNode head) {
        RandomListNode pHead = head;
        RandomListNode pNode = head.next;
        RandomListNode pReturn = pNode;
        while (pNode.next != null) {
            pHead.next = pNode.next;
            pHead = pHead.next;
            pNode.next = pHead.next;
            pNode = pNode.next;
        }
        return pReturn;
    }
    
}