package org.example.全排列leetcode46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * @Author: zc
 * @Description:
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
 */
public class Solution {
    List<List<Integer>> resList = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0){
            return resList;
        }
        backtracking(nums,path);
        return resList;
    }

    private void backtracking(int[] nums,LinkedList<Integer> path){
        if(path.size() == nums.length){
            resList.add(new ArrayList<>(path));
        }
        for(int i = 0; i < nums.length; i++){
            // 如果path中已有，则跳过
            if(path.contains(nums[i])){
                continue;
            }
            path.add(nums[i]);
            backtracking(nums,path);
            path.removeLast();
        }
    }
}
