package org.example.二叉树层序遍历.二叉树的层序遍历leetcode102;

import java.util.ArrayList;
import java.util.List;
/**
 * @Author: zc
 * @Description:  给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * 示例 2：
 *
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 *
 * 输入：root = []
 * 输出：[]
 */
//DFS--递归方式
public class Solution {
    //注意二维数组的创建方式：
    public List<List<Integer>> resList = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        checkFun01(root,0);
        return resList;
    }
    public void checkFun01(TreeNode node,int deep){
        if(node == null){
            return;
        }
        deep++;
        if(resList.size() < deep){
            //当层级增加时，list的Item也增加，利用list的索引值进行层级界定
            List<Integer> item = new ArrayList<>();
            resList.add(item);
        }
        resList.get(deep-1).add(node.val);
        checkFun01(node.left,deep);
        checkFun01(node.right, deep);
    }
}
