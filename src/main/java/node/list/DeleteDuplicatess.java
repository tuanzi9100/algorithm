package node.list;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shenWenWen 2022/4/23 下午2:45
 */
public class DeleteDuplicatess {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<Integer> set = new HashSet<>();
        ListNode pre = new ListNode(0);
        pre.next = head;
        while (pre.next.next != null) {
            if (!set.add(pre.next.val)) {
                pre.next = pre.next.next;
            }
            pre = pre.next;
        }
        return head;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
    public static ListNode deleteDuplicates3(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node11 = new ListNode(1);
        ListNode node3 = new ListNode(1);

        node11.next = node3;
        node2.next = node11;
        node.next = node2;
        ListNode listNode = deleteDuplicates3(node);
        System.out.println(listNode);
    }
}
