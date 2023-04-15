package org.example.二叉树递归遍历.中序遍历leetcode94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: zc
 * @Description: 分析一下为什么刚刚写的前序遍历的代码，不能和中序遍历通用呢，
 * 因为前序遍历的顺序是中左右，先访问的元素是中间节点，要处理的元素也是中间节点，所以刚刚才能写出相对简洁的代码，因为要访问的元素和要处理的元素顺序是一致的，都是中间节点。
 *
 * 那么再看看中序遍历，中序遍历是左中右，先访问的是二叉树顶部的节点，然后一层一层向下访问，直到到达树左面的最底部，再开始处理节点
 * （也就是在把节点的数值放进result数组中），这就造成了处理顺序和访问顺序是不一致的。
 * 那么在使用迭代法写中序遍历，就需要借用指针的遍历来帮助访问节点，栈则用来处理节点上的元素。
 */
public class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack1.isEmpty()){
            if(cur != null){
                stack1.push(cur);
                cur = cur.left;
            }else{
                cur = stack1.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }
}
/**
 * @Author: zc
 * @Description:

 *     1
 *    / \
 *   2   3
 *  / \   \
 * 4   5   6
 *
 *我们按照中序遍历的顺序来访问这个二叉树。
 * 首先，将根节点 1 入栈，然后遍历其左子树。
 * 此时，将节点 2 入栈，并遍历其左子树，将节点 4 入栈。
 * 此时，节点 4 没有左子节点，因此将其弹出栈，并将其值加入结果列表中，然后遍历其右子树。
 * 由于节点 4 没有右子节点，因此继续弹出栈顶元素，此时是节点 2。
 * 将节点 2 的值加入结果列表中，然后将 cur 更新为节点 5。
 * 此时，我们已经遍历完了节点 4 的子树，因此弹出节点 5 并加入结果列表中，然后将 cur 更新为节点 2 的右子节点 5。
 * 剩下的以此类推
 *
 */
