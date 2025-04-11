package leetcode.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. 单词拆分 中等
 *
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s 和 wordDict[i] 仅由小写英文字母组成
 * wordDict 中的所有字符串 互不相同
 *
 */
public class _139_单词拆分_20250409 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String s1 : wordDict) {
            set.add(s1);
        }

        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j <= i; j++){
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "catsandog";
        String[] arr = {"cats", "dog", "sand", "and", "cat"};
        List<String> wordDict = Arrays.asList(arr);
        _139_单词拆分_20250409 clazz = new _139_单词拆分_20250409();
        System.out.println(clazz.wordBreak(s, wordDict));
    }
}
