package org.example.有效的字母异位词.leetcode242;

/**
 * @Author: zc
 * @Description: 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1: 输入: s = "anagram", t = "nagaram" 输出: true
 *
 * 示例 2: 输入: s = "rat", t = "car" 输出: false
 *
 * 说明: 你可以假设字符串只包含小写字母。
 */
/**
 * @Author: zc
 * @Description:定义一个数组叫做record用来上记录字符串s里字符出现的次数。
 *
 * 需要把字符映射到数组也就是哈希表的索引下标上，因为字符a到字符z的ASCII是26个连续的数值，所以字符a映射为下标0，相应的字符z映射为下标25。
 *
 * 再遍历 字符串s的时候，只需要将 s[i] - ‘a’ 所在的元素做+1 操作即可，并不需要记住字符a的ASCII，只要求出一个相对数值就可以了。 这样就将字符串s中字符出现的次数，统计出来了。
 *
 * 那看一下如何检查字符串t中是否出现了这些字符，同样在遍历字符串t的时候，对t中出现的字符映射哈希表索引上的数值再做-1的操作。
 *
 * 那么最后检查一下，record数组如果有的元素不为零0，说明字符串s和t一定是谁多了字符或者谁少了字符，return false。
 *
 * 最后如果record数组所有元素都为零0，说明字符串s和t是字母异位词，return true。
 */
//charAt()是JAVA中常用的字符串方法，其作用返回一个字符串的指定位置的字符，索引是从[0,length-1].比如：
//str.charAt(0)检索str中的第一个字符,str.charAt(str.length()-1)检索最后一个字符。
public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        for(int i=0; i < s.length(); i++){
            record[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < t.length(); i++){
            record[t.charAt(i) - 'a']--;
        }
        for(int i = 0 ; i < record.length; i++){
            if(record[i] != 0)
                return false;
        }
        return true;
    }
}
