package org.example.从中序与后序遍历序列构造二叉树leetcode106;

import java.util.HashMap;

/**
 * @Description:
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，
 * 请你构造并返回这颗 二叉树 。

输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
输出：[3,9,20,null,null,15,7]
示例 2:

输入：inorder = [-1], postorder = [-1]
输出：[-1]
 */
public class Solution {
    // 方便根据数值查找位置
    HashMap<Integer, Integer> inorderMap = new HashMap<>();
    int[] post ;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0 ; i < inorder.length; i++){
            //妙啊，将节值点及索引全部记录在哈希表中
            inorderMap.put(inorder[i], i);
        }
        post = postorder;
        TreeNode buildNode = findTree(0,inorder.length-1,0,postorder.length - 1);
        return buildNode;

    }
    public TreeNode findTree(int inorderStart, int inorderEnd, int postOrderStart, int postOrderEnd){
        if(inorderEnd < inorderStart || postOrderEnd < postOrderStart){
            return null;
        }
        //根据后序遍历结果，取得根节点
        int root = post[postOrderEnd];
        //获取对应的索引
        int rootIndexInorderStart = inorderMap.get(root);
        //创建该节点
        TreeNode node = new TreeNode(root);

        node.left = findTree(inorderStart, rootIndexInorderStart -1 , postOrderStart, postOrderStart+rootIndexInorderStart-inorderStart-1);
        node.right = findTree(rootIndexInorderStart + 1, inorderEnd,postOrderStart+rootIndexInorderStart-inorderStart,postOrderEnd-1);
        return node;
    }

}
/**
 * @Author: zc
 * @Description:

将HashMap的定义放在buildTree方法内也可以，但是为了方便后续方法的调用，以及提高代码可读性，将HashMap的定义放在了类的成员变量位置。

在这个程序中，inorderMap是一个哈希表，用于存储中序遍历数组中每个节点的值以及对应的索引。
这样，在后续递归构建二叉树的过程中，可以根据节点的值快速地找到它在中序遍历数组中的位置。
由于递归调用的findTree方法中需要用到inorderMap变量，如果将它定义在buildTree方法内，就需要在findTree方法中作为参数传递，显得有些麻烦。
因此，将其定义在类的成员变量位置，就可以方便地在整个类中访问该变量。
 */
