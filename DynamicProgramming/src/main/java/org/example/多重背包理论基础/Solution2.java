package org.example.多重背包理论基础;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public static void testMultiPack2(){
        List<Integer> weights = new ArrayList<>(Arrays.asList(1,3,4));
        List<Integer> value = new ArrayList<>(Arrays.asList(15,20,30));
        List<Integer> nums = new ArrayList<>(Arrays.asList(2,3,2));
        int bagWeight = 10;

        for(int i = 0 ; i < nums.size() ; i++){
            while(nums.get(i) > 1){
                weights.add(weights.get(i));
                value.add(value.get(i));
                nums.set(i,nums.get(i)-1);
            }
        }

        int[] dp = new int[bagWeight+1];
        for(int i = 0 ; i < weights.size();i++){
            for(int j = bagWeight; j>= weights.get(i); j--){
                dp[j] = Math.max(dp[j], dp[j-weights.get(i)]+value.get(i));
            }
            System.out.println(Arrays.toString(dp));
        }
    }

    public static void main(String[] args) {
        testMultiPack2();
    }
}
