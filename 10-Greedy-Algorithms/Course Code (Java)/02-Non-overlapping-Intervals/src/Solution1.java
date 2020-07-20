import java.util.Arrays;
import java.util.Comparator;

/// 435. Non-overlapping Intervals
/// https://leetcode.com/problems/non-overlapping-intervals/description/
// Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
// Example 1:
// Input: [[1,2],[2,3],[3,4],[1,3]]
// Output: 1
// Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
// 给定一个区间，求出最小要删除的空间的个数，保证剩下的空间不重叠   组合问题-> 动态规划
/// 动态规划
/// 时间复杂度: O(n^2)
/// 空间复杂度: O(n)
public class Solution1 {

    // Definition for an interval.
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public int eraseOverlapIntervals(Interval[] intervals) {   

        if(intervals.length == 0)
            return 0;

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {     // 自定义规则比较对象的大小
                if(o1.start != o2.start)
                    return o1.start - o2.start;   // 起始点不同，谁的起始点靠前，谁就大
                return o1.end - o2.end;     // 谁先结束 ，谁靠前
            }
        });

        // memo[i]表示以intervals[i]为结尾的区间能构成的最长不重叠区间序列
        int[] memo = new int[intervals.length];
        Arrays.fill(memo, 1);    // 初始互不重叠，全部初始化为1 
        for(int i = 1 ; i < intervals.length ; i ++)  // i=0 的时候，只有一个区间，不重叠，符合初始化的情况
            // memo[i]
            for(int j = 0 ; j < i ; j ++)     // 
                if(intervals[i].start >= intervals[j].end)  //第i个区间可以跟在j的后面 那么长度就可以+1
                    memo[i] = Math.max(memo[i], 1 + memo[j]);

        int res = 0;
        for(int i = 0; i < memo.length ; i ++)
            res = Math.max(res, memo[i]);

        return intervals.length - res;   // 需要删除的区间长度
    }

    public static void main(String[] args) {
        Interval[] interval1 = {new Interval(1,2),
                                new Interval(2,3),
                                new Interval(3,4),
                                new Interval(1,3)};
        System.out.println((new Solution1()).eraseOverlapIntervals(interval1));

        Interval[] interval2 = {new Interval(1,2),
                                new Interval(1,2),
                                new Interval(1,2)};
        System.out.println((new Solution1()).eraseOverlapIntervals(interval2));

        Interval[] interval3 = {new Interval(1,2),
                                new Interval(2,3)};
        System.out.println((new Solution1()).eraseOverlapIntervals(interval3));
    }
}
