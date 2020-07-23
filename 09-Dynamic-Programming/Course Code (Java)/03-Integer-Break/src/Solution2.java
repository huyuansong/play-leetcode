import java.util.Arrays;

/// 343. Integer Break
/// https://leetcode.com/problems/integer-break/description/

///  + 记忆化搜索 避免已经拆分过的数字在需要的时候多次拆分，用一个数组记录拆分过的数据
/// 时间复杂度: O(n^2)
/// 空间复杂度: O(n)
public class Solution2 {

    private int[] memo;

    public int integerBreak(int n) {

        if(n < 1)
            throw new IllegalArgumentException("n should be greater than zero");

        memo = new int[n+1];
        Arrays.fill(memo, -1);

        return breakInteger(n);
    }

    // 将n进行分割(至少分割两部分), 可以获得的最大乘积
    private int breakInteger(int n){

        if(n == 1)
            return 1;

        if(memo[n] != -1)
            return memo[n];

        int res = -1;
        for(int i = 1 ; i <= n - 1 ; i ++)
            res = max3(res, i * (n - i) , i * breakInteger(n - i));
        memo[n] = res;    // 因为这一段代码在递归函数中，所以n会从最小的2返回，然后是3……n   由于是递归，memo还得是一个全局变量才不会每次清0
        System.out.println("memn["+n+"] = "+memo[n]);
        return res;
    }

    private int max3(int a, int b, int c){
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {

        System.out.println((new Solution2()).integerBreak(2));
        System.out.println((new Solution2()).integerBreak(10));
    }
}
