import java.util.HashMap;

// 447. Number of Boomerangs
// https://leetcode.com/problems/number-of-boomerangs/description/
/*
Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:

Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]

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
