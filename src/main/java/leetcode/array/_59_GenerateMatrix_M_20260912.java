package leetcode.array;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 59. 螺旋矩阵 II
 *
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[[1]]
 *
 *
 * 提示：
 *
 * 1 <= n <= 20
 */
public class _59_GenerateMatrix_M_20260912 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int count = 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                res[top][i] = count++;
            }
            for (int j = top + 1; j <= bottom; j++) {
                res[j][right] = count++;
            }

            if (left < right && top < bottom) {
                for (int k = right - 1; k >= left; k--) {
                    res[bottom][k] = count++;
                }

                for (int l = bottom - 1; l > top; l--) {
                    res[l][left] = count++;
                }
            }

            left++;
            right--;
            top++;
            bottom--;
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 3;
        _59_GenerateMatrix_M_20260912 clazz = new _59_GenerateMatrix_M_20260912();
        System.out.println(Arrays.stream(clazz.generateMatrix(n))
                .map(arr -> Arrays.stream(arr).mapToObj(Objects::toString)
                        .collect(Collectors.joining(",", "[", "]"))).collect(Collectors.joining(",", "[", "]")));
    }
}
