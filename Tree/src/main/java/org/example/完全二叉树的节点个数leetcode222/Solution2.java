package org.example.完全二叉树的节点个数leetcode222;

import java.util.Deque;
import java.util.LinkedList;

//针对完全二叉树的解法
//满二叉树的结点数为 2^depth - 1
public class Solution2 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 0;
        int rightDepth = 0;
        while (left != null) {
            left = left.left;
            leftDepth++;
        }
        while (right != null) {
            right = right.right;
            rightDepth++;
        }
        if (leftDepth == rightDepth) {
            return (2 << leftDepth) - 1;
        }
        return countNodes(root.left) + countNodes(root.right)+1;
    }
}
