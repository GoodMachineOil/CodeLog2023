package org.example.二叉树递归遍历.中序遍历leetcode94;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zc
 * @Description:  给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }
    public void inorder(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        //result.add(root.left.val);
        //inorder(root,result);
        //inorder(root.right, result);
        //上面三行都不对，怎么能和前序遍历一样呢
        inorder(root.left,res);
        res.add(root.val); //注意这一句
        inorder(root.right, res);
    }
}
