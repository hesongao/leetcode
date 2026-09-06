package leetcode.array;

import java.beans.IntrospectionException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 46. 全排列
 * <p>
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 */
public class _46_Permute_M_20260906 {
    public List<List<Integer>> permute(int[] nums) {
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
        _46_Permute_M_20260906 clazz = new _46_Permute_M_20260906();
        int[] nums = {1, 2, 3};
        System.out.println(clazz.permute(nums).stream().map(list -> list.stream().map(String::valueOf)
                        .collect(Collectors.joining(",", "[", "]")))
                .collect(Collectors.joining(",", "[", "]")));
    }
}
