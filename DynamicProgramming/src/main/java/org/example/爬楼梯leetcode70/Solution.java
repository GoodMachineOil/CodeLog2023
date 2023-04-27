package org.example.爬楼梯leetcode70;
/**
 * @Description:
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
示例 1：
输入：n = 2
输出：2
解释：有两种方法可以爬到楼顶。
1. 1 阶 + 1 阶
2. 2 阶
示例 2：
输入：n = 3
输出：3
解释：有三种方法可以爬到楼顶。
1. 1 阶 + 1 阶 + 1 阶
2. 1 阶 + 2 阶
3. 2 阶 + 1 阶

//确定dp数组
// 确定递推公式
// dp数组如何初始化
// 确定遍历顺序
// 举例推导dp数组
 */
//爬到第一层楼梯有一种方法，爬到二层楼梯有两种方法。
//
//那么第一层楼梯再跨两步就到第三层 ，第二层楼梯再跨一步就到第三层。
//
//所以到第三层楼梯的状态可以由第二层楼梯 和 到第一层楼梯状态推导出来，那么就可以想到动态规划了。
public class Solution {
    public int climbStairs(int n) {
        //dp[i] ,爬到第i层有dp[i]种方法
        //dp[i-1] 爬到第i-1层，有dp[i-1]种方法，再一步跳一个台阶就是dp[i]了
        //dp[i-2] 爬到第i-2层，有dp[i-2]种方法，再一步跳两个台阶就是dp[i]了
        //根据递推,dp[i] = dp[i-1] + d[i+2]

        //在爬楼梯问题中，每次只能爬 1 阶或 2 阶，因此对于当前的第i阶楼梯，只能从第i-1阶楼梯走 1 步或者从第i-2阶楼梯走 2 步到达。
        //因此，我们可以将第i阶楼梯的爬楼梯方法数量拆分为两个子问题
        //从第i-1阶楼梯爬 1 阶到达第i阶楼梯，即dp[i-1]
        //从第i-2阶楼梯爬 2 阶到达第i阶楼梯，即dp[i-2]
        //所以，dp[i] = dp[i-1] + dp[i-2]
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
