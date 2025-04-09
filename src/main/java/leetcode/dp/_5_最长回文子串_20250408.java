package leetcode.dp;

/**
 * 5. 最长回文子串 中等
 * <p>
 * 给你一个字符串 s，找到 s 中最长的 回文 子串。
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 */
public class _5_最长回文子串_20250408 {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else if (i == j - 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 1;
                } else if (dp[i + 1][j - 1] == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 1;
                }

                if (dp[i][j] == 1 && end - start < j - i) {
                    start = i;
                    end = j;
                }
            }
        }

        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        String s = "cbbd";
        _5_最长回文子串_20250408 clazz = new _5_最长回文子串_20250408();
        System.out.println(clazz.longestPalindrome(s));
    }
}
