package org.example.股票问题系列通解.买卖股票的最佳时机lleetcode121;

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
            dp[i][1] = Math.max(dp[i-1][1],-prices[i]);

        }
        return dp[len - 1][0];
    }
}
