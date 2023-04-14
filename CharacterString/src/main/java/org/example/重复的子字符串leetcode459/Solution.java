package org.example.重复的子字符串leetcode459;
/**
 * @Author: zc
 * @Description: 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。
 * 给定的字符串只含有小写英文字母，并且长度不超过10000。
 * 示例 1:
 * 输入: "abab"
 * 输出: True
 * 解释: 可由子字符串 "ab" 重复两次构成。
 *
 * 示例 2:
 * 输入: "aba"
 * 输出: False
 *
 * 示例 3:
 * 输入: "abcabcabcabc"
 * 输出: True
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if(s.equals("")) {
            return false;
        }
        int len = s.length();
        int j = 0;
        //原来的字符串前加一个空格（哨兵），使下标从1开始，这样j从0开始，也不用初始化了
        s = " "+s;
        char[] ch = s.toCharArray();
        int[] next = new int[len+1];
        //构造next数组过程，j从0开始（空格）,i从2开始
        //为了方便构造 next 数组，我们在原字符串前加上一个哨兵字符（这里是一个空格），使得原字符串的下标从 1 开始。
        // 因此，如果我们要遍历原字符串的所有位置，下标就需要从 1 开始，即 i 从 2 开始循环。这也就是为什么 i 的初始值为 2。
        for(int i = 2; i <= len; i++){
            //匹配不成功的话，j回到到前一位置next数组所对应的值
            while(j > 0 && ch[i] != ch[j+1]){
                j = next[j];
            }
            //匹配成功，j往后移
            if(ch[i] == ch[j+1]){
                j++;
            }
            //更新next数组的值
            next[i] = j;
        }

        if(next[len] > 0 && len%(len-next[len]) == 0){
            return true;
        }else{
            return false;
        }
    }
}
