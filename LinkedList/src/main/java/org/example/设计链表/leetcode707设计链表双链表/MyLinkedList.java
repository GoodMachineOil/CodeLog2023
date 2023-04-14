package org.example.设计链表.leetcode707设计链表双链表;

public class MyLinkedList {
    int size;
    ListNode head;
    ListNode tail;
    public MyLinkedList() {
        this.size = 0;
        this.head = new ListNode(0);
        this.tail = new ListNode(0);
        //这一步非常关键，否则在加入头结点的操作中会出现null.next的错误！
        head.next = tail;
        tail.prev = head;

    }

    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        ListNode currentNode = this.head;
        //判断是哪一边遍历时间更短
        if(index >= size/2){
            //从tail开始
            currentNode = tail;
            for(int i = 0 ; i < size-index ; i++){
                currentNode = currentNode.prev;
            }
        } else{
               for(int i = 0 ; i <= index ; i++){
                   currentNode = currentNode.next;
               }
            }
        return currentNode.val;
        }

    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    public void addAtIndex(int index, int val) {
        if(index > size){
            return;
        }
        if(index < 0){
            index = 0 ;
        }
        size++;
        //找到前驱
        ListNode pre = this.head;
        for(int i = 0; i < index;i++){
            pre = pre.next;
        }
        //新建结点
        ListNode newNode = new ListNode(val);
        newNode.next = pre.next;
        pre.next.prev = newNode;
        newNode.prev = pre;
        pre.next = newNode;
    }

    public void deleteAtIndex(int index) {
        //判断索引是否有效
        if(index<0||index>=size){
            return;
        }
        //删除操作
        size--;
        ListNode pre = this.head;
        for(int i = 0; i<index;i++){
            pre = pre.next;
        }
        pre.next.next.prev = pre;
        pre.next = pre.next.next;
    }
}
