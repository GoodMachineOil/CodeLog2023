package org.example.划分字母区间leetcode763;

import java.util.LinkedList;
import java.util.List;
/**
 * @Author: zc
 * @Description:
给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
返回一个表示每个字符串片段的长度的列表。
示例 1：
输入：s = "ababcbacadefegdehijhklij"
输出：[9,7,8]
解释：
划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
每个字母最多出现在一个片段中。
像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。
示例 2：
输入：s = "eccbbbbdec"
输出：[10]
 */
public class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new LinkedList<>();
        int[] edge = new int[26];
        char[] ch = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            edge[ch[i] - 'a'] = i ;
        }
        int index = 0;
        int last = -1;
        for(int i = 0 ; i < ch.length; i++){
            index = Math.max(index, edge[ch[i] - 'a']);
            if(index == i){
                list.add(i - last);
                last = i;
            }
        }
        return list;
    }
}
