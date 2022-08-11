package node.list;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shenWenWen 2022/4/20 下午9:58
 */
public class DetectCycle {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode detectCycle(ListNode pHead) {

        Set<Integer> set = new HashSet<>();
        ListNode cur = pHead;
        while (cur != null) {
            if (!set.add(cur.val)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    public static ListNode detectCycle2(ListNode pHead) {

        ListNode slow = pHead;
        ListNode fast = pHead.next;
        while (slow != null && fast != null) {
            if (slow == fast) {
                return fast;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }

    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode fast = pHead.next;
        ListNode slow = pHead;
        while (fast != slow) {
            //要确保fast下一个节点不为空
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        node4.next = node2;
        node3.next = node4;
        node2.next = node3;
        node1.next = node2;
        node.next = node1;

        ListNode node5 = detectCycle(node);
        System.out.println(node5);
    }
}
