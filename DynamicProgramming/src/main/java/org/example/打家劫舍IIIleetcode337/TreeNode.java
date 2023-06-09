package org.example.打家劫舍IIIleetcode337;

public class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(){

    }

    public TreeNode(TreeNode left, TreeNode right, int val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }
    public TreeNode(int val) {
        this.val = val;
    }
}
