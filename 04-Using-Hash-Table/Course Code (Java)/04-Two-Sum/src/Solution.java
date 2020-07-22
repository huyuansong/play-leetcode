import java.util.HashMap;

// 1. Two Sum
// https://leetcode.com/problems/two-sum/description/
// 一个数组中选出两个元素，sum1+sum2 == target
// 时间复杂度：O(n)
// 空间复杂度：O(n)
public class Solution {

    public int[] twoSum(int[] nums, int target) {

        //需要记录两个因子，因此选择map结构，而不是set。只需要查找的功能，HashMap就够了，不需要TreeMap
        HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();  //map<元素的值，元素所在的索引>
        for(int i = 0 ; i < nums.length; i ++){

            int complement = target - nums[i];   //求出第二个值是什么
            if(record.containsKey(complement)){  //第二个值在map中
                int[] res = {i, record.get(complement)}; //返回当前的元素位置 + map中元素的位置 ；第一轮循环肯定没有值
                return res;
            }

            record.put(nums[i], i);  //依次把元素加入到map中，但是需要放在后面；因为放到判断的前面可能导致key值覆盖的问题
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
