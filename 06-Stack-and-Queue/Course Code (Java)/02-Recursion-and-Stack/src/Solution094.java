import java.util.ArrayList;
import java.util.List;

/// 94. Binary Tree Inorder Traversal
/// https://leetcode.com/problems/binary-tree-inorder-traversal/solution/
/* 给定一个二叉树，返回它的中序 遍历。
示例:
输入: [1,null,2,3]
   1
    \
     2
    /
   3
输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？ */

/// 二叉树的中序遍历
/// 时间复杂度: O(n), n为树的节点个数
/// 空间复杂度: O(h), h为树的高度
public class Solution094 {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> inorderTraversal(TreeNode root) {  // Traversal 遍历

        ArrayList<Integer> res = new ArrayList<Integer>();  //中序遍历的结果存在list中
        inorderTraversal(root, res);
        return res;
    }

    private void inorderTraversal(TreeNode node, List<Integer> list){  //递归实现中序遍历
        if(node != null){  //根存在
            inorderTraversal(node.left, list);  //左孩子 作为新的根
            list.add(node.val);                 //把根加入到输出list中
            inorderTraversal(node.right, list); //右孩子 作为新的根
        }
    }
}
