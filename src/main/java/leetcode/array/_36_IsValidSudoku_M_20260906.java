package leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 36. 有效的数独
 * <p>
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * <p>
 * <p>
 * 注意：
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：false
 * 解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * <p>
 * <p>
 * 提示：
 * <p>
 * board.length == 9
 * board[i].length == 9
 * board[i][j] 是一位数字（1-9）或者 '.'
 */
public class _36_IsValidSudoku_M_20260906 {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            Set<Character> row = new HashSet();
            Set<Character> column = new HashSet<>();
            Set<Character> squre = new HashSet<>();

            for (int j = 0; j < board[i].length; j++) {
                if ('.' != board[i][j]) {
                    if (!row.contains(board[i][j])) {
                        row.add(board[i][j]);
                    } else {
                        return false;
                    }

                }

                if ('.' != board[j][i]) {
                    if (!column.contains(board[j][i])) {
                        column.add(board[j][i]);
                    } else {
                        return false;
                    }
                }
                if ('.' != board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3]) {
                    if (!squre.contains(board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3])) {
                        squre.add(board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3]);
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }


    public boolean isValidSudoku2(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            boolean[] row = new boolean[9];
            boolean[] column = new boolean[9];
            boolean[] squre = new boolean[9];

            for (int j = 0; j < board[i].length; j++) {
                if ('.' != board[i][j]) {
                    int index = board[i][j] - '1';
                    if (!row[index]) {
                        row[index] = true;
                    } else {
                        return false;
                    }
                }

                if ('.' != board[j][i]) {
                    int index = board[j][i] - '1';
                    if (!column[index]) {
                        column[index] = true;
                    } else {
                        return false;
                    }
                }
                int k = i / 3 * 3 + j / 3;
                int l = i % 3 * 3 + j % 3;
                if ('.' != board[k][l]) {
                    int index = board[k][l] - '1';
                    if (!squre[index]) {
                        squre[index] = true;
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

//        char[][] board = {{'8','3','.','.','7','.','.','.','.'}
//                ,{'6','.','.','1','9','5','.','.','.'}
//                ,{'.','9','8','.','.','.','.','6','.'}
//                ,{'8','.','.','.','6','.','.','.','3'}
//                ,{'4','.','.','8','.','3','.','.','1'}
//                ,{'7','.','.','.','2','.','.','.','6'}
//                ,{'.','6','.','.','.','.','2','8','.'}
//                ,{'.','.','.','4','1','9','.','.','5'}
//                ,{'.','.','.','.','8','.','.','7','9'}};

        _36_IsValidSudoku_M_20260906 clazz = new _36_IsValidSudoku_M_20260906();
        System.out.println(clazz.isValidSudoku(board));
        System.out.println(clazz.isValidSudoku2(board));
    }
}
