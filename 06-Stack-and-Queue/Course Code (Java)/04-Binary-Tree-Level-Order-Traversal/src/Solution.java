import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import javafx.util.Pair;

/// 102. Binary Tree Level Order Traversal
/// https://leetcode.com/problems/binary-tree-level-order-traversal/description/
/// 二叉树的层序遍历
/// 时间复杂度: O(n), n为树的节点个数
/// 空间复杂度: O(n)
class Solution {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {   //层次遍历

        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();  //list存放顺序输出的结果 一个list存放一层的数据
        if(root == null)                //到达空叶子节点，退出条件
            return res;

        // 我们使用LinkedList来做为我们的先入先出的队列
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<Pair<TreeNode, Integer>>();
        queue.addLast(new Pair<TreeNode, Integer>(root, 0));  //先把 （根节点，该节点所处的层次） 入队列

        while(!queue.isEmpty()){          //队列不为空  当根节点出队列的时候，需要加入该根节点的左右孩子 抵押

            Pair<TreeNode, Integer> front = queue.removeFirst();  //移除第一个元素
            TreeNode node = front.getKey();         //得到节点
            int level = front.getValue();           //得到该节点处于哪个层次

            if(level == res.size())        //节点在新的层中， 
                res.add(new ArrayList<Integer>()); //res中需要重新建立一个list
            assert level < res.size();

            res.get(level).add(node.val);   //找到对应的层数，把节点加入到该层的list中
            if(node.left != null)
                queue.addLast(new Pair<TreeNode, Integer>(node.left, level + 1));
            if(node.right != null)
                queue.addLast(new Pair<TreeNode, Integer>(node.right, level + 1));
        }

        return res;
    }
}
