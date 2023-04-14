package org.example.用队列实现栈leetcode225;


import java.util.ArrayDeque;
import java.util.Deque;

//使用一个deque实现
// Deque 接口继承了 Queue 接口
// 所以 Queue 中的 add、poll、peek等效于 Deque 中的 addLast、pollFirst、peekFirst
public class MyStack3 {
    Deque<Integer> que1;
    public MyStack3() {
        que1 = new ArrayDeque<>();
    }

    public void push(int x) {
        que1.addLast(x);
    }

    public int pop() {
        int size = que1.size();
        size--;
        while (size-- > 0) {
            que1.addLast(que1.peekFirst());
            que1.pollFirst();
        }
        int res = que1.pollFirst();
        return res;
    }

    public int top() {
        return que1.peekLast();
    }

    public boolean empty() {
        return que1.isEmpty();
    }
}
