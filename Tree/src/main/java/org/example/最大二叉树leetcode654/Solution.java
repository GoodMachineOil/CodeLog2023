package org.example.最大二叉树leetcode654;
/**
 * @Author: zc
 * @Description:
 * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 * 返回 nums 构建的 最大二叉树 。
 *
 * 输入：nums = [3,2,1,6,0,5]
 * 输出：[6,3,5,null,2,0,null,null,1]
 * 解释：递归调用如下所示：
 * - [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
 *     - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
 *         - 空数组，无子节点。
 *         - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
 *             - 空数组，无子节点。
 *             - 只有一个元素，所以子节点是一个值为 1 的节点。
 *     - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
 *         - 只有一个元素，所以子节点是一个值为 0 的节点。
 *         - 空数组，无子节点。
 *
 * 输入：nums = [3,2,1]
 * 输出：[3,null,2,null,1]
 */
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return TreeBuilder(nums,0,nums.length-1);
    }
    private TreeNode TreeBuilder(int[] nums, int l , int r) {
        if(l > r){
            return null;
        }
        //这里设置idx等于l 是因为每次循环的时候可以从l开始
        int idx = l;
        for(int i = l ; i <= r ; i++){
            if(nums[i] > nums[idx]){
                idx = i;
            }
        }
        TreeNode node = new TreeNode(nums[idx]);
        node.left = TreeBuilder(nums, l,idx-1);
        node.right = TreeBuilder(nums,idx+1,r);
        return node;
    }
}
