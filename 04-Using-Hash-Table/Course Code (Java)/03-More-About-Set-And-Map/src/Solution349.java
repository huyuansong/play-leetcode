import java.util.HashSet;

// 349. Intersection of Two Arrays
// https://leetcode.com/problems/intersection-of-two-arrays/description/
// 时间复杂度: O(len(nums1)+len(nums2))
// 空间复杂度: O(len(nums1))
public class Solution349 {

    public int[] intersection(int[] nums1, int[] nums2) {

        //之前用的是treeSet，虽然都是set，但是效率却不同。hashSet丢失了一些排序，顺序访问的功能，treeSet函数更加多一些，但是这道题里只用到了查找
        HashSet<Integer> record = new HashSet<Integer>(); 
        for(int num: nums1)
            record.add(num);  //把数组1的所有元素全部加入到set中

        HashSet<Integer> resultSet = new HashSet<Integer>();  //记录第二个数组中的最后结果
        for(int num: nums2)
            if(record.contains(num))  //第一个数组中也包含
                resultSet.add(num);   //可以加入到结果set中

        int[] res = new int[resultSet.size()];  //将set转换为数组
        int index = 0;
        for(Integer num: resultSet)  
            res[index++] = num;  //全部迁移到数组中

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
        int[] res = (new Solution349()).intersection(nums1, nums2);
        printArr(res);
    }
}