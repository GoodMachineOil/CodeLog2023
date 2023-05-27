package org.example.重新安排行程leetcode332;

import java.util.*;

/**
 * @Author: zc
 * @Description:
 * 给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。
 * 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。
 * 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。
 * 假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。
 */
class Solution {
    private LinkedList<String> result;
    // Map<出发机场, map<到达机场, 航班次数>> targets
    private Map<String, Map<String, Integer>> targets;

    public List<String> findItinerary(List<List<String>> tickets) {
        targets = new HashMap<String, Map<String, Integer>>();
        result = new LinkedList<>();
        // 把tickets的所有航班信息转换为：Map<出发机场, map<到达机场, 航班次数>> 的map集合
        for(List<String> t : tickets){
            Map<String, Integer> temp;
            if(targets.containsKey(t.get(0))){
                temp = targets.get(t.get(0));
                temp.put(t.get(1), temp.getOrDefault(t.get(1), 0) + 1);
            }else{
                // 升序Map，底层红黑树，保证了根据出发机场获取的map<到达机场, 航班次数>是有序的
                temp = new TreeMap<>();
                temp.put(t.get(1), 1);
            }
            targets.put(t.get(0), temp);
        }
        result.add("JFK"); // 起始机场
        backtracking(tickets.size()); // 传入机票的张数，用于终止条件判断
        return new ArrayList<>(result);
    }

    // 由于根据出发机场获取的map<到达机场, 航班次数>是有序的，所以找到的第一个路径就是需要的字典排序最小的行程组合。
    // 所以设置布尔类型返回值，找到结果停止遍历所有树，立马返回答案。
    private boolean backtracking(int ticketNum){
        if(result.size() == ticketNum + 1){
            return true;
        }
        // 获取起始位置
        String last = result.getLast();
        // 根据起始位置 确定能找到出发地为起始位置的机票
        if(targets.containsKey(last)){
            // 遍历该起始位置能到达的entry键值对<到达机场, 航班次数>
            for(Map.Entry<String, Integer> target : targets.get(last).entrySet()){
                // count为 该<起始位置, 到达机场> 的机票张数
                int count = target.getValue();
                // count＞0（有票）的情况
                if(count > 0){
                    result.add(target.getKey()); // 该目的地存入result中
                    target.setValue(count - 1); // 票数 - 1
                    if(backtracking(ticketNum)) {
                        return true;
                    }
                    target.setValue(count); // 回溯
                    result.removeLast(); // 回溯
                }
            }
        }
        return false;
    }
}

