package org.example.二叉树的统一迭代法.迭代法前序遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        if(root != null){
            stack1.push(root);
        }
        //其实是模拟递归的迭代法，null做标记
        while(!stack1.isEmpty()){
            //这里其实就是指代一个指针
            TreeNode node1 = stack1.peek();
            if(node1 != null){
                //因为是前序遍历，中间的点要最后入栈，先把他弹出来，最后添加
                stack1.pop();
                if(node1.right != null){
                    stack1.push(node1.right);
                }
                if(node1.left != null){
                    stack1.push(node1.left);
                }
                stack1.push(node1);
                // 中节点访问过，但是还没有处理，加入空节点做为标记
                //这里要插入一个null，来标记
                stack1.push(null);
            }else {
                //这里要是发现node是null，说明null之前已经被标识过了，开始要把节点加入结果集了
                stack1.pop();
                node1 = stack1.peek();
                stack1.pop();
                result.add(node1.val);
            }
        }
        return result;
    }
}
/**
 * @Description:  总的来说，这段代码是一种模拟递归的迭代方法，实现了二叉树的前序遍历。
 * 其实现的核心思想是使用栈来模拟递归的过程，将遍历过程中的中节点先入栈，再按照右中左的顺序入栈子节点，
 * 然后通过 null 标记节点已被访问但未被处理，最后在出栈的时候根据 null 标记来决定是否将节点加入结果集中。
 */
