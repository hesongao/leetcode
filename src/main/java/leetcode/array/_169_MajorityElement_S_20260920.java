package leetcode.array;

/**
 * 169. 多数元素
 *
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 *
 *
 * 提示：
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 * 输入保证数组中一定有一个多数元素。
 *
 *
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 */
public class _169_MajorityElement_S_20260920 {
    public int majorityElement(int[] nums) {
        int ret = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                ret = num;
                count = 1;
                continue;
            }

            if (ret == num) {
                count += 1;
            } else {
                count -= 1;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3};
        _169_MajorityElement_S_20260920 clazz = new _169_MajorityElement_S_20260920();
        System.out.println(clazz.majorityElement(nums));
    }
}
