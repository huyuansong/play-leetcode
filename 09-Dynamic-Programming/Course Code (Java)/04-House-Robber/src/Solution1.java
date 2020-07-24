import java.util.Arrays;

/// 198. House Robber
/// https://leetcode.com/problems/house-robber/description/
/// 画出抢劫的树形图 + 记忆化搜索
/// 时间复杂度: O(n^2)
/// 空间复杂度: O(n)
public class Solution1 {

    // memo[i] 表示考虑抢劫 nums[i...n) 所能获得的最大收益
    private int[] memo;

    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return tryRob(nums, 0);
    }

    // 考虑抢劫nums[index...nums.size())这个范围的所有房子
    private int tryRob(int[] nums, int index){

        if(index >= nums.length)  // 递归开始收敛回归的地方
            return 0;

        if(memo[index] != -1){    // 从【index … n ）这个范围的已经考虑过收益了,这个子块就不用再次计算了，直接用就好
            return memo[index];
        }

        int res = 0;
        for(int i = index ; i < nums.length ; i ++){ 
            res = Math.max( res, nums[i] + tryRob(nums, i + 2));  // 新房子i的位置，要么抢，要么不抢，看哪一个策略收益更大  
            // 当i=length-1  max中考虑的范围就变成了[length+1 , length) 而当index=length+1的时候，直接返回0，也就是整个递归开始收敛回归的开始
        }
        memo[index] = res;  // 考虑抢劫[index …… n]范围的最大收益  ，index不一定要抢的，只是index的房子在考虑的范围之内
        
        return res;
    }

    public static void main(String[] args) {

        int nums[] = {2, 1,5,7,8,4};
        System.out.println((new Solution1()).rob(nums));
    }
}
