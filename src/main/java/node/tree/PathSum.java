package node.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author shenWenWen 2022/4/27 下午7:09
 */
public class PathSum {
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

    static boolean flag = false;

    public static boolean hasPathSum(TreeNode root, int sum) {
        recur(root, sum);
        return flag;
    }

    public static void recur(TreeNode root, int tar) {
        tar -= root.val;
        if (root == null) {
            return;
        }
        if (tar == 0 && root.left == null && root.right == null) {
            flag = true;
        }
        recur(root.left, tar);
        recur(root.right, tar);
    }

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);

        TreeNode node11 = new TreeNode(11);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node8 = new TreeNode(8);
        TreeNode node13 = new TreeNode(13);
        TreeNode node44 = new TreeNode(4);
        TreeNode node55 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);

        node11.left = node7;
        node11.right = node2;
        node4.left = node11;
        node8.left = node13;
        node8.right = node44;
        node44.left = node55;
        node44.right = node1;

        node5.left = node4;
        node5.right = node8;

        hasPathSum(node5, 22);
    }
}
