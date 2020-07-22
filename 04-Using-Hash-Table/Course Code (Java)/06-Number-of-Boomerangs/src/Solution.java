import java.util.HashMap;

// 447. Number of Boomerangs
// https://leetcode.com/problems/number-of-boomerangs/description/
/*
给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。

找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。

示例:

输入:
[[0,0],[1,0],[2,0]]

输出:
2

解释:
两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]


求一个点到两个点的距离相等
转换为 到中心点的距离相等的点 有多少个， 然后map查询
*/
// 时间复杂度: O(n^2)
// 空间复杂度: O(n)

public class Solution {

    public int numberOfBoomerangs(int[][] points) {  

        int res = 0;
        for( int i = 0 ; i < points.length ; i ++ ){

            // record中存储 点i 到所有其他点的距离出现的频次
            HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();   //<距离，满足距离的点的个数>
            for(int j = 0 ; j < points.length ; j ++)
                if(j != i){
                    // 计算距离时不进行开根运算, 以保证精度
                    int dis = dis(points[i], points[j]);
                    if(record.containsKey(dis))
                        record.put(dis, record.get(dis) + 1);
                    else
                        record.put(dis, 1);
            }

            for(Integer dis: record.keySet())
                res += record.get(dis) * (record.get(dis) - 1);   //排列组合，求共有多少种可能性
        }

        return res;
    }

    private int dis(int[] pa, int pb[]){
        return (pa[0] - pb[0]) * (pa[0] - pb[0]) +
               (pa[1] - pb[1]) * (pa[1] - pb[1]);
    }

    public static void main(String[] args) {

        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        System.out.println((new Solution()).numberOfBoomerangs(points));
    }
}
