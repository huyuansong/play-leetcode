import java.util.HashMap;

// 1. Two Sum
// https://leetcode.com/problems/two-sum/description/
//
// 由于题目中只要求求出唯一的一个解。因此可以在最初的时候遍历整个数组, 将数组中的每个数字的索引放在map中。
// 此时, record中记录的永远是每一个数字最后出现的位置。
// 而对于 target = 2*a的情况, 如果nums中有两个或两个以上a,
// 我们在扫描时会先看到第一个a, 而从record中拿到的是最后一个a :)
/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/
// 时间复杂度：O(n)
// 空间复杂度：O(n)
public class Solution2 {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> record = new HashMap<Integer, Integer>(); // <数组中的值，值的索引>
        for(int i = 0 ; i < nums.length ; i ++)   // 由于键不能重复，所以里面的重复元素至少有一个，放在循环前面也可以
            record.put(nums[i], i);

        for(int i = 0 ; i < nums.length; i ++){            //第一个值的索引 i

            Integer index = record.get(target - nums[i]); //第二个值的索引index
            if(index != null && index != i){   //第二个值的索引index和第一个值的索引i不相等，说明不是同一个元素
                int[] res = {i, index};   
                return res;
            }
        }

        throw new IllegalStateException("the input has no solution");
    }

    private static void printArr(int[] nums){
        for(int num: nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {0,4,3,0};
        int target = 0;
        printArr((new Solution()).twoSum(nums, target));
    }
}
