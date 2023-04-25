package org.example.最大子数组和leetcode53;
//进行空间优化
public class Solution3 {
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int res = nums[0];
        for(int num : nums){
            pre = Math.max(pre + num, num);
            res = Math.max(res, pre);
        }
        return res;
    }
}
