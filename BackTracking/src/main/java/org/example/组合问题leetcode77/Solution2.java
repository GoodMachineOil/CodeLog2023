package org.example.组合问题leetcode77;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
/**
 * @Description:
容易知道：搜索起点和当前还需要选几个数有关，而当前还需要选几个数与已经选了几个数有关，即与 path 的长度相关。我们举几个例子分析：

例如：n = 6 ，k = 4。

path.size() == 1 的时候，接下来要选择 333 个数，搜索起点最大是 444，最后一个被选的组合是 [4, 5, 6]；
path.size() == 2 的时候，接下来要选择 222 个数，搜索起点最大是 555，最后一个被选的组合是 [5, 6]；
path.size() == 3 的时候，接下来要选择 111 个数，搜索起点最大是 666，最后一个被选的组合是 [6]；

再如：n = 15 ，k = 4。 path.size() == 1 的时候，接下来要选择 333 个数，搜索起点最大是 131313，最后一个被选的是 [13, 14, 15]；
path.size() == 2 的时候，接下来要选择 222 个数，搜索起点最大是 141414，最后一个被选的是 [14, 15]；
path.size() == 3 的时候，接下来要选择 111 个数，搜索起点最大是 151515，最后一个被选的是 [15]；

可以归纳出：

搜索起点的上界 + 接下来要选择的元素个数 - 1 = n
其中，接下来要选择的元素个数 = k - path.size()，整理得到：

搜索起点的上界 = n - (k - path.size()) + 1
所以，我们的剪枝过程就是：把 i <= n 改成 i <= n - (k - path.size()) + 1 ：

*/
public class Solution2 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resList = new ArrayList<>();
        if(k <= 0 || n < k){
            return resList;
        }
        Deque<Integer> path = new ArrayDeque<>();
        backtrack(n,k,1,path,resList);
        return resList;
    }
    private void backtrack(int n, int k, int startIndex, Deque<Integer> path, List<List<Integer>> resList){
        if(path.size() == k){
            resList.add(new ArrayList<>(path));
            return;
        }
        for(int i =  startIndex; i <= n-(k-path.size())+1; i++){
            path.offerLast(i);
            backtrack(n,k,i+1,path,resList);
            path.removeLast();

        }
    }
}
