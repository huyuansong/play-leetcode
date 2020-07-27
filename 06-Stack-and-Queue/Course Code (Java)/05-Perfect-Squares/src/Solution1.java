import java.util.LinkedList;
import javafx.util.Pair;

// 279. Perfect Squares
// https://leetcode.com/problems/perfect-squares/description/
/* 
给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
示例 1:
输入: n = 12
输出: 3 
解释: 12 = 4 + 4 + 4.

示例 2:
输入: n = 13
输出: 2
解释: 13 = 4 + 9. */

//广度优先遍历，用来解决最短路径问题，适用于无权图
// 该方法会导致 Time Limit Exceeded 或者 Memory Limit Exceeded
// 时间复杂度: O(2^n)
// 空间复杂度: O(2^n)
public class Solution1 {

    public int numSquares(int n) {  //问题转化为 求一个图的层次遍历

        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<Pair<Integer, Integer>>();  //层序遍历需要一个队列  pair<第几个数字，经历了几段路径到该数字>
        queue.addLast(new Pair<Integer, Integer>(n, 0));  // <第几个数字，经历了几段路径走到这个数字> 初始化

        while(!queue.isEmpty()){
            Pair<Integer, Integer> front = queue.removeFirst();  //取出队首的元素
            int num = front.getKey();   //数字是多少
            int step = front.getValue(); //走了几段路径

            if(num == 0)
                return step;      //这就是解

            for(int i = 1 ; num - i*i >= 0 ; i ++)      //num还可以承受一个平方数
                queue.addLast(new Pair(num - i * i, step + 1));  //向结果队列中 推入 新的数据对
        }

        throw new IllegalStateException("No Solution.");
    }

    public static void main(String[] args) {

        System.out.println((new Solution1()).numSquares(12));
        System.out.println((new Solution1()).numSquares(13));
    }
}
