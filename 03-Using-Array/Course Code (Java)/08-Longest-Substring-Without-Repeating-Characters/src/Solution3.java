// 3. Longest Substring Without Repeating Characters
// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
//
// 滑动窗口的另一个实现, 仅做参考
// 时间复杂度: O(len(s))
// 空间复杂度: O(len(charset))
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {

        int[] freq = new int[256];

        int l = 0, r = -1; //滑动窗口为s[l...r]
        int res = 0;

        while(r + 1 < s.length()){   //窗口右侧的元素没有越界

            while(r + 1 < s.length() && freq[s.charAt(r+1)] == 0)  //  窗口右侧的元素没有越界，且这个元素是第一次出现
                freq[s.charAt(++r)] ++;                            //  窗口右侧向前滑动，频率+1

            res = Math.max(res, r - l + 1);        //有没有产生新的最长记录

            if(r + 1 < s.length()){                  // 窗口右侧元素没有越界
                freq[s.charAt(++r)] ++;              // 窗口右侧向前移动 ，频率+1
                assert(freq[s.charAt(r)] == 2);      // 当前窗口右侧元素是第二次出现了
                while(l <= r && freq[s.charAt(r)] == 2) //出现了重复元素，那么窗口左侧的元素该移动了
                    freq[s.charAt(l++)] --;             //  这里还可以再优化，直接移动到重复元素的位置的后面
            }
        }

        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution3()).lengthOfLongestSubstring( "abcabcbb" ));
        System.out.println((new Solution3()).lengthOfLongestSubstring( "bbbbb" ));
        System.out.println((new Solution3()).lengthOfLongestSubstring( "pwwkew" ));
        System.out.println((new Solution3()).lengthOfLongestSubstring( "" ));
    }
}
