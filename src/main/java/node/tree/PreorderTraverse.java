package node.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author shenWenWen 2022/8/12 下午3:28
 */
public class PreorderTraverse {
    public static class TreeNode {
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
    static List<Integer> preorderTraverse(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        // 前序遍历的结果，root.val 在第一个
        res.add(root.val);
        // 利用函数定义，后面接着左子树的前序遍历结果
        res.addAll(preorderTraverse(root.left));
        // 利用函数定义，最后接着右子树的前序遍历结果
        res.addAll(preorderTraverse(root.right));
        return res;
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        node20.left = node15;
        node20.right = node7;
        node3.left = node9;
        node3.right = node20;
        List<Integer> list = preorderTraverse(node3);
        System.out.println(list);
    }
}
