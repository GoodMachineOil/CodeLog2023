package org.example.二叉树递归遍历.前序遍历leetcode144;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zc
 * @Description:  给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 *
 *
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 *
 *
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 *
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root,result);
        return result;
    }

    public void preorder(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }
        result.add(root.val);
        preorder(root.left,result);
        preorder(root.right,result);
    }
}

