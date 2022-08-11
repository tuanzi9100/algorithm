package node.tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author shenWenWen 2022/4/25 下午8:56
 */
public class Print {
    public static class TreeNode {
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
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (pRoot == null){
            return ret;
        }
        LinkedList<TreeNode> linkedList = new LinkedList();
        linkedList.add(pRoot);
        boolean flag = true;
        while (!linkedList.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = linkedList.poll();
                if (flag){
                    list.add(poll.val);
                }else {
                    list.add(0,poll.val);
                }
                if (poll.left != null){
                    linkedList.add(poll.left);
                }
                if (poll.right != null){
                    linkedList.add(poll.right);
                }
            }
            flag = !flag;
            ret.add(list);
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(3);

        node3.left = node4;
        node3.right = node5;
        node.left = node2;
        node.right = node3;
        ArrayList<ArrayList<Integer>> print = Print(node);
        System.out.println(print);
    }
}
