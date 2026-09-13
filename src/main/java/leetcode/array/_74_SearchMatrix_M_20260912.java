package leetcode.array;

/**
 * 74. 搜索二维矩阵
 *
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 *
 * 每行中的整数从左到右按非严格递增顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 *
 * 你必须编写一个时间复杂度为 O(log(m * n)) 的解决方案。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 *
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 */
public class _74_SearchMatrix_M_20260912 {
    public boolean searchMatrix(int[][] matrix, int target) {

        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int midX = 0;
        while (top <= bottom) {
            midX = (top + bottom) / 2;

            if (target < matrix[midX][0]) {
                bottom = midX - 1;
            } else if (target > matrix[midX][right]){
                top = midX + 1;
            } else {
                break;
            }
        }

        while (left <= right) {
            int midY = (left + right) / 2;
            if (target > matrix[midX][midY]) {
                left = midY + 1;
            } else if (target < matrix[midX][midY]) {
                right = midY - 1;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
//        int target = 3;
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 13;
        _74_SearchMatrix_M_20260912 clazz = new _74_SearchMatrix_M_20260912();
        System.out.println(clazz.searchMatrix(matrix, target));
    }
}
