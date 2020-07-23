import java.util.Arrays;

public class Solution1 {

    private int[] memo;

    public int climbStairs(int n) {
        memo = new int[n+1];  // 因为有 0 …… n 个阶段的数据都需要存储 共 n+1 个
        Arrays.fill(memo, -1);
        return calcWays(n);
    }

    private int calcWays(int n){

        if(n == 0 || n == 1)    // 最小子问题
            return 1;

        if(memo[n] == -1)      // -1 说明还没有被覆盖掉初始化的值 ，数组实现记忆化存储  
            memo[n] = calcWays(n - 1) + calcWays(n - 2);  // 自上而下 递归调用

        return memo[n];
    }

    public static void main(String[] args) {

        System.out.println((new Solution1()).climbStairs(10));
    }
}
