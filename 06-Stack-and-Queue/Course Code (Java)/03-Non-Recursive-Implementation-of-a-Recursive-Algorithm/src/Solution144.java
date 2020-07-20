import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/// 144. Binary Tree Preorder Traversal
/// https://leetcode.com/problems/binary-tree-preorder-traversal/description/
/// 非递归二叉树的前序遍历
/// 时间复杂度: O(n), n为树的节点个数
/// 空间复杂度: O(h), h为树的高度
public class Solution144 {

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

    public List<Integer> preorderTraversal(TreeNode root) {   //先序遍历 根左右

        ArrayList<Integer> res = new ArrayList<Integer>();  //用ArrayList存放顺序打印的结果
        if(root == null)                                    //完全退出函数的条件
            return res;

        Stack<Command> stack = new Stack<Command>();        //借助 栈 控制顺序
        stack.push(new Command("go", root));                //进栈 根节点
        while(!stack.empty()){                              //栈不为空
            Command command = stack.pop();                  //出栈

            if(command.s.equals("print"))                   //出栈的过程
                res.add(command.node.val);
            else{
                assert command.s.equals("go");
                if(command.node.right != null)      //右节点不为空，右节点进栈
                    stack.push(new Command("go",command.node.right));
                if(command.node.left != null)       //左节点不为空，左节点进栈
                    stack.push(new Command("go",command.node.left));
                stack.push(new Command("print", command.node)); //最后根节点进栈
            }
        }
        return res;
    }

}
