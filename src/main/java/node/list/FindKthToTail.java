package node.list;

/**
 * @author shenWenWen 2022/4/21 下午9:30
 */
public class FindKthToTail {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode FindKthToTail(ListNode pHead, int k) {
        if (pHead == null) {
            return null;
        }
        ListNode cur = pHead;
        ListNode node = pHead;
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        int m = size - k;
        if (m < 0) {
            return null;
        }
        for (int i = 0; i < m; i++) {
            node = node.next;
        }
        return node;
    }

    public ListNode FindKthToTail2(ListNode head, int k) {
        ListNode fast = head, slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
