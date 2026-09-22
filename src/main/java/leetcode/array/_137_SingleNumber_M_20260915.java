package leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 137. 只出现一次的数字 II
 *
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 *
 * 你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
 */
public class _137_SingleNumber_M_20260915 {
    public int singleNumber(int[] nums) {

        int res = 0;
        for (int i = 0; i < 32; i++) {
             int sum = 0;
             for (int num : nums) {
                 sum += (num >> i) & 1;
             }
            if (sum % 3 != 0) {
                res |= (sum % 3) << i;
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {2,2,3,2};
        int[] nums = {0,1,0,1,0,1,99};
        _137_SingleNumber_M_20260915 clazz = new _137_SingleNumber_M_20260915();
        System.out.println(clazz.singleNumber(nums));
    }
}
