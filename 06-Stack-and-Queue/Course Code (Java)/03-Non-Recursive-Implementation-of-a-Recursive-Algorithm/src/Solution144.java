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

        ArrayList<Integer> res = new ArrayList<Integer>();  //用ArrayList存放打印的结果
        if(root == null)                                    
            return res;

        Stack<Command> stack = new Stack<Command>();        //借助 栈 控制访问顺序
        stack.push(new Command("go", root));                // 可以认为只有当下的一棵树，那么任务只能是访问它
        while(!stack.empty()){                              //栈只要不为空
            Command command = stack.pop();                  //每次取出栈顶的元素

            if(command.s.equals("print"))                   //分析刚才出栈的任务
                res.add(command.node.val);                  // 打印
            else{                                           // 访问
                assert command.s.equals("go");  
                if(command.node.right != null)      // 右节点存在，访问右节点
                    stack.push(new Command("go",command.node.right));
                if(command.node.left != null)       //左节点存在，访问左节点
                    stack.push(new Command("go",command.node.left));

                stack.push(new Command("print", command.node));  // 打印，再访问左孩子，右孩子
            }
        }
        return res;
    }

}
