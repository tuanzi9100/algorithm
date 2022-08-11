package node.list;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shenWenWen 2021/7/18 下午4:40
 */
public class DeleteDuplicates {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = new ListNode(0);
        cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }
            cur = cur.next.next;
        }
        return cur;
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

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        deleteDuplicates2(n1);

        Map pre = new HashMap();
        pre.put(11,11);
        pre.put(22,22);

        Map pre1 = new HashMap();
        pre1.put(11,11);
        pre1.put(22,22);
        Map cur = pre;
        for (int i = 0; i < 10; i++) {
            if (cur.containsKey(11)){
                //cur.remove(11);
                cur = pre1;
            }
        }
        System.out.println(pre);
    }
}
