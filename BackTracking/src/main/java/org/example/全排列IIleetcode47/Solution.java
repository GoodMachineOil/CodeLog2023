package org.example.全排列IIleetcode47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/**
 * @Author: zc
 * @Description:
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Solution {
    List<List<Integer>> resList = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums.length == 0){
            return resList;
        }
        Arrays.sort(nums);
        used = new boolean[nums.length];
        //填充used数组
        Arrays.fill(used,false);
        backtracking(nums,used);
        return resList;
    }
    private void backtracking(int[] nums, boolean[] used){
        if(path.size() == nums.length){
            resList.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }
            if(used[i] == false){
                used[i] = true;
                path.add(nums[i]);
                backtracking(nums,used);
                path.remove(path.size() -1 );
                used[i] = false;
            }
        }
    }
}
