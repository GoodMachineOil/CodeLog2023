package org.example.对称二叉树leetcode101;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: zc
 * @Description:
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 *
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        //为什么这里LinkedList换成ArrayDeque就会报错
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root.left);
        deque.offerLast(root.right);
        while(!deque.isEmpty()){
            TreeNode leftNode = deque.pollFirst();
            TreeNode rightNode = deque.pollLast();
            if(leftNode == null && rightNode == null){
                continue;
            }
            if(leftNode == null && leftNode != null){
                return false;
            }
            if(leftNode != null && rightNode == null){
                return false;
            }
            if(leftNode.val != rightNode.val){
                return false;
            }
            deque.offerFirst(leftNode.left);
            deque.offerFirst(leftNode.right);
            deque.offerLast(rightNode.right);
            deque.offerLast(rightNode.left);
        }
        return true;
    }
}
/**
 * @Author: zc
 * @Description:
 * 这段代码中使用了双端队列 Deque 的接口，而 LinkedList 是 Deque 接口的一个实现类，所以可以使用 LinkedList 来作为队列。
 *
 * 而 ArrayDeque 也是 Deque 接口的一个实现类，但是和 LinkedList 不同的是，它是基于循环数组实现的，
 * 而 LinkedList 是基于双向链表实现的。虽然两者都实现了 Deque 接口，但它们在实现上还是有区别的。
 *
 * 在这个问题中，由于代码中使用了 offerFirst 和 offerLast 这两个方法，
 * 而这两个方法是 Deque 接口中的方法，不同的实现类可能会有不同的实现方式，
 * 因此如果将 LinkedList 替换成 ArrayDeque 可能会导致程序出错。
 * 你可以尝试在代码中将 offerFirst 和 offerLast 替换成 addFirst 和 addLast 进行尝试。

 */