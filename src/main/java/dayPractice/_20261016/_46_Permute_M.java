package dayPractice._20261016;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 46. 全排列
 *
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 */
public class _46_Permute_M {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] use = new boolean[nums.length];
        backTrack(nums, list, new ArrayList<>(), use);
        return list;
    }

    public void backTrack(int[] nums, List<List<Integer>> list, List<Integer> subList, boolean[] use) {
        if (subList.size() == nums.length) {
            list.add(new ArrayList<>(subList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
           if (!use[i]) {
               subList.add(nums[i]);
               use[i] = true;
               backTrack(nums, list, subList, use);
               use[i] = false;
               subList.remove(subList.size() - 1);
           }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        _46_Permute_M clazz = new _46_Permute_M();
        System.out.println(clazz.permute(nums).stream()
                .map(list -> list.stream()
                        .map(Objects::toString)
                        .collect(Collectors.joining(",", "[", "]")))
                .collect(Collectors.joining(",", "[", "]")));
    }
}
