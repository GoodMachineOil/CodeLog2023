package org.example.二叉树层序遍历.二叉树的右视图leetcode199;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: zc
 * @Description:
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 * 示例 2:
 *
 * 输入: [1,null,3]
 * 输出: [1,3]
 * 示例 3:
 *
 * 输入: []
 * 输出: []
 */
public class Solution {
    /**
     * 解法：队列，迭代。
     * 每次返回每层的最后一个字段即可。
     *
     * 小优化：每层右孩子先入队。代码略。
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> reslist = new ArrayList<>();
        if(root == null){
            return reslist;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);
        while(!deque.isEmpty()){
            //List<Integer> list = new ArrayList<>();
            int len = deque.size();
            for(int i = 0; i < len ; i++){
                TreeNode node = deque.pollFirst();
                if(node.left != null){
                    deque.offerLast(node.left);
                }
                if(node.right != null){
                    deque.offerLast(node.right);
                }
                //这里很巧妙，返回每层最后一个字段
                if(i == len -1){
                    reslist.add(node.val);
                }
            }
        }
        return reslist;
    }
}
