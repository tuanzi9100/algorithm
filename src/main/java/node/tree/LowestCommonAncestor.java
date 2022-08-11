package node.tree;

/**
 * @author shenWenWen 2022/5/5 上午11:33
 */
public class LowestCommonAncestor {
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
    public int lowestCommonAncestor(TreeNode root, int p, int q) {
        // write code here
        while (root != null){
            if (root.val > p && root.val >q){
                root = root.left;
            }else if (root.val<p && root.val<q){
                root = root.right;
            }else {
                break;
            }
        }
        return root.val;
    }

    public static int lowestCommonAncestor2(TreeNode root, int o1, int o2) {
        if (root == null){
            return 0;
        }
        if (root.val == o1 || root.val == o2) {
            return root.val;
        }
        int left = lowestCommonAncestor2(root.left, o1, o2);
        int right = lowestCommonAncestor2(root.right, o1, o2);
        if (left == 0) {
            return right;
        }
        if (right == 0) {
            return left;
        }
        return root.val;
    }

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        node5.left = node6;
        node5.right = node2;
        node3.left = node5;
        node3.right = node1;
        lowestCommonAncestor2(node3,node5.val,node6.val);
    }
}
