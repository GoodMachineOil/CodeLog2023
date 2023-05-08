package org.example.根据身高重建队列leetcode406;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        //(a, b) -> {...} 表示一个 Lambda 表达式
        Arrays.sort(people,(a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        LinkedList<int[]> queue = new LinkedList<>();

        for(int[] p : people){
            queue.add(p[1],p);
        }

        return queue.toArray(new int[people.length][]);
    }
}
