package org.example.用队列实现栈leetcode225;


import java.util.ArrayDeque;
import java.util.Deque;

//用两个deque实现
public class MyStack2 {
    // Deque 接口继承了 Queue 接口
    // 所以 Queue 中的 add、poll、peek等效于 Deque 中的 addLast、pollFirst、peekFirst
    Deque<Integer> que1 ;
    Deque<Integer> que2;

    public MyStack2(){
        que1 = new ArrayDeque<>();
        que2 = new ArrayDeque<>();
    }
    public void push(int x){
        que1.addLast(x);
    }

    public int pop(){
        int size = que1.size();
        //将que1导入到que2，但是留下最后一个值
        size--;
        while(size-- > 0){
            que2.addLast(que1.peekFirst());
            que1.pollFirst();
        }
        int res = que1.pollFirst();
        //将que2对象的引用赋给了que1，此时que1和que2指向同一个队列
        que1 = que2;
        que2 = new ArrayDeque<>();
        return res;
    }

    public int top() {
        return que1.peekLast();
    }

    public boolean empty() {
        return que1.isEmpty();
    }
}
