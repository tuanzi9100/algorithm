package node;

import num.AddToNumber;

/**
 * 合并两个有序链表
 *
 * @author shenWenWen 2021/4/11 下午5:46
 */
public class ListNodes {
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

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode node3 = new ListNode();
        node3.val = 4;
        ListNode node2 = new ListNode();
        node2.val = 2;
        node2.next = node3;
        ListNode node1 = new ListNode();
        node1.val = 1;
        node1.next = node2;

        ListNode node4 = new ListNode();
        node4.val = 4;
        ListNode node5 = new ListNode();
        node5.val = 3;
        node5.next = node4;
        ListNode node6 = new ListNode();
        node6.val = 1;
        node6.next = node5;
        ListNode listNode = mergeTwoLists(node1, node6);
        System.out.println(listNode.toString());
    }
}
