package org.example.二叉树的统一迭代法.迭代法中序遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        if(root != null){
            stack1.push(root);
        }
        while (!stack1.isEmpty()){
            TreeNode node = stack1.peek();
            if(node != null){
                stack1.pop();
                if(node.right != null){
                    stack1.push(node.right);
                }
                stack1.push(node);

                // 中节点访问过，但是还没有处理，加入空节点做为标记
                stack1.push(null);
                //最后才加如左结点
                if(node.left != null){
                    stack1.push(node.left);
                }
            }else{
                stack1.pop();
                node = stack1.peek();
                stack1.pop();
                result.add(node.val);
            }
        }
        return result;
    }
}
