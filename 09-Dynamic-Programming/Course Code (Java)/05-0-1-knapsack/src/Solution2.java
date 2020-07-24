/// 背包问题
/// 动态规划
/// 时间复杂度: O(n * C) 其中n为物品个数; C为背包容积
/// 空间复杂度: O(n * C)
public class Solution2 {

    public int knapsack01(int[] w, int[] v, int C){

        if(w == null || v == null || w.length != v.length)
            throw new IllegalArgumentException("Invalid w or v");

        if(C < 0)
            throw new IllegalArgumentException("C must be greater or equal to zero.");

        int n = w.length;
        if(n == 0 || C == 0)
            return 0;

        int[][] memo = new int[n][C + 1];  // 物品为[0..n-1] n个物品，容量 [1..C] 容积为0的位置被浪费，只能申请C+1 个空间

        for(int j = 0 ; j <= C ; j ++)  
            memo[0][j] = (j >= w[0] ? v[0] : 0 ); // 只放0号物品，当背包的空间放的下0号物品时，数组在[0,j]位置的价值变为0号物品的价值，否则前面所有位置[0][0..j-1]价值为0

        for(int i = 1 ; i < n ; i ++)    // 0号物品比较特殊，已经在上面填充了数组，这里从1号物品开始
            for(int j = 0 ; j <= C ; j ++){  // 容积从0开始，直到填满整个背包
                memo[i][j] = memo[i-1][j];  // 当前的位置不放置i号物品，价值还是为不放i号物品时的价值
                if(j >= w[i])   // 背包当前的容积j可以放得下i号物品w[i]
                    memo[i][j] = Math.max(memo[i][j], v[i] + memo[i - 1][j - w[i]]); // 当前的价值为 max(不放i号物品的价值，放i号物品+之前的容积下的价值)
            }

        return memo[n - 1][C];
    }

    public static void main(String[] args) {

    }
}
