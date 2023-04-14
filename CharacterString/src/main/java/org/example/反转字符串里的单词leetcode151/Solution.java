package org.example.反转字符串里的单词leetcode151;
/**
 * @Author: zc
 * @Description:
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
//所以解题思路如下：
//移除多余空格
//将整个字符串反转
//将每个单词反转
    /**
     * @Author: zc
     * @Description:     /**
     *      * 不使用Java内置方法实现
     *      * <p>
     *      * 1.去除首尾以及中间多余空格
     *      * 2.反转整个字符串
     *      * 3.反转各个单词
     *      */
public class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        sb = removeSpace(s);
        reverseString(sb,0,sb.length()-1);
        reverseEachWord(sb);
        return sb.toString();
    }
    //定义一个返回类型为StringBuilder的removeSpace方法
    public StringBuilder removeSpace(String s){
        //代码首先定义了两个指针 start 和 end，分别指向字符串的开头和结尾。
        int start = 0;
        int end = s.length()-1;
        char[] ch = s.toCharArray();
        StringBuilder sb1 = new StringBuilder();
        // 然后使用 while 循环分别将指针移动到第一个非空格字符和最后一个非空格字符的位置。
        while(ch[start] == ' '){
            start++;
        }
        while(ch[end] == ' '){
            end--;
        }
        while(start <= end){

            if(ch[start] != ' '|| sb1.charAt(sb1.length()-1) != ' '){
                sb1.append(ch[start]);
            }
            start++;
        }
        return sb1;
    }
    //定义一个在区间内翻转的方法，方法类型为字符串,其实也就是翻转整个字符串，以字符串中的空格为标记
    public void reverseString(StringBuilder sb, int start, int end){
        //异或运算（XOR），也叫做“按位异或”，是一种二进制位运算。它的原理可以简单地概括为“相同为0，不同为1”。
        while(start < end){
            char temp = sb.charAt(start);
           sb.setCharAt(start, sb.charAt(end));
           sb.setCharAt(end,temp);
           start++;
           end--;
        }
    }
    //翻转上一步字符串的每一个字符
    public void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = start+1;
        while(start < sb.length()){
            while(end < sb.length() && sb.charAt(end) != ' ' ){
                end++;
            }
            reverseString(sb,start,end-1);
            start = end+1;
            end = start +1;
        }
    }

}
