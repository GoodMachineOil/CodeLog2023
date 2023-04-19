package org.example.二叉树的最小深度leetcode111;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: zc
 * @Description:
给定一个二叉树，找出其最小深度。
最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
说明：叶子节点是指没有子节点的节点。

输入：root = [3,9,20,null,null,15,7]
输出：2

示例 2：
输入：root = [2,null,3,null,4,null,5,null,6]
输出：5
 */
//二叉树节点的深度：指从根节点到该节点的最长简单路径边的条数或者节点数（取决于深度从0开始还是从1开始）
//二叉树节点的高度：指从该节点到叶子节点的最长简单路径边的条数后者节点数（取决于高度从0开始还是从1开始）
//那么使用后序遍历，其实求的是根节点到叶子节点的最小距离，就是求高度的过程，不过这个最小距离 也同样是最小深度。
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int depth = 0;
        while(!deque.isEmpty()){
            int len = deque.size();
            depth++;
            for(int i = 0 ; i < len ; i++){
                TreeNode node = deque.poll();
                // 是叶子结点，直接返回depth，因为从上往下遍历，所以该值就是最小值
                if(node.left == null && node.right == null){
                    return depth;
                }
                if(node.left != null){
                    deque.offer(node.left);
                }
                if(node.right != null){
                    deque.offer(node.right);
                }
            }
        }
        return depth;
    }
}
