import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/// 77. Combinations  组合问题
/// https://leetcode.com/problems/combinations/description/
/* 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
/// 时间复杂度: O(n^k)
/// 空间复杂度: O(k)
//  优化 剪枝
public class Solution {

    private ArrayList<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {

        res = new ArrayList<List<Integer>>();
        if(n <= 0 || k <= 0 || k > n)
            return res;

        LinkedList<Integer> c = new LinkedList<Integer>();
        generateCombinations(n, k, 1, c);

        return res;
    }

    // 求解C(n,k), 当前已经找到的组合存储在c中, 需要从start开始搜索新的元素
    private void generateCombinations(int n, int k, int start, LinkedList<Integer> c){

        if(c.size() == k){
            res.add((List<Integer>)c.clone());
            return;
        }

        
        // c.size 个元素是已经选取的，还剩下 k-size 个元素要选取 ，提供选择的元素范围是【i，n】至少要有这么多个元素 
        // 区间长度 n-i+1 >= (k-size) ， 那么 i <= n - (k-size) + 1
        // 这里就做到了优化的功能， 这个过程有一个优雅的名字 叫做 剪枝
        for(int i = start ; i <= n - (k - c.size()) + 1 ; i ++){
            c.addLast(i);      // 考虑这个元素
            generateCombinations(n, k, i + 1, c);
            c.removeLast();   // 回溯
        }

        return;
    }

    private static void printList(List<Integer> list){
        for(Integer e: list)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        List<List<Integer>> res = (new Solution()).combine(4, 2);
        for(List<Integer> list: res)
            printList(list);
    }
}
