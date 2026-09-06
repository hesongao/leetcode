package leetcode.array;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 */
public class _34_SearchRange_M_20260906 {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        return new int[] {searchRange(nums, target, true), searchRange(nums, target, false)};
    }

    public int searchRange(int[] nums, int target, boolean isFirst) {
        int start = 0;
        int end = nums.length - 1;
        int res = -1;
        if (isFirst) {
            while (start <= end) {
                int mid = (start + end) / 2;

                if (nums[mid] == target) {
                    res = mid;
                    end = mid - 1;
                } else if (nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        } else {
            while (start <= end) {
                int mid = (start + end) / 2;

                if (nums[mid] == target) {
                    res = mid;
                    start = mid + 1;
                } else if (nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return res;

    }

    public static void main(String[] args) {
        _34_SearchRange_M_20260906 clazz = new _34_SearchRange_M_20260906();
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.stream(clazz.searchRange(nums, target)).mapToObj(Objects::toString).collect(Collectors.joining(",")));
    }
}
