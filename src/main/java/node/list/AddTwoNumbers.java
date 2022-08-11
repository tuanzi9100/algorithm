package node.list;

import java.util.*;

/**
 * @author shenWenWen 2022/4/22 下午5:33
 */
public class AddTwoNumbers {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        //两个栈
        Stack<Integer> q1 = new Stack<Integer>();
        Stack<Integer> q2 = new Stack<Integer>();
        while (head1 != null) {
            q1.push(head1.val);
            head1 = head1.next;
        }
        while (head2 != null) {
            q2.push(head2.val);
            head2 = head2.next;
        }

        int cos = 0;
        ListNode num = null;
        while (!q1.isEmpty() || !q2.isEmpty() || cos != 0) {
            int a = q1.isEmpty() ? 0 : q1.pop();
            int b = q2.isEmpty() ? 0 : q2.pop();
            int cur = a + b + cos;
            cos = cur/10;
            cur = cur%10;

            ListNode node = new ListNode(cur);
            node.next = num;
            num = node;
        }
        return num;
    }

    public static void main(String[] args) {
        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        node4.next = node3;
        node2.next = node4;

        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node24 = new ListNode(4);
        node6.next = node24;
        node5.next = node6;
        ListNode node = addTwoNumbers(node2, node5);
        System.out.println(node);
    }
}
