package org.example.链表相交.面试题0207;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA=0;
        int lenB=0;
        //求链表A的长度
        while (curA != null){
            lenA++;
            curA = curA.next;
        }
        //求链表B的长度
        while (curB != null){
            lenB++;
            curB = curB.next;
        }
        //复原一下
        curA = headA;
        curB = headB;
        //让curA为最长链表的头，lenA为其长度
        if(lenB > lenA){
            int temp = lenA;
            lenA = lenB;
            lenB = temp;
            ListNode tempNode = curA;
            curA = curB;
            curB = tempNode;
        }
        //求长度差
        int gap = lenA - lenB;
        while(gap-- >0){
            curA = curA.next;
        }
        //遍历curA和curB，遇到相同则直接返回
        while(curA != null){
            if(curA == curB){
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
