import java.util.HashMap;
import java.util.ArrayList;

// 350. Intersection of Two Arrays II
// https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
// 在意重复的元素次数
// 时间复杂度: O(len(nums1)+len(nums2))
// 空间复杂度: O(len(nums1))
public class Solution350 {

    public int[] intersect(int[] nums1, int[] nums2) {

        //之前选用的是treeMap，O（logN）用不到那么多的功能，换成HashMap,O(1),效率更高，只需要查找功能
        HashMap<Integer, Integer> record = new HashMap<Integer, Integer>(); 
        for(int num: nums1)
            if(!record.containsKey(num))   //新元素全部加入到map中，次数记录为1
                record.put(num, 1);
            else
                record.put(num, record.get(num) + 1);  //出现过的元素，将value值+1

        ArrayList<Integer> result = new ArrayList<Integer>();//最后结果放在list中，选Array速度更快
        for(int num: nums2)
            if(record.containsKey(num) && record.get(num) > 0){  //第二个数组中的元素在第一个数组中也有并且出现的次数 >0
                result.add(num);  //添加到结果动态数组中
                record.put(num, record.get(num) - 1); //将两次都出现过的元素，在第一次记录map中，次数-1
            }

        int[] ret = new int[result.size()];  //将list转为数组
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
        int[] res = (new Solution350()).intersect(nums1, nums2);
        printArr(res);
    }
}