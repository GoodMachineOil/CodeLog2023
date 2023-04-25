package org.example.最大子数组和leetcode53;
//没有空间优化的动态规划
//1、状态定义（定义子问题）
//2、状态转移方程（描述子问题之间的联系）
//3、初始化
//4、输出
//5、是否可以空间优化
public class Solution2 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        //dp[i]表示：以nums[i]结尾的连续子数组的最大和
        int[] dp = new int[len];
        dp[0] = nums[0];

        for(int i = 1 ; i < len ; i++){
            if(dp[i-1] > 0){
                dp[i] = dp[i-1] + nums[i];
            }else {
                dp[i] = nums[i];
            }
        }
        int res = dp[0];
        for(int i = 1; i < len ; i++){
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
