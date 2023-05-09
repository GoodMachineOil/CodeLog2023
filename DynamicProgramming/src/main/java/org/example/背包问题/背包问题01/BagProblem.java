package org.example.背包问题.背包问题01;

public class BagProblem {
    public static void main(String[] args) {
        int[] weights = {1,3,4};
        int[] value = {15,20,30};
        int bagSize = 4;
        testWeightBagProblem(weights, value, bagSize);
    }

    public static void testWeightBagProblem(int[] weights, int[] value, int bagSize) {
        //创建dp数组
        //weight.length是物品的数量
        int[][] dp = new int[weights.length][bagSize+1];


        //其实这里也可以不用写
        for(int i = 0; i < weights.length ; i++){
            dp[i][0] = 0;
        }
        // 初始化dp数组
        // 创建数组后，其中默认的值就是0
        for(int j = weights[0]; j <= bagSize ; j++){
            dp[0][j] = value[0];
        }
        for(int i = 1 ; i < weights.length ; i++){
            for(int j = 1 ; j<= bagSize; j++){
                if(j < weights[i]){
                    /**
                     * 当前背包的容量都没有当前物品i大的时候，是不放物品i的
                     * 那么前i-1个物品能放下的最大价值就是当前情况的最大价值
                     */
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    /*
                     * 当前背包的容量可以放下物品i
                     * 那么此时分两种情况：
                     *    1、不放物品i
                     *    2、放物品i
                     * 比较这两种情况下，哪种背包中物品的最大价值最大
                     */
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i]]+value[i]);
                }
            }
        }
        //打印dp数组
        for(int i = 0 ; i < weights.length ; i++){
            for(int j = 0 ; j <= bagSize ; j++){
                //注意这里是print
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }
}