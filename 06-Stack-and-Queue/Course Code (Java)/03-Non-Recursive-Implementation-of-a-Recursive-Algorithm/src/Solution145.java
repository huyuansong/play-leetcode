import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/// 145. Binary Tree Postorder Traversal
/// https://leetcode.com/problems/binary-tree-postorder-traversal/description/
/// 非递归的二叉树的后序遍历
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

    private class Command{
        String s;   // go, print
        TreeNode node;
        Command(String s, TreeNode node){
            this.s = s;
            this.node = node;
        }
    };

    public List<Integer> postorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<Integer>();   //存储结果的顺序数据
        if(root == null)            // 打印条件
            return res; 

        Stack<Command> stack = new Stack<Command>();   //借助栈 调整数据顺序
        stack.push(new Command("go", root));
        while(!stack.empty()){
            Command command = stack.pop();     //出栈一个命令，根据命令类型，决定接下来的操作

            if(command.s.equals("print"))    
                res.add(command.node.val);
            else{                            
                assert command.s.equals("go");
                stack.push(new Command("print", command.node));
                if(command.node.right != null)
                    stack.push(new Command("go",command.node.right));
                if(command.node.left != null)
                    stack.push(new Command("go",command.node.left));
            }
        }
        return res;
    }

}
