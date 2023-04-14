package org.example.前k个高频元素leetcode347;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author: zc
 * @Description:
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 */
//要统计元素出现频率,一类的问题可以使用map来进行统计
//对频率排序 -----这里我们可以使用一种 容器适配器就是优先级队列
//找出前K个高频元素,这里我们可以使用一种 容器适配器就是优先级队列。
    //基于小顶堆实现
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //Map.getOrDefault(Object key, V defaultValue);
        //如果在Map中存在key，则返回key所对应的的value。
        //如果在Map中不存在key，则返回默认值。
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num, 0)+1);
        }
        //在优先队列中存储二元组(num,cnt),cnt表示元素值在数组中的出现次数
        //出现次数按从队头到队尾的顺序 从大到小排，出现次数最低的在队头（相当于小顶堆)
        PriorityQueue<int[]> pd = new PriorityQueue<>((pair1,pair2)->(pair1[1]-pair2[1]));
        for(Map.Entry<>)
    }
}
