import java.util.Arrays;

/// 416. Partition Equal Subset Sum
/// https://leetcode.com/problems/partition-equal-subset-sum/description/
/* 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
注意:
每个数组中的元素不会超过 100
数组的大小不会超过 200

示例 1:
输入: [1, 5, 11, 5]
输出: true
解释: 数组可以分割成 [1, 5, 5] 和 [11].

示例 2:
输入: [1, 2, 3, 5]
输出: false
解释: 数组不能分割成两个元素和相等的子集.
*/
//  完全背包问题，挑选不知道多少个数据，要把包装满
/// 记忆化搜索  
/// 时间复杂度: O(len(nums) * O(sum(nums)))
/// 空间复杂度: O(len(nums) * O(sum(nums)))
public class Solution1 {

    // memo[i][c] 表示使用索引为[0...i]的这些元素,是否可以完全填充一个容量为c的背包
    // -1 表示为未计算; 0 表示不可以填充; 1 表示可以填充
    private int[][] memo;

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for(int i = 0 ; i < nums.length ; i ++){
            if(nums[i] <= 0)  // 题目所说都是正整数
                throw new IllegalArgumentException("numbers in nums must be greater than zero.");
            sum += nums[i];
        }

        if(sum % 2 == 1)    // 如果和为奇数，那就不用计算了，两个子集和相等 不管是奇数还是偶数，和都为偶数
            return false;

        memo = new int[nums.length][sum / 2 + 1];  // 辅助数组，有length个数据可选，和 只取一半 0的空间是浪费的，所以要+1
        for(int i = 0 ; i < nums.length ; i ++)
            Arrays.fill(memo[i], -1);   // 初始化
        return tryPartition(nums, nums.length - 1, sum / 2);  // 使用 [0..length-1] 全部的数据，填充sum/2 的背包
    }

    // 使用nums[0...index], 是否可以完全填充一个容量为sum的背包
    private boolean tryPartition(int[] nums, int index, int sum){

        if(sum == 0)
            return true;

        if(sum < 0 || index < 0)
            return false;

        if(memo[index][sum] != -1)
            return memo[index][sum] == 1;

        memo[index][sum] = (tryPartition(nums, index - 1, sum) ||   // 元素 index 不放进去
                tryPartition(nums, index - 1, sum - nums[index])) ? 1 : 0; // 元素 index 放进去

        return memo[index][sum] == 1;  // 就是想返回一个boolean类型，由于是 1或者0 ，这里转换一下
    }

    private static void printBool(boolean res){
        System.out.println(res ? "True" : "False");
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 5, 11, 5};
        printBool((new Solution1()).canPartition(nums1));

        int[] nums2 = {1, 2, 3, 5};
        printBool((new Solution1()).canPartition(nums2));
    }
}
