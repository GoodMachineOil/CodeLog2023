package org.example.删除字符串中的所有相邻重复项leetcode1047;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: zc
 * @Description:
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * 示例：
 * 输入："abbaca"
 * 输出："ca"
 * 解释：例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项
 * 之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 * 提示：
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 */
//使用 Deque 作为堆栈
public class Solution {
    public String removeDuplicates(String s) {
        //ArrayDeque会比LinkedList在除了删除元素这一点外会快一点
        //参考：https://stackoverflow.com/questions/6163166/why-is-arraydeque-better-than-linkedlist
        Deque<Character> deque1 = new ArrayDeque<>();
        char ch;
        for(int i = 0; i<s.length();i++){
            ch = s.charAt(i);
            if(deque1.isEmpty() || deque1.peek() != ch){
                deque1.push(ch);
            }else{
                deque1.pop();
            }
            }
        String str="";
        //剩余的元素即为不重复的元素
        while(!deque1.isEmpty()){
            str = deque1.pop()+str;
        }
        return str;
        }
    }
