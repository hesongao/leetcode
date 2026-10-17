package dayPractice._20261015;

import utils.TreeNode;
import utils.TreeUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 102. 二叉树的层序遍历
 *
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * 示例 2：
 *
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 *
 * 输入：root = []
 * 输出：[]
 *
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 */
public class _102_LevelOrder_M {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                subList.add(node.val);
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
            list.add(subList);
        }

        return list;

    }

    public static void main(String[] args) {
//        Integer[] nums = {3,9,20,null,null,15,7};
        Integer[] nums = {1,2,null,3,null,4,null,5};
        TreeNode root = TreeUtils.buildTree(nums);
        _102_LevelOrder_M clazz = new _102_LevelOrder_M();
        System.out.println(clazz.levelOrder(root).stream()
                .map(list -> list.stream()
                        .map(Objects::toString)
                        .collect(Collectors.joining(",", "[", "]")))
                .collect(Collectors.joining(",", "[", "]")));
    }
}
