package org.example.二叉树的所有路径leetcode257;

import java.util.ArrayList;
import java.util.List;
/**
 * @Author: zc
 * @Description:
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 * 示例 2：
 *
 * 输入：root = [1]
 * 输出：["1"]
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        //存最终的结果
        List<String> resList = new ArrayList<>();
        if(root == null){
            return resList;
        }
        //存放中间结果的路径，注意，是integer
        List<Integer> paths = new ArrayList<>();
        traversal(root, paths, resList);
        return resList;
    }
    //注意这里方法是private
    private void traversal(TreeNode root, List<Integer> paths, List<String> resList){
        //这里中间结果字符串列表先存放起始的根节点
        paths.add(root.val);
        if(root.left == null && root.right == null){
            // StringBuilder用来拼接字符串，速度更快
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < paths.size()-1;i++){
                sb.append(paths.get(i)).append("->");
            }
            //记录最后一个节点
            sb.append(paths.get(paths.size()-1));
            //收集一个路径
            resList.add(sb.toString());
            return;
        }
        //递归和回溯是同时进行，所以要放在同一个花括号里
        if(root.left != null){
            //左
            traversal(root.left,paths,resList);
            //回溯
            paths.remove(paths.size()-1);
        }
        if(root.right != null){
            //右
            traversal(root.right, paths,resList);
            paths.remove(paths.size()-1);//回溯
        }
    }
}
