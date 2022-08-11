package node.tree;

/**
 * @author shenWenWen 2022/4/28 下午5:16
 */
public class IsSymmetric {
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

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        //调用递归函数，比较左节点，右节点
        return dfs(pRoot.left, pRoot.right);
    }

    static boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null){
            return false;
        }
        if (left.val != right.val){
            return false;
        }
       return dfs(left.left , right.right) && dfs(left.right,right.left);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node22 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node33 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node44 = new TreeNode(4);

        node22.left = node44;
        node22.right = node33;

        node2.left = node3;
        node2.right = node4;
        node1.left = node2;
        node1.right = node22;
        //boolean dfs = isSymmetric(node1);
    }
}
