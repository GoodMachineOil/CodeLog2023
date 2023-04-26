package org.example.股票问题系列通解.买卖股票的最佳时机lleetcode121;
/**
 * @Author: zc
 * @Description:
你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。

示例 1：
输入：[7,1,5,3,6,4]
输出：5
解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
示例 2：
输入：prices = [7,6,4,3,1]
输出：0
解释：在这种情况下, 没有交易完成, 所以最大利润为 0。

 */
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices == null){
            return 0;
        }
        int len = prices.length;
        int[][] dp =new int[len][2];
        //基准情况
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        //状态转移
        for(int i = 1 ; i < len ; i ++){
            //第i天，没有股票，说明前一天没有股票休息，或者卖出了
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            //第i天 持有一只股票，说明前一天要么持有一只股票休息，或者买入
            //注意，这里是一次买卖
            dp[i][1] = Math.max(dp[i-1][1],-prices[i]);

        }
        return dp[len - 1][0];
    }
}
