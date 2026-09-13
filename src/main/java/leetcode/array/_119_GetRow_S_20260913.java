package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 119. 杨辉三角 II
 *
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 *
 *
 *
 *
 * 示例 1:
 *
 * 输入: rowIndex = 3
 * 输出: [1,3,3,1]
 * 示例 2:
 *
 * 输入: rowIndex = 0
 * 输出: [1]
 * 示例 3:
 *
 * 输入: rowIndex = 1
 * 输出: [1,1]
 *
 *
 * 提示:
 *
 * 0 <= rowIndex <= 33
 *
 *
 * 进阶：
 *
 * 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？
 */
public class _119_GetRow_S_20260913 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            list.add(1);
            for (int j = i - 1; j > 0; j--) {
                list.set(j, list.get(j) + list.get(j - 1));
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int rowIndex = 5;
        _119_GetRow_S_20260913 clazz = new _119_GetRow_S_20260913();
        System.out.println(clazz.getRow(rowIndex).stream().map(Objects::toString).collect(Collectors.joining(",", "[", "]")));
    }
}
