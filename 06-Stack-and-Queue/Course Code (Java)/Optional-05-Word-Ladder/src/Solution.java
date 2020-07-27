/// Source : https://leetcode.com/problems/word-ladder/description/
/* 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。
说明:

如果不存在这样的转换序列，返回 0。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
示例 1:

输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

输出: 5

解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     返回它的长度 5。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

/// BFS
/// Time Complexity: O(n*n)
/// Space Complexity: O(n)
public class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int end = wordList.indexOf(endWord);
        if(end == -1)
            return 0;

        if(!wordList.contains(beginWord))
            wordList.add(beginWord);
        int begin = wordList.indexOf(beginWord);

        int n = wordList.size();
        boolean[][] g = new boolean[n][n];
        for(int i = 0 ; i < n ; i ++)
            for(int j = 0 ; j < i ; j ++)
                g[j][i] = g[i][j] = similar(wordList.get(i), wordList.get(j));

        // bfs
        LinkedList<Integer> q = new LinkedList<>();
        int[] step = new int[n];

        q.addLast(begin);
        step[begin] = 1;
        while(!q.isEmpty()){

            int cur = q.removeFirst();

            for(int i = 0 ; i < n ; i ++)
                if(step[i] == 0 && g[cur][i]){
                    if(i == end)
                        return step[cur] + 1;
                    step[i] = step[cur] + 1;
                    q.addLast(i);
                }
        }

        return 0;
    }

    private boolean similar(String word1, String word2){

        if(word1.length() != word2.length() || word1.equals(word2))
            throw new IllegalArgumentException();

        int diff = 0;
        for(int i = 0 ; i < word1.length() ; i ++)
            if(word1.charAt(i) != word2.charAt(i)){
                diff ++;
                if(diff > 1)
                    return false;
            }
        return true;
    }

    public static void main(String[] args) {

        ArrayList<String> wordList1 = new ArrayList<String>(
                Arrays.asList("hot","dot","dog","lot","log","cog"));
        String beginWord1 = "hit";
        String endWord1 = "cog";
        System.out.println((new Solution()).ladderLength(beginWord1, endWord1, wordList1));

        // 5

        // ---

        ArrayList<String> wordList2 = new ArrayList<String>(
                Arrays.asList("a","b","c"));
        String beginWord2 = "a";
        String endWord2 = "c";
        System.out.println((new Solution()).ladderLength(beginWord2, endWord2, wordList2));
        // 2
    }
}
