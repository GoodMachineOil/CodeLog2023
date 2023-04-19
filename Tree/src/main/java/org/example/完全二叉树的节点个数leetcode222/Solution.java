package org.example.完全二叉树的节点个数leetcode222;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int result = 0;
        while(!deque.isEmpty()) {
            for (int i = 0; i < deque.size(); i++) {
                TreeNode node = deque.poll();
                result++;
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
        }
        return result;
    }
}
