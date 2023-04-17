package org.example.翻转二叉树leetcode226;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: zc
 * @Description:
输入：root = [4,2,7,1,3,6,9]
输出：[4,7,2,9,6,3,1]

输入：root = [2,1,3]
输出：[2,3,1]

输入：root = []
输出：[]
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        //我的理解就是 拿一个deque结构的容器把root的地址装进去了，然后后面的操作就是对地址交换
        deque.offerLast(root);
        while(!deque.isEmpty()){
            int len = deque.size();
            for(int i = 0 ;i<len;i++){
                TreeNode node = deque.pollFirst();
                swap(node);
                //这里交换的其实是结点的地址
                if(node.left != null){
                    deque.offerLast(node.left);
                }
                if(node.right != null){
                    deque.offerLast(node.right);
                }
            }
        }
        return root;
    }
    public void swap(TreeNode node){
        TreeNode tempNode = node.left;
        node.left = node.right;
        node.right = tempNode;
    }
}
