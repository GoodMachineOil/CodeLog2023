package org.example.根据身高重建队列leetcode406;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        //(a, b) -> {...} 表示一个 Lambda 表达式
        // 身高从大到小排（身高相同k小的站前面）
        Arrays.sort(people,(a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        LinkedList<int[]> queue = new LinkedList<>();
        //具体来说，代码中的 for 循环遍历数组 people 中的每个元素，每次将一个长度为 2 的一维数组 p 取出。
        // p[0] 表示这个人的身高，p[1] 表示在这个人前面身高比他高的人的数量。然后将这个一维数组 p 插入到优先队列中，
        // 使用的是 add 方法，并传入了两个参数：p[1] 表示插入的位置，即在队列中插入到第几个元素的位置，p 表示要插入的元素。
        for(int[] p : people){
            queue.add(p[1],p);
        }

        return queue.toArray(new int[people.length][]);
    }
}
/**
 * @Description:
具体来说，queue.toArray() 方法会返回一个包含队列中所有元素的数组，但是这个数组类型是 Object[]，需要进行强制类型转换才能得到二维数组类型 int[][]。
但是，在强制类型转换时需要注意，因为 Object[] 类型的数组不能直接转换成 int[][] 类型的数组，需要使用另一种转换方式。
在这个例子中，使用了另一种将 Object[] 转换成 int[][] 的方式，即使用 new int[people.length][] 构造一个空的二维数组，然后将其作为参数传递给 toArray 方法。
在这种方式下，toArray 方法会根据数组的元素类型和数组长度创建一个新的二维数组，并将队列中的元素复制到这个新数组中，最终返回这个新数组。

因此，这行代码的作用就是将队列中的元素转换成二维数组类型 int[][]，并将其赋值给 people 变量。
这个二维数组中的每个元素都是一个长度为 2 的一维数组，表示每个人的身高和前面比他高的人的数量。
 */
