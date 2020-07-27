/// 226. Invert Binary Tree
/// https://leetcode.com/problems/invert-binary-tree/description/
/* 
Invert a binary tree.
Example:
Input:
     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
Trivia:
This problem was inspired by this original tweet by Max Howell:

Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off. */
/// 时间复杂度: O(n), n为树中节点个数
/// 空间复杂度: O(h), h为树的高度
public class Solution {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode invertTree(TreeNode root) {

        if(root == null)  //递归终止条件
            return null;

        // TreeNode left = invertTree(root.left);     //遍历所有的 小二叉树结构
        // TreeNode right = invertTree(root.right);
        // root.left = right;    //反转操作
        // root.right = left;

        // 思路上表现为只反转一颗大的二叉树
        invertTree( root.left );   // 递归调用
        invertTree( root.right );

        swap(root.left , root.right);  // 左右翻转




        return root;
    }
}
