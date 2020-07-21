import java.util.*;

// 283. Move Zeroes
// https://leetcode.com/problems/move-zeroes/description/
/* 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:

必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。
 */
// 时间复杂度: O(n)
// 空间复杂度: O(n)
class Solution1 {

    public void moveZeroes(int[] nums) {

        ArrayList<Integer> nonZeroElements = new ArrayList<Integer>();

        // 将vec中所有非0元素放入nonZeroElements中
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != 0)
                nonZeroElements.add(nums[i]);

        // 将nonZeroElements中的所有元素依次放入到nums开始的位置
        for (int i = 0; i < nonZeroElements.size(); i++)
            nums[i] = nonZeroElements.get(i);

        // 将nums剩余的位置放置为0
        for (int i = nonZeroElements.size(); i < nums.length; i++)
            nums[i] = 0;
    }


    public static void main(String args[]){

        int[] arr = {0, 1, 0, 3, 12};

        (new Solution1()).moveZeroes(arr);

        for(int i = 0 ; i < arr.length ; i ++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}