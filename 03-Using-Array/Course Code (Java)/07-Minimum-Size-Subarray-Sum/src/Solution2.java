// 209. Minimum Size Subarray Sum
// https://leetcode.com/problems/minimum-size-subarray-sum/description/
//
// 优化暴力解   记忆化数组
// 时间复杂度: O(n^2)
// 空间复杂度: O(n)
public class Solution2 {

    public int minSubArrayLen(int s, int[] nums) {

        if(s <= 0 || nums == null)
            throw new IllegalArgumentException("Illigal Arguments");

        // sums[i]存放nums[0...i-1]的和，不包含nums[i]元素 , 搞清楚语义，下面写代码时边界条件才可以快速的写出
        int[] sums = new int[nums.length + 1];
        sums[0] = 0;
        for(int i = 1 ; i <= nums.length ; i ++)  // 依次把sum[i]的值存储下来，避免多次计算
            sums[i] = sums[i-1] + nums[i-1];   // sums[1] 存储的是第0的元素的和 sums[nums.length] 存储的是全部的元素和

        int res = nums.length + 1;
        for(int l = 0 ; l < nums.length ; l ++)
            for(int r = l ; r < nums.length ; r ++){
                // 使用sums[r+1] - sums[l] 快速获得nums[l...r]的和   [0，r] - [0,l-1] 
                if(sums[r+1] - sums[l] >= s)
                    res = Math.min(res, r - l + 1);
            }

        if(res == nums.length + 1)
            return 0;

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;
        System.out.println((new Solution2()).minSubArrayLen(s, nums));
    }
}
