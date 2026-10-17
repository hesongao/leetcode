package dayPractice._20261016;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为 K 的子数组
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * <p>
 * 子数组是数组中元素的连续非空序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 */
public class _560_SubarraySum_M_Review {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k) {
                    res += 1;
                }
            }
        }

        return res;
    }
    public int subarraySum2(int[] nums, int k) {
        int prev = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            prev += nums[i];
            if (map.containsKey(prev - k)) {
                res += map.get(prev - k);
            }
            map.put(prev, map.getOrDefault(prev, 0) + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        _560_SubarraySum_M_Review clazz = new _560_SubarraySum_M_Review();
        System.out.println(clazz.subarraySum(nums, k));
        System.out.println(clazz.subarraySum2(nums, k));
    }
}
