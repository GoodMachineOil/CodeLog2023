package org.example.leetcode209长度最小的子数组滑动窗口;

/**
 * @Author: zc
 * @Description: 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0
 * 输入：s = 7, nums = [2,3,1,2,4,3] 输出：2 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 提示：
 *
 * 1 <= target <= 10^9
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 */
public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int j;
        int i = 0;
        int sum = 0;
        int sublength = 1;
        int result = Integer.MAX_VALUE;
        for(j=0;j<nums.length;j++)
        {
            sum += nums[j];
            while(sum >= target){
                sublength = j-i+1;
                result = result < sublength ? result : sublength;
                sum = sum - nums[i];
                i++;
            }
        }
        return result == Integer.MAX_VALUE ? 0: result;
    }
}
