import java.util.TreeSet;

// 349. Intersection of Two Arrays
// https://leetcode.com/problems/intersection-of-two-arrays/description/
/* 
Given two arrays, write a function to compute their intersection.  计算两个数组的交集
Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Note:

Each element in the result must be unique.
The result can be in any order. 
*/
//这种问题，需要记录每个元素曾经出现的频次相关信息，一般使用set或者map，不需要知道顺序，且记录一个信息，set就够了
// 时间复杂度: O(nlogn)
// 空间复杂度: O(n)
public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {

        TreeSet<Integer> record = new TreeSet<Integer>();  //定义一个set记录元素曾经时候出现过，且只记录不同的元素
        for(int num: nums1)     
            record.add(num);      //遍历数组1，数组中出现过的不同的元素全部加入到set中

        TreeSet<Integer> resultSet = new TreeSet<Integer>();  //再来一个set记录，记录两个数组都出现过的元素
        for(int num: nums2)
            if(record.contains(num))  //第一个set出现过
                resultSet.add(num);   //加入到第二个set中，也就是最后的结果

        int[] res = new int[resultSet.size()];  //定义一个和结果set一样大小的数组
        int index = 0;
        for(Integer num: resultSet)  //将集合中的元素全部转移到数组中去  增强for循环，底层使用迭代器的方式
            res[index++] = num;

        return res;
    }

    private static void printArr(int[] arr){
        for(int e: arr)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] res = (new Solution()).intersection(nums1, nums2);
        printArr(res);
    }
}
