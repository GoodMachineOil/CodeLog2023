package org.example.组合总和IIleetcode40;

import java.util.*;

/**
 * @Author: zc
 * @Description:
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 注意：解集不能包含重复的组合。
示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
输出:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
输出:
[
[1,2,2],
[5]
]

 */

//使用标记数组used
public class Solution {
    List<List<Integer>> resList = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();
    //定义一个used标记数组
    boolean[] used;

    int sum = 0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        //加标志数组，用来辅助判断同层节点是否已经遍历
        Arrays.fill(used,false);
        //为了将重复数组都放到了一起，所以先进行排序
        Arrays.sort(candidates); // 很重要
        backtracking(candidates,target,0);
        return resList;
    }
    private void backtracking(int[] candidates, int target, int begin){
        if(sum == target){
            resList.add(new ArrayList<>(path));
            return;
        }

        for(int i = begin ; i < candidates.length ; i++){
            if(sum + candidates[i] > target){
                //跳出循环，直接进入到循环后面的代码执行。在这个特定的代码中，会执行后面的回溯操作
                break;
            }
            //出现重复节点，同层的第一个节点已经被访问过了，所以直接跳过
            //跳过该循环中还未执行的代码，直接进入下一次循环的判断
            if(i > 0 && candidates[i] == candidates[i-1] && !used[i-1]){
                continue;
            }
            used[i] = true;
            sum += candidates[i];
            path.add(candidates[i]);
            //每个节点仅能选择一次，所以从下一位开始
            backtracking(candidates,target,i+1);
            //当搜索不到时，说明这一点不合适，需要回撤
            used[i] = false;
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
