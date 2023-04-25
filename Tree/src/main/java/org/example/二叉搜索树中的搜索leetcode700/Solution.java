package org.example.二叉搜索树中的搜索leetcode700;
/**
 * @Description:
 * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
 *
 * 输入：root = [4,2,7,1,3], val = 2
 * 输出：[2,1,3]
 *
 * 输入：root = [4,2,7,1,3], val = 5
 * 输出：[]
 */

//注意二叉搜索树的定义
/**
 * @Description:
一提到二叉树遍历的迭代法，可能立刻想起使用栈来模拟深度遍历，使用队列来模拟广度遍历。
对于二叉搜索树可就不一样了，因为二叉搜索树的特殊性，也就是节点的有序性，可以不使用辅助栈或者队列就可以写出迭代法。
对于一般二叉树，递归过程中还有回溯的过程，例如走一个左方向的分支走到头了，那么要调头，在走右分支。
而对于二叉搜索树，不需要回溯的过程，因为节点的有序性就帮我们确定了搜索的方向。
例如要搜索元素为3的节点，我们不需要搜索其他节点，也不需要做回溯，查找的路径已经规划好了。

 */
public class Solution {
    // 迭代，利用二叉搜索树特点，优化，可以不需要栈
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null){
            if(val < root.val){
                root = root.left;
            }else if(val > root.val){
                root = root.right;
            }
            else {
                return root;
            }
        }
        return null;
    }
}
