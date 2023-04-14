package org.example.删除链表的倒数第N个结点leetcode19;

public class Solution {
    /**
     * @Author: zc
     * @Description:给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     *
     * 进阶：你能尝试使用一趟扫描实现吗？
     *输入：head = [1,2,3,4,5], n = 2 输出：[1,2,3,5] 示例 2：
     *
     * 输入：head = [1], n = 1 输出：[] 示例 3：
     *
     * 输入：head = [1,2], n = 1 输出：[1]
     */
    //快慢指针的思路
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        ListNode fast;
        ListNode slow;
        dummy.next = head;
        fast = dummy;
        slow = dummy;
        for(int i = 0; i < n ; i++){
            fast = fast.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
