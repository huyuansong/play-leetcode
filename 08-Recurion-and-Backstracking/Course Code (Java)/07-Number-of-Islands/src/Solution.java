/// 200. Number of Islands
/// https://leetcode.com/problems/number-of-islands/description/
//  广度优先遍历，实现遍历所有的元素，然后回溯 ，按照一定的方位顺序搜索，出错回退
//  
/* 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
此外，你可以假设该网格的四条边均被水包围。

示例 1:

输入:
[
['1','1','1','1','0'],
['1','1','0','1','0'],
['1','1','0','0','0'],
['0','0','0','0','0']
]
输出: 1
示例 2:

输入:
[
['1','1','0','0','0'],
['1','1','0','0','0'],
['0','0','1','0','0'],
['0','0','0','1','1']
]
输出: 3
解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 */
/// 时间复杂度: O(n*m)
/// 空间复杂度: O(n*m)
class Solution {

    private int d[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};  // 依次搜索的方位顺序
    private int m, n;    // 整个区域的 行 列
    private boolean visited[][];

    public int numIslands(char[][] grid) {

        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        m = grid.length;      // 行 
        n = grid[0].length;   // 列

        visited = new boolean[m][n];

        int res = 0;
        for(int i = 0 ; i < m ; i ++)
            for(int j = 0 ; j < n ; j ++)
                if(grid[i][j] == '1' && !visited[i][j]){  // 没有被访问的陆地
                    dfs(grid, i, j);
                    res ++;   // 陆地的块数
                }

        return res;
    }

    // 从grid[x][y]的位置开始,进行floodfill
    // 保证(x,y)合法,且grid[x][y]是没有被访问过的陆地
    private void dfs(char[][] grid, int x, int y){

        //assert(inArea(x,y));
        visited[x][y] = true;
        for(int i = 0; i < 4; i ++){
            int newx = x + d[i][0];  // 0 1 0 -1  
            int newy = y + d[i][1];  // 1 0 -1 0
            if(inArea(newx, newy) && !visited[newx][newy] && grid[newx][newy] == '1')  // 递归允许的条件，终止的条件也就不用写了
                dfs(grid, newx, newy);  // 深度优先遍历
        }

        return;
    }

    private boolean inArea(int x, int y){
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {

        char grid1[][] = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        System.out.println((new Solution()).numIslands(grid1));
        // 1

        // ---

        char grid2[][] = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        System.out.println((new Solution()).numIslands(grid2));
        // 3
    }
}
