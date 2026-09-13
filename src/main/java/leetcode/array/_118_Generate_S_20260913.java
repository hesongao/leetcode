package leetcode.array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 118. 杨辉三角
 *
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 *
 *
 *
 *
 * 示例 1:
 *
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 示例 2:
 *
 * 输入: numRows = 1
 * 输出: [[1]]
 *
 *
 * 提示:
 *
 * 1 <= numRows <= 30
 */
public class _118_Generate_S_20260913 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> subList = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    subList.add(1);
                } else {
                    List<Integer> integers = list.get(list.size() - 1);
                    subList.add(integers.get(j - 1) +integers.get(j));
                }
            }
            list.add(subList);
        }

        return list;
    }

    public static void main(String[] args) {
        int numRows = 5;
        _118_Generate_S_20260913 clazz = new _118_Generate_S_20260913();
        System.out.println(clazz.generate(numRows).stream().map(inner -> inner.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(",", "[", "]")))
                .collect(Collectors.joining(",", "[", "]")));
    }
}
