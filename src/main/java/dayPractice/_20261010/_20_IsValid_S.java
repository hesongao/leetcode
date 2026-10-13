package dayPractice._20261010;

import java.util.*;

/**
 * 20. 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 *
 * 示例 1：
 *
 * 输入：s = "()"
 *
 * 输出：true
 *
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 *
 * 输出：true
 *
 * 示例 3：
 *
 * 输入：s = "(]"
 *
 * 输出：false
 *
 * 示例 4：
 *
 * 输入：s = "([])"
 *
 * 输出：true
 *
 * 示例 5：
 *
 * 输入：s = "([)]"
 *
 * 输出：false
 *
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class _20_IsValid_S {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (stack.isEmpty() || map.containsKey(c)) {
                stack.push(c);
            } else {
                if(c != map.get(stack.pop())) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
//        String s = "()[]{}";
        String s = "))";
        _20_IsValid_S clazz = new _20_IsValid_S();
        System.out.println(clazz.isValid(s));
    }
}
