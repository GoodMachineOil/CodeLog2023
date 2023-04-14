package org.example.反转链表leetode206.递归解法;

public class Solution {
    public ListNode reverseList(ListNode head) {
        return reverse(null,head);
    }
    private ListNode reverse(ListNode pre, ListNode cur){
        if(cur == null)
            return pre;
        ListNode temp = cur.next;
        cur.next = pre;
        //更新位置
        //pre = cur;
        //cur = temp;
        return reverse(cur,temp);
    }
}
