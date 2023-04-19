package org.example.二叉树的所有路径leetcode257;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//迭代法
public class Solution2 {
    public List<String> binaryTreePaths(TreeNode root) {
       List<String> resList = new ArrayList<>();
       if(root == null){
           return resList;
       }
        Stack<Object> stack = new Stack<>();
       //节点和路径同时入栈
        stack.push(root);
        //该行代码将root.val转换成字符串，并将其压入栈中
        stack.push(root.val+"");
        while(! stack.isEmpty()){
            String path = (String) stack.pop();
            TreeNode node = (TreeNode)stack.pop();
            if(node.left == null && node.right == null){
                resList.add(path);
            }
            if(node.right != null){
                stack.push(node.right);
                stack.push(path+"->"+node.right.val);
            }
            if(node.left != null){
                stack.push(node.left);
                stack.push(path+"->"+node.left.val);
            }
        }
        return resList;
    }
}
