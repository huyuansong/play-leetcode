import java.util.ArrayList;
import java.util.List;

/// 145. Binary Tree Postorder Traversal
/// https://leetcode.com/problems/binary-tree-postorder-traversal/description/
/// 二叉树的后序遍历
/// 时间复杂度: O(n), n为树的节点个数
/// 空间复杂度: O(h), h为树的高度
public class Solution145 {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> postorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<Integer>();   //这里是一个顺序的list用来存放最后的结果
        postorderTraversal(root, res);
        return res;
    }

    private void postorderTraversal(TreeNode node, List<Integer> list){
        if(node != null){
            postorderTraversal(node.left, list);   //左节点作为新的根，入栈
            postorderTraversal(node.right, list);  //右节点作为新的根，入栈
            list.add(node.val);                    //根，入栈
        }
    }
}
