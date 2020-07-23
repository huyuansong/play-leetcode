import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

/// 51. N-Queens
/// https://leetcode.com/problems/n-queens/description/
//  并回溯
/// 时间复杂度: O(n^n)
/// 空间复杂度: O(n)
public class Solution {

    private boolean[] col;
    private boolean[] dia1;
    private boolean[] dia2;
    private ArrayList<List<String>> res;

    public List<List<String>> solveNQueens(int n) {   // 返回值 ：所有解《一种可能的解《这种可能的解用字符串表示》》

        res = new ArrayList<List<String>>();  // 所有的 可能摆放情况的结果
        col = new boolean[n];   // 列
        dia1 = new boolean[2 * n - 1];   // 正对角线  diagonal
        dia2 = new boolean[2 * n - 1];   // 斜对角线

        LinkedList<Integer> row = new LinkedList<Integer>();  // 一行中唯一的一个皇后所在的位置（列）
        putQueen(n, 0, row);  // 整个尝试过程的开始  n皇后，第0行，第0行皇后所在的下标(列)

        return res;
    }

    // 尝试在一个n皇后问题中, 摆放第index行的皇后位置
    private void putQueen(int n, int index, LinkedList<Integer> row){   // row[i] 一行唯一的皇后的排放在第几个位置（列） index ：当前要放皇后的行 

        if(index == n){  // index 当前要放的皇后已经是最后一个皇后了，得到了1个解
            res.add(generateBoard(n, row));  //一个解（字符串组成的可视化解）
            return;
        }

        for(int i = 0 ; i < n ; i ++)
            // 尝试将第index行的皇后摆放在第i列
            if(!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]){  // 一行只放一个，不用判断行，列col[i] ,  对角线 斜对角线 都没有皇后
                row.addLast(i);  // 尝试放入i列
                col[i] = true;  //这一列不能再有其他皇后了
                dia1[index + i] = true;  // 这一列所在的正对角线不能再有了
                dia2[index - i + n - 1] = true;  // 斜对角线不能再有了
                putQueen(n, index + 1, row);  // 尝试下一个位置
                col[i] = false; // 回溯 当前列撤回 ，假设第index行放入的不是i当前的列1，而是[2……n]中的其他一列
                dia1[index + i] = false;  // 当前列所在的正对角线撤回
                dia2[index - i + n - 1] = false; // 斜对角线
                row.removeLast();  // 真正的从记录结果的 row 中撤回 ，上面只是访问标记撤回
            }

        return;
    }
    // 生成一个解
    private List<String> generateBoard(int n, LinkedList<Integer> row){  // row[i] 第i行的那一个皇后所处的第几个位置（列）

        assert row.size() == n;

        ArrayList<String> board = new ArrayList<String>();  // 存放 一种可能的摆放方式 
        for(int i = 0 ; i < n ; i ++){      // 一共有n行
            char[] charArray = new char[n];  // 创建一行的位置空间
            Arrays.fill(charArray, '.');     // 默认时全部没有皇后
            charArray[row.get(i)] = 'Q';     // row[i] 由于一行只能有一个皇后，row[i] 表示 第i行的那一个皇后的所处的第几个位置
            board.add(new String(charArray));  // 把当前行字符数组转为字符串， 存储在一个解的结果图中
        }
        return board;
    }

    private static void printBoard(List<String> board){
        for(String s: board)  // 每一个元素是一行
            System.out.println(s);
        System.out.println();  // 一个解与其他解之间的分割
    }

    public static void main(String[] args) {

        int n = 5;
        List<List<String>> res = (new Solution()).solveNQueens(n);   // 全部解list < 一个解list <一个解的多行String> >
        for(List<String> board: res)
            printBoard(board);
    }
}
