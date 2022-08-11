package node.tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author shenWenWen 2022/5/2 下午5:40
 */
public class IsValidBST {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        Integer pre  = Integer.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            if (pop.val< pre){
                return false;
            }
            pre = pop.val;
            root = pop.right;
        }
        return true;
    }

    public static boolean isValidBST2(TreeNode root) {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isValid(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val < min) {
            return false;
        }
        if (max != null && root.val > max) {
            return false;
        }
        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node2.left = node1;
        node2.right = node3;
        boolean validBST = isValidBST(node2);
        System.out.println(validBST);
    }
}
