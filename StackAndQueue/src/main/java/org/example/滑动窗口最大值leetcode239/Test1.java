package org.example.滑动窗口最大值leetcode239;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Test1 {
    @Test
    public void test2(){
        Solution solution = new Solution();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums, 3)));
    }
}
