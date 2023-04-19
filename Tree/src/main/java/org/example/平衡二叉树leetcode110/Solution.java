package org.example.平衡二叉树leetcode110;
/**
 * @Author: zc
 * @Description:
给定一个二叉树，判断它是否是高度平衡的二叉树。
本题中，一棵高度平衡二叉树定义为：
一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。

输入：root = [3,9,20,null,null,15,7]
输出：true

输入：root = [1,2,2,3,3,null,null,4,4]
输出：false
示例 3：

输入：root = []
输出：true

/**
递归法
 *
 */
//明确递归函数的参数和返回值
//参数：当前传入节点。 返回值：以当前传入节点为根节点的树的高度

// 明确终止条件
//递归的过程中依然是遇到空节点了为终止，返回0，表示当前节点为根节点的树高度为0

// 明确单层递归的逻辑
//如何判断以当前传入节点为根节点的二叉树是否是平衡二叉树呢？当然是其左子树高度和其右子树高度的差值。
//
//分别求出其左右子树的高度，然后如果差值小于等于1，则返回当前二叉树的高度，否则返回-1，表示已经不是二叉平衡树了。
public class Solution {
    public boolean isBalanced(TreeNode root) {
        //
        return getHeight(root) != -1;
    }

    public int getHeight(TreeNode root) {
        //说明这里的结点是叶节点
        if(root == null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        //这里要先判断，要是leftHeight或者rightHeight等于-1了，说明已经不是平衡树了
        if(leftHeight == -1){
            return -1;
        }
        if(rightHeight == -1){
            return -1;
        }
        if(Math.abs(leftHeight - rightHeight)>1){
            return -1;
        }
        //这里可以看出是后序遍历
        return Math.max(leftHeight,rightHeight)+1;
    }
}
