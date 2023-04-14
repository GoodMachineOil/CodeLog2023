package org.example.两个数组的交集.leetcode349;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zc
 * @Description:
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。
 * 我们可以 不考虑输出结果的顺序 。
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if( nums1 == null || nums1.length ==0 || nums2 == null || nums2.length == 0){
            return new int[0];
        }

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet2 = new HashSet<>();
        for(int i : nums1){
            set1.add(i);
        }
        for(int i: nums2){
            if(set1.contains(i)){
                resSet2.add(i);
            }
        }
        ////方法1，将结果集合转成数组
        return resSet2.stream().mapToInt(x -> x).toArray();


        //方法2： 另外申请一个数组存放resSet中的元素，最后返回数组
        //int[] arr = new int[resSet2.size()];
        //int j = 0;
        //for(int i : resSet2){
        //    arr[j++] = i;
        //}
        //return arr;
    }
}
