import java.util.LinkedList;
import javafx.util.Pair;

// 279. Perfect Squares
// https://leetcode.com/problems/perfect-squares/description/
// 进一步优化
/* 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

示例 1:

输入: n = 12
输出: 3 
解释: 12 = 4 + 4 + 4.
示例 2:

输入: n = 13
输出: 2
解释: 13 = 4 + 9.
 */
// 时间复杂度: O(n)
// 空间复杂度: O(n)
public class Solution3 {

    public int numSquares(int n) {

        if(n == 0)
            return 0;

        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<Pair<Integer, Integer>>();
        queue.addLast(new Pair<Integer, Integer>(n, 0));

        boolean[] visited = new boolean[n+1];
        visited[n] = true;

        while(!queue.isEmpty()){
            Pair<Integer, Integer> front = queue.removeFirst();
            int num = front.getKey();
            int step = front.getValue();

            if(num == 0)
                return step;

            // for(int i = 1 ; num - i*i >= 0 ; i ++){   //num - i*i 不要被反复重复计算
            //     int a = num - i*i;
            //     if(!visited[a]){
            //         if(a == 0) return step + 1;  //已经结束，可以提前结束
            //         queue.addLast(new Pair(num - i * i, step + 1));
            //         visited[num - i * i] = true;
            //     }
            // }

            for(int i = 1 ; ; i ++){   //num - i*i 不要被反复重复计算
                int a = num - i*i;
                if(a < 0)
                    break;
                if(!visited[a]){
                    if(a == 0) return step + 1;  //只经历了一步就已经到达0了，直接返回结果
                    queue.addLast(new Pair( a , step + 1));
                    visited[a] = true;
                }
            }
        }

        throw new IllegalStateException("No Solution.");
    }

    public static void main(String[] args) {

        System.out.println((new Solution3()).numSquares(12));
        System.out.println((new Solution3()).numSquares(13));
    }
}
