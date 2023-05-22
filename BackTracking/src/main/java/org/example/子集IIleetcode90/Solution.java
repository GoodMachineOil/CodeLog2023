package org.example.子集IIleetcode90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/**
 * @Description:
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。

 * 示例 1：
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */

public class Solution {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> result = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length == 0){
            result.add(path);
            return result;
        }
        // 对数组进行排序
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtracking(nums,0);
        return result;
    }

    private void backtracking(int[] nums, int startIndex){
        result.add(new ArrayList<>(path));// 将当前符合条件的子集加入结果集合
        if(startIndex >= nums.length){
            return;
        }
        for(int i = startIndex ; i < nums.length;i++){
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1]){
                continue; // 遇到重复元素并且前一个元素没有被使用过，则跳过当前循环
            }
            path.add(nums[i]); // 将当前元素加入路径
            used[i] = true ; // 标记当前元素已使用
            backtracking(nums,i+1);// 递归调用下一层
            path.removeLast();// 回溯，移除最后一个元素
            used[i] = false;// 标记当前元素未使用，以便下一轮循环使用
        }
    }
}
