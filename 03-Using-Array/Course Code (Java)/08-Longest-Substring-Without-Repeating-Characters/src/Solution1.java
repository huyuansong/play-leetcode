// 3. Longest Substring Without Repeating Characters
 // https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
/*
Given a string, find the length of the longest substring without repeating characters.
Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring. 
*/
// 滑动窗口
// 时间复杂度: O(len(s))
// 空间复杂度: O(len(charset))
class Solution1 {
    public int lengthOfLongestSubstring(String s) {

        int[] freq = new int[256];   // 字符可以用ASCII码表示所有的情况

        int l = 0, r = -1; //滑动窗口为s[l...r]
        int res = 0;

        // 整个循环从 l == 0; r == -1 这个空窗口开始
        // 到l == s.length(); r == s.length()-1 这个空窗口截止
        // 在每次循环里逐渐改变窗口, 维护freq, 并记录当前窗口中是否找到了一个新的最优值
        // while(l < s.length()){   //维持定义的循环不变量
            while(r+1 <= s.length()-1){   // 滑动窗口右侧还有一个元素可以供本次选择

            if(r + 1 < s.length() && freq[s.charAt(r+1)] == 0)  // 元素位置合法且第一次出现
                freq[s.charAt(++r)] ++; //右侧窗口向前
            else    //r已经没有元素可以取了 || freq[s[r+1]] == 1
                freq[s.charAt(l++)] --;  // 左侧窗口向前

            res = Math.max(res, r-l+1);
        }

        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution1()).lengthOfLongestSubstring( "abcabcbb" ));
        System.out.println((new Solution1()).lengthOfLongestSubstring( "bbbbb" ));
        System.out.println((new Solution1()).lengthOfLongestSubstring( "pwwkew" ));
        System.out.println((new Solution1()).lengthOfLongestSubstring( "" ));
    }
}