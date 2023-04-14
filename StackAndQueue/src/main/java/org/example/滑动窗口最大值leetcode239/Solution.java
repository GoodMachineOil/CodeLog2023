package org.example.滑动窗口最大值leetcode239;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: zc
 * @Description: 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 */
//解法一  自定义数组
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==1){
            return nums;
        }
        int len = nums.length - k +1;
        int[] res = new int[len];
        int num = 0;

        //自定义队列
        MyQueue myQueue = new MyQueue();
        //先将前K个元素放入队列
        for(int i = 0; i<k; i++){
            myQueue.add(nums[i]);
        }
        res[num++]= myQueue.peek();
        for(int i = k ; i < nums.length; i++){
            //滑动窗口移除最前面的元素，
            //其实也可以这样想，为了确保之前最大的那个元素在移动到某一个位置后肯定会移出去，因为每次往右移动一个单位
            //所以先判断
            myQueue.poll(nums[i-k]);
            //然后加入最后一位元素
            myQueue.add(nums[i]);
            //记录对应的最大值
            res[num++] = myQueue.peek();
        }
        return res;
    }
}

        class MyQueue{
        Deque<Integer> deque1 = new ArrayDeque<>();
        //弹出元素时，比较当前要弹出的数值是否等于队列出口的数值，如果相等，则弹出
        //同时判断队列当前是否为空
        void poll(int x){
        if(!deque1.isEmpty() && x == deque1.peek() ){
            deque1.poll();
        }
        }
        //添加元素时，如果要添加的元素大于入口处的元素，就将入口处元素弹出
        //保证队列元素单调递减
        void add(int x){
            while (!deque1.isEmpty() && x > deque1.getLast()){
                deque1.removeLast();
            }
            deque1.add(x);
        }
        int peek() {
            return deque1.peek();
        }
        }
