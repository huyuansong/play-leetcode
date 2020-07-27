/// Source : https://leetcode.com/problems/binary-tree-preorder-traversal/description/

// 先序遍历 根左右
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Classic Non-Recursive algorithm for preorder traversal
// Time Complexity: O(n), n is the node number in the tree
// Space Complexity: O(h), h is the height of the tree
public class Solution1 {

    public List<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;

        Stack<TreeNode> stack = new Stack<TreeNode>();   //需要借助stack作为数据的中转
        stack.push(root);
        while(!stack.empty()){
            TreeNode curNode = stack.pop();
            res.add(curNode.val);

            if(curNode.right != null)
                stack.push(curNode.right);
            if(curNode.left != null)
                stack.push(curNode.left);
        }
        return res;
    }

}
