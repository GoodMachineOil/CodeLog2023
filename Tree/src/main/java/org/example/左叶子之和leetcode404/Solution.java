package org.example.左叶子之和leetcode404;

import java.util.Stack;

/**
 * @Author: zc
 * @Description:  给定二叉树的根节点 root ，返回所有左叶子之和。
 *
 * 输入: root = [3,9,20,null,null,15,7]
 * 输出: 24
 * 解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * 示例 2:
 * 输入: root = [1]
 * 输出: 0
 */
//首先要注意是判断左叶子，不是二叉树左侧节点，所以不要上来想着层序遍历。
// 因为题目中其实没有说清楚左叶子究竟是什么节点，
// 那么我来给出左叶子的明确定义：节点A的左孩子不为空，且左孩子的左右孩子都为空（说明是叶子节点），那么A节点的左孩子为左叶子节点
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        int result = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            //判断当前节点是不是左叶子是无法判断的，必须要通过节点的父节点来判断其左孩子是不是左叶子
            if(node.left != null && node.left.left == null && node.left.right == null){
                result += node.left.val;
            }
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
        return result;
    }
}
