package org.example.二叉树递归遍历.后序遍历leetcode145;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zc
 * @Description:  给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 *输入：root = [1,null,2,3]
 * 输出：[3,2,1]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    postOrder(root,result);
    return result;

    }
    public void postOrder(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        postOrder(root.left,res);
        postOrder(root.right,res);
        //注意这一句
        res.add(root.val);
    }

}
