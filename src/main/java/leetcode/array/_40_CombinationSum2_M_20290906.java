package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 40. 组合总和 II
 *
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 *
 * 注意：解集不能包含重复的组合。
 *
 *
 *
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 *
 * 提示:
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */
public class _40_CombinationSum2_M_20290906 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        combinationSum2(candidates, target, 0, list, new ArrayList<Integer>());
        return list;
    }

    private void combinationSum2(int[] candidates, int target, int index, List<List<Integer>> list, ArrayList<Integer> subList) {
        if (target == 0) {
            list.add(new ArrayList<>(subList));
            return;
        }

        if (target < 0 || index == candidates.length) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i-1]) {
                continue;
            }
            subList.add(candidates[i]);
            combinationSum2(candidates, target - candidates[i], i + 1, list, subList);
            subList.remove(subList.size()-1);
        }
    }

    public static void main(String[] args) {
        _40_CombinationSum2_M_20290906 clazz = new _40_CombinationSum2_M_20290906();
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
//        int[] candidates = {2,5,2,1,2};
//        int target = 5;
        System.out.println(clazz.combinationSum2(candidates, target).stream().map(inner -> inner.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(",", "[", "]")))
                .collect(Collectors.joining(",", "[", "]")));
    }
}
