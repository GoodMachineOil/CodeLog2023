package org.example.全排列leetcode46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    List<List<Integer>> resList = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used ;
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0){
            return resList;
        }
        used = new boolean[nums.length];
        backtracking(nums);
        return resList;

    }

    private void backtracking(int[] nums){
        if(path.size() == nums.length){
            resList.add(new ArrayList<>(path));
        }
        for(int i = 0 ; i < nums.length; i++){
            if(used[i]){
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backtracking(nums);
            path.removeLast();
            used[i] = false;
        }

    }
}
