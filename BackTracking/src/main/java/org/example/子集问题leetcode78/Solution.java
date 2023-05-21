package org.example.子集问题leetcode78;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * @Author: zc
 * @Description:
给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
示例 1：
输入：nums = [1,2,3]
输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
示例 2：
输入：nums = [0]
输出：[[],[0]]
 */

public class Solution {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums,0);
        return res;
    }
    private void backtracking(int[] nums, int startIndex){
        //「遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合」
        res.add(new ArrayList<>(path));
        if(startIndex >= nums.length){
            return;
        }
        for(int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }
}
