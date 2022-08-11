package node.list;

/**
 * @author shenWenWen 2022/4/23 下午1:44
 */
public class AddEvenList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static ListNode oddEvenList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode next = head.next;
        ListNode odd = head,even = next;
        while (even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = next;
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node4.next = node5;
        node3.next = node4;
        node2.next = node3;
        node.next = node2;

        ListNode node1 = oddEvenList(node);
        System.out.println(node1);
    }
}
