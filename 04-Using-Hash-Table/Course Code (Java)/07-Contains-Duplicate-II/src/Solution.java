import java.util.HashSet;

// 219. Contains Duplicate II
// https://leetcode.com/problems/contains-duplicate-ii/description/
/*
Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the 
给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。

示例 1:

输入: nums = [1,2,3,1], k = 3
输出: true
示例 2:

输入: nums = [1,0,1,1], k = 1
输出: true
示例 3:

输入: nums = [1,2,3,1,2,3], k = 2
输出: false

num[i] = num[j] |i-j|<=k   

*/
// 时间复杂度: O(n)
// 空间复杂度: O(k)
public class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {  // 依旧是滑动窗口的思想，只是这一次窗口的大小是固定的长度，只是需要移动窗口的位置

        if(nums == null || nums.length <= 1)
            return false;

        if(k <= 0)
            return false;

        HashSet<Integer> record = new HashSet<Integer>(); //
        for(int i = 0 ; i < nums.length; i ++){
            if(record.contains(nums[i]))    //窗口的长度始终维持在k之内，如果窗口中已经包含了这个新的元素，那么肯定是满足题目答案要求的
                return true;

            record.add(nums[i]);   //把元素加入到record窗口中
            if(record.size() == k + 1)  //如果set窗口的大小已经开始超过K的长度了，需要移除窗口左侧的元素，维持窗口的长度为K
                record.remove(nums[i-k]);  //应该把窗口左侧的元素从set窗口左侧（i-k）移除  i表示窗口右侧当前的元素，k表示窗口的长度 
        }

        return false;
    }

    private static void printBool(boolean b){
        System.out.println(b ? "True" : "False");
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 1};
        int k = 1;
        printBool((new Solution()).containsNearbyDuplicate(nums, k));
    }
}
