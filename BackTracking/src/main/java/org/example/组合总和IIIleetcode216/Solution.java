package org.example.组合总和IIIleetcode216;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * @Author: zc
 * @Description:

找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：

只使用数字1到9
每个数字 最多使用一次
返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。

示例 1:

输入: k = 3, n = 7
输出: [[1,2,4]]
解释:
1 + 2 + 4 = 7
没有其他符合的组合了。
示例 2:

输入: k = 3, n = 9
输出: [[1,2,6], [1,3,5], [2,3,4]]
解释:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
没有其他符合的组合了。
示例 3:

输入: k = 4, n = 1
输出: []
解释: 不存在有效的组合。
在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。

 */
public class Solution {
    //这里要开始建两个数组，一个存放结果，一个存放路径
    List<List<Integer>> resList = new ArrayList<>();
    //变存放路径的是链表
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTacking(k,n,1,0);
        return resList;
    }
    private void backTacking(int k, int n, int startIndex, int sum){
        //剪枝
        if(sum > n){
            return;
        }
        if(path.size() == k){
            if(sum == n){
                resList.add(new ArrayList<>(path));
            }
            return;
        }
        //剪枝， 9-(k-path.size())+1
        for(int i = startIndex ; i <= 9-(k-path.size())+1;i++){
            path.add(i);
            sum += i;
            backTacking(k,n,i+1,sum);
            //回溯
            path.removeLast();
            //回溯
            sum -= i;
        }
    }
}
