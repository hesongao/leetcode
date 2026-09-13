package leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 *
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 *
 *
 *
 * 示例 1:
 *
 *
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 * 示例 2:
 *
 * 输入：inorder = [-1], postorder = [-1]
 * 输出：[-1]
 *
 *
 * 提示:
 *
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder 和 postorder 都由 不同 的值组成
 * postorder 中每一个值都在 inorder 中
 * inorder 保证是树的中序遍历
 * postorder 保证是树的后序遍历
 *
 */
public class _106_BuildTree_M_20260913 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }


    }

    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int rootIndex, int start, int end) {
        if (rootIndex <  0 || start > end) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[rootIndex]);
        Integer index = map.get(postorder[rootIndex]);
        root.left = buildTree(inorder, postorder, rootIndex - 1 - end + index, start, index - 1);
        root.right = buildTree(inorder, postorder, rootIndex - 1, index + 1, end);

        return root;
    }


    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        _106_BuildTree_M_20260913 clazz = new _106_BuildTree_M_20260913();
        TreeNode treeNode = clazz.buildTree(inorder, postorder);
        System.out.println(1);

    }
}
