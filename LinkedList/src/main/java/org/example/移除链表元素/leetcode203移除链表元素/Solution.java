package org.example.移除链表元素.leetcode203移除链表元素;

/**
 * @Author: zc
 * @Description: 题意：删除链表中等于给定值 val 的所有节点。
 *
 * 示例 1： 输入：head = [1,2,6,3,4,5,6], val = 6 输出：[1,2,3,4,5]
 *
 * 示例 2： 输入：head = [], val = 1 输出：[]
 *
 * 示例 3： 输入：head = [7,7,7,7], val = 7 输出：[]
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }
        //因为删除可能涉及到头节点，所以设置dummy节点，统一操作
        ListNode dummyhead = new ListNode(-1, head);
        ListNode prev = dummyhead;
        ListNode cur = head;
        while(cur != null){
            if(cur.val == val){
                prev.next = cur.next;
            }else {
                prev = cur;
            }
            cur = cur.next;
        }
        return dummyhead.next;
    }
}
