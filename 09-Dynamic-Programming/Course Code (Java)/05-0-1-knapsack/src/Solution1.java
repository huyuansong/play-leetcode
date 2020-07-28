/// 背包问题
/// 记忆化搜索
/// 时间复杂度: O(n * C) 其中n为物品个数; C为背包容积
/// 空间复杂度: O(n * C)
public class Solution1 {

    private int[][] memo;

    public int knapsack01(int[] w, int[] v, int C){  // w 物品的重量 v 物品的价值 C 背包的容量

        if(w == null || v == null || w.length != v.length) 
            throw new IllegalArgumentException("Invalid w or v");

        if(C < 0)
            throw new IllegalArgumentException("C must be greater or equal to zero.");

        int n = w.length;  // 物品的个数
        if(n == 0 || C == 0)
            return 0;

        memo = new int[n][C + 1];   // 辅助数组空间，物品为[0..n-1] n个物品，容量 [1..C] 容积为0的位置被浪费，只能申请C+1 个空间
        for(int i = 0; i < n; i ++)
            for(int j = 0; j <= C; j ++)
                memo[i][j] = -1;        // 初始化所有的空间为 -1
        return bestValue(w, v, n - 1, C);  // 最后一个物品编号n-1 ，尝试用全部的物品【0，n-1】装满背包
    }

    // 用 [0...index]的物品,填充容积为c的背包的最大价值 c为当前剩下的容积 C为背包的最大容积
    private int bestValue(int[] w, int[] v, int index, int c){

        if(c <= 0 || index < 0)
            return 0;

        if(memo[index][c] != -1)
            return memo[index][c];

        int res = bestValue(w, v, index-1, c);  // 当前物品index不放进背包时的最大价值
        if(c >= w[index])  // 背包当前剩下的容积 >= 当前物品所占的空间
            res = Math.max(res, v[index] + bestValue(w, v, index - 1, c - w[index]));  // 不放进去价值大，还是放进去之后的价值大

        return memo[index][c] = res;  // 把index号物品放进背包时的总价值存储下来
    }

    public static void main(String[] args) {

    }

}
