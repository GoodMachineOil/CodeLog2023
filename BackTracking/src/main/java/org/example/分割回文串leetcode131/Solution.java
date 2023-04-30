package org.example.分割回文串leetcode131;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
回文串 是正着读和反着读都一样的字符串。
示例 1：
输入：s = "aab"
输出：[["a","a","b"],["aa","b"]]
示例 2：
输入：s = "a"
输出：[["a"]]

 */
public class Solution {
    List<List<String>> lists = new ArrayList<>();
    Deque<String> deque = new LinkedList<>();
    public List<List<String>> partition(String s) {
        backtracking(s,0);
        return lists;
    }
    private void backtracking(String s, int startIndex) {
        //如果起始位置大于s的大小，说明找到一组分割方案
        if (startIndex >= s.length()) {
            lists.add(new ArrayList<>(deque));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            //如果是回文串，则记录
            if (isPalindrome(s, startIndex, i)) {
                //substring 方法的第二个参数是不包含在截取范围内的，即截取的字符串的最后一个字符的下标应该是 i，而不是 i+1
                String str = s.substring(startIndex, i + 1);
                deque.addLast(str);
            }else {
                continue;
            }
            //起始位置往后移，保证不重复，这里应该是深度
            backtracking(s,i+1);
            deque.removeLast();
        }
    }
    private boolean isPalindrome(String s, int startIndex,int end) {
        for(int i = startIndex, j = end ; i < j ; i++,j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
