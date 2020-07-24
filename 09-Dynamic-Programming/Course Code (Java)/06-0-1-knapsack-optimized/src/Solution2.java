/// 背包问题
/// 动态规划改进
/// 时间复杂度: O(n * C) 其中n为物品个数; C为背包容积
/// 空间复杂度: O(C), 只使用了C的额外空间
public class Solution2 {

    public int knapsack01(int[] w, int[] v, int C){

        if(w == null || v == null || w.length != v.length)
            throw new IllegalArgumentException("Invalid w or v");

        if(C < 0)
            throw new IllegalArgumentException("C must be greater or equal to zero.");

        int n = w.length;
        if(n == 0 || C == 0)
            return 0;

        int[] memo = new int[C+1];  // 其实一行的空间也够用

        for(int j = 0 ; j <= C ; j ++)
            memo[j] = (j >= w[0] ? v[0] : 0);  // 只放0号物品，把数组中的第一行初始数据建立起来 memo[0..C] 全部有值

        for(int i = 1 ; i < n ; i ++)
            for(int j = C ; j >= w[i] ; j --)  // 由于后面物品的容积只参照前面物品的容积数据，所以从后往前依次覆盖掉不会再使用的数据
                memo[j] = Math.max(memo[j], v[i] + memo[j - w[i]]); // [只放i号物品 ... 刚好放的下i号物品] 中的最大的价值 从0号物品开始迭代，开始+v[i]迭代

        return memo[C];
    }

    public static void main(String[] args) {

    }
}
