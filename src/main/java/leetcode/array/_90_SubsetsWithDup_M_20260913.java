package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 90. 子集 II
 *
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的 子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 *
 */
public class _90_SubsetsWithDup_M_20260913 {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subsetsWithDup(nums, 0, new ArrayList<Integer>());
        return list;
    }

    private void subsetsWithDup(int[] nums, int index, ArrayList<Integer> subList) {
        list.add(new ArrayList<>(subList));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            subList.add(nums[i]);
            subsetsWithDup(nums, i + 1, subList);
            subList.remove(subList.size() - 1);
        }
    }

    public static void main(String[] args) {
//        int[] nums = {1,2,2};
        int[] nums = {4,4,4,1,4};
        _90_SubsetsWithDup_M_20260913 clazz = new _90_SubsetsWithDup_M_20260913();
        System.out.println(clazz.subsetsWithDup(nums).stream().map(inner -> inner.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(",", "[", "]")))
                .collect(Collectors.joining(",", "[", "]")));
    }
}
