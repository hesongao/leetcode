package leetcode.array;

import java.util.Arrays;

/**
 * 135. 分发糖果
 * <p>
 * n 个孩子站成一排。
 * <p>
 * 给你一个整数数组 ratings 表示每个孩子的评分。
 * <p>
 * 你需要按照以下要求，给这些孩子分发糖果：
 * <p>
 * 每个孩子 至少 分配到 1 个糖果。
 * 相邻两个孩子中，评分 更高 的那个会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少 糖果数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 * 示例 2：
 * <p>
 * 输入：ratings = [1,2,2]
 * 输出：4
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n == ratings.length <= 5 * 104
 * 0 <= ratings[i] <= 5 * 104
 */
public class _135_Candy_M_20260915 {
    public int candy(int[] ratings) {
        int[] candys = new int[ratings.length];
        candys[0] = 1;

        for (int i = 1; i < ratings.length; i++) {
            candys[i] = 1;
            if (ratings[i] > ratings[i - 1]) {
                candys[i] = candys[i - 1] + 1;
            }
        }
        int sum = candys[ratings.length - 1];

        for (int j = ratings.length - 2; j >= 0; j--) {
            if (ratings[j] > ratings[j + 1]) {
                candys[j] = Math.max(candys[j], candys[j + 1] + 1);
            }
            sum += candys[j];
        }

        return sum;

    }

    public static void main(String[] args) {
//        int[] ratings = {1, 0, 2};
//        int[] ratings = {1,3,2,2,1};
        int[] ratings = {1,2,87,87,87,2,1};
        _135_Candy_M_20260915 clazz = new _135_Candy_M_20260915();
        System.out.println(clazz.candy(ratings));
    }

}
