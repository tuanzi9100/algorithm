package node.list;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shenWenWen 2021/7/14 下午5:06
 */
public class HasCycle {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 三种方案
     * 第一种：遍历所有链表，看有没有为null的情况。
     * <p>
     * 第二种：把遍历完的值放入set集合中，然后判断接下来的值会不会在set集合中存在。
     * 时间复杂度：O(N)O(N)，其中 NN 是链表中的节点数。最坏情况下我们需要遍历每个节点一次。
     * 空间复杂度：O(N)O(N)，其中 NN 是链表中的节点数。主要为哈希表的开销，最坏情况下我们需要将每个节点插入到哈希表中一次
     * <p>
     * 第三种：快慢指针，快指针每次走两步、慢指针每次走一步，看最后两个指针会不会重合。
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow) {
            //要确保fast下一个节点不为空
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node3 = new ListNode(3);

        ListNode node2 = new ListNode(2);

        ListNode node1 = new ListNode(1);
        node1.next = node2;
        //node2.next = node3;
        System.out.println(hasCycle2(node1));
        ;
    }
}
