import java.util.List;
import java.util.ArrayList;

/// 257. Binary Tree Paths
/// https://leetcode.com/problems/binary-tree-paths/description/
/* 给定一个二叉树，返回所有从根节点到叶子节点的路径。

说明: 叶子节点是指没有子节点的节点。

示例:

输入:

   1
 /   \
2     3
 \
  5

输出: ["1->2->5", "1->3"]

解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 */
/// 时间复杂度: O(n), n为树中的节点个数
/// 空间复杂度: O(h), h为树的高度
public class Solution {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<String> binaryTreePaths(TreeNode root) {

        ArrayList<String> res = new ArrayList<String>();

        if(root == null)
            return res;

        if(root.left == null && root.right == null){
            res.add(Integer.toString(root.val));                    //叶子节点
            return res;
        }

        List<String> leftPaths = binaryTreePaths(root.left);   //语义清楚  左
        for(String s: leftPaths){
            StringBuilder sb = new StringBuilder(Integer.toString(root.val));
            sb.append("->");
            sb.append(s);   //当前节点+左子树路径
            res.add(sb.toString());
        }

        List<String> rightPaths = binaryTreePaths(root.right);      //右
        for(String s: rightPaths) {
            StringBuilder sb = new StringBuilder(Integer.toString(root.val));
            sb.append("->");
            sb.append(s);   // 当前节点+右子树路径
            res.add(sb.toString());
        }

        return res;
    }
}
