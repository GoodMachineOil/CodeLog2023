package org.example.路径总和leetcode112;

//简化版的递归法
public class Solution2 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        //判断叶子节点判断是否符合
        if(root.left == null && root.right == null){
            return root.val == targetSum;
        }
        //求两侧分枝的路径和
        return hasPathSum(root.left,targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
