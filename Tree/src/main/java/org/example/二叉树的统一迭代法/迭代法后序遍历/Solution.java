package org.example.二叉树的统一迭代法.迭代法后序遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * @Author: zc
 * @Description:
 * 其实吧，就是前中后序遍历的时候，中节点在的位置就是要处理的位置，也就是放null标记的位置
 */

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        if(root != null){
            stack1.push(root);
        }
        while (!stack1.isEmpty()){
            TreeNode node = stack1.peek();
            if(node != null){
                stack1.push(null);
                if(node.right != null){
                    stack1.push(node.right);
                }
                if(node.left != null){
                    stack1.push(node.left);
                }
            }else {
                stack1.pop();
                node = stack1.peek();
                stack1.pop();
                result.add(node.val);
            }
        }
        return result;
    }
}
