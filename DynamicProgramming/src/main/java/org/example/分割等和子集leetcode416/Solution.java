package org.example.分割等和子集leetcode416;
/**
 * @Description:
 *给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 示例 1：
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }
        int sum = 0 ;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0 ){
            return false;
        }
        int target = sum / 2;
        int[] dp = new int[target+1];
        for(int i = 0 ; i < nums.length ; i ++){
            for(int j = target; j >= nums[i] ; j--){
                //物品的重量是nums[i],价值也是nums[i]
                dp[j] = Math.max(dp[j], dp[j-nums[i]]+nums[i]);
            }
        }
        return dp[target] == target;
    }
}
