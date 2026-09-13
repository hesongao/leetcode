package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 120. 三角形最小路径和
 *
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 示例 2：
 *
 * 输入：triangle = [[-10]]
 * 输出：-10
 *
 *
 * 提示：
 *
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 *
 *
 * 进阶：
 *
 * 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？
 *
 */
public class _120_MinimumTotal_M_20260913 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[] dp = new int[m];
        List<Integer> integers = triangle.get(m - 1);
        for (int i = 0; i < m; i++) {
            dp[i] = integers.get(i);
        }
        for (int i  = m - 2; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j+1]) + list.get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        _120_MinimumTotal_M_20260913 clazz = new _120_MinimumTotal_M_20260913();
        Integer[][] triangle = {{2},{3,4},{6,5,7},{4,1,8,3}};

        List<List<Integer>> list = new ArrayList<>();
        for (Integer[] row : triangle) {
            list.add(new ArrayList<>(Arrays.asList(row)));
        }
        System.out.println(clazz.minimumTotal(list));

    }
}
