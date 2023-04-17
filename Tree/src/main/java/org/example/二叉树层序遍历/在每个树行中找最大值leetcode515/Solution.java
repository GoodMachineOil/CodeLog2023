package org.example.二叉树层序遍历.在每个树行中找最大值leetcode515;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: zc
 * @Description:
 *给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 *
 *输入: root = [1,3,2,5,3,null,9]
 * 输出: [1,3,9]
 *
 * 示例2：
 * 输入: root = [1,2,3]
 * 输出: [1,3]
 */
public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if(root == null){
            return resList;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);
        while(!deque.isEmpty()){
            int len = deque.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0 ; i < len ; i++){
                TreeNode node = deque.pollFirst();
                max = Math.max(max,node.val);
                if(node.left != null){
                    deque.offerLast(node.left);
                }
                if(node.right != null){
                    deque.offerLast(node.right);
                }
            }
            resList.add(max);
        }
        return resList;
    }
}
