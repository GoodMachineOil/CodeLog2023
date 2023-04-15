package org.example.二叉树递归遍历.前序遍历leetcode144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        //创建一个Stack对象stack，用于辅助遍历二叉树。将二叉树的根节点root推入栈中。
        Stack<TreeNode> stack1 = new Stack<>();
        stack1.push(root);
        //进入一个while循环，只要栈不为空就一直循环。每次从栈中弹出一个节点node，并将该节点的值node.val添加到结果List中。
        // 然后按照先右子节点，再左子节点的顺序将node的子节点入栈，这样下一次从栈中弹出的节点就是左子节点，这样就可以实现前序遍历。
        // 如果node的右子节点或左子节点是空，则不进行入栈操作。
        while(!stack1.isEmpty()){
            TreeNode node = stack1.pop();
            result.add(node.val);
            if(node.right != null){
                stack1.push(node.right);
            }
            if(node.left != null){
                stack1.push(node.left);
            }
        }
        return result;
    }
}
/**
 * @Description:  总的来说，这段代码是利用一个栈来模拟前序遍历二叉树的过程。
 * 每次从栈中弹出一个节点，并将它的值添加到结果List中，同时按照先右子节点，再左子节点的顺序将子节点入栈，直到栈为空为止。
 */
