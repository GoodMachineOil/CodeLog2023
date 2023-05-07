package org.example.复原ip地址leetcode93;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。
你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。

示例 1：
输入：s = "25525511135"
输出：["255.255.11.135","255.255.111.35"]
示例 2：
输入：s = "0000"
输出：["0.0.0.0"]
示例 3：
输入：s = "101023"
输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 */
//+ 回溯函数模板返回值以及参数
//  回溯算法中函数返回值一般为void。再来看一下参数，因为回溯算法需要的参数可不像二叉树递归的时候那么容易一次性确定下来，所以一般是先写逻辑，然后需要什么参数，就填什么参数
//
//+ 回溯函数终止条件
//  什么时候达到了终止条件，树中就可以看出，一般来说搜到叶子节点了，也就找到了满足条件的一条答案，把这个答案存放起来，并结束本层递归。
//
//+ 回溯搜索的遍历过程
//  回溯法一般是在集合中递归搜索，集合的大小构成了树的宽度，递归的深度构成的树的深度
public class Solution {
    List<String> resList = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if(s.length() > 12){
            return resList;
        }
        backTracking(s,0,0);
        return resList;
    }
    // startIndex: 搜索的起始位置， pointNum:添加逗点的数量
    public void backTracking(String s, int startIndex, int pointNum){
        if(pointNum == 3){
            // 逗点数量为3时，分隔结束
            // 判断第四段⼦字符串是否合法，如果合法就放进result中
            if(isValid(s,startIndex,s.length()-1 )){
                resList.add(s);
            }
            return;
        }
        for(int i = startIndex; i<s.length(); i++){
            if(isValid(s,startIndex,i)){
                //在str的后⾯插⼊⼀个逗点
                s = s.substring(0,i+1) + "." + s.substring(i+1);
                pointNum++;
                // 插⼊逗点之后下⼀个⼦串的起始位置为i+2
                backTracking(s,i+2,pointNum);
                pointNum--;
                // 回溯删掉逗点
                s=s.substring(0,i+1)+s.substring(i+2);
            }else{
                break;
            }
        }
    }
    // 判断字符串s在左闭⼜闭区间[start, end]所组成的数字是否合法
    public boolean isValid(String s,int start, int end) {
        if(start > end){
            return false;
        }
        //0字开头的数字不合法
        if(s.charAt(start) == '0' && start != end){
            return false;
        }
        int num = 0;
        for(int i = start; i <= end ; i++){
            if(s.charAt(i) > '9' || s.charAt(i) < '0'){// 遇到⾮数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if(num > 255){// 如果⼤于255了不合法
                return false;
            }
        }
        return true;
    }

}
