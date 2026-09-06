package leetcode.array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 39. 组合总和
 *
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 *
 *
 *
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * 示例 2：
 *
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 示例 3：
 *
 * 输入: candidates = [2], target = 1
 * 输出: []
 *
 *
 * 提示：
 *
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * candidates 的所有元素 互不相同
 * 1 <= target <= 40
 */
public class _39_CombinationSum_M_20260906 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        combinationSum(candidates, target, 0, list, new ArrayList<Integer>());
        return list;
    }

    private void combinationSum(int[] candidates, int target, int index, List<List<Integer>> list, ArrayList<Integer> subList) {
        if (target == 0) {
            list.add(new ArrayList<>(subList));
            return;
        }
        if (index == candidates.length || target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            subList.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], i, list, subList);
            subList.remove(subList.size()-1);
        }
    }

    public static void main(String[] args) {
        _39_CombinationSum_M_20260906 clazz = new _39_CombinationSum_M_20260906();
//        int[] candidates = {2,3,6,7};
//        int target = 7;
        int[] candidates = {2,3,5};
        int target = 8;
        System.out.println(clazz.combinationSum(candidates, target).stream().map(inner -> inner.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(",", "[", "]")))
                .collect(Collectors.joining(",", "[", "]")));
    }
}
