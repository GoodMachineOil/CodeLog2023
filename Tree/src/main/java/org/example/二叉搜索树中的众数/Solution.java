package org.example.二叉搜索树中的众数;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> resList = new ArrayList<>();
        if(root == null){
            return resList.stream().mapToInt(Integer::intValue).toArray();
        }
        //获得频率map
        searchBST(root,map);
        List<Map.Entry<Integer, Integer>> mapList = map.entrySet().stream()
                .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                .collect(Collectors.toList());
        resList.add(mapList.get(0).getKey());
        //把频率最高的加入list
        for(int i = 1; i < mapList.size(); i++){
            if(mapList.get(i).getValue() == mapList.get(i-1).getValue()){
                resList.add(mapList.get(i).getKey());
            }else {
                break;
            }
        }
        return resList.stream().mapToInt(Integer::intValue).toArray();
    }

    public void searchBST(TreeNode cur , Map<Integer,Integer> map){
        if(cur == null){
            return ;
        }
        map.put(cur.val,map.getOrDefault(cur.val,0)+1);
        searchBST(cur.left, map);
        searchBST(cur.right, map);
    }
}
