package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 120. 三角形最小路径和 中等
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * <p>
 * 示例 1：
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * <p>
 * 示例 2：
 * 输入：triangle = [[-10]]
 * 输出：-10
 * <p>
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 */
public class _120_三角形最小路径和_20250329 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (i == 0) {
                    dp[i][j] = list.get(j);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + list.get(j);
                } else if (j == list.size() - 1) {
                    dp[i][j] = dp[i-1][j-1] + list.get(j);
                } else{
                    dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + list.get(j);
                }

                if(i == m - 1){
                    min = Math.min(min, dp[i][j]);
                }
            }
        }

        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(2);
        triangle.add(list);
        list = new ArrayList<>();
        list.add(3);
        list.add(4);
        triangle.add(list);
        list = new ArrayList<>();
        list.add(6);
        list.add(5);
        list.add(7);
        triangle.add(list);
        list = new ArrayList<>();
        list.add(4);
        list.add(1);
        list.add(8);
        list.add(3);
        triangle.add(list);
        _120_三角形最小路径和_20250329 clazz = new _120_三角形最小路径和_20250329();
        System.out.println(clazz.minimumTotal(triangle));
    }
}
