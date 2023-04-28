package org.example.不同路径IIleetcode63;
/**
 * @Description:
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示
 *
 *
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 *
 *
 * 输入：obstacleGrid = [[0,1],[0,0]]
 * 输出：1

 */
//1、确定dp数组（dp table）以及下标的含义
//2、确定递推公式
//3、dp数组如何初始化
//4、确定遍历顺序
//5、举例推导dp数组
//    滚动数组思想
//    无后效性
//    最优子结构
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //矩阵的行数
        int m = obstacleGrid.length;
        //矩阵的列数
        //obstacleGrid[0]代表了矩阵的第一行，obstacleGrid[0].length则代表了第一行的长度，也就是矩阵的列数。
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1){
            return 0;
        }
        for(int i = 0 ; i < m && obstacleGrid[i][0] != 1; i++){
            dp[i][0] = 1;
        }
        for(int j = 0 ; j < n && obstacleGrid[0][j] != 1 ; j++){
            dp[0][j] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1 ; j < n ; j++){
                dp[i][j] =  (obstacleGrid[i][j] == 0)? dp[i-1][j] + dp[i][j-1] : 0;
                }
            }
        return dp[m-1][n-1];
        }
    }
