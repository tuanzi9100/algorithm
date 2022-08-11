package node.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shenWenWen 2022/4/25 下午4:26
 */
public class InorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int[] inorderTraversal (TreeNode root) {
        // write code here
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    public void inorder(TreeNode root,List<Integer> list){
        if (root == null){
            return;
        }
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
}
