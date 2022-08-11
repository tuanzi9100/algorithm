package recur;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author shenWenWen 2022/5/17 下午2:45
 */


public class AA {
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

    public List<List<Integer>> leveOrder(TreeNode rode) {

        List<List<Integer>> ret = new ArrayList<>();
        if (rode == null) {
            return ret;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(rode);

        while (stack != null) {
            List<Integer> list = new ArrayList<>();
            TreeNode pop = stack.pop();
            list.add(pop.val);

            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }

            ret.add(list);
        }
        return ret;
    }
}
