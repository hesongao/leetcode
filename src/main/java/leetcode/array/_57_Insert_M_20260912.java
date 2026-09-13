package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 57. 插入区间
 *
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，其中 intervals[i] = [starti, endi] 表示第 i 个区间的开始和结束，并且 intervals 按照 starti 升序排列。同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。
 *
 * 如果两个区间 至少 共享一个点，则认为它们是重叠的。
 *
 * 在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，且区间之间不重叠（如果有必要的话，可以合并区间）。
 *
 * 返回插入之后的 intervals。
 *
 * 注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。
 *
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 *
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 *
 * 提示：
 *
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 105
 * intervals 根据 starti 按 升序 排列
 * newInterval.length == 2
 * 0 <= start <= end <= 105
 */
public class _57_Insert_M_20260912 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] < newInterval[0]) {
                list.add(intervals[i]);
            } else if (intervals[i][0] > newInterval[1]) {
                list.add(newInterval);
                newInterval = intervals[i];
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }

        if (list.size() == 0) {
            list.add(newInterval);
        }  else {
            int[] ints = list.get(list.size() - 1);

            if (ints[1] < newInterval[0]) {
                list.add(newInterval);
            } else {
                ints[0] = Math.min(newInterval[0], ints[0]);
                ints[1] = Math.max(newInterval[1], ints[1]);
                list.set(list.size()-1, ints);
            }
        }

        return list.toArray(new int[0][]);
    }

    public static void main(String[] args) {
//        int[][] intervals = {{1,3},{6,9}};
//        int[] newInterval = {2,5};
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};

//        int[][] intervals = {{1,5}};
//        int[] newInterval = {6,8};
        _57_Insert_M_20260912 clazz = new _57_Insert_M_20260912();
        System.out.println(Arrays.stream(clazz.insert(intervals, newInterval))
                .map(arr -> Arrays.stream(arr).mapToObj(Objects::toString)
                        .collect(Collectors.joining(",", "[", "]"))).collect(Collectors.joining(",", "[", "]")));
    }
}
