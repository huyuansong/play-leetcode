import java.util.Arrays;

/// 198. House Robber
/// https://leetcode.com/problems/house-robber/description/
/// 记忆化搜索, 优化状态转移 逻辑更加的清晰
/// 时间复杂度: O(n)
/// 空间复杂度: O(n)
public class Solution5 {

    // memo[i] 表示考虑抢劫 nums[i...n) 所能获得的最大收益
    private int[] memo;

    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return tryRob(nums, 0);
    }

    // 考虑抢劫nums[index...nums.size())这个范围的所有房子
    private int tryRob(int[] nums, int index){

        if(index >= nums.length)  // 没有房子可以抢了，递归开始回溯的地方
            return 0;

        if(memo[index] != -1)
            return memo[index]

        // 当前房子要么抢，要么不抢，只有两种可能，换句话说：
        // 要么当前房子放弃, 从下一个房子开始考虑 ，要么抢劫当前的房子, 从i+2以后的房子开始考虑  逻辑更加的直观
        return memo[index] =
                Math.max(tryRob(nums, index + 1),
                         nums[index] + tryRob(nums, index + 2));
    }

    public static void main(String[] args) {

        int nums[] = {2, 1};
        System.out.println((new Solution5()).rob(nums));
    }
}
