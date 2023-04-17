package org.example.二叉树层序遍历.二叉树的层序遍历leetcode102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: zc
 * @Description://BFS--迭代方式--借助队列
 */
public class Solution2 {
    List<List<Integer>> resList = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        checkFun02(root);
        return resList;
    }
    public void checkFun02(TreeNode node){
        if(node == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        //注意这里的循环条件，判断的是整体
        while (!queue.isEmpty()){
            //这里定义一个数组，记录每一层的结点的值
            List<Integer> itemlist = new ArrayList<>();
            //len是记录一层有几个结点
            int len = queue.size();
            //while循环是把结点都一一排出
            while(len > 0){
                TreeNode tempNode = queue.poll();
                itemlist.add(tempNode.val);

                if(tempNode.left != null){
                    queue.offer(tempNode.left);
                }
                if(tempNode.right != null){
                    queue.offer(tempNode.right);
                }
                len--;
            }
            //这里每层统一加入到reslist上面
            resList.add(itemlist);
        }
    }
}
/**
 * @Description:
 * 在Java中，队列有两种实现：LinkedList和ArrayDeque，前者实现了List和Deque接口，后者仅实现了Deque接口。
 * LinkedList底层采用的是链表结构实现，插入、删除效率高，访问元素效率低；
 * ArrayDeque底层采用的是循环数组结构实现，访问元素效率高，插入、删除效率相对较低。
 */
