package org.example.无重叠区域leetcode435;

import java.util.Arrays;
import java.util.Comparator;
/**
 * @Description:
给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
示例 1:
输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
输出: 1
解释: 移除 [1,3] 后，剩下的区间没有重叠。
示例 2:
输入: intervals = [ [1,2], [1,2], [1,2] ]
输出: 2
解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
示例 3:
输入: intervals = [ [1,2], [2,3] ]
输出: 0
解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 */
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        int count = 1;
        for(int i = 1 ; i < intervals.length ; i++){
            if(intervals[i][0] < intervals[i-1][1]){
                intervals[i][1] = Math.min(intervals[i][1], intervals[i-1][1]);
                continue;
            }else {
                count++;
            }
        }
        return intervals.length - count;
    }
}
/**
 * @Description:
 * 本题其实和452.用最少数量的箭引爆气球 (opens new window)非常像，弓箭的数量就相当于是非交叉区间的数量，
 * 只要把弓箭那道题目代码里射爆气球的判断条件加个等号（认为[0，1][1，2]不是相邻区间），然后用总区间数减去弓箭数量 就是要移除的区间数量了
 */
