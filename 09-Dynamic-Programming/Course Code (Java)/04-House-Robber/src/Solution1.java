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

    // 考虑抢劫nums[index...nums.length-1]这个范围的所有房子
    private int tryRob(int[] nums, int index){

        if(index >= nums.length)  // 递归开始收敛回归的地方
            return 0;

        if(memo[index] != -1){    // 从【index … n ）这个范围的已经计算过收益了,这个子块就不用再次计算了，递归直接返回结果，无需再次深入底层递归
            return memo[index];
        }

        int res = 0;
        for(int i = index ; i < nums.length ; i ++){ 
            res = Math.max( res, nums[i] + tryRob(nums, i + 2));  // res第一轮永远为0，房子i第一次循环是一定要抢的，如果不抢，下一轮i++,表示i位置不抢，看哪一个策略收益更大  
            // 因为开始调用时，传进来的index=0 ，递归很深，产生递归树
            // 当i=length-2 倒数第2次循环： 递归触底回溯 ，max(res,nums[n-2] + 0 )  每回溯一步，结果就保存在下面的memo[index]即 memo[length-2] 中
            // 当i=length-1 最后一次循环： 递归触底的开始值 ，max（res=0 , nums[length-1]+0 ) 得到了具体值，开始回溯，结果就保存在下面的memo[length-1]中
        }
        memo[index] = res;  // 考虑抢劫[index …… n]范围的最大收益  ，index家不一定抢，只是index的房子在考虑的范围之内
        
        return res;
    }

    public static void main(String[] args) {

        int nums[] = {2, 1,5,7,8,4};
        System.out.println((new Solution1()).rob(nums));
    }
}
