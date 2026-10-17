package pitfalls;

import utils.ListNode;
import utils.ListNodeUtil;

/**
 * 206. 反转链表
 *
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 *
 *
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *
 *
 * 提示：
 *
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 *
 *
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 */
public class _206_ReverseList_S {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode res = null;
        while (head != null) {
            res = new ListNode(head.val, res);
            head = head.next;
        }

        return res;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        _206_ReverseList_S clazz = new _206_ReverseList_S();
        ListNode listNode = ListNodeUtil.arrayToList(nums);
        System.out.println(ListNodeUtil.printList(clazz.reverseList(listNode)));
        System.out.println(ListNodeUtil.printList(clazz.reverseList2(listNode)));

    }
}
