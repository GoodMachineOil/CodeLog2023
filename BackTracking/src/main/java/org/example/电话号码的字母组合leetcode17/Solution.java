package org.example.电话号码的字母组合leetcode17;

import java.util.ArrayList;
import java.util.List;
/**
 * @Author: zc
 * @Description:
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 */

public class Solution {
    //设置全局列表存储最后的结果
    List<String> resList = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return resList;
        }
        //初始化对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
        String[] numStrings = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        //迭代处理
        backTracking(digits,numStrings,0);
        return resList;
    }
    //注意，这里的定义在两个方法体之间
    //每次迭代获取一个字符串，所以会设计大量的字符串拼接，所以这里选择更为高效的 StringBuild
    StringBuilder temp = new StringBuilder();
    //比如digits如果为"23",num 为0，则str表示2对应的 abc
    private void backTracking(String digits, String[] numStrings, int numIndex){
        //遍历全部一次记录一次得到的字符串
        if(numIndex == digits.length()){
            resList.add(temp.toString());
            return;
        }
        //str表示当前num对应的字符串
        String str = numStrings[digits.charAt(numIndex) - '0'];
        for(int i = 0; i < str.length() ; i++){
            temp.append(str.charAt(i));
            backTracking(digits,numStrings,numIndex+1);
            //剔除末尾 继续尝试
            temp.deleteCharAt(temp.length()-1);
        }
    }
}
