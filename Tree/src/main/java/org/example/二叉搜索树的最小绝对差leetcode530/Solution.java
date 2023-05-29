package org.example.二叉搜索树的最小绝对差leetcode530;

import java.util.Stack;

public class Solution {
    public int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        int result = Integer.MAX_VALUE;

        if(root == null){
            return result;
        }

        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.peek();
            if(cur != null){
                stack.pop();
                if(cur.right != null){
                    stack.add(cur.right);
                }
                stack.add(cur);
                stack.add(null);
                if(cur.left != null){
                    stack.add(cur.left);
                }
            }else{
                stack.pop();
                TreeNode temp = stack.pop();
                if(pre !=null){
                result = Math.min(result, temp.val - pre.val);
                }
                pre = temp;
            }
        }
        return result;
    }
}
