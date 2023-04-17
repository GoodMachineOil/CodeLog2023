package org.example.二叉树层序遍历.二叉树的层平均值leetcode637;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: zc
 * @Description:输入：
 * 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10^-5 以内的答案可以被接受。
 * root = [3,9,20,null,null,15,7]
 * 输出：[3.00000,14.50000,11.00000]
 * 解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
 * 因此返回 [3, 14.5, 11] 。
 */
/**
 * @Description:
 *解法：队列，迭代。
 *每次返回每层的最后一个字段即可。
 */
public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> resList = new ArrayList<>();
        if(root == null){
            return resList;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);
        while(!deque.isEmpty()){
            List<Double> list = new ArrayList<>();
            int len = deque.size();
            Double levelSum = 0.0;
            for(int i = 0 ; i < len; i++){
                TreeNode node = deque.pollFirst();
                if(node.left != null){
                    deque.offerLast(node.left);
                }
                if(node.right != null){
                    deque.offerLast(node.right);
                }
                levelSum += node.val;
            }
            resList.add(levelSum/len);
        }
        return resList;
    }
}
