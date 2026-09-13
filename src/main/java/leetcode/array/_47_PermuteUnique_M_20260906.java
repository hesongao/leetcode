package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 47. 全排列 II
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 */
public class _47_PermuteUnique_M_20260906 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        boolean[] use = new boolean[nums.length];
        backTrack(nums, use, 0, list, new ArrayList<Integer>());
        return list;
    }

    private void backTrack(int[] nums, boolean[] use, int len, List<List<Integer>> list, ArrayList<Integer> subList) {
        if (len == nums.length) {
            list.add(new ArrayList<>(subList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && !use[i-1] && nums[i] == nums[i - 1]) {
                continue;
            }
            if (!use[i]) {
                use[i] = true;
                subList.add(nums[i]);
                backTrack(nums, use, len + 1, list, subList);
                subList.remove(subList.size() - 1);
                use[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        _47_PermuteUnique_M_20260906 clazz = new _47_PermuteUnique_M_20260906();
        int[] nums = {1,1,2};
        System.out.println(clazz.permuteUnique(nums).stream().map(list -> list.stream().map(String::valueOf)
                        .collect(Collectors.joining(",", "[", "]")))
                .collect(Collectors.joining(",", "[", "]")));
    }
}
