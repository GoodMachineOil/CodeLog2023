package org.example.二叉树递归遍历.后序遍历leetcode145;

import java.util.*;

/**
 * @Author: zc
 * @Description:
 * 再来看后序遍历，先序遍历是中左右，后续遍历是左右中，
 * 那么我们只需要调整一下先序遍历的代码顺序，就变成中右左的遍历顺序，然后在反转result数组，输出的结果顺序就是左右中了
 */
public class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.left!=null){
                stack.push(node.left);
            }
            if(node.right!=null){
                stack.push(node.right);
            }
        }
        //注意Java里 翻转数组的应用！！
        Collections.reverse(result);
        return result;
    }
}
