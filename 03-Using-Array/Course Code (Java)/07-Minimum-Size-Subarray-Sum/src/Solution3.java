// 209. Minimum Size Subarray Sum
// https://leetcode.com/problems/minimum-size-subarray-sum/description/
//
// 滑动窗口的思路   因为题中说明了是要求连续的子数组，所以这里不用要求原数组有序，题中要求连续，就只能向前滑动
// 时间复杂度: O(n)
// 空间复杂度: O(1)
public class Solution3 {

    public int minSubArrayLen(int s, int[] nums) {

        if(s <= 0 || nums == null)
            throw new IllegalArgumentException("Illigal Arguments");

        int l = 0 , r = -1; // nums[l...r]为我们的滑动窗口 初始的时候是一个无意义的空数组[0,-1]
        int sum = 0;
        int res = nums.length + 1;  //取一个较大的不可能的结果

        while(l < nums.length){   // 窗口的左边界最大为 length-1 则右边界最大也为 length-1 ，此刻窗口有意义

            if(r + 1 < nums.length && sum < s)  // 右边界还可以继续移动
                sum += nums[++r];
            else // r已经到头 或者 sum >= s
                sum -= nums[l++];  // 先减掉元素 左侧再右移

            if(sum >= s)
                res = Math.min(res, r - l + 1);
        }

        if(res == nums.length + 1)
            return 0;
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;
        System.out.println((new Solution3()).minSubArrayLen(s, nums));
    }
}
