package org.example.移除链表元素.leetcode203移除链表元素;

public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val==val){
            head = head.next;
        }
        ListNode cur = head;
        while(cur!=null){
            while (cur.next!=null && cur.next.val==val){
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;

    }
}
