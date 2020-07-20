// 3. Longest Substring Without Repeating Characters
// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
//
// 滑动窗口
// 其中使用last[c]保存字符c上一次出现的位置, 用于在右边界发现重复字符时, 快速移动左边界
// 使用这种方法, 时间复杂度依然为O(n), 但是只需要动r指针, 实际上对整个s只遍历了一次
// 相较而言, 之前的方法, 需要移动l和r两个指针, 相对于对s遍历了两次

import java.util.Arrays;

// 时间复杂度: O(len(s))
// 空间复杂度: O(len(charset))
public class Solution5 {

    public int lengthOfLongestSubstring(String s) {

        int[] last = new int[256];  //查找表，记录元素最后一次出现的索引。这里比较简单，可以直接使用数组代替，如果元素的类型不是可以转化为int可以表示的，那就只能使用map结构
        Arrays.fill(last, -1);      //把数组所有的元素全部初始化为-1，表示所有的元素都没有出现在滑动窗口中

        int l = 0, r = -1; //滑动窗口为s[l...r]，初始状态没有一个元素
        int res = 0;        //记录出现的最长的子串长度
        while(r + 1 < s.length()){  //窗口最右侧元素（r+1）没有越界

            r ++;   //窗口右侧向前滑动
            if(last[s.charAt(r)] != -1)  //窗口右侧新元素 之前出现过窗口中！！！
                l = Math.max(l, last[s.charAt(r)] + 1);     //窗口左侧直接移动 跳跃到曾经出现过的旧元素的下一个位置

            res = Math.max(res, r - l + 1);  //有没有产生新的最长子串
            last[s.charAt(r)] = r;      //窗口最右侧的元素的位置索引得更新为当前位置r
        }   //先把整体的大的思路流程写下来，然后再细分每一小步

        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution5()).lengthOfLongestSubstring( "abcabcbb" ));
        System.out.println((new Solution5()).lengthOfLongestSubstring( "bbbbb" ));
        System.out.println((new Solution5()).lengthOfLongestSubstring( "pwwkew" ));
        System.out.println((new Solution5()).lengthOfLongestSubstring( "" ));
    }
}
