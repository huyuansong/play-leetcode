/// 198. House Robber
/// https://leetcode.com/problems/house-robber/description/
/// 动态规划, 改变状态定义, 优化转移方程 逻辑更加的清晰
/// 时间复杂度: O(n)
/// 空间复杂度: O(n)
public class Solution8 {

    public int rob(int[] nums) {

        int n = nums.length;
        if(n == 0)
            return 0;

        // memo[i] 表示考虑抢劫 nums[0...i] 所能获得的最大收益
        int[] memo = new int[nums.length];
        memo[0] = nums[0];  // 递推开始条件
        for(int i = 1 ; i < n ; i ++)
            memo[i] = Math.max(memo[i - 1],  // i位置的房子放弃，直接考虑抢[0,i-1]
                               nums[i] + (i - 2 >= 0 ? memo[i - 2] : 0));  // i位置的房子确定是要抢了，只能考虑[0,i-2]范围且要在区间范围内
                            

        return memo[n-1];
    }

    public static void main(String[] args) {

        int nums[] = {2, 1};
        System.out.println((new Solution8()).rob(nums));
    }
}
