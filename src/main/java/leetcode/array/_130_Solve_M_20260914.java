package leetcode.array;

import java.util.Arrays;

/**
 * 130. 被围绕的区域
 * <p>
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' 组成，捕获 所有 被围绕的区域：
 * <p>
 * 连接：一个单元格与水平或垂直方向上相邻的单元格连接。
 * 区域：连接所有 'O' 的单元格来形成一个区域。
 * 围绕：如果一个区域中的所有 'O' 单元格都不在棋盘的边缘，则该区域被包围。这样的区域 完全 被 'X' 单元格包围。
 * 通过 原地 将输入矩阵中的所有 'O' 替换为 'X' 来 捕获被围绕的区域。你不需要返回任何值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [['X','X','X','X'],['X','O','O','X'],['X','X','O','X'],['X','O','X','X']]
 * <p>
 * 输出：[['X','X','X','X'],['X','X','X','X'],['X','X','X','X'],['X','O','X','X']]
 * <p>
 * 解释：
 * <p>
 * <p>
 * 在上图中，底部的区域没有被捕获，因为它在 board 的边缘并且不能被围绕。
 * <p>
 * 示例 2：
 * <p>
 * 输入：board = [['X']]
 * <p>
 * 输出：[['X']]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] 为 'X' 或 'O'
 */
public class _130_Solve_M_20260914 {
    public void solve(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            solve(board, i, 0);
            solve(board, i, board[0].length - 1);
        }

        for (int j = 1; j < board[0].length - 1; j++) {
            solve(board, 0, j);
            solve(board, board.length - 1, j);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    private void solve(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'A';
        solve(board, i - 1, j);
        solve(board, i + 1, j);
        solve(board, i, j + 1);
        solve(board, i, j - 1);

    }

    public static void main(String[] args) {
        _130_Solve_M_20260914 clazz = new _130_Solve_M_20260914();
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        clazz.solve(board);
        System.out.println(Arrays.deepToString(board));
    }
}
