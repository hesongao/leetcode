package utils;

public class ListNodeUtil {
    public static ListNode arrayToList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int value : arr) {
            current.next = new ListNode(value);
            current = current.next;
        }

        return dummy.next;
    }

    public static String printList(ListNode root) {
        if (root == null) {
            return "[]";
        }
        String s = "[";
        while (root != null) {
            s += root.val + ",";
            root = root.next;
        }
        return s.substring(0, s.length() - 1) + "]";
    }

    public static ListNode arrayToCircularList(int[] arr, int nextIndex) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ListNode[] nodes = new ListNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new ListNode(arr[i]);
            if (i > 0) {
                nodes[i - 1].next = nodes[i];
            }
        }

        if (nextIndex >= 0 && nextIndex < arr.length) {
            nodes[arr.length - 1].next = nodes[nextIndex];
        }

        return nodes[0];
    }
}
