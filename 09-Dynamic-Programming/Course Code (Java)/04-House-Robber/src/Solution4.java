/// 198. House Robber
/// https://leetcode.com/problems/house-robber/description/
/// 动态规划, 改变状态定义
/// 时间复杂度: O(n^2)
/// 空间复杂度: O(n)
public class Solution4 {

    public int rob(int[] nums) {

        int n = nums.length;
        if(n == 0)
            return 0;

        // memo[i] 表示考虑抢劫 nums[0...i] 所能获得的最大收益
        int[] memo = new int[nums.length];
        memo[0] = nums[0];
        for(int i = 1 ; i < n ; i ++)  // 抢劫[0,i]范围的收益
            // 求memo[i]
            for (int j = i; j >= 0; j--) // i 这个位置抢不抢需要考虑，后面的抢不抢也需要考虑
                memo[i] = Math.max(memo[i], //memo[i]第一轮为默认值0，后来每一轮和前一轮的结果比较，选出最大值
                                   nums[j] + (j - 2 >= 0 ? memo[j - 2] : 0)); // j第一个位置默认是抢的，j--表示j位置不抢

        return memo[n-1];
    }

    public static void main(String[] args) {

        int nums[] = {2, 1};
        System.out.println((new Solution4()).rob(nums));
    }
}
