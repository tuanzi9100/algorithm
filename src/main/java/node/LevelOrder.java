package node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author shenWenWen 2021/4/10 下午10:07
 */
public class LevelOrder {
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

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }

    public static List<List<Integer>> levelOrder2(TreeNode root) {
        //声明返回的结构
        List<List<Integer>> ret = new ArrayList<>();
        //范围判断
        if (root == null) {
            return ret;
        }
        //将节点赋值给队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            //声明返回的内层集合
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                //取出队列的第一个元素并删除
                TreeNode node = queue.poll();
                list.add(node.val);
                //每次按照顺序将node放入队列，再按照顺序取出节点的val,for循环每次放入队列的尺寸。
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ret.add(list);
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode();
        node5.val = 15;
        TreeNode node6 = new TreeNode();
        node6.val = 7;

        TreeNode node3 = new TreeNode();
        node3.val = 20;
        node3.left = node5;
        node3.right = node6;

        TreeNode node2 = new TreeNode();
        node2.val = 9;
        node2.left = null;
        node2.right = null;

        TreeNode node1 = new TreeNode();
        node1.val = 3;
        node1.left = node2;
        node1.right = node3;

        System.out.println(levelOrder2(node1));
    }
}
