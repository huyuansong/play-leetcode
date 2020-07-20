import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/// 94. Binary Tree Inorder Traversal
/// https://leetcode.com/problems/binary-tree-inorder-traversal/solution/
/// 非递归二叉树的中序遍历
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

    private class Command{
        String s;   // go, print
        TreeNode node;
        Command(String s, TreeNode node){
            this.s = s;
            this.node = node;
        }
    };

    public List<Integer> inorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<Integer>();   //不管什么遍历，都需要把结果放在一个顺序的list中
        if(root == null)
            return res;

        Stack<Command> stack = new Stack<Command>();     //中序遍历，手动实现，需要借助第三方数据结构  栈
        stack.push(new Command("go", root));
        while(!stack.empty()){
            Command command = stack.pop();               //出栈

            if(command.s.equals("print"))   //这是出栈的操作
                res.add(command.node.val);
            else{
                assert command.s.equals("go");
                if(command.node.right != null)
                    stack.push(new Command("go",command.node.right));   //反向压栈的过程  中序出栈顺序：左根右  入栈顺序：右根左  
                stack.push(new Command("print", command.node)); //---------> 入栈根节点的过程
                if(command.node.left != null)
                    stack.push(new Command("go",command.node.left));
            }
        }
        return res;
    }

}
