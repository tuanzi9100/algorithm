package node.list;

/**
 * @author shenWenWen 2022/4/22 下午11:54
 */
public class IsPail {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean isPail(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        if (head == pre){
            return true;
        }
        return false;
    }
}
