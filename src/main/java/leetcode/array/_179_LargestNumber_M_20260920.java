package leetcode.array;

/**
 * 179. 最大数
 *
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 *
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 */
public class _179_LargestNumber_M_20260920 {
    public String largestNumber(int[] nums) {
        String res = "";

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                String s1 = "" + nums[j] + nums[j + 1];
                String s2 = "" + nums[j + 1] + nums[j];

                if (s1.compareTo(s2) < 0) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        for (int num : nums) {
            if (!"0".equals(res) || num != 0) {
                res += num;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        _179_LargestNumber_M_20260920 clazz = new _179_LargestNumber_M_20260920();
        System.out.println(clazz.largestNumber(nums));

    }
}
