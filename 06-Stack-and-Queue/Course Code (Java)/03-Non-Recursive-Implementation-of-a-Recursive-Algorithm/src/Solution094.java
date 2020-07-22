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
        stack.push(new Command("go", root));   // 可以看做只有一个节点，当下的任务只有访问这个节点
        while(!stack.empty()){
            Command command = stack.pop();               // 取出接下来的任务

            if(command.s.equals("print"))               // 接下来的任务是打印 
                res.add(command.node.val);
            else{                                       // 接下来的任务是访问
                assert command.s.equals("go");
                if(command.node.right != null)          // 右节点存在
                    stack.push(new Command("go",command.node.right));   // 访问右节点  
                stack.push(new Command("print", command.node));         // 打印根节点
                if(command.node.left != null)                           // 左节点存在，访问左节点
                    stack.push(new Command("go",command.node.left));
            }
        }
        return res;
    }

}
