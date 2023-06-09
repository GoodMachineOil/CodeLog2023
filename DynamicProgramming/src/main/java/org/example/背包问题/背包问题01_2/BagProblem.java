package org.example.背包问题.背包问题01_2;

public class BagProblem {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        testWeightBagProblem(weight, value, bagWeight);
    }
    public static void testWeightBagProblem(int[] weight, int[] value, int bagWeight){
        //定义dp数组：dp[j]表示背包容量为j时，能获得的最大价值
        int[] dp = new int[bagWeight+1];
        //遍历顺序：先遍历物品，再遍历背包容量
        for(int i = 0 ; i < weight.length;i++){
            for(int j = bagWeight; j >= weight[i] ; j--){
                dp[j] = Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }
        //打印dp数组
        for(int j = 0 ; j <= bagWeight;j++){
            System.out.println(dp[j]+" ");
        }

    }
}
