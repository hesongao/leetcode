package leetcode.array;

/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 为 无重复元素 的 升序 排列数组
 * -104 <= target <= 104
 */
public class _35_SearchInsert_E_20260906 {

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int res = nums.length;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] > target) {
                res = mid;
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        _35_SearchInsert_E_20260906 clazz = new _35_SearchInsert_E_20260906();
        int[] nums = {1,3,5,6};
//        int target = 5;
//        int target = 2;
//        int target = 7;
        int target = 0;
        System.out.println(clazz.searchInsert(nums, target));
    }
}
