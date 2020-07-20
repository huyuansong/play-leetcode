// 3. Longest Substring Without Repeating Characters
// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
//
// 课程问答区 @yatkun 提出的方法,
// l每次可以向前跳跃, 而不仅仅是+1
// 但代价是, 为了获得这个跳跃的位置, 每次需要遍历整个窗口的字符串
//
// 时间复杂度: O(len(s)*len(charset))
// 空间复杂度: O(1)
public class Solution4{

    public int lengthOfLongestSubstring(String s) {

        int l = 0, r = 0; //滑动窗口为s[l...r]  初始是第一个元素
        int res = 0;        //记录最长的子串长度

        while(r < s.length()){  //窗口右侧元素没有越界

            int index = isDuplicateChar(s, l, r); // 返回s串中的[l,r-1]之间曾经出现的r元素的位置的索引

            // 如果s[r]之前出现过
            // l可以直接跳到s[r+1]之前出现的位置 + 1的地方
            if(index != -1)       
                l = index + 1;  //滑动窗口的左侧直接移动到重复元素的下一位位置

            res = Math.max(res, r-l+1);  //有没有产生新的最长子串
            r ++;   //窗口右侧继续滑动
        }

        return res;
    }

    // 查看s[l...r-1]之间是否存在s[r]
    // 若存在,返回相应的索引, 否则返回-1
    private int isDuplicateChar(String s, int l, int r){
        for(int i = l ; i < r ; i ++)
            if(s.charAt(i) == s.charAt(r))    //窗口中旧元素和新元素重复的位置
                return i;
        return -1;
    }

    public static void main(String[] args) {

        System.out.println((new Solution4()).lengthOfLongestSubstring( "abcabcbb" ));
        System.out.println((new Solution4()).lengthOfLongestSubstring( "bbbbb" ));
        System.out.println((new Solution4()).lengthOfLongestSubstring( "pwwkew" ));
        System.out.println((new Solution4()).lengthOfLongestSubstring( "" ));
    }
}
