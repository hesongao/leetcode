package leetcode.array;

/**
 * 79. 单词搜索
 * <p>
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = "SEE"
 * 输出：true
 * 示例 3：
 * <p>
 * <p>
 * 输入：board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = "ABCB"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 * <p>
 * <p>
 * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
 */
public class _79_Exist_M_20260912 {
    public boolean exist(char[][] board, String word) {
        boolean[][] use = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (exist(board, word, i, j, use, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int row, int column, boolean[][] use, int index) {
        if(index == word.length()) {
            return true;
        }
        if (row < 0 || row == board.length || column < 0 || column == board[0].length) {
            return false;
        }
        char c = word.charAt(index);

        if (!use[row][column] && board[row][column] == c) {
            use[row][column] = true;
            if (exist(board, word, row + 1, column, use, index + 1)
                    || exist(board, word, row - 1, column, use, index + 1)
                    || exist(board, word, row, column + 1, use, index + 1)
                    || exist(board, word, row, column - 1, use, index + 1)) {
                return true;
            }
            use[row][column] = false;
        }
        return false;
    }

    public static void main(String[] args) {
//        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        String word = "ABCB";
//        String word = "ABCCED";
//        char[][] board = {{'a','b'}};
//        String word = "ba";
        char[][] board = {{'a','b'},{'c','d'}};
        String word = "abcd";
        _79_Exist_M_20260912 clazz = new _79_Exist_M_20260912();
        System.out.println(clazz.exist(board, word));

    }
}
