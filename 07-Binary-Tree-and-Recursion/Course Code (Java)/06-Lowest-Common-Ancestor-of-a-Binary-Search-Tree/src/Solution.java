import javax.sound.sampled.SourceDataLine;

/// 235. Lowest Common Ancestor of a Binary Search Tree
/// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
/* Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q 
as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]

Example 1:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
Example 2:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 */
// 求最近公共祖先
// 时间复杂度: O(lgn), 其中n为树的节点个数
// 空间复杂度: O(h), 其中h为树的高度
class Solution {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(p == null || q == null)
            throw new IllegalArgumentException("p or q can not be null.");

        if(root == null)    // 空树中不存在这样的节点
            return null;

        if(p.val < root.val && q.val < root.val)   //p q 都在root的左边
            return lowestCommonAncestor(root.left, p, q);
        if(p.val > root.val && q.val > root.val)  // p q 都在root的右边
            return lowestCommonAncestor(root.right, p, q);

        assert p.val == root.val || q.val == root.val   // p 或者 q 本身就是root 
                || (root.val - p.val) * (root.val - q.val) < 0;  // p q 分布在root的两侧

        return root;  // p 和 q 能够保证都存在
    }


    public static void main(String[] args) {
        System.out.println("hello ");
    }
    
}
