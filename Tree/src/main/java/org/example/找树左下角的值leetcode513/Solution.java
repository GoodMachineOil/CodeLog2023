package org.example.找树左下角的值leetcode513;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: zc
 * @Description:
 *
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * 假设二叉树中至少有一个节点。
 *
 * 输入: root = [2,1,3]
 * 输出: 1
 *
 *
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 *
 */

//使用 BFS 进行「层序遍历」，每次用当前层的首个节点来更新 ans，当 BFS 结束后，ans 存储的是最后一层最靠左的节点。
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        if(root == null){
            return 0;
        }
        int result = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while(!deque.isEmpty()){
            int len = deque.size();
            //每次用当前层的首个节点来更新
            result = deque.peekFirst().val;
            for(int i = 0 ; i < len; i++){
                TreeNode node = deque.pollFirst();
                if(node.left != null){
                    deque.offerLast(node.left);
                }
                if(node.right != null){
                    deque.offerLast(node.right);
                }
            }
        }
        return result;
    }
}
