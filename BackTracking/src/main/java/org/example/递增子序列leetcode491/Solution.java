package org.example.递增子序列leetcode491;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/**
 * @Author: zc
 * @Description:
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 *
 * 示例 1:
 * 输入：nums = [4,6,7,7]
 * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 * 示例 2：
 * 输入：nums = [4,4,3,2,1]
 * 输出：[[4,4]]
 */
public class Solution {
    List<List<Integer>> resList = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums,0);
        return resList;
    }
    private void backtracking(int[] nums , int startIndex){
        //if(startIndex >= nums.length){
        //    return;
        //}不能写这段
        if(path.size() > 1){
            resList.add(new ArrayList<>(path));
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = startIndex; i < nums.length ; i++){
            if(!path.isEmpty() && nums[i] < path.getLast()){
                continue;
            }
            if(map.getOrDefault(nums[i],0) >= 1){
                continue;
            }
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            path.add(nums[i]);
            backtracking(nums,i+1);
            path.removeLast();

        }
    }
}
