package org.example.合并二叉树leetcode21;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
/**
 * @Author: zc
 * @Description: 给你两棵二叉树： root1 和 root2 。
 *
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 *
 * 返回合并后的二叉树。
 *
 * 注意: 合并过程必须从两个树的根节点开始。

输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
输出：[3,4,5,5,4,null,7]
示例 2：

输入：root1 = [1], root2 = [1,2]
输出：[2,2]
 */
public class Solution {
    // 使用队列迭代
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return null;
        }
        if(root1 == null){
            return root2;
        }
        if(root2 == null){
            return root1;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root1);
        deque.offerLast(root2);

        while (!deque.isEmpty()){
            TreeNode node1 = deque.pollFirst();
            TreeNode node2 = deque.pollFirst();
            // 此时两个节点一定不为空，val相加
            node1.val = node1.val + node2.val;
            // 如果两棵树左节点都不为空，加入队列
            if(node1.left != null && node2.left != null){
                deque.offerLast(node1.left);
                deque.offerLast(node2.left);
            }
            // 如果两棵树右节点都不为空，加入队列
            if(node1.right != null && node2.right != null){
                deque.offerLast(node1.right);
                deque.offerLast(node2.right);
            }
            // 若node1的左节点为空，直接赋值
            if(node1.left == null && node2.left != null){
                node1.left = node2.left;
            }
            // 若node1的右节点为空，直接赋值
            if(node1.right == null && node2.right != null){
                node1.right = node2.right;
            }
        }
        return root1;
    }
}
/**
 * @Description:
 * 在函数执行时，参数 root1 是作为一个引用被传递的，因此对 node1 的任何修改都会反映在 root1 中。
 * 因此，当函数结束时，root1 已经被修改为合并后的树。因此，只需要在函数的最后将 root1 返回即可
 */
