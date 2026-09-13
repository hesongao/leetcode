package leetcode.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 49. 字母异位词分组
 * <p>
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * <p>
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * <p>
 * 解释：
 * <p>
 * 在 strs 中没有字符串可以通过重新排列来形成 "bat"。
 * 字符串 "nat" 和 "tan" 是字母异位词，因为它们可以重新排列以形成彼此。
 * 字符串 "ate" ，"eat" 和 "tea" 是字母异位词，因为它们可以重新排列以形成彼此。
 * 示例 2:
 * <p>
 * 输入: strs = [""]
 * <p>
 * 输出: [[""]]
 * <p>
 * 示例 3:
 * <p>
 * 输入: strs = ["a"]
 * <p>
 * 输出: [["a"]]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 */
public class _49_GroupAnagrams_M_20260907 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String s2 = new String(chars);
//            String s2 = Arrays.toString(chars);
            List<String> list = map.getOrDefault(s2, new ArrayList<String>());
            list.add(s);
            map.put(s2, list);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        _49_GroupAnagrams_M_20260907 clazz = new _49_GroupAnagrams_M_20260907();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(clazz.groupAnagrams(strs).stream()
                .map(list -> list.stream()
                        .collect(Collectors.joining(",", "[", "]")))
                .collect(Collectors.joining(",", "[", "]")));
    }
}
