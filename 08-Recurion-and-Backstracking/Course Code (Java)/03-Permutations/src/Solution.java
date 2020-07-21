/* 给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
] */

//全排列问题  回溯法 递归树
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {

    private ArrayList<List<Integer>> res;
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {   // permute 全排列

        res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return res;

        used = new boolean[nums.length];
        LinkedList<Integer> p = new LinkedList<Integer>();
        generatePermutation(nums, 0, p);

        return res;
    }

    // p中保存了一个有index-1个元素的排列。
    // 向这个排列的末尾添加第index个元素, 获得一个有index个元素的排列
    private void generatePermutation(int[] nums, int index, LinkedList<Integer> p){ // index 正在处理第几个元素 

        if(index == nums.length){  // 终止条件
            res.add((LinkedList<Integer>)p.clone());
            return;
        }

        for(int i = 0 ; i < nums.length ; i ++)   //回溯
            if(!used[i]){           
                p.addLast(nums[i]);     // nums[i]没有被使用过，才可以加入到list中
                used[i] = true;
                generatePermutation(nums, index + 1, p );
                p.removeLast();  // 把最后一个元素退出
                used[i] = false;  // 修改为没有使用过
            }

        return;
    }

    private static void printList(List<Integer> list){
        for(Integer e: list)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        List<List<Integer>> res = (new Solution()).permute(nums);
        for(List<Integer> list: res)
            printList(list);
    }
}
