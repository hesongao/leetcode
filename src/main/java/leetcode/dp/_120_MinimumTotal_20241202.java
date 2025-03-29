package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 *给定一个三角形 triangle ，找出自顶向下的最小路径和。
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
 * 提示：
 *
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 */
public class _120_MinimumTotal_20241202 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int h = triangle.size();
        int w = triangle.get(h-1).size();
        int[][] dp = new int[h][w];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < h; i++){
            for(int j = 0; j < triangle.get(i).size(); j++){
                if(i == 0 && j == 0){
                    dp[i][j] = triangle.get(i).get(j);
                }else if(j == 0){
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                }else if(j == triangle.get(i).size()-1){
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j]) + triangle.get(i).get(j);
                }
            }
        }
        for(int i = 0; i < w; i++){
            min = Math.min(min, dp[h-1][i]);
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
        _120_MinimumTotal_20241202 minimumTotal_20241202 = new _120_MinimumTotal_20241202();
        System.out.println(minimumTotal_20241202.minimumTotal(triangle));
    }
}
