package org.example.两两交换链表中的节点.虚结点;
/**
 * @Author: zc
 * @Description: 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1); //设置一个虚拟头结点
        dummy.next = head; //将虚拟头结点指向head，方便后面做删除操作
        ListNode cur = dummy; //定义一个移动的临时指针
        ListNode firstNode; //临时结点，保存两个结点中的第一个结点
        ListNode secondNode; //临时结点，保存两个结点中的第二个结点
        ListNode temp; // 临时结点，保存两个结点后面的结点
        while(cur.next != null && cur.next.next != null){
            temp = cur.next.next.next;
            firstNode = cur.next;
            secondNode = cur.next.next;
            cur.next = secondNode;  //步骤1
            secondNode.next = firstNode; //步骤2
            firstNode.next = temp; // 步骤三
            cur = firstNode; // 移动cur，准备下一轮交换
        }
        return dummy.next;

    }
}
