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
