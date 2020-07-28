import java.util.Arrays;

/// 300. Longest Increasing Subsequence
/// https://leetcode.com/problems/longest-increasing-subsequence/description/
/* 

给定一个无序的整数数组，找到其中最长上升子序列的长度。

示例:

输入: [10,9,2,5,3,7,101,18]
输出: 4 
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
说明:

可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
你算法的时间复杂度应该为 O(n2) 。
进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
/// 记忆化搜索
/// 时间复杂度: O(n^2)
/// 空间复杂度: O(n)
public class Solution1 {

    private int[] memo;

    public int lengthOfLIS(int[] nums) {

        if(nums.length == 0)
            return 0;

        memo = new int[nums.length]; 
        Arrays.fill(memo, -1);
        int res = 1;  // 上升的子串最短也能有1个，就是自身
        for(int i = 0 ; i < nums.length ; i ++)         
            res = Math.max(res, getMaxLength(nums, i));  // 和之前的长度 res 比， 新的子串的长度 谁更长

        return res;
    }

    // 以 nums[index] 为结尾的最长上升子序列的长度
    private int getMaxLength(int[] nums, int index){

        if(memo[index] != -1)    
            return memo[index];

        int res = 1;
        for(int i = 0 ; i <= index-1 ; i ++)
            if(nums[index] > nums[i])  // index 位置的元素比前面位置的元素大，有可能会刷新最长长度
                res = Math.max(res, 1 + getMaxLength(nums, i));

        return memo[index] = res;  // 基于传入的index范围内的最大值
    }

    public static void main(String[] args) {

        int nums1[] = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println((new Solution1()).lengthOfLIS(nums1));
        // 4

        // ---

        int nums2[] = {4, 10, 4, 3, 8, 9};
        System.out.println((new Solution1()).lengthOfLIS(nums2));
        // 3

        // ---

        int nums3[] = {2, 2};
        System.out.println((new Solution1()).lengthOfLIS(nums3));
        // 1

        // ---

        int nums4[] = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println((new Solution1()).lengthOfLIS(nums4));
        // 6
    }
}
