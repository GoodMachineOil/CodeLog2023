package org.example.跳跃游戏leetcode55;
/**
 * @Description:
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 *
 * 示例 1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。

 */
public class Solution {
    public boolean canJump(int[] nums) {
        //可以考虑覆盖范围的方式去解决
        int len = nums.length;
        int coverRange = 0;
        //覆盖范围, 初始覆盖范围应该是0，因为下面的迭代是从下标0开始的
        //在覆盖范围内更新最大的覆盖范围
        for(int i = 0; i<=coverRange; i++){
            coverRange = Math.max(coverRange, nums[i]+i);
            if(coverRange >= len -1){
                return true;
            }
        }
        return false;
    }
}
