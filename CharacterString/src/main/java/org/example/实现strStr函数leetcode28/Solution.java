package org.example.实现strStr函数leetcode28;
/**
 * @Author: zc
 * @Description:
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * 示例 1: 输入: haystack = "hello", needle = "ll" 输出: 2
 * 示例 2: 输入: haystack = "aaaaa", needle = "bba" 输出: -1
 * 说明: 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class Solution {

    //前缀表不减一
    public int strStr(String haystack, String needle) {
        int[] next = new int[needle.length()];
        getNext(next,needle);
        int j = 0;
        for(int i = 0; i < haystack.length();i++){
            while(j>0&&haystack.charAt(i) != needle.charAt(j)){
                j=next[j-1];
            }
            if(haystack.charAt(i) == needle.charAt(j)){
                j++;
            }
            if(j == needle.length()){
                return i-needle.length()+1;
            }
        }
        return -1;
    }

    public void getNext(int[] next, String needle){
        int j = 0;
        next[0] = j;
        for(int i = 1; i<needle.length();i++){
            while(j>0 && needle.charAt(i) != needle.charAt(j) ){
                j = next[j-1];
            }
            if(needle.charAt(i) == needle.charAt(j)){
                j++;
            }
            next[i] = j;
        }
    }
}
