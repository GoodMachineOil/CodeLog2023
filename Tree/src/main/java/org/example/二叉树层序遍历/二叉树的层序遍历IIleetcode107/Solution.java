package org.example.二叉树层序遍历.二叉树的层序遍历IIleetcode107;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: zc
 * @Description:  给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[15,7],[9,20],[3]]
 *
 * 示例 2：
 * 输入：root = [1]
 * 输出：[[1]]
 *
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //这里存储反转前输出的数组
        List<List<Integer>> resList = new ArrayList<>();
        if(root == null){
            return resList;
        }
        //这里用队列，迭代
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);
        //这里整体判断deque,因为deque=[[root]]
        while(!deque.isEmpty()){
            //这里是记录一层结点的值
            List<Integer> list = new ArrayList<>();
            //这里是记录每一层的结点数量
            int len  = deque.size();
            for(int i = 0; i< len ; i++){
                //tempNode = [root]
                TreeNode tempNode = deque.peekFirst();
                //这里是pollFirst [root]的第一个结点
                list.add(deque.pollFirst().val);
                if(tempNode.left != null){
                    deque.offerLast(tempNode.left);
                }
                if(tempNode.right != null){
                    deque.offerLast(tempNode.right);
                }
                //[3] [9] [20,15,7] 细品左右结点
            }
            resList.add(list);
        }
        List<List<Integer>> result = new ArrayList<>();
        //这里翻转数组，得出自底向上的层序遍历
        for(int i = resList.size()-1;i>=0;i--){
            result.add(resList.get(i));
        }
        return result;
    }
}

