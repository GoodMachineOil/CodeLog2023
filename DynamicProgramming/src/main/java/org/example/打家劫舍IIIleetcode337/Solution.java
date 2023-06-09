package org.example.打家劫舍IIIleetcode337;
/**
 * @Description:
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 *示例1
 * 输入: root = [3,2,3,null,3,null,1]
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
 *
 * 示例2
 * 输入: root = [3,4,5,1,3,null,1]
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
 */
public class Solution {
    public int rob(TreeNode root) {
        int[] res = robAction(root);
        return Math.max(res[0], res[1]);
    }
    public int[] robAction(TreeNode root) {
        int[] res = new int[2];
        if(root == null){
            return res;
        }
        int[] left = robAction(root.left);
        int[] right = robAction(root.right);

        res[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1] );
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}
