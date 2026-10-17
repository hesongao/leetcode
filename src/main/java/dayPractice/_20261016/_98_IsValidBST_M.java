package dayPractice._20261016;

import utils.TreeNode;
import utils.TreeUtils;

/**
 * 98. 验证二叉搜索树
 *
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 严格小于 当前节点的数。
 * 节点的右子树只包含 严格大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [2,1,3]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 *
 *
 * 提示：
 *
 * 树中节点数目范围在[1, 104] 内
 * -231 <= Node.val <= 231 - 1
 */
public class _98_IsValidBST_M {
    public boolean isValidBST(TreeNode root) {

        return isValidBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean isValidBST(TreeNode root, long max, long min) {
        if (root == null) {
            return true;
        }
        if (root.val >= max || root.val <= min) {
            return false;
        }

        return isValidBST(root.left, root.val, min)
                && isValidBST(root.right, max, root.val);

    }



    public static void main(String[] args) {
//        Integer[] nums = {2,1,3};
        Integer[] nums = {5,4,6,null,null,3,7};
        TreeNode root = TreeUtils.buildTree(nums);
        _98_IsValidBST_M clazz = new _98_IsValidBST_M();
        System.out.println(clazz.isValidBST(root));
    }
}
