package org.example.摆动序列leetcode376;
//用动态规划做
//1、确定dp数组（dp table）以及下标的含义
//2、确定递推公式
//3、dp数组如何初始化
//4、确定遍历顺序
//5、举例推导dp数组
public class Solution2 {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int up = 1;
        int down = 1;
        for(int i = 1; i < nums.length ; i++){
            if(nums[i] < nums[i-1] ){
                down = up + 1;
            }
            if(nums[i] > nums[i-1]){
                up = down + 1;
            }
        }
        return Math.max(up,down);
    }
    //public int wiggleMaxLength(int[] nums) {
    //    if(nums.length == 0){
    //        return 0;
    //    }
    //    int[][] dp = new int[nums.length][2];
    //    dp[0][0] = dp[0][1] = 1;
    //    for(int i = 1; i < nums.length ; i++){
    //        dp[i][0] = dp[i][1] = 1;
    //        for(int j = 0 ; j < i ; j++){
    //            if(nums[i] > nums[j]){
    //                dp[i][0] = Math.max(dp[i][0],dp[j][1]+1);
    //            }
    //            if(nums[i] < nums[j]){
    //                dp[i][1] = Math.max(dp[i][1],dp[j][0]+1);
    //            }
    //        }
    //    }
    //    return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    //}
}
