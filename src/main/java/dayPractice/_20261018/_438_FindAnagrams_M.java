package dayPractice._20261018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 438. 找到字符串中所有字母异位词
 *
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *  示例 2:
 *
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *
 *
 * 提示:
 *
 * 1 <= s.length, p.length <= 3 * 104
 * s 和 p 仅包含小写字母
 */
public class _438_FindAnagrams_M {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            return res;
        }

        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pCount, sCount)) {
            res.add(0);
        }
        for (int i = 1; i <= s.length() - p.length(); i++) {
            sCount[s.charAt(i - 1) - 'a']--;
            sCount[s.charAt(i + p.length() - 1) - 'a']++;
            if (Arrays.equals(sCount, pCount)) {
                res.add(i);
            }
        }
        return res;
    }
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            return res;
        }
        int[] count = new int[26];
        for (int i = 0; i < p.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[p.charAt(i) - 'a']--;
        }
        int diff = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                diff++;
            }
        }
        if (diff == 0) {
            res.add(0);
        }

        for (int i = 0; i < s.length() - p.length(); i++) {
            int pre = s.charAt(i) - 'a';
            int aft = s.charAt(i + p.length()) - 'a';
            if (count[pre] == 0) {
                diff++;
            } else if (count[pre] == 1) {
                diff--;
            }
            count[pre]--;
            if (count[aft] == 0) {
                diff++;
            } else if(count[aft] == -1) {
                diff--;
            }
            count[aft]++;

            if (diff == 0) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
//        String s = "abab";
//        String p = "ab";
//        String s = "aababbaa";
//        String p = "aab";
        _438_FindAnagrams_M clazz = new _438_FindAnagrams_M();
        System.out.println(clazz.findAnagrams(s, p).stream().map(Objects::toString).collect(Collectors.joining(",", "[", "]")));
        System.out.println(clazz.findAnagrams2(s, p).stream().map(Objects::toString).collect(Collectors.joining(",", "[", "]")));
    }
}
