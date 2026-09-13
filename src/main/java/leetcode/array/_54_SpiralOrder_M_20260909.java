package leetcode.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 54. 螺旋矩阵
 * <p>
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class _54_SpiralOrder_M_20260909 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }

            for (int j = top + 1; j <= bottom; j++) {
                list.add(matrix[j][right]);
            }

            if (left < right && top < bottom) {
                for (int k = right - 1; k >= left; k--) {
                    list.add(matrix[bottom][k]);
                }

                for (int l = bottom - 1; l > top; l--) {
                    list.add(matrix[l][left]);
                }
            }

            left++;
            right--;
            top++;
            bottom--;
        }

        return list;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        _54_SpiralOrder_M_20260909 clazz = new _54_SpiralOrder_M_20260909();
        System.out.println(clazz.spiralOrder(matrix).stream().map(Objects::toString).collect(Collectors.joining(",", "[", "]")));
    }
}
