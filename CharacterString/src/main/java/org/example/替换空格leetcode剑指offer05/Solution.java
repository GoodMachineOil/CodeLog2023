package org.example.替换空格leetcode剑指offer05;
/**
 * @Author: zc
 * @Description: 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
//双指针法
public class Solution {
    public String replaceSpace(String s) {
        if( s == null || s.length() == 0){
            return s;
        }
        //扩充空间，空格数量是原来的两倍，因为题目要求是一个空格替换成三个格子
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                str.append("  ");
            }
        }
        //若是没有空格直接返回
        if(str.length()==0){
            return s;
        }
        //若有空格，定义两个指针
        //不用开辟新的空间存放数组了，直接在原来的数组基础上添加
        int left = s.length()-1;
        s += str.toString();
        int right = s.length()-1;
        //将原来的字符串转变成字符串数组形式
        char[] ch = s.toCharArray();
        while(left >=0){
            if(ch[left] == ' '){
                ch[right] = '0';
                ch[--right]='2';
                ch[--right]='%';
            }else{
                ch[right]=ch[left];
            }
            left--;
            right--;
        }
        return new String(ch);
    }

}

