import java.util.LinkedList;
import javafx.util.Pair;

// 279. Perfect Squares
// https://leetcode.com/problems/perfect-squares/description/
// 使用visited数组,记录每一个入队元素
//
// 时间复杂度: O(n)
// 空间复杂度: O(n)
public class Solution2 {

    public int numSquares(int n) {

        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<Pair<Integer, Integer>>();
        queue.addLast(new Pair<Integer, Integer>(n, 0));

        boolean[] visited = new boolean[n+1];  //由于是图结构，一个节点会有多种途径到达，因此存在很多的重复推入队列
        visited[n] = true;  // n节点默认是访问过的

        while(!queue.isEmpty()){
            Pair<Integer, Integer> front = queue.removeFirst();
            int num = front.getKey();
            int step = front.getValue();

            if(num == 0)
                return step;

            for(int i = 1 ; num - i*i >= 0 ; i ++)
                if(!visited[num - i * i]){  //该数字还没有被访问
                    queue.addLast(new Pair(num - i * i, step + 1));
                    visited[num - i * i] = true;   //该数字已经被访问过了
                }
        }

        throw new IllegalStateException("No Solution.");
    }

    public static void main(String[] args) {

        System.out.println((new Solution2()).numSquares(12));
        System.out.println((new Solution2()).numSquares(13));
    }
}
