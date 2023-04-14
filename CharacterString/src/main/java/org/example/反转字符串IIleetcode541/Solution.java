package org.example.反转字符串IIleetcode541;

/**
 * @Author: zc
 * @Description: 给定一个字符串 s 和一个整数 k，从字符串开头算起, 每计数至 2k 个字符，就反转这 2k 个字符中的前 k 个字符。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 *
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 * 示例:
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 */
public class Solution {
    public String reverseStr(String s, int k) {
        //toCharArray() 是 Java String 类中的一个方法，用于将一个字符串对象转换为一个字符数组。
        char[] ch = s.toCharArray();
        //i += 2 * k 每次循环都跳过2k个字符
        for(int i = 0 ; i < ch.length ; i += k * 2){
            int start = i;
            //判断end位置,这里是判断尾数够不够k个来取决end指针的位置
            int end = Math.min(ch.length-1, start+k-1);
            while(start < end){
                //用异或反转运算
                ch[start] ^= ch[end];
                ch[end] ^= ch[start];
                ch[start] ^= ch[end];
                start++;
                end--;
            }
        }
        //注意 返回字符串
        return new String(ch);
    }
}
