import java.util.*;
import java.util.HashMap;

import javafx.util.Pair;

// 347. Top K Frequent Elements
// https://leetcode.com/problems/top-k-frequent-elements/description/
/* 
给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

示例 1:
输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:
输入: nums = [1], k = 1
输出: [1]

提示：
你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
你可以按任意顺序返回答案。  */
// 时间复杂度: O(nlogk)
// 空间复杂度: O(n + k)
class Solution {

    private class PairComparator implements Comparator<Pair<Integer, Integer>>{   //保证创建的优先队列是最小堆

        @Override
        public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2){
            if(p1.getKey() != p2.getKey())
                return p1.getKey() - p2.getKey();
            return p1.getValue() - p2.getValue();
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        if(k <= 0)
            throw new IllegalArgumentException("k should be greater than 0");

        // 统计每个元素出现的频率
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();  //<元素，频率>
        for(int i = 0 ; i < nums.length ; i ++)
            if(freq.containsKey(nums[i]))
                freq.put(nums[i], freq.get(nums[i]) + 1);
            else
                freq.put(nums[i], 1);

        if(k > freq.size())     //k超过元素的种类个数就没有意义了
            throw new IllegalArgumentException("k should be less than the number of unique numbers in nums");

        // 扫描freq,维护当前出现频率最高的k个元素
        // 在优先队列中,按照频率排序,所以数据对是 (频率,元素) 的形式  O(nlogk)
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<Pair<Integer, Integer>>(new PairComparator());  //logK  最小堆 因为要淘汰频率最小的堆顶元素
        for(Integer num: freq.keySet()){    //o(n)
            int numFreq = freq.get(num);
            if(pq.size() == k){
                if(numFreq > pq.peek().getKey()){
                    pq.poll();                      //优先队列中的数据被淘汰
                    pq.add(new Pair(numFreq, num)); //加入新的具有更高频率的数据
                }
            }
            else
                pq.add(new Pair(numFreq, num));   //优先队列还没有满，是新数据都加入
        }

        ArrayList<Integer> res = new ArrayList<Integer>();
        while(!pq.isEmpty())
            res.add(pq.poll().getValue());   //把优先队列 首元素取出来

        return res;
    }

    private static void printList(List<Integer> nums){
        for(Integer num: nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        printList((new Solution()).topKFrequent(nums, k));
    }
}
