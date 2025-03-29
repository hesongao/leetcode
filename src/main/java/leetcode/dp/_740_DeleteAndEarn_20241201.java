package leetcode.dp;

public class _740_DeleteAndEarn_20241201 {

    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int[] arr = new int[max];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i] - 1] += nums[i];
        }
        if (arr.length == 1) {
            return arr[0];
        }
        int a = 0;
        int b = arr[0];
        int c = 0;
        for (int i = 1; i < arr.length; i++) {
            c = Math.max(a + arr[i], b);
            a = b;
            b = c;
        }

        return c;
    }

    public int deleteAndEarn2(int[] nums) {
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        int[] a = new int[max+1];
        for(int i = 0; i < nums.length; i++){
            a[nums[i]] += nums[i];
        }
        int[] dp = new int[a.length+1];
        dp[0] = 0;
        dp[1] = a[0];
        for(int i = 2; i <= a.length; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + a[i-1]);
        }

        return dp[a.length];
    }

    public static void main(String[] args) {
//        int[] nums = {1, 1, 1};
//        int[] nums = {3,4,2};
        int[] nums = {3,1};
        _740_DeleteAndEarn_20241201 deleteAndEarn20241201 = new _740_DeleteAndEarn_20241201();
        System.out.println(deleteAndEarn20241201.deleteAndEarn2(nums));

    }
}
