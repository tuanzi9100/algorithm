package node;

/**
 * @author shenWenWen 2021/6/15 下午6:11
 */
public class IsValidBST {
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

    public static boolean isValidBST(TreeNode root) {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isValid(TreeNode node, int lower, int upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValid(node.left, lower, node.val) && isValid(node.right, node.val, upper);
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);

        TreeNode node1 = new TreeNode(2);

        TreeNode nod2 = new TreeNode(1);
        nod2.left = node1;
        nod2.right = node3;
        isValidBST(nod2);
    }

}
