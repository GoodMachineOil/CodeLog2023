package org.example.路径总和leetcode112;

import java.util.Deque;
import java.util.LinkedList;

//用BFS
//迭代法
public class Solution3 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        Deque<Integer> deque2 = new LinkedList<>();
        deque.offerLast(root);
        deque2.offerLast(root.val);

        while (!deque.isEmpty()){
            int len = deque.size();
            for(int i = 0 ; i < len ; i++){
                TreeNode node = deque.pollFirst();
                int sum = deque2.pollFirst();
                // 如果该节点是叶子节点了，同时该节点的路径数值等于sum，那么就返回true
                if(node.left == null && node.right == null && sum == targetSum){
                    return true;
                }
                // 右节点，压进去一个节点的时候，将该节点的路径数值也记录下来
                if(node.right != null){
                    deque.offerLast(node.right);
                    deque2.offerLast(sum + node.right.val);
                }
                // 左节点，压进去一个节点的时候，将该节点的路径数值也记录下来
                if(node.left != null){
                    deque.offerLast(node.left);
                    deque2.offerLast(sum + node.left.val);
                }
            }
        }
        return false;
    }
}
