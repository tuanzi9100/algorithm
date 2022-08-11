package node.list;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author shenWenWen 2022/4/22 下午9:38
 */
public class SortListNode {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        while (head != null){
            heap.offer(head);
            head = head.next;
        }

        ListNode node = new ListNode(0);
        ListNode cur = node;

        while (!heap.isEmpty()){
            cur.next = heap.poll();
            cur = cur.next;
        }
        cur.next = null;
        return node.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);
        node2.next = node1;
        node3.next = node2;
        node.next = node3;
        ListNode nodee = sortList(node);
        System.out.println(nodee);
    }
}
