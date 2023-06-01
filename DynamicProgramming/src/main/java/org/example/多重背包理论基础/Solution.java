package org.example.多重背包理论基础;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    //改变遍历个数
    public static void testMultiPack1(int[] weights,int[] value,int[] nums,int bagWeight){

        int [] dp = new int[bagWeight+1];
        for(int i = 0 ; i< nums.length ; i++){
            for(int j = bagWeight ; j>= weights[i] ; j--){
                //以上为01背包，然后加一个遍历个数
                for(int k = 1 ; k <= nums[i]&&(j-k*weights[i])>=0;k++){
                    dp[j] = Math.max(dp[j], dp[j - k * weights[i]] + k * value[i]);
                }
                System.out.println(Arrays.toString(dp));
            }
        }
    }
    public static void main(String[] args) {
        int[] weights = new int[]{1,3,4};
        int[] value = new int[]{15,20,30};
        int[] nums = new int[] {2,3,2};
        int bagWeight = 10;
        testMultiPack1(weights,value, nums, bagWeight);
    }
}
