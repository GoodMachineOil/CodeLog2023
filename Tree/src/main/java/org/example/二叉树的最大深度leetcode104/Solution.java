package org.example.二叉树的最大深度leetcode104;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: zc
 * @Description:
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 *
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int depth=0;
        while (!deque.isEmpty()) {
            int len = deque.size();
            depth++;
            for(int i = 0; i < len; i++){
                TreeNode node = deque.pollFirst();
                if(node.left != null){
                    deque.offerLast(node.left);
                }
                if(node.right != null){
                    deque.offerLast(node.right);
                }
            }
        }
        return depth;
    }
}
