package org.example.螺旋矩阵.leetcode59;

/**
 * @Author: zc
 * @Description: 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 *
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int loop = 0;
        int start = 0;
        int[][] result = new int[n][n];
        int count = 1;
        int i = 0,j = 0;

        while(loop++ < n / 2){
            for(j = start; j< n - loop ; j++){
                result[start][j] = count++;
            }
            for(i = start; i< n-loop; i++){
                result[i][j] = count++;
            }
            for(;j>=loop;j--){
                result[i][j] = count++;
            }
            for(;i>=loop;i--){
                result[i][j] = count++;
            }
            start++;
        }
        if(n%2==1){
            result[start][start]=count;
        }
        return result;
    }
}
