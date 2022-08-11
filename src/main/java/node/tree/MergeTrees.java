package node.tree;

/**
 * @author shenWenWen 2022/4/28 下午6:26
 */
public class MergeTrees {
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

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }
        return dfs(t1, t2);
    }

    static TreeNode dfs(TreeNode r1, TreeNode r2) {
        if (r1 == null || r2 == null) {
            return r1 == null ? r2 : r1;
        }
        r1.val += r2.val;
        r1.left = dfs(r1.left,r2.left);
        r1.right = dfs(r1.right,r2.right);
        return r1;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6  = new TreeNode(6);

        node5.left = node6;
        node3.left = node5;
        node1.left = node3;
        node1.right = node2;

        TreeNode node22 = new TreeNode(2);
        TreeNode node11 = new TreeNode(1);
        TreeNode node33 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        node11.right = node4;
        node33.right = node7;
        node22.left = node11;
        node22.right = node33;
        TreeNode node = mergeTrees(node1, node22);
        System.out.println(node);
    }
}
