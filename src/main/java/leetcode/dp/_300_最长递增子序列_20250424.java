package leetcode.dp;

/**
 * 300. 最长递增子序列 中等
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 输入：nums = {10,9,2,5,3,7,101,18}
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 *
 * 输入：nums = {0,1,0,3,2,3}
 * 输出：4
 *
 * 输入：nums = {7,7,7,7,7,7,7}
 * 输出：1
 *
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 */
public class _300_最长递增子序列_20250424 {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 1;
        dp[0] = 1;
        for(int i = 1; i < nums.length; i++){

            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] = dp[i] + 1;
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
//        int[] nums = {10,9,2,5,3,7,101,18};
//        int[] nums = {0,1,0,3,2,3};
//        int[] nums = {7,7,7,7,7,7,7};
        int[] nums = {1,3,6,7,9,4,10,5,6};
        _300_最长递增子序列_20250424 clazz = new _300_最长递增子序列_20250424();
        System.out.println(clazz.lengthOfLIS(nums));

    }
}
