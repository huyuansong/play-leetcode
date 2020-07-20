import java.util.TreeMap;
import java.util.ArrayList;

// 350. Intersection of Two Arrays II
// https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
/*
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
*/

// 时间复杂度: O(nlogn)
// 空间复杂度: O(n)
public class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {

        TreeMap<Integer, Integer> record = new TreeMap<Integer, Integer>();  //因为题意需要在意出现的次数，这里用map记录出现过的元素 <元素的值，元素出现次数>
        for(int num: nums1)     
            if(!record.containsKey(num))      // map中还没有记录数组中的这个元素  map中的key是不可以重复的，因此也具有set的功能
                record.put(num, 1);           //添加到map中记录下来 
            else
                record.put(num, record.get(num) + 1); //map中已经出现过这个元素，把出现的次数+1

        ArrayList<Integer> result = new ArrayList<Integer>();  //
        for(int num: nums2)
            if(record.containsKey(num) && record.get(num) > 0){ //第二个数组中的元素也出现在map中，至少一次
                result.add(num);                        //确认出现过两次，可以直接加入到list中
                record.put(num, record.get(num) - 1);   //因为在意每个元素在数组中出现的次数，用掉一次就删除一次
            }

        int[] ret = new int[result.size()]; //把list转为数组存储
        int index = 0;
        for(Integer num: result)
            ret[index++] = num;

        return ret;
    }

    private static void printArr(int[] arr){
        for(int e: arr)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] res = (new Solution()).intersect(nums1, nums2);
        printArr(res);
    }
}
