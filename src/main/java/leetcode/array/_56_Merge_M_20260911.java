package leetcode.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 56. 合并区间
 *
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 示例 3：
 *
 * 输入：intervals = [[4,7],[1,4]]
 * 输出：[[1,7]]
 * 解释：区间 [1,4] 和 [4,7] 可被视为重叠区间。
 */
public class _56_Merge_M_20260911 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        int[] arr = new int[]{-1, -1};
        for (int i = 0; i < intervals.length; i++) {
            if (arr[0] == -1) {
                arr = intervals[i];
            } else {
                if (arr[1] >= intervals[i][0]) {
                    if (arr[1] <= intervals[i][1]) {
                        arr[1] = intervals[i][1];
                    }
                } else {
                    list.add(arr);
                    arr = new int[]{intervals[i][0], intervals[i][1]};
                }
            }
        }

        list.add(arr);

        return list.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
//        int[][] intervals = {{4,7},{1,4}};
//        int[][] intervals = {{4,7}};
        _56_Merge_M_20260911 clazz = new _56_Merge_M_20260911();
        System.out.println(Arrays.stream(clazz.merge(intervals))
                .map(arr -> Arrays.stream(arr).mapToObj(Objects::toString)
                        .collect(Collectors.joining(",", "[", "]"))).collect(Collectors.joining(",", "[", "]")));
    }
}
