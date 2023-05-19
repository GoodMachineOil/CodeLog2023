package org.example.单调递增的数字leetcode738;
/**
 * @Description:
 * 当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
 * 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
 * 示例 1:
 * 输入: n = 10
 * 输出: 9
 * 示例 2:
 * 输入: n = 1234
 * 输出: 1234
 * 示例 3:
 * 输入: n = 332
 * 输出: 299
 */
public class Solution {
    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char[] ch = s.toCharArray();
        int flag = s.length();
        for(int i = s.length()-1; i > 0 ; i--){
            if( ch[i-1] > ch[i]){
                flag = i;
                ch[i-1]--;
            }
        }
        for(int i = flag ; i < s.length(); i++){
            ch[i] = '9';
        }
        return Integer.parseInt(String.valueOf(ch));
    }
}
