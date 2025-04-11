package leetcode.dp;

import java.util.Arrays;
import java.util.List;

/**
 * 516. 最长回文子序列 中等
 *
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 *
 * 输入：s = "bbbab"
 * 输出：4
 *
 * 输入：s = "cbbd"
 * 输出：2
 *
 * 1 <= s.length <= 1000
 * s 仅由小写英文字母组成
 */
public class _516_最长回文子序列_20250409 {

    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i = s.length()-1; i >= 0; i--){
            for(int j = i; j < s.length(); j++){
                if(i == j){
                    dp[i][j] = 1;
                }else if(i == j - 1 && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = 2;
                }else if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }

        return dp[0][s.length()-1];
    }

    public static void main(String[] args) {
        String s = "cbbd";
        _516_最长回文子序列_20250409 clazz = new _516_最长回文子序列_20250409();
        System.out.println(clazz.longestPalindromeSubseq(s));
    }
}
