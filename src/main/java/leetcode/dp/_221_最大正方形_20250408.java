package leetcode.dp;

/**
 * 221. 最大正方形 中等
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：4
 *
 * 输入：matrix = [["0","1"],["1","0"]]
 * 输出：1
 *
 * 输入：matrix = [["0"]]
 * 输出：0
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] 为 '0' 或 '1'
 */
public class _221_最大正方形_20250408 {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(i == 0 || j == 0 || matrix[i][j] == '0'){
                    dp[i][j] = matrix[i][j] - '0';
                }else if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }else{
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max * max;
    }

    public static void main(String[] args) {
//        char[][] matrix = {{'1','0','1','0','0'}, {'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        char[][] matrix = {{'0','1'},{'1','0'}};
        _221_最大正方形_20250408 clazz = new _221_最大正方形_20250408();
        System.out.println(clazz.maximalSquare(matrix));
    }
}
