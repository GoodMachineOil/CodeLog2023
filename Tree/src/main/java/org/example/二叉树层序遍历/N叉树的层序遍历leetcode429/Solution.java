package org.example.二叉树层序遍历.N叉树的层序遍历leetcode429;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: zc
 * @Description:
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）
 *
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[[1],[3,2,4],[5,6]]
 *
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 */
public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> resList = new ArrayList<>();
        Deque<Node> deque = new ArrayDeque<>();
        if(root == null){
            return resList;
        }
        deque.offerLast(root);
        while(!deque.isEmpty()){
            int len = deque.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0 ; i< len ; i++){
                Node node = deque.pollFirst();
                list.add(node.val);
                List<Node> children = node.children;
                if(node.children == null && children.size() == 0){
                    continue;
                }
                for(Node child : children){
                    if(child != null){
                        deque.offerLast(child);
                    }
                }
            }
            resList.add(list);
        }
        return resList;
    }
}
