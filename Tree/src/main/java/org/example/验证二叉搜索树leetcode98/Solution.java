package org.example.验证二叉搜索树leetcode98;
/**
 * @Description:
给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
有效 二叉搜索树定义如下：
节点的左子树只包含 小于 当前节点的数。
节点的右子树只包含 大于 当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
示例1：
输入：root = [2,1,3]
输出：true
示例2：
输入：root = [5,1,4,null,null,3,6]
输出：false
解释：根节点的值是 5 ，但是右子节点的值是 4 。
 */
//递归法
    //1、确定递归函数的返回类型和参数
    //2、确定递归的终止条件
    //3、单层的递归逻辑
public class Solution {
    //注意pre定义的位置
    TreeNode pre;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        //左节点
        boolean left = isValidBST(root.left);
        if(!left){
            return false;
        }
        //当前
        if(pre != null && pre.val >= root.val){
            return false;
        }
        pre = root;
        //右节点
        boolean right = isValidBST(root.right);
        return right;
    }
}
