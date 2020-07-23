/// 79. Word Search
/// Source : https://leetcode.com/problems/word-search/description/
/* 给定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

示例:
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false
 */
/// 回溯法   思路非常简单 代码需要很多的第三方标志变量，考察代码能力，逻辑简单
/// 时间复杂度: O(m*n*m*n)
/// 空间复杂度: O(m*n)
public class Solution {

    private int d[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};  // 按照这样的方位顺序依次扫描对应的字母并比较
    private int m, n;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {   // 用来处理各种异常情况

        if(board == null || word == null)
            throw new IllegalArgumentException("board or word can not be null!");

        m = board.length;  // 有多少行
        if(m == 0)
            throw new IllegalArgumentException("board can not be empty.");
        n = board[0].length;   // 有多少列
        if(n == 0)
            throw new IllegalArgumentException("board can not be empty.");

        visited = new boolean[m][n];   // 用来判断这个位置的元素是否被访问过
        for(int i = 0 ; i < m ; i ++)
            for(int j = 0 ; j < n ; j ++)
                if(searchWord(board, word, 0, i, j))
                    return true;

        return false;
    }

    private boolean inArea( int x , int y ){
        return x >= 0 && x < m && y >= 0 && y < n;   // x 向下 ， y 向右 坐标系
    }

    // 从board[startx][starty]开始, 寻找word[index...word.size())
    private boolean searchWord(char[][] board, String word, int index,
                               int startx, int starty){

        //assert(inArea(startx,starty));
        if(index == word.length() - 1)     // 已经找到了一个满足字符串长度的序列了
            return board[startx][starty] == word.charAt(index); // 前面的元素都满足条件了，只剩下判断最后一位元素是否相等

        if(board[startx][starty] == word.charAt(index)){  // 当前位置的元素是匹配的
            visited[startx][starty] = true;
            // 从startx, starty出发,向四个方向寻
            for(int i = 0 ; i < 4 ; i ++){
                int newx = startx + d[i][0];   // {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}  [][0] 只取{X上下，Y左右} X上下的值，上下移动
                int newy = starty + d[i][1];   // [][1] 只取上述集合中的右侧的值，在左右做移动
                if(inArea(newx, newy) && !visited[newx][newy] &&   // 在要扫描的区域，且没有访问过
                        searchWord(board, word, index + 1, newx, newy))
                    return true;
            }
            visited[startx][starty] = false;  // 回溯，假设回到这个位置没有被访问过的时候，再去访问4个中其他可能的位置
        }
        return false;
    }

    public static void main(String args[]){

        char[][] b1 = { {'A','B','C','E'},
                        {'S','F','C','S'},
                        {'A','D','E','E'}};

        String words[] = {"ABCCED", "SEE", "ABCB" };
        for(int i = 0 ; i < words.length ; i ++)
            if((new Solution()).exist(b1, words[i]))
                System.out.println("found " + words[i]);
            else
                System.out.println("can not found " + words[i]);

        // ---

        char[][] b2 = {{'A'}};
        if((new Solution()).exist(b2,"AB"))
            System.out.println("found AB");
        else
            System.out.println("can not found AB");
    }
}
