package node.tree;

/**
 * @author shenWenWen 2022/4/28 上午12:38
 */
public class IsSymmetrical {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        if (isSymmetrical(pRoot.left) == isSymmetrical(pRoot.right)){
            return true;
        }
        return false;
    }
}
