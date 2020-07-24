//import java.util.Arrays;

/// 198. House Robber
/// https://leetcode.com/problems/house-robber/description/
/// 动态规划  自底向上解决问题
/// 时间复杂度: O(n^2)
/// 空间复杂度: O(n)
public class Solution2 {

    public int rob(int[] nums) {  // nums 房子的排列顺序 返回值：抢劫的收益

        int n = nums.length;  // 要抢的房子有多少家
        if(n == 0)   // 没有房子可以抢
            return 0; // 收益当然是0

        // memo[i] 表示考虑抢劫 nums[i...n) 或者nums[i...n-1] 所能获得的最大收益
        int[] memo = new int[nums.length]; // memo[o] 考虑[0...n) 全部的房子  memo[length-1,length) 考虑最后一家房子
        memo[n - 1] = nums[n - 1];   // nums[n-1] ：最后一家里的财富 当只考虑抢劫[n-1,n) ,只有一家的时候，抢了才是收益最大的，整个递推的开始
        for(int i = n - 2 ; i >= 0 ; i --)   // 有了两家要考虑，需要开始计算。从 倒数第二家开始往前考虑 递推 考虑偷的家数越来越多，直到考虑偷全部
            // 求解memo[i]
            for (int j = i; j < n; j++)      // 从要考虑的这一家i开始，到最后一家n-1
                memo[i] = Math.max( memo[i], // memo[i] 在第一轮的时候永远为默认值0，在这层for循环执行一次后表示要抢这一家就有了目前的max值，j++向后移动，表示j这家不抢。然后和上一轮抢j家做收益大小比较
                                    nums[j] + (j + 2 < n ? memo[j + 2] : 0)); // [j,n-1] j这一家是一定要抢的,如果不抢，那就把j++表示不抢j这家。 i是从最后一家往前考虑的，后面的memo一定是计算过的

        return memo[0];
    }

    public static void main(String[] args) {

        int nums[] = {3, 2, 1};
        System.out.println((new Solution2()).rob(nums));
    }
}
