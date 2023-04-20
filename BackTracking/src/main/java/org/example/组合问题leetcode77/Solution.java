package org.example.组合问题leetcode77;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: zc
 * @Description:
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 *
 * 示例 1：
 *
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 示例 2：
 *
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resList = new ArrayList<>();
        if(k <= 0 || n < k){
            return resList;
        }
        Deque<Integer> path = new ArrayDeque<>();
        // 从 1 开始是题目的设定
        backtracking(n,k,1,path,resList);
        return resList;
    }

    private void backtracking(int n, int k, int startIndex,Deque<Integer> path , List<List<Integer>> resList){
        //递归的终止条件是path.size == k;
        if(path.size() == k){
            //存放结果
            //为了保持结果的独立性，我们使用了ArrayList来创建一个新的List对象，并将path中的元素复制到该对象中。
            // 这样做的好处是，如果后续修改了path变量的内容，结果列表中的元素不会受到影响。
            resList.add(new ArrayList<>(path));
            return;
        }
        //选择：本层集合中元素（树中节点孩子的数量就是集合的大小)
        //这里要注意，i可以取到n
        for(int i = startIndex; i <= n ; i++){
            //处理节点
            path.offerLast(i);
            //这里使用递归，是深度遍历, 纵向的路径
            //下一轮搜索，设置的搜索起点要加1，因为组合数理不允许出现重复的元素
            backtracking(n, k,i+1,path,resList);
            //回溯，撤销处理结果
            //重点理解这里，深度优先遍历有回头的过程，因此递归之前做了什么，递归之后需要做相同操作的逆向操作
            path.removeLast();
        }
    }
}
