package org.example.组合总和leetcode39;

import java.util.*;

/**
 * @Author: zc
 * @Description:
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
 * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 *
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 *
 * 示例 2：
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 *
 * 示例 3：
 * 输入: candidates = [2], target = 1
 * 输出: []
 *
 */

public class Solution {

    List<List<Integer>> resList = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        if(len == 0){
            return resList;
        }

        //排序是剪枝的前提
        Arrays.sort(candidates);
        backTracking(candidates,target,0,len,path,resList);
        return resList;

    }
    private void backTracking(int[] candidates, int target, int begin, int len, Deque<Integer> path, List<List<Integer>> resList){
        //做减法，画树状图
        // 由于进入更深层的时候，小于 0 的部分被剪枝，因此递归终止条件值只判断等于 0 的情况
        if(target == 0){
            resList.add(new ArrayList<>(path));
            return;
        }
        for(int i = begin ; i < len; i++){
            // 重点理解这里剪枝，前提是候选数组已经有序，
            if(target - candidates[i] < 0){
                break;
            }
            path.offerLast(candidates[i]);
            backTracking(candidates, target - candidates[i], i, len, path,resList);
            path.removeLast();
        }
    }
}
